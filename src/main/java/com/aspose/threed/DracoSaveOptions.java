package com.aspose.threed;

/**
 * Options for Draco compression.
 */
public class DracoSaveOptions extends SaveOptions {
    private int positionalAccuracy = 6;
    private int normalAccuracy = 5;
    private int textureCoordinateAccuracy = 5;
    private int colorAccuracy = 4;
    private int genericAccuracy = 3;
    private boolean quantizeGeneration = true;

    /**
     * Constructor of DracoSaveOptions.
     */
    public DracoSaveOptions() {
    }

    /**
     * Gets the positional accuracy for Draco compression.
     * @return the positional accuracy.
     */
    public int getPositionalAccuracy() {
        return positionalAccuracy;
    }

    /**
     * Sets the positional accuracy for Draco compression.
     * @param value New value.
     */
    public void setPositionalAccuracy(int value) {
        this.positionalAccuracy = value;
    }

    /**
     * Gets the normal accuracy for Draco compression.
     * @return the normal accuracy.
     */
    public int getNormalAccuracy() {
        return normalAccuracy;
    }

    /**
     * Sets the normal accuracy for Draco compression.
     * @param value New value.
     */
    public void setNormalAccuracy(int value) {
        this.normalAccuracy = value;
    }

    /**
     * Gets the texture coordinate accuracy for Draco compression.
     * @return the texture coordinate accuracy.
     */
    public int getTextureCoordinateAccuracy() {
        return textureCoordinateAccuracy;
    }

    /**
     * Sets the texture coordinate accuracy for Draco compression.
     * @param value New value.
     */
    public void setTextureCoordinateAccuracy(int value) {
        this.textureCoordinateAccuracy = value;
    }

    /**
     * Gets the color accuracy for Draco compression.
     * @return the color accuracy.
     */
    public int getColorAccuracy() {
        return colorAccuracy;
    }

    /**
     * Sets the color accuracy for Draco compression.
     * @param value New value.
     */
    public void setColorAccuracy(int value) {
        this.colorAccuracy = value;
    }

    /**
     * Gets the generic accuracy for Draco compression.
     * @return the generic accuracy.
     */
    public int getGenericAccuracy() {
        return genericAccuracy;
    }

    /**
     * Sets the generic accuracy for Draco compression.
     * @param value New value.
     */
    public void setGenericAccuracy(int value) {
        this.genericAccuracy = value;
    }

    /**
     * Gets whether to quantize the generation.
     * @return true if quantize generation.
     */
    public boolean getQuantizeGeneration() {
        return quantizeGeneration;
    }

    /**
     * Sets whether to quantize the generation.
     * @param value New value.
     */
    public void setQuantizeGeneration(boolean value) {
        this.quantizeGeneration = value;
    }
}
