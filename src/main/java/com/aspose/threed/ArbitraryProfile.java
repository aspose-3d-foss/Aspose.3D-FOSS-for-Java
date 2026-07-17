package com.aspose.threed;

import java.util.ArrayList;

/**
 * This class allows you to construct a 2D profile directly from arbitrary curve.
 */
public class ArbitraryProfile extends Profile {
    private Curve curve;
    private ArrayList<Curve> holes;

    /**
     * Constructor of ArbitraryProfile.
     */
    public ArbitraryProfile() {
        this.holes = new ArrayList<>();
    }

    /**
     * Constructor of ArbitraryProfile with an initial curve.
     * @param curve Initial curve of the profile.
     */
    public ArbitraryProfile(Curve curve) {
        this();
        this.curve = curve;
    }

    /**
     * Gets the Curve used to construct the profile.
     * @return The Curve used to construct the profile.
     */
    public Curve getCurve() {
        return curve;
    }

    /**
     * Sets the Curve used to construct the profile.
     * @param value New value.
     */
    public void setCurve(Curve value) {
        this.curve = value;
    }

    /**
     * Gets holes of the profile, also represented as curve.
     * @return Holes of the profile, also represented as curve.
     */
    public ArrayList<Curve> getHoles() {
        return holes;
    }
}
