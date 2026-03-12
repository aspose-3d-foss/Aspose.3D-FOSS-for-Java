package com.aspose.threed;

import java.io.*;
import java.util.*;

public class IOService {
    private static final List<FileFormat> registeredFormats = new ArrayList<>();

    static {
        // File formats are registered in FileFormat static initialization
    }

    public static FileFormat detectFormat(Stream stream, String fileName) throws IOException {
        if (stream != null && stream.getInputStream() != null && stream.getInputStream().markSupported()) {
            InputStream in = stream.getInputStream();
            in.mark(Integer.MAX_VALUE);
            try {
                for (FileFormat format : registeredFormats) {
                    if (format.canDetect(stream, fileName)) {
                        return format;
                    }
                }
            } finally {
                in.reset();
            }
        }

        if (fileName != null) {
            return FileFormat.getFormatByExtension(fileName);
        }

        throw new IOException("Cannot detect file format without file name or stream data");
    }

    public static FileFormat getFormatByFileName(String fileName) {
        String ext = getExtension(fileName);
        return FileFormat.getFormatByExtension(ext);
    }

    private static String getExtension(String fileName) {
        if (fileName == null) return "";
        int lastDot = fileName.lastIndexOf('.');
        if (lastDot > 0) {
            return fileName.substring(lastDot);
        }
        return "";
    }

    public static void registerFormat(FileFormat format) {
        registeredFormats.add(format);
    }
}
