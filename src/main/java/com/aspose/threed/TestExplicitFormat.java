package com.aspose.threed;

import java.nio.file.*;
import java.io.*;

public class TestExplicitFormat {
    public static void main(String[] args) {
        try {
            String stlPath = "/home/lexchou/workspace/aspose/foss.3d.java/testdata/input/stl_binary.stl";
            
            System.out.println("Using STL_BINARY format explicitly...");
            Scene scene = Scene.fromFile(stlPath, FileFormat.STL_BINARY);
            System.out.println("Root: " + scene.getRootNode().getName());
            System.out.println("Children: " + scene.getRootNode().getChildNodes().size());
            
            for (Node child : scene.getRootNode().getChildNodes()) {
                Entity e = child.getEntity();
                if (e instanceof Mesh) {
                    Mesh mesh = (Mesh) e;
                    System.out.println("Mesh vertices: " + mesh.getControlPoints().size());
                    System.out.println("Mesh polygons: " + mesh.getPolygonCount());
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
