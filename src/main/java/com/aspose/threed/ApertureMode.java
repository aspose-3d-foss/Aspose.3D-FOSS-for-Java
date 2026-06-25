package com.aspose.threed;

/**
 * Camera aperture modes.
 *   The aperture mode determines which values drive the camera aperture.
 *   If the aperture mode is HorizAndVert, Horizontal, or Vertical, then the field of view is used.
 *   If the aperture mode is FocalLength, then the focal length is used.
 */
public enum ApertureMode {
    /**
     * Set the angle values for both the horizontal and vertical settings.
     */
    HORIZ_AND_VERT,
    /**
     * Set only the horizontal angle.
     */
    HORIZONTAL,
    /**
     * Set only the vertical angle.
     */
    VERTICAL,
    /**
     * Use focal length directly.
     */
    FOCAL_LENGTH;
}
