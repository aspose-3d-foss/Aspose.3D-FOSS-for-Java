package com.aspose.threed;

public class PolygonModifier extends Entity {
    private PolygonMode mode;

    public PolygonModifier() {
        this(null);
    }

    public PolygonModifier(String name) {
        super(name != null ? name : "PolygonModifier");
        this.mode = PolygonMode.FILL;
    }

    public PolygonMode getMode() { return mode; }
    public void setMode(PolygonMode value) { this.mode = value; }

    @Override
    public BoundingBox getBoundingBox() {
        return new BoundingBox();
    }

    @Override
    public EntityRendererKey getEntityRendererKey() {
        return new EntityRendererKey(EntityRendererFeatures.None, "PolygonModifier");
    }
}
