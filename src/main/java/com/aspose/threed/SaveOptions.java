package com.aspose.threed;

public class SaveOptions extends A3DObject {
    private FileFormat fileFormat;

    public SaveOptions() {
        super();
    }

    public SaveOptions(String name) {
        super(name);
    }

    public FileFormat getFileFormat() {
        return fileFormat;
    }

    protected void setFileFormat(FileFormat value) {
        this.fileFormat = value;
    }
}
