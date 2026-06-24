package com.aspose.threed;

/**
 * This class defines the texture from an external file.
 */
public class Texture extends TextureBase {
    private boolean enableMipMap;
    private byte[] content;
    private String fileName;

    /**
     * Initializes a new instance of the Texture class.
     */
    public Texture() {
        super("Texture");
    }

    /**
     * Initializes a new instance of the Texture class.
     */
    public Texture(String name) {
        super(name);
    }

    /**
     * Gets or sets if the mipmap is enabled for this texture.
     */
    public boolean isEnableMipMap() {
        return enableMipMap;
    }

    public void setEnableMipMap(boolean enableMipMap) {
        this.enableMipMap = enableMipMap;
    }

    /**
     * Gets or sets the binary content of the texture.
     * The embedded texture content is optional, user should load texture from external file if this is missing.
     */
    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    /**
     * Gets or sets the associated texture file.
     */
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
