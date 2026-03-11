package com.aspose.threed.formats;

import com.aspose.threed.*;
import java.io.*;

public class DebugStlImporter implements IImporter {
    @Override
    public boolean canImport(FileFormat format) {
        return format == FileFormat.STL_BINARY || format == FileFormat.STLASCII;
    }

    @Override
    public Scene load(Stream stream, LoadOptions options) throws ImportException {
        System.out.println("DebugStlImporter.load() called");
        System.out.println("Options class: " + options.getClass().getName());
        
        if (!(options instanceof StlLoadOptions)) {
            options = new StlLoadOptions();
        }
        StlLoadOptions stlOptions = (StlLoadOptions) options;

        System.out.println("Flip coord: " + stlOptions.getFlipCoordinateSystem());
        System.out.println("Content type: " + stlOptions.getContentType());
        
        Scene scene = new Scene();
        Node rootNode = scene.getRootNode();

        try {
            byte[] header = new byte[80];
            int bytesRead = stream.read(header);
            System.out.println("Read header: " + bytesRead + " bytes");
            
            if (bytesRead < 80) {
                throw new ImportException("Invalid STL file - too short");
            }
            
            System.out.println("Header bytes: ");
            for (int i = 0; i < 20; i++) {
                System.out.printf("%02x ", header[i] & 0xFF);
            }
            System.out.println();
            
            String headerStr = readHeaderString(header);
            System.out.println("Header string: '" + headerStr + "'");
            
            byte[] faceCountBytes = new byte[4];
            if (stream.read(faceCountBytes) < 4) {
                throw new ImportException("Invalid STL binary file");
            }

            int faceCount = readUint32(faceCountBytes);
            System.out.println("Face count: " + faceCount);

            Mesh mesh = new Mesh(headerStr.isEmpty() ? "Mesh" : headerStr);
            System.out.println("Created mesh: " + mesh.getName());

            rootNode.createChildNode("Test", mesh);

            return scene;

        } catch (IOException e) {
            throw new ImportException("Failed to read STL file", e);
        }
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
}
