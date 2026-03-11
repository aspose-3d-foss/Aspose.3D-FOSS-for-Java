package com.aspose.threed;

public class EntityRendererKey {
    private final EntityRendererFeatures features;
    private final String name;

    public EntityRendererKey(EntityRendererFeatures features, String name) {
        this.features = features;
        this.name = name;
    }

    public EntityRendererFeatures getFeatures() {
        return features;
    }

    public String getName() {
        return name;
    }
}
