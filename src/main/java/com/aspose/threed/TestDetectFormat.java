package com.aspose.threed;

import java.nio.file.*;
import java.io.*;

public class TestDetectFormat {
    public static void main(String[] args) {
        try {
            String stlPath = "/home/lexchou/workspace/aspose/foss.3d.java/testdata/input/stl_binary.stl";
            
            FileFormat detected = FileFormat.detect(stlPath);
            System.out.println("Detected format: " + detected);
            System.out.println("Can import: " + detected.getCanImport());
            System.out.println("Can export: " + detected.getCanExport());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
