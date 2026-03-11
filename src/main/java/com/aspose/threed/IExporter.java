package com.aspose.threed;

public interface IExporter {
    boolean canExport(FileFormat format);
    void export(Scene scene, Stream stream, SaveOptions options) throws ExportException;
}
