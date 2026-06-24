package com.aspose.threed;

import com.aspose.threed.*;
import java.io.*;
import java.util.*;

public class ObjExporter implements IExporter {
    private static final Set<String> supportedExtensions = Set.of(".obj");

    @Override
    public boolean canExport(FileFormat format) {
        if (format == FileFormat.WAVEFRONTOBJ) {
            return true;
        }
        return false;
    }

    @Override
    public void export(Scene scene, Stream stream, SaveOptions options) throws ExportException {
        if (!(options instanceof ObjSaveOptions)) {
            throw new ExportException("Invalid save options for OBJ export");
        }
        ObjSaveOptions objOptions = (ObjSaveOptions) options;

        try {
            Writer writer = new OutputStreamWriter(stream.getOutputStream());

            writer.write("# Exported by Aspose.3D FOSS\n");
            writer.write("# https://github.com/aspose-3d\n\n");

            exportNodes(scene.getRootNode(), writer, objOptions);

            writer.flush();
        } catch (IOException e) {
            throw new ExportException("Failed to write OBJ file", e);
        }
    }

    private void exportNodes(Node node, Writer writer, ObjSaveOptions options) throws IOException {
        for (Node child : node.getChildNodes()) {
            exportNodes(child, writer, options);
        }

        Entity entity = node.getEntity();
        if (entity instanceof Mesh) {
            Mesh mesh = (Mesh) entity;
            exportMesh(mesh, writer, node, options);
        }
    }

    private void exportMesh(Mesh mesh, Writer writer, Node node, ObjSaveOptions options) throws IOException {
        if (options.getVerbose()) {
            writer.write("# Mesh: " + mesh.getName() + "\n");
            writer.write("# Node: " + node.getName() + "\n");
        }

        writer.write("o " + mesh.getName() + "\n");

        if (options.getFlipCoordinateSystem()) {
            for (Vector4 v : mesh.getControlPoints()) {
                writer.write(String.format("v %f %f %f\n", v.x, v.y, -v.z));
            }
        } else {
            for (Vector4 v : mesh.getControlPoints()) {
                writer.write(String.format("v %f %f %f\n", v.x, v.y, v.z));
            }
        }

        VertexElementUV uvElement = mesh.getVertexElementOfUV(TextureMapping.DIFFUSE);
        if (uvElement != null) {
            List<Object> uvData = uvElement.getData();
            for (Object uv : uvData) {
                if (uv instanceof Vector2) {
                    Vector2 v = (Vector2) uv;
                    writer.write(String.format("vt %f %f\n", v.x, v.y));
                }
            }
        }

        VertexElementNormal normalElement = (VertexElementNormal) mesh.getElement(VertexElementType.NORMAL);
        if (normalElement != null) {
            List<Object> normalData = normalElement.getData();
            for (Object n : normalData) {
                if (n instanceof Vector3) {
                    Vector3 v = (Vector3) n;
                    if (options.getFlipCoordinateSystem()) {
                        writer.write(String.format("vn %f %f %f\n", v.x, v.y, -v.z));
                    } else {
                        writer.write(String.format("vn %f %f %f\n", v.x, v.y, v.z));
                    }
                }
            }
        }

        Material material = node.getMaterial();
        if (material != null && options.getEnableMaterials()) {
            writer.write("usemtl " + material.getName() + "\n");
        }

        boolean hasUV = uvElement != null;
        boolean hasNormal = normalElement != null;

        for (int[] polygon : mesh.getPolygons()) {
            StringBuilder sb = new StringBuilder("f");
            for (int idx : polygon) {
                int vIdx = idx + 1;
                sb.append(" ").append(vIdx);

                if (hasUV) {
                    sb.append("/").append(vIdx);
                    if (hasNormal) {
                        sb.append("/").append(vIdx);
                    }
                } else if (hasNormal) {
                    sb.append("//").append(vIdx);
                }
            }
            sb.append("\n");
            writer.write(sb.toString());
        }

        writer.write("\n");
    }
}
