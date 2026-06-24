package com.aspose.threed;

import com.aspose.threed.*;
import java.io.*;
import java.util.*;

public class FbxExporter implements IExporter {
    private static final Set<String> supportedExtensions = Set.of(".fbx");

    @Override
    public boolean canExport(FileFormat format) {
        if (format.getExtension().equals("fbx")) {
            return true;
        }
        return false;
    }

    @Override
    public void export(Scene scene, Stream stream, SaveOptions options) throws ExportException {
        throw new ExportException("FBX export is not implemented in FOSS version");
    }
}
