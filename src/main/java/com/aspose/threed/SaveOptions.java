package com.aspose.threed;

/**
 * The base class to configure options in file saving for different types.
 */
public class SaveOptions extends IOConfig {
    private FileFormat fileFormat;

    /**
     * Initializes a new instance of the SaveOptions class.
     */
    public SaveOptions() {
    }

    /**
     * Initializes a new instance of the SaveOptions class with a file format.
     * @param format The file format.
     */
    public SaveOptions(FileFormat format) {
        setFileFormat(format);
    }

    /**
     * Initializes a new instance of the SaveOptions class with a file content type.
     * @param contentType The file content type.
     */
    public SaveOptions(FileContentType contentType) {
        // The FileFormat is set by the subclass based on contentType
    }

    /**
     * Try to copy textures used in scene to output directory.
     * @return true if export textures.
     */
    public boolean getExportTextures() {
        // Not implemented in FOSS
        return false;
    }

    /**
     * Try to copy textures used in scene to output directory.
     * @param value New value.
     */
    public void setExportTextures(boolean value) {
        // Not implemented in FOSS
    }

    public FileFormat getFileFormat() {
        return fileFormat;
    }

    protected void setFileFormat(FileFormat value) {
        this.fileFormat = value;
    }
}
