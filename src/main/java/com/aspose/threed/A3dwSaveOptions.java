package com.aspose.threed;

/**
 * Options for A3DW saving.
 */
public class A3dwSaveOptions extends SaveOptions {
    private boolean exportMetaData = true;
    private String metaDataPrefix = null;

    /**
     * Constructor of A3dwSaveOptions.
     */
    public A3dwSaveOptions() {
    }

    /**
     * Export meta data associated with Scene/Node to client.
     * Default value is true.
     * @return true if export meta data.
     */
    public boolean getExportMetaData() {
        return exportMetaData;
    }

    /**
     * Sets whether to export meta data associated with Scene/Node to client.
     * @param value New value.
     */
    public void setExportMetaData(boolean value) {
        this.exportMetaData = value;
    }

    /**
     * If this property is non-null, only the properties of Scene/Node that start with this prefix will be exported, and the prefix will be removed.
     * @return The meta data prefix.
     */
    public String getMetaDataPrefix() {
        return metaDataPrefix;
    }

    /**
     * Sets the meta data prefix.
     * @param value New value.
     */
    public void setMetaDataPrefix(String value) {
        this.metaDataPrefix = value;
    }
}
