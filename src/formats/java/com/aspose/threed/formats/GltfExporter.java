package com.aspose.threed.formats;

import com.aspose.threed.*;
import java.io.*;
import java.util.*;

public class GltfExporter implements IExporter {
    private static final Set<String> supportedExtensions = Set.of(".gltf", ".glb");

    @Override
    public boolean canExport(FileFormat format) {
        return format == FileFormat.GLTF || format == FileFormat.GLTF2 ||
               format == FileFormat.GLTF_BINARY || format == FileFormat.GLTF2_BINARY;
    }

    @Override
    public void export(Scene scene, Stream stream, SaveOptions options) throws ExportException {
        if (!(options instanceof GltfSaveOptions)) {
            throw new ExportException("Invalid save options for glTF export");
        }
        GltfSaveOptions gltfOptions = (GltfSaveOptions) options;

        try {
            GltfData gltfData = buildGltfData(scene, gltfOptions);
            
            if (gltfOptions.getContentType() == FileContentType.BINARY) {
                writeBinaryGltf(stream, gltfData);
            } else {
                writeAsciiGltf(stream, gltfData);
            }
        } catch (IOException e) {
            throw new ExportException("Failed to write glTF file", e);
        }
    }

    private GltfData buildGltfData(Scene scene, GltfSaveOptions options) {
        List<Node> allNodes = new ArrayList<>();
        List<Mesh> allMeshes = new ArrayList<>();

        collectNodes(scene.getRootNode(), allNodes, allMeshes);

        List<Map<String, Object>> buffers = new ArrayList<>();
        List<Map<String, Object>> bufferViews = new ArrayList<>();
        List<Map<String, Object>> accessors = new ArrayList<>();
        List<Map<String, Object>> materials = new ArrayList<>();
        List<Map<String, Object>> meshes = new ArrayList<>();
        List<Map<String, Object>> nodes = new ArrayList<>();

        byte[] binaryBuffer = new byte[0];
        Map<Mesh, Integer> meshIndexMap = new HashMap<>();
        Map<Material, Integer> materialIndexMap = new HashMap<>();

        Map<Node, Integer> nodeIndexMap = new HashMap<>();
        for (int i = 0; i < allNodes.size(); i++) {
            nodeIndexMap.put(allNodes.get(i), i);
        }

        Map<Mesh, Material> meshToMaterial = new HashMap<>();
        for (Node node : allNodes) {
            if (node.getMaterial() != null && node.getEntity() instanceof Mesh) {
                meshToMaterial.put((Mesh) node.getEntity(), node.getMaterial());
            }
        }

        materials = buildMaterials(meshToMaterial, materialIndexMap);

        for (int i = 0; i < allMeshes.size(); i++) {
            Mesh mesh = allMeshes.get(i);
            Map<String, Object> meshData = buildMeshData(mesh, options, binaryBuffer, bufferViews, accessors, buffers, i, meshToMaterial, materialIndexMap);
            meshes.add(meshData);
            meshIndexMap.put(mesh, i);
        }

        for (Node node : allNodes) {
            Map<String, Object> nodeData = new HashMap<>();
            if (node.getName() != null && !node.getName().isEmpty()) {
                nodeData.put("name", node.getName());
            }

            if (node.getEntity() instanceof Mesh) {
                Mesh mesh = (Mesh) node.getEntity();
                if (meshIndexMap.containsKey(mesh)) {
                    nodeData.put("mesh", meshIndexMap.get(mesh));
                }
            }

            Transform transform = node.getTransform();
            Vector3 translation = transform.getTranslation();
            if (translation.x != 0 || translation.y != 0 || translation.z != 0) {
                nodeData.put("translation", new double[]{translation.x, translation.y, translation.z});
            }

            nodes.add(nodeData);
        }

        List<Integer> childIndices = new ArrayList<>();
        for (Node node : allNodes) {
            Node parentNode = node.getParentNode();
            if (parentNode != null && nodeIndexMap.containsKey(parentNode)) {
                int parentIdx = nodeIndexMap.get(parentNode);
                nodes.get(parentIdx).computeIfAbsent("children", k -> new ArrayList<Integer>());
                @SuppressWarnings("unchecked")
                List<Integer> children = (List<Integer>) nodes.get(parentIdx).get("children");
                children.add(nodeIndexMap.get(node));
            } else if (parentNode == scene.getRootNode()) {
                childIndices.add(nodeIndexMap.get(node));
            }
        }

        Map<String, Object> sceneData = new HashMap<>();
        sceneData.put("nodes", childIndices);

        Map<String, Object> gltfJson = new LinkedHashMap<>();
        gltfJson.put("asset", Map.of("version", "2.0", "generator", "Aspose.3D FOSS"));
        gltfJson.put("scene", 0);
        gltfJson.put("scenes", List.of(sceneData));
        gltfJson.put("nodes", nodes);
        gltfJson.put("meshes", meshes);
        gltfJson.put("buffers", buffers);
        gltfJson.put("bufferViews", bufferViews);
        gltfJson.put("accessors", accessors);

        if (!materials.isEmpty()) {
            gltfJson.put("materials", materials);
        }

        return new GltfData(gltfJson, binaryBuffer);
    }

