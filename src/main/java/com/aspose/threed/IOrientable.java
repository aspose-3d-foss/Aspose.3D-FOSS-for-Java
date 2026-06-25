package com.aspose.threed;

/**
 * Orientable entities shall implement this interface.
 */
public interface IOrientable {
    /**
     * Gets the direction that the entity is looking at.
     * @return the direction that the entity is looking at.
     */
    Vector3 getDirection();
    
    /**
     * Sets the direction that the entity is looking at.
     * @param value New value
     */
    void setDirection(Vector3 value);
    
    /**
     * Gets the target that the entity is looking at.
     * @return the target that the entity is looking at.
     */
    Node getTarget();
    
    /**
     * Sets the target that the entity is looking at.
     * @param value New value
     */
    void setTarget(Node value);
}
