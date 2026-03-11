package com.aspose.threed;

import java.nio.file.*;
import java.io.*;

public class TestStlFullImport {
    public static void main(String[] args) {
        try {
            String stlPath = args.length > 0 ? args[0] : "../testdata/input/stl_binary.stl";
            
            Scene scene = Scene.fromFile(stlPath);
            System.out.println("Scene root: " + scene.getRootNode().getName());
            System.out.println("Child count: " + scene.getRootNode().getChildNodes().size());
            
            for (Node child : scene.getRootNode().getChildNodes()) {
                System.out.println("Child: " + child.getName());
                Entity e = child.getEntity();
                System.out.println("  Entity class: " + e.getClass().getName());
                if (e instanceof Mesh) {
                    Mesh mesh = (Mesh) e;
                    System.out.println("  Mesh vertices: " + mesh.getControlPoints().size());
                    System.out.println("  Mesh polygons: " + mesh.getPolygonCount());
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