    private void collectNodes(Node node, List<Node> allNodes, List<Mesh> allMeshes) {
        for (Node child : node.getChildNodes()) {
            collectNodes(child, allNodes, allMeshes);
        }

        if (!allNodes.contains(node)) {
            allNodes.add(node);
            if (node.getEntity() instanceof Mesh) {
                Mesh mesh = (Mesh) node.getEntity();
                if (!allMeshes.contains(mesh)) {
                    allMeshes.add(mesh);
                }
            }
        }
    }

    private List<Map<String, Object>> buildMaterials(Map<Mesh, Material> meshToMaterial, Map<Material, Integer> materialIndexMap) {
        List<Map<String, Object>> materials = new ArrayList<>();

        for (Map.Entry<Mesh, Material> entry : meshToMaterial.entrySet()) {
            Material material = entry.getValue();
            if (materialIndexMap.containsKey(material)) {
                continue;
            }

            int materialIdx = materials.size();
            materialIndexMap.put(material, materialIdx);

            Map<String, Object> materialData = new HashMap<>();

            if (material.getName() != null && !material.getName().isEmpty()) {
                materialData.put("name", material.getName());
            }

            PbrMaterial pbrMaterial = PbrMaterial.fromMaterial(material);

            Map<String, Object> pbrData = new HashMap<>();

            if (pbrMaterial.getAlbedo() != null) {
                Vector3 albedo = pbrMaterial.getAlbedo();
                pbrData.put("baseColorFactor", new double[]{albedo.x, albedo.y, albedo.z, 1.0});
            }

            if (pbrMaterial.getMetallicFactor() != 0.0) {
                pbrData.put("metallicFactor", pbrMaterial.getMetallicFactor());
            }

            if (pbrMaterial.getRoughnessFactor() != 1.0) {
                pbrData.put("roughnessFactor", pbrMaterial.getRoughnessFactor());
            }

            if (!pbrData.isEmpty()) {
                materialData.put("pbrMetallicRoughness", pbrData);
            }

            if (pbrMaterial.getEmissiveColor() != null) {
                Vector3 emissive = pbrMaterial.getEmissiveColor();
                materialData.put("emissiveFactor", new double[]{emissive.x, emissive.y, emissive.z});
            }

            if (pbrMaterial.getTransparency() != 0.0) {
                if (pbrMaterial.getTransparency() == 1.0) {
                    materialData.put("alphaMode", "BLEND");
                } else {
                    materialData.put("alphaMode", "MASK");
                    materialData.put("alphaCutoff", 1.0 - pbrMaterial.getTransparency());
                }
            }

            materials.add(materialData);
        }

        return materials;
    }

