package com.aspose.threed;

import java.nio.file.*;
import java.io.*;

public class TestStlStructure {
    public static void main(String[] args) {
        try {
            String stlPath = args.length > 0 ? args[0] : "../testdata/input/stl_binary.stl";
            
            byte[] data = Files.readAllBytes(new java.io.File(stlPath).toPath());
            int faceCount = (data[83] & 0xFF) << 24 |
                           (data[82] & 0xFF) << 16 |
                           (data[81] & 0xFF) << 8 |
                           (data[80] & 0xFF);
            
            System.out.println("Total faces: " + faceCount);
            
            for (int i = 0; i < 3; i++) {
                int offset = 84 + i * 50;
                System.out.println("\nFace " + i + " at offset " + offset + ":");
                
                System.out.print("  Normal: ");
                for (int j = 0; j < 12; j++) {
                    System.out.printf("%02x ", data[offset + j] & 0xFF);
                }
                System.out.println();
                
                System.out.print("  V1: ");
                for (int j = 0; j < 12; j++) {
                    System.out.printf("%02x ", data[offset + 12 + j] & 0xFF);
                }
                System.out.println();
                
                System.out.print("  V2: ");
                for (int j = 0; j < 12; j++) {
                    System.out.printf("%02x ", data[offset + 24 + j] & 0xFF);
                }
                System.out.println();
                
                System.out.print("  V3: ");
                for (int j = 0; j < 12; j++) {
                    System.out.printf("%02x ", data[offset + 36 + j] & 0xFF);
                }
                System.out.println();
                
                System.out.print("  Attr: ");
                for (int j = 0; j < 2; j++) {
                    System.out.printf("%02x ", data[offset + 48 + j] & 0xFF);
                }
                System.out.println();
                
                float nx = Float.intBitsToFloat((data[offset + 3] & 0xFF) << 24 |
                                               (data[offset + 2] & 0xFF) << 16 |
                                               (data[offset + 1] & 0xFF) << 8 |
                                               (data[offset] & 0xFF));
                float vx1 = Float.intBitsToFloat((data[offset + 15] & 0xFF) << 24 |
                                                (data[offset + 14] & 0xFF) << 16 |
                                                (data[offset + 13] & 0xFF) << 8 |
                                                (data[offset + 12] & 0xFF));
                
                System.out.println("  Normal.x = " + nx);
                System.out.println("  V1.x = " + vx1);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
