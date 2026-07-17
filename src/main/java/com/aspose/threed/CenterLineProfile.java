package com.aspose.threed;

/**
 * IFC compatible center line profile.
 */
public class CenterLineProfile extends Profile {
    private double thickness;
    private Curve curve;

    /**
     * Constructs a new CenterLineProfile with specified curve as center line.
     * @param curve Center line curve
     * @param thickness Thickness applied along the center line
     */
    public CenterLineProfile(Curve curve, double thickness) {
        this.thickness = thickness;
        this.curve = curve;
    }

    /**
     * Gets the thickness applied along the center line.
     * @return Thickness applied along the center line
     */
    public double getThickness() {
        return thickness;
    }

    /**
     * Sets the thickness applied along the center line.
     * @param value New value
     */
    public void setThickness(double value) {
        this.thickness = value;
    }

    /**
     * Gets the center line curve of the profile.
     * @return The center line curve of the profile
     */
    public Curve getCurve() {
        return curve;
    }

    /**
     * Sets the center line curve of the profile.
     * @param value New value
     */
    public void setCurve(Curve value) {
        this.curve = value;
    }
}
