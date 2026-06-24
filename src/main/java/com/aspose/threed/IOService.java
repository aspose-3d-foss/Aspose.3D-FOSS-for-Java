package com.aspose.threed;

import com.aspose.threed.FileFormat;
import com.aspose.threed.IImporter;
import com.aspose.threed.IExporter;
import com.aspose.threed.Stream;
import java.io.IOException;

/**
 * IO service for importing and exporting files.
 * This is a stub implementation for FOSS version.
 */
class IOService {
    
    private IOService() {
        // Private constructor to prevent instantiation
    }

    /**
     * Gets the singleton instance of IOService.
     */
    static IOService getInstance() {
        return IOServiceHolder.INSTANCE;
    }

    private static class IOServiceHolder {
        private static final IOService INSTANCE = new IOService();
    }

    /**
     * Creates an importer for the specified file format.
     */
    static IImporter createImporter(FileFormat format) {
        return format.getImporter();
    }

    /**
     * Creates an exporter for the specified file format.
     */
    static IExporter createExporter(FileFormat format) {
        return format.getExporter();
    }

    /**
     * Detects the format of a file from a stream.
     */
    static FileFormat detectFormat(Stream stream, String fileName) throws IOException {
        if (stream != null && stream.getInputStream() != null) {
            java.io.InputStream in = stream.getInputStream();
            if (in.markSupported()) {
                in.mark(Integer.MAX_VALUE);
                try {
                    // Try to detect by extension
                    if (fileName != null) {
                        FileFormat format = FileFormat.getFormatByExtension(fileName);
                        if (format != null && format.getCanImport()) {
                            return format;
                        }
                    }
                } finally {
                    in.reset();
                }
            }
        }

        if (fileName != null) {
            return FileFormat.getFormatByExtension(fileName);
        }

        throw new IOException("Cannot detect file format without file name or stream data");
    }

    /**
     * Gets the file format by file name.
     */
    static FileFormat getFormatByFileName(String fileName) {
        if (fileName == null) return null;
        int lastDot = fileName.lastIndexOf('.');
        if (lastDot >= 0) {
            String ext = fileName.substring(lastDot);
            return FileFormat.getFormatByExtension(ext);
        }
        return null;
    }
}
