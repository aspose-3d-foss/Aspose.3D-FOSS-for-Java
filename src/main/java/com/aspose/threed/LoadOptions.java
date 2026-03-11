package com.aspose.threed;

public class LoadOptions extends A3DObject {
    private FileFormat fileFormat;

    public LoadOptions() {
        super();
    }

    public LoadOptions(String name) {
        super(name);
    }

    public FileFormat getFileFormat() {
        return fileFormat;
    }

    protected void setFileFormat(FileFormat value) {
        this.fileFormat = value;
    }
}
