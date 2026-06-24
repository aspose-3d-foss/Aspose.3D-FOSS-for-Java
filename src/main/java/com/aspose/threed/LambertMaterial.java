package com.aspose.threed;

import com.aspose.threed.Vector3;

/**
 * Material for lambert shading model.
 */
public class LambertMaterial extends Material {
    private Vector3 emissiveColor = new Vector3(0, 0, 0);
    private Vector3 ambientColor = new Vector3(0, 0, 0);
    private Vector3 diffuseColor = new Vector3(0.5f, 0.5f, 0.5f);
    private Vector3 transparentColor = new Vector3(0, 0, 0);
    private double transparency = 0.0;

    /**
     * Initializes a new instance of the LambertMaterial class.
     */
    public LambertMaterial() {
        super();
    }

    /**
     * Initializes a new instance of the LambertMaterial class.
     * @param name Material name
     */
    public LambertMaterial(String name) {
        super(name);
    }

    /**
     * Gets or sets the emissive color.
     */
    public Vector3 getEmissiveColor() {
        return emissiveColor;
    }

    public void setEmissiveColor(Vector3 emissiveColor) {
        this.emissiveColor = emissiveColor;
    }

    /**
     * Gets or sets the ambient color.
     */
    public Vector3 getAmbientColor() {
        return ambientColor;
    }

    public void setAmbientColor(Vector3 ambientColor) {
        this.ambientColor = ambientColor;
    }

    /**
     * Gets or sets the diffuse color.
     */
    public Vector3 getDiffuseColor() {
        return diffuseColor;
    }

    public void setDiffuseColor(Vector3 diffuseColor) {
        this.diffuseColor = diffuseColor;
    }

    /**
     * Gets or sets the transparent color.
     * The factor should be ranged between 0(0%, fully opaque) and 1(100%, fully transparent)
     * Any invalid factor value will be clamped.
     */
    public Vector3 getTransparentColor() {
        return transparentColor;
    }

    public void setTransparentColor(Vector3 transparentColor) {
        this.transparentColor = transparentColor;
    }

    /**
     * Gets or sets the transparency factor.
     * The factor should be ranged between 0(0%, fully opaque) and 1(100%, fully transparent)
     * Any invalid factor value will be clamped.
     */
    public double getTransparency() {
        return transparency;
    }

    public void setTransparency(double transparency) {
        this.transparency = transparency;
    }
}
