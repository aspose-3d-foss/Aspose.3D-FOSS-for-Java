package com.aspose.threed;

/**
 * Texture slot in Material, can be enumerated through material instance.
 */
public class TextureSlot {
    private String slotName;
    private TextureBase texture;

    /**
     * The slot name that indicates where this texture will be bounded to.
     */
    public String getSlotName() {
        return slotName;
    }

    /**
     * The texture that will be bounded to the material.
     */
    public TextureBase getTexture() {
        return texture;
    }
    
    /** @internal */
    void setSlotName(String slotName) {
        this.slotName = slotName;
    }
    
    /** @internal */
    void setTexture(TextureBase texture) {
        this.texture = texture;
    }
}
