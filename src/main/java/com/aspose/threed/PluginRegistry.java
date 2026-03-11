package com.aspose.threed;

import com.aspose.threed.formats.ObjImporter;
import com.aspose.threed.formats.ObjExporter;
import com.aspose.threed.formats.StlImporter;
import com.aspose.threed.formats.StlExporter;

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
    }

    static void registerImporter(IImporter importer) {
        importers.add(importer);
    }

    static void registerExporter(IExporter exporter) {
        exporters.add(exporter);
    }

    static Scene importScene(Stream stream, LoadOptions options) throws IOException {
        // Read the entire stream into memory so we can try multiple importers
        byte[] data = readAllBytes(stream);
        
        for (IImporter importer : importers) {
            try {
                ByteArrayInputStream bis = new ByteArrayInputStream(data);
                Stream s = new Stream(bis);
                Scene scene = importer.load(s, options);
                if (scene != null && !scene.getRootNode().getChildNodes().isEmpty()) {
                    boolean hasData = false;
                    for (Node n : scene.getRootNode().getChildNodes()) {
                        if (n.getEntity() instanceof Mesh) {
                            Mesh m = (Mesh) n.getEntity();
                            if (m.getControlPoints().size() > 0) {
                                hasData = true;
                                break;
                            }
                        }
                    }
                    if (hasData) {
                        return scene;
                    }
                }
            } catch (ImportException e) {
            }
        }
        throw new IOException("No suitable importer found");
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

    static void exportScene(Scene scene, Stream stream, SaveOptions options) throws IOException {
        for (IExporter exporter : exporters) {
            try {
                exporter.export(scene, stream, options);
                return;
            } catch (ExportException e) {
            }
        }
        throw new IOException("No suitable exporter found");
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
