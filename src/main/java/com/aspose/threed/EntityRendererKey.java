package com.aspose.threed;

/**
 * The key of registered entity renderer.
 */
public final class EntityRendererKey {
    private final String name;

    /**
     * Constructor.
     * @param name The name of the key.
     */
    public EntityRendererKey(String name) {
        this.name = name;
    }

    /**
     * Gets the string representation of the key.
     * @return The string representation.
     */
    @Override
    public String toString() {
        return name != null ? name : "";
    }
}
