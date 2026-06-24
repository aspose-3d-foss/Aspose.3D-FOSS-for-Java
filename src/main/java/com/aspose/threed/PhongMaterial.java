package com.aspose.threed;

import com.aspose.threed.Vector3;

/**
 * Material for blinn-phong shading model.
 */
public class PhongMaterial extends LambertMaterial {
    private Vector3 specularColor = new Vector3(0.2f, 0.2f, 0.2f);
    private double specularFactor = 1.0;
    private double shininess = 20.0;
    private Vector3 reflectionColor = new Vector3(0, 0, 0);
    private double reflectionFactor = 0.0;

    /**
     * Initializes a new instance of the PhongMaterial class.
     */
    public PhongMaterial() {
        super();
    }

    /**
     * Initializes a new instance of the PhongMaterial class.
     * @param name Material name
     */
    public PhongMaterial(String name) {
        super(name);
    }

    /**
     * Gets or sets the specular color.
     */
    public Vector3 getSpecularColor() {
        return specularColor;
    }

    public void setSpecularColor(Vector3 specularColor) {
        this.specularColor = specularColor;
    }

    /**
     * Gets or sets the specular factor.
     * The formula of specular:
     *  SpecularColor * SpecularFactor * (N dot H) ^ Shininess
     */
    public double getSpecularFactor() {
        return specularFactor;
    }

    public void setSpecularFactor(double specularFactor) {
        this.specularFactor = specularFactor;
    }

    /**
     * Gets or sets the shininess, this controls the specular highlight's size.
     * The formula of specular:
     *  SpecularColor * SpecularFactor * (N dot H) ^ Shininess
     */
    public double getShininess() {
        return shininess;
    }

    public void setShininess(double shininess) {
        this.shininess = shininess;
    }

    /**
     * Gets or sets the reflection color.
     */
    public Vector3 getReflectionColor() {
        return reflectionColor;
    }

    public void setReflectionColor(Vector3 reflectionColor) {
        this.reflectionColor = reflectionColor;
    }

    /**
     * Gets or sets the attenuation of the reflection color.
     */
    public double getReflectionFactor() {
        return reflectionFactor;
    }

    public void setReflectionFactor(double reflectionFactor) {
        this.reflectionFactor = reflectionFactor;
    }
}
