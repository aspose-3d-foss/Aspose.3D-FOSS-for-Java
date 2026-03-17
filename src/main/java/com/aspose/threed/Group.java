package com.aspose.threed;

public class Group extends Entity {
    public Group() {
        this(null);
    }

    public Group(String name) {
        super(name != null ? name : "Group");
    }

    @Override
    public BoundingBox getBoundingBox() {
        return new BoundingBox();
    }

    @Override
    public EntityRendererKey getEntityRendererKey() {
        return new EntityRendererKey(EntityRendererFeatures.None, "Group");
    }
}
