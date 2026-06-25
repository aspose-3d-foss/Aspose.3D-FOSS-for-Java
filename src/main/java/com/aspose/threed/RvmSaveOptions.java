package com.aspose.threed;

/**
 * Save options for Aveva PDMS RVM file.
 */
public class RvmSaveOptions extends SaveOptions {
    private String fileNote = "";
    private String author = "3d@aspose";
    private String creationTime = "";
    private String attributePrefix = "rvm:";
    private String attributeListFile = null;
    private boolean exportAttributes = false;
    private FileContentType contentType = FileContentType.ASCII;

    /**
     * Constructor of RvmSaveOptions.
     */
    public RvmSaveOptions() {
    }

    /**
     * Constructor of RvmSaveOptions.
     * @param contentType Text or binary RVM file?
     */
    public RvmSaveOptions(FileContentType contentType) {
        this.contentType = contentType;
    }

    /**
     * File note in the file header.
     * @return The file note.
     */
    public String getFileNote() {
        return fileNote;
    }

    /**
     * File note in the file header.
     * @param value New value.
     */
    public void setFileNote(String value) {
        this.fileNote = value;
    }

    /**
     * Author information, default value is '3d@aspose'.
     * @return The author information.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Author information, default value is '3d@aspose'.
     * @param value New value.
     */
    public void setAuthor(String value) {
        this.author = value;
    }

    /**
     * The timestamp that exported this file, default value is current time.
     * @return The creation time.
     */
    public String getCreationTime() {
        return creationTime;
    }

    /**
     * The timestamp that exported this file, default value is current time.
     * @param value New value.
     */
    public void setCreationTime(String value) {
        this.creationTime = value;
    }

    /**
     * Gets the prefix of which attributes that will be exported, the exported property will contains no prefix, custom properties with different prefix will not be exported, default value is 'rvm:'.
     * @return The attribute prefix.
     */
    public String getAttributePrefix() {
        return attributePrefix;
    }

    /**
     * Sets the prefix of which attributes that will be exported, the exported property will contains no prefix, custom properties with different prefix will not be exported, default value is 'rvm:'.
     * @param value New value.
     */
    public void setAttributePrefix(String value) {
        this.attributePrefix = value;
    }

    /**
     * Gets the file name of attribute list file, exporter will generate a name based on the .rvm file name when this property is undefined, default value is null.
     * @return The attribute list file name.
     */
    public String getAttributeListFile() {
        return attributeListFile;
    }

    /**
     * Sets the file name of attribute list file, exporter will generate a name based on the .rvm file name when this property is undefined, default value is null.
     * @param value New value.
     */
    public void setAttributeListFile(String value) {
        this.attributeListFile = value;
    }

    /**
     * Gets whether to export the attribute list to an external .att file, default value is false.
     * @return true if export attributes.
     */
    public boolean getExportAttributes() {
        return exportAttributes;
    }

    /**
     * Sets whether to export the attribute list to an external .att file, default value is false.
     * @param value New value.
     */
    public void setExportAttributes(boolean value) {
        this.exportAttributes = value;
    }
}
