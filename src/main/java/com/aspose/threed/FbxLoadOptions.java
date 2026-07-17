package com.aspose.threed;

/**
 * Load options for FBX format.
 */
public class FbxLoadOptions extends LoadOptions {
    private boolean keepBuiltinGlobalSettings = false;
    private boolean compatibleMode = false;

    /**
     * Constructor of FbxLoadOptions.
     */
    public FbxLoadOptions() {
        super();
    }

    /**
     * Constructor of FbxLoadOptions.
     * @param format The file format.
     */
    public FbxLoadOptions(FileFormat format) {
        super(format);
    }

    /**
     * Gets or sets whether to keep the builtin properties in GlobalSettings which have a native property replacement in .NET FOSS.
     * Set this to true if you want the full properties in GlobalSettings
     * Default value is false
     * @return true if keep builtin global settings.
     */
    public boolean getKeepBuiltinGlobalSettings() {
        return keepBuiltinGlobalSettings;
    }

    /**
     * Sets whether to keep the builtin properties in GlobalSettings which have a native property replacement in .NET FOSS.
     * @param value New value.
     */
    public void setKeepBuiltinGlobalSettings(boolean value) {
        this.keepBuiltinGlobalSettings = value;
    }

    /**
     * Gets or sets whether to enable compatible mode.
     * Compatible mode will try to support non-standard FBX definitions like PBR materials exported by Blender.
     * Default value is false.
     * @return true if compatible mode enabled.
     */
    public boolean getCompatibleMode() {
        return compatibleMode;
    }

    /**
     * Sets whether to enable compatible mode.
     * @param value New value.
     */
    public void setCompatibleMode(boolean value) {
        this.compatibleMode = value;
    }
}
