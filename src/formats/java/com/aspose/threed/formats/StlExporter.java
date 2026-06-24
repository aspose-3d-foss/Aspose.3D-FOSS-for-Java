package com.aspose.threed.formats;

import com.aspose.threed.*;
import java.io.*;
import java.util.*;

public class StlExporter implements IExporter {
    private static final Set<String> supportedExtensions = Set.of(".stl");

    @Override
    public boolean canExport(FileFormat format) {
        if (format == FileFormat.STL_BINARY || format == FileFormat.STLASCII) {
            return true;
        }
        return false;
    }

    @Override
    public void export(Scene scene, Stream stream, SaveOptions options) throws ExportException {
        if (!(options instanceof StlSaveOptions)) {
            options = new StlSaveOptions();
        }
        StlSaveOptions stlOptions = (StlSaveOptions) options;

        try {
            if (stlOptions.getContentType() == FileContentType.BINARY) {
                exportBinary(scene, stream);
            } else {
                exportAscii(scene, stream);
            }
        } catch (IOException e) {
            throw new ExportException("Failed to write STL file", e);
        }
    }

    private void exportBinary(Scene scene, Stream stream) throws IOException {
        byte[] header = new byte[80];
        for (int i = 0; i < header.length; i++) header[i] = 0;
        String name = "Aspose3DExport";
        for (int i = 0; i < name.length() && i < 80; i++) {
            header[i] = (byte) name.charAt(i);
        }
        stream.getOutputStream().write(header);

        int faceCount = countFaces(scene);
        byte[] faceCountBytes = new byte[4];
        faceCountBytes[0] = (byte) (faceCount & 0xFF);
        faceCountBytes[1] = (byte) ((faceCount >> 8) & 0xFF);
        faceCountBytes[2] = (byte) ((faceCount >> 16) & 0xFF);
        faceCountBytes[3] = (byte) ((faceCount >> 24) & 0xFF);
        stream.getOutputStream().write(faceCountBytes);

        for (Node node : findNodesWithMesh(scene.getRootNode())) {
            Entity entity = node.getEntity();
            if (entity instanceof Mesh) {
                Mesh mesh = (Mesh) entity;
                exportMeshBinary(mesh, stream);
            }
        }

        stream.getOutputStream().flush();
    }

    private void exportMeshBinary(Mesh mesh, Stream stream) throws IOException {
        byte[] buffer = new byte[48];

        for (int[] face : mesh.getPolygons()) {
            if (face.length < 3) continue;

            Vector3 normal = calculateNormal(mesh, face);
            writeFloat(buffer, 0, (float) normal.x);
            writeFloat(buffer, 4, (float) normal.y);
            writeFloat(buffer, 8, (float) normal.z);

            int vertexOffset = 12;
            for (int i = 0; i < 3; i++) {
                if (i < face.length) {
                    Vector4 v = mesh.getControlPoints().get(face[i]);
                    writeFloat(buffer, vertexOffset, (float) v.x);
                    writeFloat(buffer, vertexOffset + 4, (float) v.y);
                    writeFloat(buffer, vertexOffset + 8, (float) v.z);
                }
                vertexOffset += 12;
            }

            stream.getOutputStream().write(buffer);

            byte[] attr = new byte[2];
            stream.getOutputStream().write(attr);
        }
    }

    private void writeFloat(byte[] buffer, int offset, float value) {
        int bits = Float.floatToIntBits(value);
        buffer[offset] = (byte) (bits & 0xFF);
        buffer[offset + 1] = (byte) ((bits >> 8) & 0xFF);
        buffer[offset + 2] = (byte) ((bits >> 16) & 0xFF);
        buffer[offset + 3] = (byte) ((bits >> 24) & 0xFF);
    }

    private void exportAscii(Scene scene, Stream stream) throws IOException {
        Writer writer = new OutputStreamWriter(stream.getOutputStream());
        writer.write("solid Aspose3DExport\n");

        for (Node node : findNodesWithMesh(scene.getRootNode())) {
            Entity entity = node.getEntity();
            if (entity instanceof Mesh) {
                Mesh mesh = (Mesh) entity;
                exportMeshAscii(mesh, writer);
            }
        }

        writer.write("endsolid Aspose3DExport\n");
        writer.flush();
    }

    private void exportMeshAscii(Mesh mesh, Writer writer) throws IOException {
        for (int[] face : mesh.getPolygons()) {
            if (face.length < 3) continue;

            Vector3 normal = calculateNormal(mesh, face);

            writer.write(" facet normal ");
            writer.write(String.format("%.6f %.6f %.6f\n", normal.x, normal.y, normal.z));
            writer.write("  outer loop\n");

            for (int idx : face) {
                Vector4 v = mesh.getControlPoints().get(idx);
                writer.write("   vertex ");
                writer.write(String.format("%.6f %.6f %.6f\n", v.x, v.y, v.z));
            }

            writer.write("  endloop\n");
            writer.write(" endfacet\n");
        }
    }

    private List<Node> findNodesWithMesh(Node node) {
        List<Node> nodes = new ArrayList<>();
        if (node.getEntity() instanceof Mesh) {
            nodes.add(node);
        }
        for (Node child : node.getChildNodes()) {
            nodes.addAll(findNodesWithMesh(child));
        }
        return nodes;
    }

    private int countFaces(Scene scene) {
        int count = 0;
        for (Node node : findNodesWithMesh(scene.getRootNode())) {
            Entity entity = node.getEntity();
            if (entity instanceof Mesh) {
                count += ((Mesh) entity).getPolygonCount();
            }
        }
        return count;
    }

    private Vector3 calculateNormal(Mesh mesh, int[] face) {
        if (face.length < 3) return new Vector3(0, 0, 1);

        Vector4 v0 = mesh.getControlPoints().get(face[0]);
        Vector4 v1 = mesh.getControlPoints().get(face[1]);
        Vector4 v2 = mesh.getControlPoints().get(face[2]);

        double x1 = v1.x - v0.x, y1 = v1.y - v0.y, z1 = v1.z - v0.z;
        double x2 = v2.x - v0.x, y2 = v2.y - v0.y, z2 = v2.z - v0.z;

        double nx = y1 * z2 - z1 * y2;
        double ny = z1 * x2 - x1 * z2;
        double nz = x1 * y2 - y1 * x2;

        double len = Math.sqrt(nx * nx + ny * ny + nz * nz);
        if (len > 0) {
            return new Vector3(nx / len, ny / len, nz / len);
        }
        return new Vector3(0, 0, 1);
    }
}
