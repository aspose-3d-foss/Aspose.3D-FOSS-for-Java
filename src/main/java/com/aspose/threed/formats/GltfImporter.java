package com.aspose.threed.formats;

import com.aspose.threed.*;
import java.io.*;
import java.util.*;

public class GltfImporter implements IImporter {
    private static final Set<String> supportedExtensions = Set.of(".gltf", ".glb");

    @Override
    public boolean canImport(FileFormat format) {
        if (format == FileFormat.GLTF || format == FileFormat.GLTF2 || 
            format == FileFormat.GLTF_BINARY || format == FileFormat.GLTF2_BINARY) {
            return true;
        }
        return false;
    }

    @Override
    public Scene load(Stream stream, LoadOptions options) throws ImportException {
        if (!(options instanceof GltfLoadOptions)) {
            options = new GltfLoadOptions();
        }
        GltfLoadOptions gltfOptions = (GltfLoadOptions) options;

        Scene scene = new Scene();
        Node rootNode = scene.getRootNode();

        try {
            byte[] content = readAllBytes(stream);
            
            if (content.length == 0) {
                throw new ImportException("Empty glTF file");
            }

            if (isBinaryGltf(content)) {
                return loadBinaryGltf(content, gltfOptions, scene, rootNode);
            } else {
                return loadAsciiGltf(content, gltfOptions, scene, rootNode);
            }
        } catch (IOException e) {
            throw new ImportException("Failed to read glTF file", e);
        }
    }

