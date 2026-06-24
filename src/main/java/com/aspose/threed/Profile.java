package com.aspose.threed;

/**
 * 2D Profile in xy plane.
 */
public abstract class Profile extends Entity {
    /**
     * Protected constructor to allow derived classes to set name.
     * @param name The name of the profile.
     */
    protected Profile(String name) {
        super(name);
    }

    /**
     * Constructor.
     */
    public Profile() {
        this("Profile");
    }

    @Override
    public EntityRendererKey getEntityRendererKey() {
        return new EntityRendererKey("Profile");
    }
}