    private Map<String, Object> buildMeshData(Mesh mesh, GltfSaveOptions options, byte[] binaryBuffer, 
                                              List<Map<String, Object>> bufferViews, 
                                              List<Map<String, Object>> accessors, 
                                              List<Map<String, Object>> buffers,
                                              int meshIndex, 
                                              Map<Mesh, Material> meshToMaterial,
                                              Map<Material, Integer> materialIndexMap) {
        Map<String, Object> primitiveData = new LinkedHashMap<>();
        primitiveData.put("attributes", new LinkedHashMap<>());
        primitiveData.put("mode", 4);

        List<Double> positions = new ArrayList<>();
        for (Vector4 cp : mesh.getControlPoints()) {
            positions.add(cp.x);
            positions.add(cp.y);
            positions.add(cp.z);
        }

        byte[] positionBytes = encodeFloatArray(positions);
        int positionBufferOffset = binaryBuffer.length;
        
        byte[] newData = new byte[binaryBuffer.length + positionBytes.length];
        System.arraycopy(binaryBuffer, 0, newData, 0, binaryBuffer.length);
        System.arraycopy(positionBytes, 0, newData, binaryBuffer.length, positionBytes.length);
        binaryBuffer = newData;

        Map<String, Object> positionBufferView = new LinkedHashMap<>();
        positionBufferView.put("buffer", 0);
        positionBufferView.put("byteOffset", positionBufferOffset);
        positionBufferView.put("byteLength", positionBytes.length);
        bufferViews.add(positionBufferView);

        Map<String, Object> positionAccessor = new LinkedHashMap<>();
        positionAccessor.put("bufferView", bufferViews.size() - 1);
        positionAccessor.put("componentType", 5126);
        positionAccessor.put("count", positions.size() / 3);
        positionAccessor.put("type", "VEC3");
        accessors.add(positionAccessor);

        @SuppressWarnings("unchecked")
        Map<String, Object> attributes = (Map<String, Object>) primitiveData.get("attributes");
        attributes.put("POSITION", accessors.size() - 1);

        VertexElementNormal normalElement = (VertexElementNormal) mesh.getElement(VertexElementType.NORMAL);
        if (normalElement != null && !normalElement.getData().isEmpty()) {
            List<Double> normals = new ArrayList<>();
            for (Object fv : normalElement.getData()) {
                if (fv instanceof Vector3) {
                    Vector3 v = (Vector3) fv;
                    normals.add(v.x);
                    normals.add(v.y);
                    normals.add(v.z);
                }
            }

            byte[] normalBytes = encodeFloatArray(normals);
            int normalBufferOffset = binaryBuffer.length;
            
            newData = new byte[binaryBuffer.length + normalBytes.length];
            System.arraycopy(binaryBuffer, 0, newData, 0, binaryBuffer.length);
            System.arraycopy(normalBytes, 0, newData, binaryBuffer.length, normalBytes.length);
            binaryBuffer = newData;

            Map<String, Object> normalBufferView = new LinkedHashMap<>();
            normalBufferView.put("buffer", 0);
            normalBufferView.put("byteOffset", normalBufferOffset);
            normalBufferView.put("byteLength", normalBytes.length);
            bufferViews.add(normalBufferView);

            Map<String, Object> normalAccessor = new LinkedHashMap<>();
            normalAccessor.put("bufferView", bufferViews.size() - 1);
            normalAccessor.put("componentType", 5126);
            normalAccessor.put("count", normals.size() / 3);
            normalAccessor.put("type", "VEC3");
            accessors.add(normalAccessor);

            attributes.put("NORMAL", accessors.size() - 1);
        }

        VertexElementUV uvElement = mesh.getVertexElementOfUV(TextureMapping.DIFFUSE);
        if (uvElement != null && !uvElement.getData().isEmpty()) {
            List<Double> texcoords = new ArrayList<>();
            for (Object fv : uvElement.getData()) {
                if (fv instanceof Vector2) {
                    Vector2 v = (Vector2) fv;
                    texcoords.add(v.x);
                    texcoords.add(v.y);
                }
            }

            byte[] texcoordBytes = encodeFloatArray(texcoords);
            int texcoordBufferOffset = binaryBuffer.length;
            
            newData = new byte[binaryBuffer.length + texcoordBytes.length];
            System.arraycopy(binaryBuffer, 0, newData, 0, binaryBuffer.length);
            System.arraycopy(texcoordBytes, 0, newData, binaryBuffer.length, texcoordBytes.length);
            binaryBuffer = newData;

            Map<String, Object> texcoordBufferView = new LinkedHashMap<>();
            texcoordBufferView.put("buffer", 0);
            texcoordBufferView.put("byteOffset", texcoordBufferOffset);
            texcoordBufferView.put("byteLength", texcoordBytes.length);
            bufferViews.add(texcoordBufferView);

            Map<String, Object> texcoordAccessor = new LinkedHashMap<>();
            texcoordAccessor.put("bufferView", bufferViews.size() - 1);
            texcoordAccessor.put("componentType", 5126);
            texcoordAccessor.put("count", texcoords.size() / 2);
            texcoordAccessor.put("type", "VEC2");
            accessors.add(texcoordAccessor);

            attributes.put("TEXCOORD_0", accessors.size() - 1);
        }

        VertexElementVertexColor colorElement = (VertexElementVertexColor) mesh.getElement(VertexElementType.COLOR);
        if (colorElement != null && !colorElement.getData().isEmpty()) {
            List<Double> colors = new ArrayList<>();
            for (Object fv : colorElement.getData()) {
                if (fv instanceof Vector4) {
                    Vector4 v = (Vector4) fv;
                    colors.add(v.x);
                    colors.add(v.y);
                    colors.add(v.z);
                    colors.add(v.w);
                }
            }

            byte[] colorBytes = encodeFloatArray(colors);
            int colorBufferOffset = binaryBuffer.length;
            
            newData = new byte[binaryBuffer.length + colorBytes.length];
            System.arraycopy(binaryBuffer, 0, newData, 0, binaryBuffer.length);
            System.arraycopy(colorBytes, 0, newData, binaryBuffer.length, colorBytes.length);
            binaryBuffer = newData;

            Map<String, Object> colorBufferView = new LinkedHashMap<>();
            colorBufferView.put("buffer", 0);
            colorBufferView.put("byteOffset", colorBufferOffset);
            colorBufferView.put("byteLength", colorBytes.length);
            bufferViews.add(colorBufferView);

            Map<String, Object> colorAccessor = new LinkedHashMap<>();
            colorAccessor.put("bufferView", bufferViews.size() - 1);
            colorAccessor.put("componentType", 5126);
            colorAccessor.put("count", colors.size() / 4);
            colorAccessor.put("type", "VEC4");
            accessors.add(colorAccessor);

            attributes.put("COLOR_0", accessors.size() - 1);
        }

        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < mesh.getPolygonCount(); i++) {
            int[] polygon = mesh.getPolygons().get(i);
            for (int j = 0; j < polygon.length; j++) {
                indices.add(polygon[j]);
            }
        }

