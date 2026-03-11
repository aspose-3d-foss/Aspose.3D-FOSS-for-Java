package com.aspose.threed.formats;

import com.aspose.threed.*;
import java.io.*;
import java.util.*;

public class ObjImporter implements IImporter {
    private static final Set<String> supportedExtensions = Set.of(".obj");

    @Override
    public boolean canImport(FileFormat format) {
        if (format == FileFormat.WAVEFRONTOBJ) {
            return true;
        }
        return false;
    }

    @Override
    public Scene load(Stream stream, LoadOptions options) throws ImportException {
        if (!(options instanceof ObjLoadOptions)) {
            options = new ObjLoadOptions();
        }
        ObjLoadOptions objOptions = (ObjLoadOptions) options;

        Scene scene = new Scene();
        Node rootNode = scene.getRootNode();

        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        List<Vector3> vertices = new ArrayList<>();
        List<Vector3> normals = new ArrayList<>();
        List<Vector2> uvs = new ArrayList<>();
        List<ObjFace> faces = new ArrayList<>();
        List<ObjGroup> groups = new ArrayList<>();
        Map<String, Material> materials = new HashMap<>();
        Material currentMaterial = null;

        String currentObjectName = "Mesh";

        try {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }

                String[] parts = line.split("\\s+");
                String keyword = parts[0];

                try {
                    switch (keyword) {
                        case "v":
                            if (parts.length >= 4) {
                                double x = Double.parseDouble(parts[1]);
                                double y = Double.parseDouble(parts[2]);
                                double z = Double.parseDouble(parts[3]);
                                vertices.add(new Vector3(x, y, z));
                            }
                            break;
                        case "vn":
                            if (parts.length >= 4) {
                                double x = Double.parseDouble(parts[1]);
                                double y = Double.parseDouble(parts[2]);
                                double z = Double.parseDouble(parts[3]);
                                normals.add(new Vector3(x, y, z));
                            }
                            break;
                        case "vt":
                            if (parts.length >= 3) {
                                double u = Double.parseDouble(parts[1]);
                                double v = Double.parseDouble(parts[2]);
                                uvs.add(new Vector2(u, v));
                            }
                            break;
                        case "f":
                            faces.add(parseFace(line));
                            break;
                        case "g":
                        case "o":
                            if (parts.length > 1) {
                                currentObjectName = parts[1];
                            }
                            break;
                        case "usemtl":
                            if (parts.length > 1 && objOptions.getEnableMaterials()) {
                                String matName = parts[1];
                                currentMaterial = materials.get(matName);
                                if (currentMaterial == null) {
                                    currentMaterial = new Material(matName);
                                    materials.put(matName, currentMaterial);
                                }
                            }
                            break;
                        case "mtllib":
                            if (parts.length > 1 && objOptions.getEnableMaterials()) {
                                String mtlFile = parts[1];
                                loadMaterials(mtlFile, materials, reader);
                            }
                            break;
                    }
                } catch (NumberFormatException e) {
                }
            }

            if (objOptions.getFlipCoordinateSystem()) {
                for (Vector3 v : vertices) {
                    v.z = -v.z;
                }
            }

            if (objOptions.getScale() != 1.0) {
                double scale = objOptions.getScale();
                for (Vector3 v : vertices) {
                    v.x *= scale;
                    v.y *= scale;
                    v.z *= scale;
                }
            }

            Mesh mesh = new Mesh(currentObjectName);
            for (Vector3 v : vertices) {
                mesh.addControlPoint(v.x, v.y, v.z);
            }

            for (ObjFace face : faces) {
                int[] indices = new int[face.vertexIndices.size()];
                for (int i = 0; i < face.vertexIndices.size(); i++) {
                    indices[i] = face.vertexIndices.get(i) - 1;
                }
                mesh.createPolygon(indices);
            }

            Node meshNode = rootNode.createChildNode(currentObjectName, mesh);
            if (currentMaterial != null && objOptions.getEnableMaterials()) {
                meshNode.setMaterial(currentMaterial);
            }

            if (mesh.getControlPoints().isEmpty() || mesh.getPolygonCount() == 0) {
                throw new ImportException("No valid geometry found in file");
            }

            return scene;

        } catch (IOException e) {
            throw new ImportException("Failed to read OBJ file", e);
        }
    }

    private ObjFace parseFace(String line) {
        ObjFace face = new ObjFace();
        String[] parts = line.split("\\s+");
        for (int i = 1; i < parts.length; i++) {
            String vertexDef = parts[i];
            String[] indices = vertexDef.split("/");

            if (indices.length > 0 && !indices[0].isEmpty()) {
                face.vertexIndices.add(Integer.parseInt(indices[0]));
            }
            if (indices.length > 1 && !indices[1].isEmpty()) {
                face.texCoordIndices.add(Integer.parseInt(indices[1]));
            }
            if (indices.length > 2 && !indices[2].isEmpty()) {
                face.normalIndices.add(Integer.parseInt(indices[2]));
            }
        }
        return face;
    }

    private void loadMaterials(String mtlFile, Map<String, Material> materials, BufferedReader mainReader) {
        try {
            File file = new File(mtlFile);
            if (!file.exists()) {
                return;
            }
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            String currentMatName = null;
            Vector3 kd = null;
            Vector3 ka = null;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }

                String[] parts = line.split("\\s+");
                String keyword = parts[0];

                switch (keyword) {
                    case "newmtl":
                        if (currentMatName != null && kd != null) {
                            Material mat = new Material(currentMatName);
                            materials.put(currentMatName, mat);
                        }
                        if (parts.length > 1) {
                            currentMatName = parts[1];
                            kd = null;
                            ka = null;
                        }
                        break;
                    case "Kd":
                        if (parts.length >= 4) {
                            kd = new Vector3(
                                Double.parseDouble(parts[1]),
                                Double.parseDouble(parts[2]),
                                Double.parseDouble(parts[3])
                            );
                        }
                        break;
                    case "Ka":
                        if (parts.length >= 4) {
                            ka = new Vector3(
                                Double.parseDouble(parts[1]),
                                Double.parseDouble(parts[2]),
                                Double.parseDouble(parts[3])
                            );
                        }
                        break;
                }
            }

            if (currentMatName != null) {
                Material mat = new Material(currentMatName);
                materials.put(currentMatName, mat);
            }

            reader.close();
        } catch (IOException e) {
        }
    }

    private static class ObjFace {
        List<Integer> vertexIndices = new ArrayList<>();
        List<Integer> texCoordIndices = new ArrayList<>();
        List<Integer> normalIndices = new ArrayList<>();
    }

    private static class ObjGroup {
        String name;
        String material;
        List<ObjFace> faces = new ArrayList<>();
    }
}
