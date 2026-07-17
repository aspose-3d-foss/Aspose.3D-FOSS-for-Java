package com.aspose.threed;

/**
 * The HShape provides the defining parameters of an 'H' or 'I' shape.
 */
public class HShape extends ParameterizedProfile {
    /**
     * Gets or sets the extent of the depth.
     */
    private double overallDepth;

    /**
     * Gets or sets the extent of the width.
     */
    private double bottomFlangeWidth;

    /**
     * Gets or sets the width of the top flange.
     */
    private double topFlangeWidth;

    /**
     * Gets or sets the thickness of the top flange.
     */
    private double topFlangeThickness;

    /**
     * Gets or sets the radius of the lower edges of the top flange.
     */
    private double topFlangeEdgeRadius;

    /**
     * Gets or sets the radius of fillet between the web and the top flange.
     */
    private double topFlangeFilletRadius;

    /**
     * Gets or sets the flange thickness of H-shape.
     */
    private double bottomFlangeThickness;

    /**
     * Gets or sets the thickness of the web of the H-shape.
     */
    private double webThickness;

    /**
     * Gets or sets the radius of fillet between the web and the bottom flange.
     */
    private double bottomFlangeFilletRadius;

    /**
     * Gets or sets the radius of the upper edges of the bottom flange.
     */
    private double bottomFlangeEdgeRadius;

    /**
     * Constructor of HShape
     */
    public HShape() {
    }

    /**
     * Gets the extent of the depth.
     */
    public double getOverallDepth() {
        return overallDepth;
    }

    /**
     * Sets the extent of the depth.
     */
    public void setOverallDepth(double value) {
        this.overallDepth = value;
    }

    /**
     * Gets the extent of the width.
     */
    public double getBottomFlangeWidth() {
        return bottomFlangeWidth;
    }

    /**
     * Sets the extent of the width.
     */
    public void setBottomFlangeWidth(double value) {
        this.bottomFlangeWidth = value;
    }

    /**
     * Gets the width of the top flange.
     */
    public double getTopFlangeWidth() {
        return topFlangeWidth;
    }

    /**
     * Sets the width of the top flange.
     */
    public void setTopFlangeWidth(double value) {
        this.topFlangeWidth = value;
    }

    /**
     * Gets the thickness of the top flange.
     */
    public double getTopFlangeThickness() {
        return topFlangeThickness;
    }

    /**
     * Sets the thickness of the top flange.
     */
    public void setTopFlangeThickness(double value) {
        this.topFlangeThickness = value;
    }

    /**
     * Gets the radius of the lower edges of the top flange.
     */
    public double getTopFlangeEdgeRadius() {
        return topFlangeEdgeRadius;
    }

    /**
     * Sets the radius of the lower edges of the top flange.
     */
    public void setTopFlangeEdgeRadius(double value) {
        this.topFlangeEdgeRadius = value;
    }

    /**
     * Gets the radius of fillet between the web and the top flange.
     */
    public double getTopFlangeFilletRadius() {
        return topFlangeFilletRadius;
    }

    /**
     * Sets the radius of fillet between the web and the top flange.
     */
    public void setTopFlangeFilletRadius(double value) {
        this.topFlangeFilletRadius = value;
    }

    /**
     * Gets the flange thickness of H-shape.
     */
    public double getBottomFlangeThickness() {
        return bottomFlangeThickness;
    }

    /**
     * Sets the flange thickness of H-shape.
     */
    public void setBottomFlangeThickness(double value) {
        this.bottomFlangeThickness = value;
    }

    /**
     * Gets the thickness of the web of the H-shape.
     */
    public double getWebThickness() {
        return webThickness;
    }

    /**
     * Sets the thickness of the web of the H-shape.
     */
    public void setWebThickness(double value) {
        this.webThickness = value;
    }

    /**
     * Gets the radius of fillet between the web and the bottom flange.
     */
    public double getBottomFlangeFilletRadius() {
        return bottomFlangeFilletRadius;
    }

    /**
     * Sets the radius of fillet between the web and the bottom flange.
     */
    public void setBottomFlangeFilletRadius(double value) {
        this.bottomFlangeFilletRadius = value;
    }

    /**
     * Gets the radius of the upper edges of the bottom flange.
     */
    public double getBottomFlangeEdgeRadius() {
        return bottomFlangeEdgeRadius;
    }

    /**
     * Sets the radius of the upper edges of the bottom flange.
     */
    public void setBottomFlangeEdgeRadius(double value) {
        this.bottomFlangeEdgeRadius = value;
    }

    /**
     * Gets the extent in x and y dimension.
     * @return The extent of the profile
     */
    public Vector2 getExtent() {
        return new Vector2();
    }
}
