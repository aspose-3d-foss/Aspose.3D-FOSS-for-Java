package com.aspose.threed;

import java.lang.reflect.*;

public class TestDebugOpen {
    public static void main(String[] args) {
        try {
            String stlPath = "/home/lexchou/workspace/aspose/foss.3d.java/testdata/input/stl_binary.stl";
            
            Scene scene = new Scene();
            
            java.io.InputStream fis = new java.io.FileInputStream(stlPath);
            Stream stream = new Stream(fis);
            
            System.out.println("Before open - stream position should be 0");
            
            FileFormat format = FileFormat.STL_BINARY;
            
            //Field formatField = Scene.class.getDeclaredField("format");
            //formatField.setAccessible(true);
            
            scene.open(stream, format, null);
            
            System.out.println("After open");
            System.out.println("Root: " + scene.getRootNode().getName());
            System.out.println("Children: " + scene.getRootNode().getChildNodes().size());
            
            for (Node child : scene.getRootNode().getChildNodes()) {
                Entity e = child.getEntity();
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
