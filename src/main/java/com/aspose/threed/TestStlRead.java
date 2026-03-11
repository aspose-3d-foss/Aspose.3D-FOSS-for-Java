package com.aspose.threed;

import java.nio.file.*;
import java.io.*;
import java.util.*;

public class TestStlRead {
    public static void main(String[] args) {
        try {
            String stlPath = args.length > 0 ? args[0] : "../testdata/input/stl_binary.stl";
            
            byte[] data = Files.readAllBytes(new java.io.File(stlPath).toPath());
            int faceCount = (data[83] & 0xFF) << 24 |
                           (data[82] & 0xFF) << 16 |
                           (data[81] & 0xFF) << 8 |
                           (data[80] & 0xFF);
            
            System.out.println("Face count: " + faceCount);
            
            Mesh mesh = new Mesh("Test");
            List<Vector3> vertices = new ArrayList<>();
            
            for (int i = 0; i < 3; i++) {
                int offset = 84 + i * 50;
                byte[] buf = new byte[48];
                System.arraycopy(data, offset, buf, 0, 48);
                
                for (int j = 0; j < 12; j++) {
                    float v = Float.intBitsToFloat(readUint32(Arrays.copyOfRange(buf, j * 4, j * 4 + 4)));
                }
                
                double x0 = Float.intBitsToFloat(readUint32(Arrays.copyOfRange(buf, 12, 16)));
                double y0 = Float.intBitsToFloat(readUint32(Arrays.copyOfRange(buf, 16, 20)));
                double z0 = Float.intBitsToFloat(readUint32(Arrays.copyOfRange(buf, 20, 24)));
                System.out.println("V0: " + x0 + ", " + y0 + ", " + z0);
                
                vertices.add(new Vector3(x0, y0, z0));
                
                double x1 = Float.intBitsToFloat(readUint32(Arrays.copyOfRange(buf, 24, 28)));
                double y1 = Float.intBitsToFloat(readUint32(Arrays.copyOfRange(buf, 28, 32)));
                double z1 = Float.intBitsToFloat(readUint32(Arrays.copyOfRange(buf, 32, 36)));
                System.out.println("V1: " + x1 + ", " + y1 + ", " + z1);
                
                double x2 = Float.intBitsToFloat(readUint32(Arrays.copyOfRange(buf, 36, 40)));
                double y2 = Float.intBitsToFloat(readUint32(Arrays.copyOfRange(buf, 40, 44)));
                double z2 = Float.intBitsToFloat(readUint32(Arrays.copyOfRange(buf, 44, 48)));
                System.out.println("V2: " + x2 + ", " + y2 + ", " + z2);
                
                double x3 = Float.intBitsToFloat(readUint32(Arrays.copyOfRange(buf, 48, 52)));
                double y3 = Float.intBitsToFloat(readUint32(Arrays.copyOfRange(buf, 52, 56)));
                double z3 = Float.intBitsToFloat(readUint32(Arrays.copyOfRange(buf, 56, 60)));
                System.out.println("V3: " + x3 + ", " + y3 + ", " + z3);
                
                int v0 = vertices.size() - 4;
                int v1 = vertices.size() - 3;
                int v2 = vertices.size() - 2;
                int v3 = vertices.size() - 1;
                
                int[] face1 = new int[]{v0, v1, v2};
                int[] face2 = new int[]{v2, v3, v0};
                
                mesh.createPolygon(face1);
                mesh.createPolygon(face2);
            }
            
            for (Vector3 v : vertices) {
                mesh.addControlPoint(v.x, v.y, v.z);
            }
            
            System.out.println("\nMesh vertices: " + mesh.getControlPoints().size());
            System.out.println("Mesh polygons: " + mesh.getPolygonCount());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static int readUint32(byte[] bytes) {
        return (bytes[3] & 0xFF) << 24 |
               (bytes[2] & 0xFF) << 16 |
               (bytes[1] & 0xFF) << 8 |
               (bytes[0] & 0xFF);
    }
}
