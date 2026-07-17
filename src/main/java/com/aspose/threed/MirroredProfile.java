package com.aspose.threed;

/**
 * IFC compatible mirror profile.
 * This profile defines a new profile by mirroring the base profile about the y axis.
 */
public class MirroredProfile extends Profile {
    private Profile baseProfile;

    /**
     * Package-private constructor for On-Premise compatibility.
     * @param baseProfile The base profile to be mirrored.
     */
    MirroredProfile(Profile baseProfile) {
        this.baseProfile = baseProfile;
    }

    /**
     * Gets the base profile to be mirrored.
     * @return The base profile to be mirrored.
     */
    public Profile getBaseProfile() {
        return baseProfile;
    }
}
