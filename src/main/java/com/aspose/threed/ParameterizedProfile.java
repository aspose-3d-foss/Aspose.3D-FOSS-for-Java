package com.aspose.threed;

/**
 * The base class of all parameterized profiles.
 */
public abstract class ParameterizedProfile extends Profile {
    /**
     * Constructor.
     */
    public ParameterizedProfile() {
        super("ParameterizedProfile");
    }

    /**
     * Gets the extent in x and y dimension.
     * @return The extent of the profile.
     */
    public abstract Vector2 getExtent();
}
