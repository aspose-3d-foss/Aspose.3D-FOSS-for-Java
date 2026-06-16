package com.aspose.threed;

import java.io.Serializable;

/**
 * Class to hold user-defined properties.
 */
public abstract class Property implements Serializable {
    private String name;
    Object value;

    /**
     * Initializes a new instance of the Property class.
     * @param name The name of the property.
     */
    public Property(String name) {
        this.name = name != null ? name : "";
        this.value = null;
    }

    /**
     * Initializes a new instance of the Property class.
     * @param name The name of the property.
     * @param value The value of the property.
     */
    public Property(String name, Object value) {
        this.name = name != null ? name : "";
        this.value = value;
    }

    /**
     * Gets the name of the property.
     * @return the name of the property.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the value.
     * @return the value.
     */
    public abstract Object getValue();

    /**
     * Sets the value.
     * @param value New value.
     */
    public abstract void setValue(Object value);

    /**
     * Gets the type of the property value.
     * @return the type of the property value.
     */
    public Class<?> getValueType() {
        return value != null ? value.getClass() : Object.class;
    }

    /**
     * Gets extra data of the property associated by name.
     * @param name The name of the property's extra data.
     * @return The extra data associated by name.
     */
    public Object getExtra(String name) {
        return null;
    }

    /**
     * Sets extra data of the property associated by name.
     * @param name The name of the property's extra data.
     * @param value The value of the property's extra data.
     */
    public void setExtra(String name, Object value) {
    }

    /**
     * Gets the property bind point on specified animation instance.
     * @param anim On which animation to create the bind point.
     * @param create Create the property bind point if it's not found.
     * @return The property bind point on specified animation instance.
     */
    public BindPoint getBindPoint(AnimationNode anim, boolean create) {
        return null;
    }

    /**
     * Gets the keyframe sequence on specified animation instance.
     * @param anim On which animation to create the keyframe sequence.
     * @param create Create the keyframe sequence if it's not found.
     * @return The keyframe sequence on specified animation instance.
     */
    public KeyframeSequence getKeyframeSequence(AnimationNode anim, boolean create) {
        return null;
    }

    /**
     * Returns a string that represents the current Property.
     * @return A string that represents the current Property.
     */
    @Override
    public String toString() {
        return "Property: " + name;
    }
}
