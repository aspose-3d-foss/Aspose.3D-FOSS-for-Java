package com.aspose.threed.formats;

import com.aspose.threed.*;
import java.io.*;
import java.util.*;

public class StlImporter implements IImporter {
    private static final Set<String> supportedExtensions = Set.of(".stl");

    @Override
    public boolean canImport(FileFormat format) {
        if (format == FileFormat.STL_BINARY || format == FileFormat.STLASCII) {
            return true;
        }
        return false;
    }

    @Override
    public Scene load(Stream stream, LoadOptions options) throws ImportException {
        System.out.println("StlImporter.load() called");
        if (!(options instanceof StlLoadOptions)) {
            options = new StlLoadOptions();
        }
        StlLoadOptions stlOptions = (StlLoadOptions) options;
        System.out.println("Content type: " + stlOptions.getContentType());

        Scene scene = new Scene();
        Node rootNode = scene.getRootNode();

        try {
            byte[] header = new byte[80];
            System.out.println("    StlImporter: reading header...");
            int bytesRead = stream.read(header);
            System.out.println("    StlImporter: read " + bytesRead + " bytes");
            
            if (bytesRead < 80) {
                throw new ImportException("Invalid STL file - too short, read " + bytesRead + " of 80");
            }
            
            String headerStr = readHeaderString(header);
            
            if (isAsciiHeader(header)) {
                return loadAscii(stream, stlOptions, scene, rootNode, headerStr);
            }
            
            byte[] faceCountBytes = new byte[4];
            if (stream.read(faceCountBytes) < 4) {
                throw new ImportException("Invalid STL binary file");
            }

            int faceCount = readUint32(faceCountBytes);

            Mesh mesh = new Mesh(headerStr.isEmpty() ? "Mesh" : headerStr);
            List<Vector3> vertices = new ArrayList<>();

            for (int i = 0; i < faceCount; i++) {
                byte[] buf = new byte[48];
                if (stream.read(buf) < 48) {
                    throw new ImportException("Unexpected end of file");
                }
                
                double x0 = Float.intBitsToFloat(readUint32(Arrays.copyOfRange(buf, 12, 16)));
                double y0 = Float.intBitsToFloat(readUint32(Arrays.copyOfRange(buf, 16, 20)));
                double z0 = Float.intBitsToFloat(readUint32(Arrays.copyOfRange(buf, 20, 24)));
                vertices.add(new Vector3(x0, y0, z0));

                double x1 = Float.intBitsToFloat(readUint32(Arrays.copyOfRange(buf, 24, 28)));
                double y1 = Float.intBitsToFloat(readUint32(Arrays.copyOfRange(buf, 28, 32)));
                double z1 = Float.intBitsToFloat(readUint32(Arrays.copyOfRange(buf, 32, 36)));
                vertices.add(new Vector3(x1, y1, z1));

                double x2 = Float.intBitsToFloat(readUint32(Arrays.copyOfRange(buf, 36, 40)));
                double y2 = Float.intBitsToFloat(readUint32(Arrays.copyOfRange(buf, 40, 44)));
                double z2 = Float.intBitsToFloat(readUint32(Arrays.copyOfRange(buf, 44, 48)));
                vertices.add(new Vector3(x2, y2, z2));

                int v0 = vertices.size() - 3;
                int v1 = vertices.size() - 2;
                int v2 = vertices.size() - 1;

                int[] face = new int[]{v0, v1, v2};
                mesh.createPolygon(face);

                byte[] attribute = new byte[2];
                stream.read(attribute);
            }

            for (Vector3 v : vertices) {
                mesh.addControlPoint(v.x, v.y, v.z);
            }

            Node meshNode = rootNode.createChildNode(headerStr.isEmpty() ? "Mesh" : headerStr, mesh);

            if (stlOptions.getFlipCoordinateSystem()) {
                for (int i = 0; i < mesh.getControlPoints().size(); i++) {
                    Vector4 cp = mesh.getControlPoints().get(i);
                    mesh.getControlPoints().set(i, new Vector4(cp.x, cp.y, -cp.z, cp.w));
                }
            }

            return scene;

        } catch (IOException e) {
            throw new ImportException("Failed to read STL file", e);
        }
    }

    private boolean isAsciiHeader(byte[] header) {
        for (int i = 0; i < 80; i++) {
            char c = (char) header[i];
            if (c < 32 || c > 126) {
                return false;
            }
        }
        return true;
    }

    private String readHeaderString(byte[] header) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 80; i++) {
            char c = (char) header[i];
            if (c >= 32 && c <= 126) {
                sb.append(c);
            }
        }
        return sb.toString().trim();
    }

    private int readUint32(byte[] bytes) {
        return (bytes[3] & 0xFF) << 24 |
               (bytes[2] & 0xFF) << 16 |
               (bytes[1] & 0xFF) << 8 |
               (bytes[0] & 0xFF);
    }

    private Scene loadAscii(Stream stream, StlLoadOptions stlOptions, Scene scene, Node rootNode, String header) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        Mesh mesh = new Mesh(header.isEmpty() ? "Mesh" : header);
        Map<String, Integer> vertexMap = new HashMap<>();
        List<Vector3> vertices = new ArrayList<>();

        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");
            String keyword = parts[0];

            try {
                switch (keyword) {
                    case "vertex":
                        if (parts.length >= 4) {
                            double x = Double.parseDouble(parts[1]);
                            double y = Double.parseDouble(parts[2]);
                            double z = Double.parseDouble(parts[3]);
                            String key = String.format("%.6f,%.6f,%.6f", x, y, z);
                            
                            Integer idx = vertexMap.get(key);
                            if (idx == null) {
                                idx = vertices.size();
                                vertexMap.put(key, idx);
                                vertices.add(new Vector3(x, y, z));
                            }
                            faceVertices.add(idx);
                        }
                        break;
                    case "endloop":
                        if (faceVertices.size() >= 3) {
                            int[] indices = new int[3];
                            for (int i = 0; i < 3; i++) {
                                indices[i] = faceVertices.get(i);
                            }
                            mesh.createPolygon(indices);
                        }
                        faceVertices.clear();
                        break;
                    case "endsolid":
                        for (Vector3 v : vertices) {
                            mesh.addControlPoint(v.x, v.y, v.z);
                        }
                        Node meshNode = rootNode.createChildNode(header.isEmpty() ? "Mesh" : header, mesh);
                        
                        if (stlOptions.getFlipCoordinateSystem()) {
                            for (int i = 0; i < mesh.getControlPoints().size(); i++) {
                                Vector4 cp = mesh.getControlPoints().get(i);
                                mesh.getControlPoints().set(i, new Vector4(cp.x, cp.y, -cp.z, cp.w));
                            }
                        }
                        return scene;
                }
            } catch (NumberFormatException e) {
            }
        }

        return scene;
    }

    private final List<Integer> faceVertices = new ArrayList<>();
}
