package com.aspose.threed;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Material defines the parameters necessary for visual appearance of geometry.
 * Aspose.3D provides shading model for LambertMaterial, PhongMaterial and ShaderMaterial.
 */
public abstract class Material extends A3DObject implements Iterable<TextureSlot> {
    private Map<String, TextureBase> textures = new HashMap<>();

    /**
     * Used in setTexture(java.lang.String, com.aspose.threed.TextureBase) to assign a specular texture mapping.
     */
    public static final String MAP_SPECULAR = "Specular";

    /**
     * Used in setTexture(java.lang.String, com.aspose.threed.TextureBase) to assign a diffuse texture mapping.
     */
    public static final String MAP_DIFFUSE = "Diffuse";

    /**
     * Used in setTexture(java.lang.String, com.aspose.threed.TextureBase) to assign a emissive texture mapping.
     */
    public static final String MAP_EMISSIVE = "Emissive";

    /**
     * Used in setTexture(java.lang.String, com.aspose.threed.TextureBase) to assign a ambient texture mapping.
     */
    public static final String MAP_AMBIENT = "Ambient";

    /**
     * Used in setTexture(java.lang.String, com.aspose.threed.TextureBase) to assign a normal texture mapping.
     */
    public static final String MAP_NORMAL = "Normal";

    /**
     * Initializes a new instance of the Material class.
     */
    protected Material() {
        super();
    }

    /**
     * Initializes a new instance of the Material class.
     */
    protected Material(String name) {
        super(name);
    }

    /**
     * Gets the texture from the specified slot, it can be material's property name or shader's parameter name.
     * @param slotName Slot name.
     * @return The texture.
     */
    public TextureBase getTexture(String slotName) {
        return textures.get(slotName);
    }

    /**
     * Sets the texture to specified slot.
     * @param slotName Slot name.
     * @param texture Texture to set.
     */
    public void setTexture(String slotName, TextureBase texture) {
        textures.put(slotName, texture);
    }

    /**
     * Formats object to string.
     * @return Object string.
     */
    @Override
    public String toString() {
        return "Material [" + getName() + "]";
    }

    /**
     * Gets the enumerator to enumerate internal texture slots.
     */
    @Override
    public Iterator<TextureSlot> iterator() {
        return new TextureSlotIterator();
    }

    private class TextureSlotIterator implements Iterator<TextureSlot> {
        private Iterator<Map.Entry<String, TextureBase>> iterator = textures.entrySet().iterator();

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public TextureSlot next() {
            Map.Entry<String, TextureBase> entry = iterator.next();
            TextureSlot slot = new TextureSlot();
            slot.setSlotName(entry.getKey());
            slot.setTexture(entry.getValue());
            return slot;
        }
    }
}