    private byte[] readAllBytes(Stream stream) throws IOException {
        java.io.InputStream in = stream.getInputStream();
        if (in == null) {
            throw new IOException("Stream not readable");
        }
        
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        byte[] buffer = new byte[8192];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1) {
            baos.write(buffer, 0, bytesRead);
        }
        return baos.toByteArray();
    }

    private boolean isBinaryGltf(byte[] content) {
        if (content.length < 12) {
            return false;
        }
        String magic = new String(content, 0, 4);
        return "glTF".equals(magic);
    }

    private Scene loadBinaryGltf(byte[] content, GltfLoadOptions options, Scene scene, Node rootNode) throws ImportException {
        try {
            String magic = new String(content, 0, 4);
            int version = readUint32(content, 4);
            int length = readUint32(content, 8);

            if (!"glTF".equals(magic)) {
                throw new ImportException("Invalid glTF binary file magic");
            }

            if (version != 2) {
                throw new ImportException("Unsupported glTF version: " + version);
            }

            byte[] jsonChunk = null;
            byte[] binaryChunk = null;

            int chunkOffset = 12;
            while (chunkOffset + 8 <= length) {
                int chunkLength = readUint32(content, chunkOffset);
                int chunkType = readUint32(content, chunkOffset + 4);

                byte[] chunkData = new byte[chunkLength];
                System.arraycopy(content, chunkOffset + 8, chunkData, 0, chunkLength);

                if (chunkType == 0x4E4F534A) {
                    jsonChunk = chunkData;
                } else if (chunkType == 0x004E4942) {
                    binaryChunk = chunkData;
                }

                chunkOffset += 8 + chunkLength;
            }

            if (jsonChunk == null) {
                throw new ImportException("Missing JSON chunk in glTF binary file");
            }

            String jsonStr = new String(jsonChunk, "UTF-8");
            return buildSceneFromJson(jsonStr, options, scene, rootNode, binaryChunk);

        } catch (Exception e) {
            throw new ImportException("Failed to parse binary glTF", e);
        }
    }

    private Scene loadAsciiGltf(byte[] content, GltfLoadOptions options, Scene scene, Node rootNode) throws ImportException {
        try {
            String jsonStr = new String(content, "UTF-8");
            return buildSceneFromJson(jsonStr, options, scene, rootNode, new byte[0]);
        } catch (Exception e) {
            throw new ImportException("Failed to parse ASCII glTF", e);
        }
    }

    private Scene buildSceneFromJson(String jsonStr, GltfLoadOptions options, Scene scene, Node rootNode, byte[] binaryChunk) throws ImportException {
        try {
            Map<String, Object> gltfData = GltfJsonParser.parseJson(jsonStr);

            List<byte[]> buffers = loadBuffers(gltfData, binaryChunk, options);
            List<Map<String, Object>> bufferViews = (List<Map<String, Object>>) gltfData.getOrDefault("bufferViews", new ArrayList<>());
            List<Map<String, Object>> accessors = (List<Map<String, Object>>) gltfData.getOrDefault("accessors", new ArrayList<>());
            List<Map<String, Object>> meshes = (List<Map<String, Object>>) gltfData.getOrDefault("meshes", new ArrayList<>());
            List<Map<String, Object>> nodes = (List<Map<String, Object>>) gltfData.getOrDefault("nodes", new ArrayList<>());
            List<Map<String, Object>> materials = (List<Map<String, Object>>) gltfData.getOrDefault("materials", new ArrayList<>());

            Map<Integer, Mesh> meshObjects = new HashMap<>();
            Map<Integer, Material> materialObjects = loadMaterials(materials);

            for (int meshIdx = 0; meshIdx < meshes.size(); meshIdx++) {
                Map<String, Object> meshData = meshes.get(meshIdx);
                String meshName = (String) meshData.getOrDefault("name", "mesh_" + meshIdx);
                Mesh mesh = new Mesh(meshName);

                List<Map<String, Object>> primitives = (List<Map<String, Object>>) meshData.getOrDefault("primitives", new ArrayList<>());
                
                for (Map<String, Object> primitive : primitives) {
                    buildPrimitive(mesh, primitive, accessors, bufferViews, buffers, options);
                }

                meshObjects.put(meshIdx, mesh);
            }

            Map<Integer, Node> nodeObjects = new HashMap<>();

            for (int nodeIdx = 0; nodeIdx < nodes.size(); nodeIdx++) {
                Map<String, Object> nodeData = nodes.get(nodeIdx);
                String nodeName = (String) nodeData.getOrDefault("name", "node_" + nodeIdx);
                Node node = new Node(nodeName);

                if (nodeData.containsKey("mesh")) {
                    int meshIdx = ((Number) nodeData.get("mesh")).intValue();
                    if (meshObjects.containsKey(meshIdx)) {
                        node.setEntity(meshObjects.get(meshIdx));
                        Map<String, Object> meshData = meshes.get(meshIdx);
                        List<Map<String, Object>> primitives = (List<Map<String, Object>>) meshData.getOrDefault("primitives", new ArrayList<>());
                        if (!primitives.isEmpty()) {
                            Map<String, Object> prim = primitives.get(0);
                            if (prim.containsKey("material")) {
                                int matIdx = ((Number) prim.get("material")).intValue();
                                if (materialObjects.containsKey(matIdx)) {
                                    node.setMaterial(materialObjects.get(matIdx));
                                }
                            }
                        }
                    }
                }

                if (nodeData.containsKey("translation")) {
                    List<Number> translation = (List<Number>) nodeData.get("translation");
                    if (translation.size() >= 3) {
                        node.getTransform().setTranslation(
                            translation.get(0).doubleValue(),
                            translation.get(1).doubleValue(),
                            translation.get(2).doubleValue()
                        );
                    }
                }

                if (nodeData.containsKey("rotation")) {
                    List<Number> rotation = (List<Number>) nodeData.get("rotation");
                    if (rotation.size() >= 4) {
                        node.getTransform().setRotation(
                            rotation.get(0).doubleValue(),
                            rotation.get(1).doubleValue(),
                            rotation.get(2).doubleValue(),
                            rotation.get(3).doubleValue()
                        );
                    }
                }

                if (nodeData.containsKey("scale")) {
                    List<Number> scale = (List<Number>) nodeData.get("scale");
                    if (scale.size() >= 3) {
                        node.getTransform().setScale(
                            scale.get(0).doubleValue(),
                            scale.get(1).doubleValue(),
                            scale.get(2).doubleValue()
                        );
                    }
                }

                nodeObjects.put(nodeIdx, node);
            }

            for (int nodeIdx = 0; nodeIdx < nodes.size(); nodeIdx++) {
                Map<String, Object> nodeData = nodes.get(nodeIdx);
                if (nodeData.containsKey("children")) {
                    List<Number> children = (List<Number>) nodeData.get("children");
                    Node parentNode = nodeObjects.get(nodeIdx);
                    if (parentNode != null) {
                        for (Number childIdx : children) {
                            int childNodeIdx = childIdx.intValue();
                            if (nodeObjects.containsKey(childNodeIdx)) {
                                parentNode.addChildNode(nodeObjects.get(childNodeIdx));
                            }
                        }
                    }
                }
            }

            int sceneIndex = 0;
            if (gltfData.containsKey("scene")) {
                sceneIndex = ((Number) gltfData.get("scene")).intValue();
            }

            List<Map<String, Object>> scenes = (List<Map<String, Object>>) gltfData.getOrDefault("scenes", new ArrayList<>());

            if (sceneIndex < scenes.size()) {
                Map<String, Object> sceneRoot = scenes.get(sceneIndex);
                List<Number> rootNodes = (List<Number>) sceneRoot.getOrDefault("nodes", new ArrayList<>());
                for (Number nodeIdx : rootNodes) {
                    if (nodeObjects.containsKey(nodeIdx.intValue())) {
                        rootNode.addChildNode(nodeObjects.get(nodeIdx.intValue()));
                    }
                }
            }

            return scene;

        } catch (Exception e) {
            throw new ImportException("Failed to parse glTF JSON", e);
        }
    }

    private List<byte[]> loadBuffers(Map<String, Object> gltfData, byte[] binaryChunk, GltfLoadOptions options) {
            List<Map<String, Object>> buffers = (List<Map<String, Object>>) gltfData.getOrDefault("buffers", new ArrayList<>());
            List<byte[]> loadedBuffers = new ArrayList<>();

            for (Map<String, Object> buffer : buffers) {
                String uri = (String) buffer.get("uri");
                int byteLength = ((Number) buffer.getOrDefault("byteLength", 0)).intValue();

        if (uri == null) {
            loadedBuffers.add(binaryChunk);
        } else if (uri.startsWith("data:")) {
            loadedBuffers.add(decodeDataUri(uri));
        } else {
            loadedBuffers.add(new byte[0]);
        }
            }

        return loadedBuffers;
    }

    private byte[] decodeDataUri(String uri) {
        int commaIndex = uri.indexOf(',');
        if (commaIndex > 0) {
            String data = uri.substring(commaIndex + 1);
            try {
                return java.util.Base64.getDecoder().decode(data);
            } catch (Exception e) {
                return new byte[0];
            }
        }
        return new byte[0];
    }

    private void buildPrimitive(Mesh mesh, Map<String, Object> primitive, List<Map<String, Object>> accessors, 
                                List<Map<String, Object>> bufferViews, List<byte[]> buffers, GltfLoadOptions options) {
        Map<String, Object> attributes = (Map<String, Object>) primitive.getOrDefault("attributes", new HashMap<>());
        Object indicesAccessorIdx = primitive.get("indices");
        int mode = 4;
        if (primitive.containsKey("mode")) {
            mode = ((Number) primitive.get("mode")).intValue();
        }

        if (mode != 4 && mode != 0 && mode != 1 && mode != 2) {
            return;
        }

        Object positionAccessorIdx = attributes.get("POSITION");
        Object normalAccessorIdx = attributes.get("NORMAL");
        Object tangentAccessorIdx = attributes.get("TANGENT");
        Object texcoordAccessorIdx = attributes.get("TEXCOORD_0");
        Object colorAccessorIdx = attributes.get("COLOR_0");

        if (positionAccessorIdx == null) {
            return;
        }

        Map<String, Object> positionAccessor = (Map<String, Object>) accessors.get(((Number) positionAccessorIdx).intValue());
        List<Vector3> positions = readAccessorData(positionAccessor, bufferViews, buffers, "VEC3");

        int vertexCount = positions.size();
        int baseVertexIndex = mesh.getControlPoints().size();

        for (Vector3 position : positions) {
            mesh.addControlPoint(position.x, position.y, position.z);
        }

        if (normalAccessorIdx != null) {
            Map<String, Object> normalAccessor = (Map<String, Object>) accessors.get(((Number) normalAccessorIdx).intValue());
            addNormalsToMesh(mesh, normalAccessor, bufferViews, buffers, vertexCount, baseVertexIndex);
        }

        if (tangentAccessorIdx != null) {
            Map<String, Object> tangentAccessor = (Map<String, Object>) accessors.get(((Number) tangentAccessorIdx).intValue());
            addTangentsToMesh(mesh, tangentAccessor, bufferViews, buffers, vertexCount, baseVertexIndex);
        }

        if (texcoordAccessorIdx != null) {
            Map<String, Object> texcoordAccessor = (Map<String, Object>) accessors.get(((Number) texcoordAccessorIdx).intValue());
            addUvsToMesh(mesh, texcoordAccessor, bufferViews, buffers, vertexCount, baseVertexIndex, options);
        }

        if (colorAccessorIdx != null) {
            Map<String, Object> colorAccessor = (Map<String, Object>) accessors.get(((Number) colorAccessorIdx).intValue());
            addColorsToMesh(mesh, colorAccessor, bufferViews, buffers, vertexCount, baseVertexIndex);
        }

        if (indicesAccessorIdx != null) {
            Map<String, Object> indicesAccessor = (Map<String, Object>) accessors.get(((Number) indicesAccessorIdx).intValue());
            List<Number> indices = readAccessorData(indicesAccessor, bufferViews, buffers, "SCALAR");

            int componentType = 5125;
            if (indicesAccessor.containsKey("componentType")) {
                componentType = ((Number) indicesAccessor.get("componentType")).intValue();
            }

            if (componentType == 5123) {
                for (int i = 0; i < indices.size(); i += 3) {
                    mesh.createPolygon(baseVertexIndex + indices.get(i).intValue(),
                                     baseVertexIndex + indices.get(i + 1).intValue(),
                                     baseVertexIndex + indices.get(i + 2).intValue());
                }
            } else {
                for (int i = 0; i < indices.size(); i += 3) {
                    mesh.createPolygon(baseVertexIndex + indices.get(i).intValue(),
                                     baseVertexIndex + indices.get(i + 1).intValue(),
                                     baseVertexIndex + indices.get(i + 2).intValue());
                }
            }
        } else {
            for (int i = 0; i < vertexCount; i += 3) {
                mesh.createPolygon(baseVertexIndex + i,
                                 baseVertexIndex + i + 1,
                                 baseVertexIndex + i + 2);
            }
        }
    }

    private void addNormalsToMesh(Mesh mesh, Map<String, Object> accessor, List<Map<String, Object>> bufferViews, 
                                  List<byte[]> buffers, int vertexCount, int baseVertexIndex) {
        List<Vector3> normals = readAccessorData(accessor, bufferViews, buffers, "VEC3");

        if (normals.size() < vertexCount) {
            return;
        }

        VertexElementNormal normalElement = new VertexElementNormal(MappingMode.CONTROL_POINT, ReferenceMode.DIRECT);
        for (Vector3 normal : normals) {
            FVector4 fn = new FVector4((float) normal.x, (float) normal.y, (float) normal.z, 0);
            normalElement.getData().add(fn);
        }

        mesh.addElement(normalElement);
    }

    private void addTangentsToMesh(Mesh mesh, Map<String, Object> accessor, List<Map<String, Object>> bufferViews, 
                                   List<byte[]> buffers, int vertexCount, int baseVertexIndex) {
        List<Vector3> tangents = readAccessorData(accessor, bufferViews, buffers, "VEC3");

        if (tangents.size() < vertexCount) {
            return;
        }

        VertexElementTangent tangentElement = new VertexElementTangent(MappingMode.CONTROL_POINT, ReferenceMode.DIRECT);
        for (Vector3 tangent : tangents) {
            FVector4 ft = new FVector4((float) tangent.x, (float) tangent.y, (float) tangent.z, 0);
            tangentElement.getData().add(ft);
        }

        mesh.addElement(tangentElement);
    }

    private void addUvsToMesh(Mesh mesh, Map<String, Object> accessor, List<Map<String, Object>> bufferViews, 
                              List<byte[]> buffers, int vertexCount, int baseVertexIndex, GltfLoadOptions options) {
        List<Vector2> uvs = readAccessorData2(accessor, bufferViews, buffers, "VEC2");

        if (uvs.size() < vertexCount) {
            return;
        }

        VertexElementUV uvElement = new VertexElementUV(TextureMapping.DIFFUSE, MappingMode.CONTROL_POINT, ReferenceMode.DIRECT);
        for (Vector2 uv : uvs) {
            double v = uv.y;
            if (options != null && options.getFlipCoordinateSystem()) {
                v = -v;
            }
            FVector4 fuv = new FVector4((float) uv.x, (float) v, 0, 0);
            uvElement.getData().add(fuv);
        }

        mesh.addElement(uvElement);
    }

    private void addColorsToMesh(Mesh mesh, Map<String, Object> accessor, List<Map<String, Object>> bufferViews, 
                                 List<byte[]> buffers, int vertexCount, int baseVertexIndex) {
        List<Vector3> colors3 = readAccessorData(accessor, bufferViews, buffers, "VEC3");
        List<Vector4> colors4 = readAccessorData4(accessor, bufferViews, buffers, "VEC4");

        if (colors3.isEmpty() && colors4.isEmpty()) {
            return;
        }

        List<Vector4> colors = colors4.isEmpty() ? colors3.stream().map(c -> new Vector4(c.x, c.y, c.z, 1)).toList() : colors4;

        if (colors.size() < vertexCount) {
            return;
        }

        VertexElementVertexColor colorElement = new VertexElementVertexColor(MappingMode.CONTROL_POINT, ReferenceMode.DIRECT);
        for (Vector4 color : colors) {
            FVector4 fc = new FVector4((float) color.x, (float) color.y, (float) color.z, (float) color.w);
            colorElement.getData().add(fc);
        }

        mesh.addElement(colorElement);
    }

    @SuppressWarnings("unchecked")
    private <T> List<T> readAccessorData(Map<String, Object> accessor, List<Map<String, Object>> bufferViews, 
                                         List<byte[]> buffers, String expectedType) {
        Object bufferViewIdx = accessor.get("bufferView");
        int byteOffset = ((Number) accessor.getOrDefault("byteOffset", 0)).intValue();
        int count = ((Number) accessor.get("count")).intValue();
        String accessorType = (String) accessor.get("type");

        if (bufferViewIdx == null || ((Number) bufferViewIdx).intValue() >= bufferViews.size()) {
            return new ArrayList<>();
        }

        Map<String, Object> bufferView = bufferViews.get(((Number) bufferViewIdx).intValue());
        int bufferIdx = ((Number) bufferView.getOrDefault("buffer", 0)).intValue();
        int viewByteOffset = ((Number) bufferView.getOrDefault("byteOffset", 0)).intValue();
        int viewByteLength = ((Number) bufferView.getOrDefault("byteLength", 0)).intValue();

        if (bufferIdx >= buffers.size()) {
            return new ArrayList<>();
        }

        byte[] buffer = buffers.get(bufferIdx);
        int dataStart = viewByteOffset + byteOffset;
        int dataEnd = dataStart + viewByteLength;
        int length = Math.min(viewByteLength, buffer.length - dataStart);
        byte[] data = new byte[length];
        System.arraycopy(buffer, dataStart, data, 0, length);
        
        return decodeBuffer(data, ((Number) accessor.getOrDefault("componentType", 5126)).intValue(), (expectedType), count);
    }

    @SuppressWarnings("unchecked")
    private List<Vector2> readAccessorData2(Map<String, Object> accessor, List<Map<String, Object>> bufferViews, 
                                           List<byte[]> buffers, String expectedType) {
        List<?> data = readAccessorData(accessor, bufferViews, buffers, expectedType);
        List<Vector2> result = new ArrayList<>();
        for (Object item : data) {
            if (item instanceof Vector2) {
                result.add((Vector2) item);
            } else if (item instanceof Vector3) {
                result.add(new Vector2(((Vector3) item).x, ((Vector3) item).y));
            } else if (item instanceof Vector4) {
                result.add(new Vector2(((Vector4) item).x, ((Vector4) item).y));
            }
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    private List<Vector4> readAccessorData4(Map<String, Object> accessor, List<Map<String, Object>> bufferViews, 
                                           List<byte[]> buffers, String expectedType) {
        List<?> data = readAccessorData(accessor, bufferViews, buffers, expectedType);
        List<Vector4> result = new ArrayList<>();
        for (Object item : data) {
            if (item instanceof Vector4) {
                result.add((Vector4) item);
            } else if (item instanceof Vector3) {
                result.add(new Vector4(((Vector3) item).x, ((Vector3) item).y, ((Vector3) item).z, 1));
            }
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    private <T> List<T> decodeBuffer(byte[] data, int componentType, String expectedType, int count) {
        int componentsPerValue = 1;
        if ("VEC2".equals(expectedType)) {
            componentsPerValue = 2;
        } else if ("VEC3".equals(expectedType)) {
            componentsPerValue = 3;
        } else if ("VEC4".equals(expectedType)) {
            componentsPerValue = 4;
        }
        
        int totalComponents = count * componentsPerValue;
        List<Object> values = new ArrayList<>();

        if (componentType == 5120) {
            for (int i = 0; i < totalComponents; i++) {
                if (i < data.length) {
                    values.add((byte) data[i]);
                }
            }
        } else if (componentType == 5121) {
            for (int i = 0; i < totalComponents; i++) {
                if (i < data.length) {
                    values.add(data[i] & 0xFF);
                }
            }
        } else if (componentType == 5122) {
            for (int i = 0; i < totalComponents * 2; i += 2) {
                if (i + 1 < data.length) {
                    int val = (data[i] & 0xFF) | ((data[i + 1] & 0xFF) << 8);
                    if (val > 32767) val -= 65536;
                    values.add(val);
                }
            }
        } else if (componentType == 5123) {
            for (int i = 0; i < totalComponents * 2; i += 2) {
                if (i + 1 < data.length) {
                    values.add((data[i] & 0xFF) | ((data[i + 1] & 0xFF) << 8));
                }
            }
        } else if (componentType == 5125) {
            for (int i = 0; i < totalComponents * 4; i += 4) {
                if (i + 3 < data.length) {
                    int val = (data[i] & 0xFF) | ((data[i + 1] & 0xFF) << 8) |
                              ((data[i + 2] & 0xFF) << 16) | ((data[i + 3] & 0xFF) << 24);
                    values.add(val);
                }
            }
        } else if (componentType == 5126) {
            for (int i = 0; i < totalComponents * 4; i += 4) {
                if (i + 3 < data.length) {
                    int bits = (data[i] & 0xFF) | ((data[i + 1] & 0xFF) << 8) |
                               ((data[i + 2] & 0xFF) << 16) | ((data[i + 3] & 0xFF) << 24);
                    Float f = Float.intBitsToFloat(bits);
                    values.add(f);
                }
            }
        }

        if ("SCALAR".equals(expectedType)) {
            return (List<T>) values;
        } else if ("VEC2".equals(expectedType)) {
            List<T> result = new ArrayList<>();
            for (int i = 0; i < values.size(); i += 2) {
                if (values.get(i) instanceof Float) {
                    result.add((T) new Vector2((Float) values.get(i), (Float) values.get(i + 1)));
                } else if (values.get(i) instanceof Integer) {
                    result.add((T) new Vector2(((Number) values.get(i)).doubleValue(), ((Number) values.get(i + 1)).doubleValue()));
                } else if (values.get(i) instanceof Byte) {
                    result.add((T) new Vector2(((Number) values.get(i)).doubleValue(), ((Number) values.get(i + 1)).doubleValue()));
                }
            }
            return result;
        } else if ("VEC3".equals((expectedType))) {
            List<T> result = new ArrayList<>();
            for (int i = 0; i < values.size(); i += 3) {
                if (i + 2 < values.size()) {
                    if (values.get(i) instanceof Float) {
                        Float f0 = (Float) values.get(i);
                        Float f1 = (Float) values.get(i + 1);
                        Float f2 = (Float) values.get(i + 2);
                        result.add((T) new Vector3(f0, f1, f2));
                    } else if (values.get(i) instanceof Number) {
                        Number n0 = (Number) values.get(i);
                        Number n1 = (Number) values.get(i + 1);
                        Number n2 = (Number) values.get(i + 2);
                        result.add((T) new Vector3(n0.doubleValue(), n1.doubleValue(), n2.doubleValue()));
                    }
                }
            }
            return result;
        } else if ("VEC4".equals((expectedType))) {
            List<T> result = new ArrayList<>();
            for (int i = 0; i < values.size(); i += 4) {
                if (values.get(i) instanceof Float) {
                    result.add((T) new Vector4((Float) values.get(i), (Float) values.get(i + 1), (Float) values.get(i + 2), (Float) values.get(i + 3)));
                } else if (values.get(i) instanceof Integer) {
                    result.add((T) new Vector4(((Number) values.get(i)).doubleValue(), ((Number) values.get(i + 1)).doubleValue(), ((Number) values.get(i + 2)).doubleValue(), ((Number) values.get(i + 3)).doubleValue()));
                } else if (values.get(i) instanceof Byte) {
                    result.add((T) new Vector4(((Number) values.get(i)).doubleValue(), ((Number) values.get(i + 1)).doubleValue(), ((Number) values.get(i + 2)).doubleValue(), ((Number) values.get(i + 3)).doubleValue()));
                }
            }
            return result;
        }

        return new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    private Map<Integer, Material> loadMaterials(List<Map<String, Object>> materials) {
        Map<Integer, Material> materialObjects = new HashMap<>();

        for (int i = 0; i < materials.size(); i++) {
            Map<String, Object> materialData = materials.get(i);
            String materialName = (String) materialData.getOrDefault("name", "material_" + i);
            Material material = new Material(materialName);

            Map<String, Object> pbrData = (Map<String, Object>) materialData.getOrDefault("pbrMetallicRoughness", new HashMap<>());
            
            List<Number> baseColorFactor = (List<Number>) pbrData.getOrDefault("baseColorFactor", 
                List.of(1.0, 1.0, 1.0, 1.0));
            float metallicFactor = ((Number) pbrData.getOrDefault("metallicFactor", 0.0)).floatValue();
            float roughnessFactor = ((Number) pbrData.getOrDefault("roughnessFactor", 1.0)).floatValue();

            if (baseColorFactor.size() >= 3) {
                material.setName(materialName);
            }

            List<Number> emissiveFactor = (List<Number>) materialData.getOrDefault("emissiveFactor", 
                List.of(0.0, 0.0, 0.0));
            if (emissiveFactor.size() >= 3) {
                material.setName(materialName);
            }

            String alphaMode = (String) materialData.getOrDefault("alphaMode", "OPAQUE");
            if ("BLEND".equals(alphaMode)) {
                material.setName(materialName);
            } else if ("MASK".equals(alphaMode)) {
                float alphaCutoff = ((Number) materialData.getOrDefault("alphaCutoff", 0.5f)).floatValue();
                if (alphaCutoff < 1.0f) {
                    material.setName(materialName);
                }
            }

            materialObjects.put(i, material);
        }

        return materialObjects;
    }

    private int readUint32(byte[] data, int offset) {
        return (data[offset] & 0xFF) |
               ((data[offset + 1] & 0xFF) << 8) |
               ((data[offset + 2] & 0xFF) << 16) |
               ((data[offset + 3] & 0xFF) << 24);
    }
}
