package com.aspose.threed;

/**
 * A callback to travel through the whole node hierarchy.
 */
public interface NodeVisitor {
    /**
     * A callback to travel through the whole node hierarchy.
     * @param node Node being visited
     * @return Return false to stop traveling
     */
    boolean call(Node node);
}
