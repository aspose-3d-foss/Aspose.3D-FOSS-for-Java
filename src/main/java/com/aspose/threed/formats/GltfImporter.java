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

                if (chunkType == 0x4E4F534A) { // JSON chunk
                    jsonChunk = chunkData;
                } else if (chunkType == 0x004E4942) { // BIN chunk
                    binaryChunk = chunkData;
                }

                chunkOffset += 8 + chunkLength;
            }

            if (jsonChunk == null) {
                throw new ImportException("Missing JSON chunk in glTF binary file");
            }

            String jsonStr = new String(jsonChunk, "UTF-8");
            return buildSceneFromJson(jsonStr, options, scene, rootNode);

        } catch (Exception e) {
            throw new ImportException("Failed to parse binary glTF", e);
        }
    }

    private Scene loadAsciiGltf(byte[] content, GltfLoadOptions options, Scene scene, Node rootNode) throws ImportException {
        try {
            String jsonStr = new String(content, "UTF-8");
            return buildSceneFromJson(jsonStr, options, scene, rootNode);
        } catch (Exception e) {
            throw new ImportException("Failed to parse ASCII glTF", e);
        }
    }

    private Scene buildSceneFromJson(String jsonStr, GltfLoadOptions options, Scene scene, Node rootNode) throws ImportException {
        throw new ImportException("glTF import not yet fully implemented - stub");
    }

    private int readUint32(byte[] data, int offset) {
        return (data[offset] & 0xFF) |
               ((data[offset + 1] & 0xFF) << 8) |
               ((data[offset + 2] & 0xFF) << 16) |
               ((data[offset + 3] & 0xFF) << 24);
    }
}
