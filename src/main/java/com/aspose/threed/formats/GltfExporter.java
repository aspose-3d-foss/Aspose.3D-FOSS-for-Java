package com.aspose.threed.formats;

import com.aspose.threed.*;
import java.io.*;
import java.util.*;

public class GltfExporter implements IExporter {
    private static final Set<String> supportedExtensions = Set.of(".gltf", ".glb");

    @Override
    public boolean canExport(FileFormat format) {
        if (format == FileFormat.GLTF || format == FileFormat.GLTF2 ||
            format == FileFormat.GLTF_BINARY || format == FileFormat.GLTF2_BINARY) {
            return true;
        }
        return false;
    }

    @Override
    public void export(Scene scene, Stream stream, SaveOptions options) throws ExportException {
        throw new ExportException("glTF export not yet fully implemented - stub");
    }
}
