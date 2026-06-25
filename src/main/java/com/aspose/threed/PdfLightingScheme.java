package com.aspose.threed;

/**
 * LightingScheme specifies the lighting to apply to 3D artwork.
 */
public enum PdfLightingScheme {
    /**
     * Uses the lights defined in the scene
     */
    ARTWORK,
    /**
     * No lights are used.
     */
    NONE,
    /**
     * Three blue-grey infinite lights, no ambient term
     */
    WHITE,
    /**
     * Three light-grey infinite lights, no ambient term
     */
    DAY,
    /**
     * One yellow, one aqua, and one blue infinite light, no ambient term
     */
    NIGHT,
    /**
     * Three grey infinite lights, moderate ambient term
     */
    HARD,
    /**
     * One red, one green, and one blue infinite light, no ambient term
     */
    PRIMARY,
    /**
     * Three blue infinite lights, no ambient term
     */
    BLUE,
    /**
     * Three red infinite lights, no ambient term
     */
    RED,
    /**
     * Six grey infinite lights aligned with the major axes, no ambient term
     */
    CUBE,
    /**
     * Three grey infinite lights and one light attached to the camera, no ambient term
     */
    CAD,
    /**
     * Single infinite light attached to the camera, low ambient term
     */
    HEADLAMP;
}
