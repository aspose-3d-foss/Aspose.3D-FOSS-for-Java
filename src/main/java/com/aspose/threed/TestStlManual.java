package com.aspose.threed;

import java.nio.file.*;
import java.io.*;

public class TestStlManual {
    public static void main(String[] args) {
        try {
            String stlPath = "/home/lexchou/workspace/aspose/foss.3d.java/testdata/input/stl_binary.stl";
            
            byte[] data = Files.readAllBytes(new java.io.File(stlPath).toPath());
            int faceCount = (data[83] & 0xFF) << 24 |
                           (data[82] & 0xFF) << 16 |
                           (data[81] & 0xFF) << 8 |
                           (data[80] & 0xFF);
            
            Mesh mesh = new Mesh("TestMesh");
            System.out.println("Initial control points: " + mesh.getControlPoints().size());
            
            for (int i = 0; i < 3; i++) {
                int offset = 84 + i * 50;
                double x = Float.intBitsToFloat((data[offset + 15] & 0xFF) << 24 |
                                               (data[offset + 14] & 0xFF) << 16 |
                                               (data[offset + 13] & 0xFF) << 8 |
                                               (data[offset + 12] & 0xFF));
                double y = Float.intBitsToFloat((data[offset + 19] & 0xFF) << 24 |
                                               (data[offset + 18] & 0xFF) << 16 |
                                               (data[offset + 17] & 0xFF) << 8 |
                                               (data[offset + 16] & 0xFF));
                double z = Float.intBitsToFloat((data[offset + 23] & 0xFF) << 24 |
                                               (data[offset + 22] & 0xFF) << 16 |
                                               (data[offset + 21] & 0xFF) << 8 |
                                               (data[offset + 20] & 0xFF));
                
                System.out.println("Adding vertex " + i + ": " + x + ", " + y + ", " + z);
                mesh.addControlPoint(x, y, z);
                System.out.println("  Control points now: " + mesh.getControlPoints().size());
            }
            
            for (int i = 0; i < 3; i++) {
                int v0 = i * 3;
                int v1 = i * 3 + 1;
                int v2 = i * 3 + 2;
                mesh.createPolygon(new int[]{v0, v1, v2});
            }
            System.out.println("Polygons: " + mesh.getPolygonCount());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
