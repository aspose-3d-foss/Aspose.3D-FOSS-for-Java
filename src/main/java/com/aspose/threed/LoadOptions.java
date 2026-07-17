package com.aspose.threed;

/**
 * The base class to configure options in file loading for different types.
 */
public class LoadOptions extends IOConfig {
    private FileFormat fileFormat;

    /**
     * Initializes a new instance of the LoadOptions class.
     */
    public LoadOptions() {
    }

    /**
     * Initializes a new instance of the LoadOptions class with a file format.
     * @param format The file format.
     */
    public LoadOptions(FileFormat format) {
        setFileFormat(format);
    }

    public FileFormat getFileFormat() {
        return fileFormat;
    }

    protected void setFileFormat(FileFormat value) {
        this.fileFormat = value;
    }
}
