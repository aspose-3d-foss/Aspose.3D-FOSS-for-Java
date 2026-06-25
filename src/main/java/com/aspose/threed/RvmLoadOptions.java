package com.aspose.threed;

/**
 * Load options for AVEVA Plant Design Management System's RVM file.
 */
public class RvmLoadOptions extends LoadOptions {
    private boolean generateMaterials = true;
    private int cylinderRadialSegments = 16;
    private int dishLongitudeSegments = 12;
    private int dishLatitudeSegments = 8;
    private int torusTubularSegments = 20;
    private int rectangularTorusSegments = 20;
    private boolean centerScene = false;
    private String attributePrefix = "rvm:";
    private boolean lookupAttributes = true;

    /**
     * Construct a RvmLoadOptions instance.
     */
    public RvmLoadOptions() {
    }

    /**
     * Construct a RvmLoadOptions instance.
     * @param contentType The file content type.
     */
    public RvmLoadOptions(FileContentType contentType) {
    }

    /**
     * Gets the number of cylinder's radial segments, default value is 16.
     * @return the number of cylinder's radial segments.
     */
    public int getCylinderRadialSegments() {
        return cylinderRadialSegments;
    }

    /**
     * Sets the number of cylinder's radial segments, default value is 16.
     * @param value New value.
     */
    public void setCylinderRadialSegments(int value) {
        this.cylinderRadialSegments = value;
    }

    /**
     * Gets the number of dish's longitude segments, default value is 12.
     * @return the number of dish's longitude segments.
     */
    public int getDishLongitudeSegments() {
        return dishLongitudeSegments;
    }

    /**
     * Sets the number of dish's longitude segments, default value is 12.
     * @param value New value.
     */
    public void setDishLongitudeSegments(int value) {
        this.dishLongitudeSegments = value;
    }

    /**
     * Gets the number of dish's latitude segments, default value is 8.
     * @return the number of dish's latitude segments.
     */
    public int getDishLatitudeSegments() {
        return dishLatitudeSegments;
    }

    /**
     * Sets the number of dish's latitude segments, default value is 8.
     * @param value New value.
     */
    public void setDishLatitudeSegments(int value) {
        this.dishLatitudeSegments = value;
    }

    /**
     * Gets the number of torus's tubular segments, default value is 20.
     * @return the number of torus's tubular segments.
     */
    public int getTorusTubularSegments() {
        return torusTubularSegments;
    }

    /**
     * Sets the number of torus's tubular segments, default value is 20.
     * @param value New value.
     */
    public void setTorusTubularSegments(int value) {
        this.torusTubularSegments = value;
    }

    /**
     * Gets the number of rectangular torus's radial segments, default value is 20.
     * @return the number of rectangular torus's radial segments.
     */
    public int getRectangularTorusSegments() {
        return rectangularTorusSegments;
    }

    /**
     * Sets the number of rectangular torus's radial segments, default value is 20.
     * @param value New value.
     */
    public void setRectangularTorusSegments(int value) {
        this.rectangularTorusSegments = value;
    }

    /**
     * Center the scene after it's loaded.
     * @return true if center the scene.
     */
    public boolean getCenterScene() {
        return centerScene;
    }

    /**
     * Center the scene after it's loaded.
     * @param value New value.
     */
    public void setCenterScene(boolean value) {
        this.centerScene = value;
    }

    /**
     * Gets the prefix of the attributes that were defined in external attribute files.
     * @return the attribute prefix.
     */
    public String getAttributePrefix() {
        return attributePrefix;
    }

    /**
     * Sets the prefix of the attributes that were defined in external attribute files.
     * @param value New value.
     */
    public void setAttributePrefix(String value) {
        this.attributePrefix = value;
    }

    /**
     * Gets whether to load attributes from external attribute list file.
     * @return true if lookup attributes.
     */
    public boolean getLookupAttributes() {
        return lookupAttributes;
    }

    /**
     * Sets whether to load attributes from external attribute list file.
     * @param value New value.
     */
    public void setLookupAttributes(boolean value) {
        this.lookupAttributes = value;
    }

    /**
     * Generate materials with random colors for each objects in the scene.
     * @return true if generate materials.
     */
    public boolean getGenerateMaterials() {
        return generateMaterials;
    }

    /**
     * Generate materials with random colors for each objects in the scene.
     * @param value New value.
     */
    public void setGenerateMaterials(boolean value) {
        this.generateMaterials = value;
    }
}
