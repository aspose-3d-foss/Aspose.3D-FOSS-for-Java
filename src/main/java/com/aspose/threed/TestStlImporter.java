package com.aspose.threed;

import java.nio.file.*;
import java.io.*;
import java.util.*;

public class TestStlImporter {
    public static void main(String[] args) {
        try {
            String stlPath = args.length > 0 ? args[0] : "../testdata/input/stl_binary.stl";
            System.out.println("Reading: " + stlPath);
            
            byte[] data = Files.readAllBytes(new java.io.File(stlPath).toPath());
            System.out.println("File size: " + data.length + " bytes");
            
            int faceCount = (data[83] & 0xFF) << 24 |
                           (data[82] & 0xFF) << 16 |
                           (data[81] & 0xFF) << 8 |
                           (data[80] & 0xFF);
            System.out.println("Face count from file: " + faceCount);
            
            int expectedSize = 80 + 4 + faceCount * 50;
            System.out.println("Expected size: " + expectedSize);
            
            Mesh mesh = new Mesh("Test");
            for (int i = 0; i < faceCount; i++) {
                int offset = 84 + i * 50;
                if (offset + 48 > data.length) {
                    System.out.println("End of data at face " + i);
                    break;
                }
                
                int v0 = mesh.getControlPoints().size();
                
                for (int j = 0; j < 4; j++) {
                    int dataOffset = offset + 12 + j * 12;
                    float x = Float.intBitsToFloat(readInt(data, dataOffset));
                    float y = Float.intBitsToFloat(readInt(data, dataOffset + 4));
                    float z = Float.intBitsToFloat(readInt(data, dataOffset + 8));
                    mesh.addControlPoint(x, y, z);
                }
                
                int[] face = new int[]{v0, v0 + 1, v0 + 2};
                mesh.createPolygon(face);
            }
            
            System.out.println("Mesh vertices: " + mesh.getControlPoints().size());
            System.out.println("Mesh polygons: " + mesh.getPolygonCount());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static int readInt(byte[] b, int offset) {
        return (b[offset + 3] & 0xFF) << 24 |
               (b[offset + 2] & 0xFF) << 16 |
               (b[offset + 1] & 0xFF) << 8 |
               (b[offset] & 0xFF);
    }
}
