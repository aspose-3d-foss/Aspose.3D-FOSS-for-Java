package com.aspose.threed;

import java.util.ArrayList;
import java.util.List;

/**
 * A skeleton defines a hierarchical structure of bones for skinning.
 */
public class Skeleton extends Entity {
    private List<Skeleton> children;
    private Node node;

    /**
     * Constructor of Skeleton.
     */
    public Skeleton() {
        this("Skeleton");
    }

    /**
     * Constructor of Skeleton.
     * @param name The name of the skeleton.
     */
    public Skeleton(String name) {
        super(name);
        children = new ArrayList<Skeleton>();
    }

    /**
     * Gets all child skeletons.
     * @return the list of child skeletons.
     */
    public List<Skeleton> getChildren() {
        return children;
    }

    /**
     * Gets the node associated with this skeleton.
     * @return the node.
     */
    public Node getNode() {
        return node;
    }

    /**
     * Sets the node associated with this skeleton.
     * @param value The node.
     */
    public void setNode(Node value) {
        this.node = value;
    }
}
