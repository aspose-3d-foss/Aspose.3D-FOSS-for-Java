package com.aspose.threed;

import java.io.*;
import com.aspose.threed.formats.*;

public class TestObjImporterOnStl {
    public static void main(String[] args) {
        try {
            String stlPath = "/home/lexchou/workspace/aspose/foss.3d.java/testdata/input/stl_binary.stl";
            
            InputStream fis = new FileInputStream(stlPath);
            Stream stream = new Stream(fis);
            
            IImporter importer = new ObjImporter();
            FileFormat format = FileFormat.WAVEFRONTOBJ;
            
            System.out.println("OBJImporter.canImport(STL): " + importer.canImport(FileFormat.STL_BINARY));
            
            LoadOptions options = new ObjLoadOptions();
            
            try {
                Scene scene = importer.load(stream, options);
                System.out.println("OBJImporter succeeded unexpectedly!");
                System.out.println("Child count: " + scene.getRootNode().getChildNodes().size());
            } catch (ImportException e) {
                System.out.println("OBJImporter failed as expected: " + e.getMessage());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
