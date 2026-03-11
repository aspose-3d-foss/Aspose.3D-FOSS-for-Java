package com.aspose.threed;

import java.io.*;
import com.aspose.threed.formats.*;

public class TestDebugImporter {
    public static void main(String[] args) {
        try {
            String stlPath = "/home/lexchou/workspace/aspose/foss.3d.java/testdata/input/stl_binary.stl";
            
            InputStream fis = new FileInputStream(stlPath);
            Stream stream = new Stream(fis);
            
            IImporter importer = new DebugStlImporter();
            FileFormat format = FileFormat.STL_BINARY;
            
            System.out.println("Can import: " + importer.canImport(format));
            
            LoadOptions options = new StlLoadOptions();
            System.out.println("Loading...");
            
            Scene scene = importer.load(stream, options);
            System.out.println("Scene: " + scene);
            System.out.println("Root node: " + scene.getRootNode().getName());
            System.out.println("Child count: " + scene.getRootNode().getChildNodes().size());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
