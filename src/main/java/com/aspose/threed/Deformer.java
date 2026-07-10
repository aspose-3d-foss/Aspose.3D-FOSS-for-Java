package com.aspose.threed;

public abstract class Deformer extends A3DObject {
    private Geometry owner;

    public Deformer(String name) {
        super(name);
    }

    /**
     * Gets the geometry which owns this deformer.
     * @return the geometry which owns this deformer.
     */
    public Geometry getOwner() {
        return owner;
    }

    /**
     * Sets the geometry which owns this deformer.
     * @param value New value.
     */
    protected void setOwner(Geometry value) {
        this.owner = value;
    }
}
