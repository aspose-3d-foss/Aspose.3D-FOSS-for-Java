package com.aspose.threed.formats;

import com.aspose.threed.*;
import java.io.*;
import java.util.*;

public class TestStlImporterDirect {
    public static void main(String[] args) {
        try {
            String stlPath = "/home/lexchou/workspace/aspose/foss.3d.java/testdata/input/stl_binary.stl";
            
            InputStream fis = new FileInputStream(stlPath);
            Stream stream = new Stream(fis);
            
            IImporter importer = new StlImporter();
            FileFormat format = FileFormat.STL_BINARY;
            
            System.out.println("Can import: " + importer.canImport(format));
            
            LoadOptions options = new StlLoadOptions(FileContentType.BINARY);
            
            Scene scene = importer.load(stream, options);
            System.out.println("Scene: " + scene);
            System.out.println("Root node: " + scene.getRootNode().getName());
            System.out.println("Child count: " + scene.getRootNode().getChildNodes().size());
            
            for (Node child : scene.getRootNode().getChildNodes()) {
                Entity e = child.getEntity();
                System.out.println("Entity: " + e.getClass().getName());
                if (e instanceof Mesh) {
                    Mesh mesh = (Mesh) e;
                    System.out.println("Mesh vertices: " + mesh.getControlPoints().size());
                    System.out.println("Mesh polygons: " + mesh.getPolygonCount());
                    
                    if (mesh.getControlPoints().size() > 0) {
                        Vector4 v = mesh.getControlPoints().get(0);
                        System.out.println("First vertex: (" + v.x + ", " + v.y + ", " + v.z + ")");
                    }
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
