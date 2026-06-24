package com.aspose.threed;

/**
 * Base class for all primitives.
 */
public abstract class Primitive extends Entity implements IMeshConvertible {
    private boolean castShadows = true;
    private boolean receiveShadows = true;

    /**
     * Gets whether this geometry can cast shadow.
     */
    public boolean getCastShadows() {
        return castShadows;
    }

    public void setCastShadows(boolean value) {
        this.castShadows = value;
    }

    /**
     * Gets whether this geometry can receive shadow.
     */
    public boolean getReceiveShadows() {
        return receiveShadows;
    }

    public void setReceiveShadows(boolean value) {
        this.receiveShadows = value;
    }

    /**
     * Initializes a new instance of the Primitive class.
     * @param name Name.
     */
    public Primitive(String name) {
        super(name);
    }

    /**
     * Convert current object to mesh.
     * @return The mesh.
     */
    public abstract Mesh toMesh();
}
