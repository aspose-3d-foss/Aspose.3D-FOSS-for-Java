package com.aspose.threed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A Group represents the logical relationships of Node.
 */
public class Group extends A3DObject {
    private Group parent;
    private final List<Group> groups = new ArrayList<Group>();
    private final List<Node> nodes = new ArrayList<Node>();

    /**
     * Construct a new instance of Group
     * @param name Group's name
     */
    public Group(String name) {
        super(name != null ? name : "Group");
    }

    /**
     * Construct a new instance of Group
     */
    public Group() {
        this(null);
    }

    /**
     * Parent group of current group
     * @return Parent group of current group
     */
    public Group getParent() {
        return parent;
    }

    /**
     * Sub-groups
     * @return Sub-groups
     */
    public List<Group> getGroups() {
        return Collections.unmodifiableList(groups);
    }

    /**
     * The nodes in this group
     * @return The nodes in this group
     */
    public List<Node> getNodes() {
        return Collections.unmodifiableList(nodes);
    }

    /**
     * Gets the string representation of Group
     * @return The string representation of current instance
     */
    @Override
    public String toString() {
        return "Group[" + getName() + "]";
    }
}
