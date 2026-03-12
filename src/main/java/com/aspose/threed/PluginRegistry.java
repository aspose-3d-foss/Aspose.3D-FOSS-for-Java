package com.aspose.threed;

import com.aspose.threed.formats.ObjImporter;
import com.aspose.threed.formats.ObjExporter;
import com.aspose.threed.formats.StlImporter;
import com.aspose.threed.formats.StlExporter;
import com.aspose.threed.formats.GltfImporter;
import com.aspose.threed.formats.GltfExporter;
import com.aspose.threed.formats.FbxImporter;
import com.aspose.threed.formats.FbxExporter;

import java.util.*;
import java.io.*;

final class PluginRegistry {
    private static final List<IImporter> importers = new ArrayList<>();
    private static final List<IExporter> exporters = new ArrayList<>();
    private static final Map<String, FileFormat> extensionMap = new HashMap<>();

    static {
        registerDefaultFormats();
    }

    private static void registerDefaultFormats() {
        registerImporter(new ObjImporter());
        registerExporter(new ObjExporter());
        registerImporter(new StlImporter());
        registerExporter(new StlExporter());
        registerImporter(new GltfImporter());
        registerExporter(new GltfExporter());
        registerImporter(new FbxImporter());
        registerExporter(new FbxExporter());
    }

    static void registerImporter(IImporter importer) {
        importers.add(importer);
    }

    static void registerExporter(IExporter exporter) {
        exporters.add(exporter);
    }

    static Scene importScene(Stream stream, FileFormat format, LoadOptions options) throws IOException {
        for (IImporter importer : importers) {
            if (importer.canImport(format)) {
                try {
                    return importer.load(stream, options);
                } catch (ImportException e) {
                    throw new IOException("Import failed: " + e.getMessage(), e);
                }
            }
        }
        throw new IOException("No suitable importer found for format: " + format.getExtension());
    }

    private static byte[] readAllBytes(Stream stream) throws IOException {
        java.io.InputStream in = stream.getInputStream();
        if (in == null) {
            throw new IOException("Stream not readable");
        }
        
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        byte[] buffer = new byte[8192];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1) {
            baos.write(buffer, 0, bytesRead);
        }
        return baos.toByteArray();
    }

    static void exportScene(Scene scene, Stream stream, FileFormat format, SaveOptions options) throws IOException {
        for (IExporter exporter : exporters) {
            if (exporter.canExport(format)) {
                try {
                    exporter.export(scene, stream, options);
                    return;
                } catch (ExportException e) {
                    throw new IOException("Export failed: " + e.getMessage(), e);
                }
            }
        }
        throw new IOException("No suitable exporter found for format: " + format.getExtension());
    }

    static void registerFormat(FileFormat format) {
        for (String ext : format.getExtensions()) {
            extensionMap.put(ext.toLowerCase(), format);
        }
    }

    static FileFormat findFormat(String filePath) {
        String fileName = filePath.toLowerCase();
        for (String ext : extensionMap.keySet()) {
            if (fileName.endsWith(ext)) {
                return extensionMap.get(ext);
            }
        }
        return null;
    }
}
