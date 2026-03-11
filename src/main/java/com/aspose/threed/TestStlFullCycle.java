package com.aspose.threed;

import java.io.*;

public class TestStlFullCycle {
    public static void main(String[] args) {
        try {
            String stlPath = "/home/lexchou/workspace/aspose/foss.3d.java/testdata/input/stl_binary.stl";
            
            Scene scene = Scene.fromFile(stlPath, FileFormat.STL_BINARY);
            System.out.println("Import worked!");
            System.out.println("Root: " + scene.getRootNode().getName());
            System.out.println("Children: " + scene.getRootNode().getChildNodes().size());
            
            for (Node child : scene.getRootNode().getChildNodes()) {
                Entity e = child.getEntity();
                if (e instanceof Mesh) {
                    Mesh mesh = (Mesh) e;
                    System.out.println("  Mesh: " + mesh.getName());
                    System.out.println("  Vertices: " + mesh.getControlPoints().size());
                    System.out.println("  Polygons: " + mesh.getPolygonCount());
                }
            }
            
            String outputPath = "/home/lexchou/workspace/aspose/foss.3d.java/testdata/output/stl_full_export.stl";
            scene.save(outputPath);
            System.out.println("\nExported to: " + outputPath);
            
            java.io.File f = new java.io.File(outputPath);
            System.out.println("Exported file size: " + f.length() + " bytes");
            
            Scene reimported = Scene.fromFile(outputPath);
            System.out.println("\nRe-imported successfully!");
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
