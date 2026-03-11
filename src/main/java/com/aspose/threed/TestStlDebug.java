package com.aspose.threed;

import java.nio.file.*;
import java.io.*;

public class TestStlDebug {
    public static void main(String[] args) {
        try {
            String stlPath = args.length > 0 ? args[0] : "../testdata/input/stl_binary.stl";
            System.out.println("Reading: " + stlPath);
            
            byte[] data = Files.readAllBytes(new java.io.File(stlPath).toPath());
            System.out.println("File size: " + data.length + " bytes");
            
            for (int i = 0; i < data.length && i < 100; i++) {
                System.out.printf("%02x ", data[i] & 0xFF);
                if ((i + 1) % 16 == 0) System.out.println();
            }
            System.out.println();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
