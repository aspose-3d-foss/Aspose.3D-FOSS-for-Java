package com.aspose.threed;

public interface IImporter {
    boolean canImport(FileFormat format);
    Scene load(Stream stream, LoadOptions options) throws ImportException;
}