        if (!indices.isEmpty()) {
            byte[] indicesBytes = encodeUint16Array(indices);
            int indicesBufferOffset = binaryBuffer.length;
            
            newData = new byte[binaryBuffer.length + indicesBytes.length];
            System.arraycopy(binaryBuffer, 0, newData, 0, binaryBuffer.length);
            System.arraycopy(indicesBytes, 0, newData, binaryBuffer.length, indicesBytes.length);
            binaryBuffer = newData;

            Map<String, Object> indicesBufferView = new LinkedHashMap<>();
            indicesBufferView.put("buffer", 0);
            indicesBufferView.put("byteOffset", indicesBufferOffset);
            indicesBufferView.put("byteLength", indicesBytes.length);
            bufferViews.add(indicesBufferView);

            Map<String, Object> indicesAccessor = new LinkedHashMap<>();
            indicesAccessor.put("bufferView", bufferViews.size() - 1);
            indicesAccessor.put("componentType", 5123);
            indicesAccessor.put("count", indices.size());
            indicesAccessor.put("type", "SCALAR");
            accessors.add(indicesAccessor);

            primitiveData.put("indices", accessors.size() - 1);
        }

        Mesh meshObj = (Mesh) mesh;
        if (meshToMaterial.containsKey(meshObj) && materialIndexMap.containsKey(meshToMaterial.get(meshObj))) {
            primitiveData.put("material", materialIndexMap.get(meshToMaterial.get(meshObj)));
        }

        String meshName = mesh.getName() != null && !mesh.getName().isEmpty() ? mesh.getName() : "mesh_" + meshIndex;
        Map<String, Object> meshData = new LinkedHashMap<>();
        meshData.put("name", meshName);
        meshData.put("primitives", List.of(primitiveData));

