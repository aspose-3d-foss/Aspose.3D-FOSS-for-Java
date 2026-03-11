package com.aspose.threed;

import java.util.ArrayList;

public abstract class Entity extends SceneObject {
    private Node parentNode;
    private boolean excluded = false;
    private final ArrayList<Node> parentNodes = new ArrayList<>();

    public Entity() {
        super();
    }

    public Entity(String name) {
        super(name);
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node value) {
        this.parentNode = value;
    }

    public ArrayList<Node> getParentNodes() {
        return parentNodes;
    }

    public boolean getExcluded() {
        return excluded;
    }

    public void setExcluded(boolean value) {
        this.excluded = value;
    }

    public BoundingBox getBoundingBox() {
        return new BoundingBox();
    }

    public EntityRendererKey getEntityRendererKey() {
        return new EntityRendererKey(EntityRendererFeatures.None, "Generic");
    }
}