        return meshData;
    }

    private byte[] encodeFloatArray(List<Double> values) {
        byte[] data = new byte[values.size() * 4];
        int idx = 0;
        for (double v : values) {
            int intBits = Float.floatToIntBits((float) v);
            data[idx++] = (byte) (intBits & 0xFF);
            data[idx++] = (byte) ((intBits >> 8) & 0xFF);
            data[idx++] = (byte) ((intBits >> 16) & 0xFF);
            data[idx++] = (byte) ((intBits >> 24) & 0xFF);
        }
        return data;
    }

    private byte[] encodeUint16Array(List<Integer> values) {
        byte[] data = new byte[values.size() * 2];
        int idx = 0;
        for (int v : values) {
            data[idx++] = (byte) (v & 0xFF);
            data[idx++] = (byte) ((v >> 8) & 0xFF);
        }
        return data;
    }

    private void writeAsciiGltf(Stream stream, GltfData gltfData) throws IOException {
        Map<String, Object> gltfJson = gltfData.getJson();
        
        if (gltfData.getBinaryData().length > 0) {
            String base64Data = java.util.Base64.getEncoder().encodeToString(gltfData.getBinaryData());
            Map<String, Object> buffer = new LinkedHashMap<>();
            buffer.put("uri", "data:application/octet-stream;base64," + base64Data);
            buffer.put("byteLength", gltfData.getBinaryData().length);
            gltfJson.put("buffers", List.of(buffer));
        } else {
            gltfJson.put("buffers", List.of());
        }

        String jsonStr = buildJsonString(gltfJson, true);

        OutputStream out = stream.getOutputStream();
        if (out != null) {
            out.write(jsonStr.getBytes("UTF-8"));
            out.flush();
        }
    }

    private void writeBinaryGltf(Stream stream, GltfData gltfData) throws IOException {
        Map<String, Object> gltfJson = gltfData.getJson();
        byte[] binaryData = gltfData.getBinaryData();

        if (binaryData.length > 0) {
            gltfJson.put("buffers", List.of(Map.of("byteLength", binaryData.length)));
        }

        String jsonStr = buildJsonString(gltfJson, false);
        byte[] jsonBytes = jsonStr.getBytes("UTF-8");

        int jsonChunkLength = jsonBytes.length;
        int jsonChunkPadding = (4 - jsonChunkLength % 4) % 4;

        int binaryChunkLength = binaryData.length;
        int binaryChunkPadding = (4 - binaryChunkLength % 4) % 4;

        int totalLength = 12 + 8 + jsonChunkLength + jsonChunkPadding;
        if (binaryData.length > 0) {
            totalLength += 8 + binaryChunkLength + binaryChunkPadding;
        }

        OutputStream out = stream.getOutputStream();
        if (out == null) {
            throw new IOException("Output stream not available");
        }

        out.write("glTF".getBytes("UTF-8"));
        out.write(intToBytes(2));      // version
        out.write(intToBytes(totalLength));

        out.write(intToBytes(jsonChunkLength));
        out.write(intToBytes(0x4E4F534A));
        out.write(jsonBytes);
        for (int i = 0; i < jsonChunkPadding; i++) {
            out.write(0);
        }

        if (binaryData.length > 0) {
            out.write(intToBytes(binaryChunkLength));
            out.write(intToBytes(0x004E4942));
            out.write(binaryData);
            for (int i = 0; i < binaryChunkPadding; i++) {
                out.write(0);
            }
        }

        out.flush();
    }

    private String buildJsonString(Map<String, Object> json, boolean prettyPrint) {
        StringBuilder sb = new StringBuilder();
        buildJsonString(json, sb, prettyPrint, 0);
        return sb.toString();
    }

    private void buildJsonString(Map<String, Object> json, StringBuilder sb, boolean prettyPrint, int indent) {
        sb.append("{");
        boolean first = true;
        for (Map.Entry<String, Object> entry : json.entrySet()) {
            if (entry.getValue() == null) continue;  // Skip null values
            
            if (!first) {
                sb.append(",");
                if (prettyPrint) sb.append("\n");
            }
            first = false;
            
            if (prettyPrint) {
                for (int i = 0; i < indent + 1; i++) sb.append("  ");
            }
            
            sb.append("\"").append(entry.getKey()).append("\": ");
            
            Object value = entry.getValue();
            if (value instanceof Map) {
                @SuppressWarnings("unchecked")
                Map<String, Object> mapValue = (Map<String, Object>) value;
                buildJsonString(mapValue, sb, prettyPrint, indent + 1);
            } else if (value instanceof List) {
                buildJsonString((List<?>) value, sb, prettyPrint, indent + 1);
            } else if (value instanceof String) {
                sb.append("\"").append(escapeJson((String) value)).append("\"");
            } else if (value instanceof Double) {
                sb.append(value);
            } else if (value instanceof Float) {
                sb.append(value);
            } else if (value instanceof Integer) {
                sb.append(value);
            } else if (value instanceof Boolean) {
                sb.append(value);
            } else if (value instanceof byte[]) {
                sb.append("\"").append(java.util.Base64.getEncoder().encodeToString((byte[]) value)).append("\"");
            } else if (value instanceof double[]) {
                sb.append("[");
                double[] arr = (double[]) value;
                for (int i = 0; i < arr.length; i++) {
                    if (i > 0) sb.append(", ");
                    sb.append(arr[i]);
                }
                sb.append("]");
            } else if (value instanceof int[]) {
                sb.append("[");
                int[] arr = (int[]) value;
                for (int i = 0; i < arr.length; i++) {
                    if (i > 0) sb.append(", ");
                    sb.append(arr[i]);
                }
                sb.append("]");
            }
        }
        
        if (prettyPrint && !json.isEmpty()) {
            sb.append("\n");
            for (int i = 0; i < indent; i++) sb.append("  ");
        }
        sb.append("}");
    }

    private void buildJsonString(List<?> list, StringBuilder sb, boolean prettyPrint, int indent) {
        sb.append("[");
        boolean first = true;
        for (Object item : list) {
            if (!first) {
                sb.append(",");
                if (prettyPrint) sb.append(" ");
            }
            first = false;
            
            if (item instanceof Map) {
                @SuppressWarnings("unchecked")
                Map<String, Object> mapItem = (Map<String, Object>) item;
                buildJsonString(mapItem, sb, prettyPrint, indent);
            } else if (item instanceof List) {
                @SuppressWarnings("unchecked")
                List<Object> listItem = (List<Object>) item;
                buildJsonString(listItem, sb, prettyPrint, indent);
            } else if (item instanceof String) {
                sb.append("\"").append(escapeJson((String) item)).append("\"");
            } else if (item instanceof Double) {
                sb.append(item);
            } else if (item instanceof Float) {
                sb.append(item);
            } else if (item instanceof Integer) {
                sb.append(item);
            } else if (item instanceof Boolean) {
                sb.append(item);
            } else if (item instanceof byte[]) {
                sb.append("\"").append(java.util.Base64.getEncoder().encodeToString((byte[]) item)).append("\"");
            } else if (item instanceof double[]) {
                sb.append("[");
                double[] arr = (double[]) item;
                for (int i = 0; i < arr.length; i++) {
                    if (i > 0) sb.append(", ");
                    sb.append(arr[i]);
                }
                sb.append("]");
            } else if (item instanceof int[]) {
                sb.append("[");
                int[] arr = (int[]) item;
                for (int i = 0; i < arr.length; i++) {
                    if (i > 0) sb.append(", ");
                    sb.append(arr[i]);
                }
                sb.append("]");
            } else if (item == null) {
                sb.append("null");
            }
        }
        sb.append("]");
    }

    private String escapeJson(String s) {
        if (s == null) return "";
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '"': sb.append("\\\""); break;
                case '\\': sb.append("\\\\"); break;
                case '\b': sb.append("\\b"); break;
                case '\f': sb.append("\\f"); break;
                case '\n': sb.append("\\n"); break;
                case '\r': sb.append("\\r"); break;
                case '\t': sb.append("\\t"); break;
                default:
                    if (c < 0x20) {
                        sb.append(String.format("\\u%04x", (int) c));
                    } else {
                        sb.append(c);
                    }
            }
        }
        return sb.toString();
    }

    private byte[] intToBytes(int value) {
        return new byte[] {
            (byte) (value & 0xFF),
            (byte) ((value >> 8) & 0xFF),
            (byte) ((value >> 16) & 0xFF),
            (byte) ((value >> 24) & 0xFF)
        };
    }

    private static class GltfData {
        private final Map<String, Object> json;
        private final byte[] binaryData;

        public GltfData(Map<String, Object> json, byte[] binaryData) {
            this.json = json;
            this.binaryData = binaryData;
        }

        public Map<String, Object> getJson() {
            return json;
        }

        public byte[] getBinaryData() {
            return binaryData;
        }
    }
}
