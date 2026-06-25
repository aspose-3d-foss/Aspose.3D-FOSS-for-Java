package com.aspose.threed;

/**
 * Material for physically based rendering based on diffuse color/specular/glossiness
 */
public class PbrSpecularMaterial extends Material {
    /**
     * The texture map for specular glossiness
     */
    public static final String MAP_SPECULAR_GLOSSINESS = "SpecularGlossiness";

    /**
     * Constructor of the PbrSpecularMaterial
     */
    public PbrSpecularMaterial() {
    }

    /**
     * Gets the transparency factor.
     * The factor should be ranged between 0(0%, fully opaque) and 1(100%, fully transparent)
     * Any invalid factor value will be clamped.
     * @return the transparency factor.
     */
    public double getTransparency() {
        throw new UnsupportedOperationException();
    }

    /**
     * Sets the transparency factor.
     * The factor should be ranged between 0(0%, fully opaque) and 1(100%, fully transparent)
     * Any invalid factor value will be clamped.
     * @param value New value
     */
    public void setTransparency(double value) {
        throw new UnsupportedOperationException();
    }

    /**
     * Gets the texture of normal mapping
     * @return the texture of normal mapping
     */
    public TextureBase getNormalTexture() {
        throw new UnsupportedOperationException();
    }

    /**
     * Sets the texture of normal mapping
     * @param value New value
     */
    public void setNormalTexture(TextureBase value) {
        throw new UnsupportedOperationException();
    }

    /**
     * Gets the texture for specular color, channel RGB stores the specular color and channel A stores the glossiness.
     * @return the texture for specular color, channel RGB stores the specular color and channel A stores the glossiness.
     */
    public TextureBase getSpecularGlossinessTexture() {
        throw new UnsupportedOperationException();
    }

    /**
     * Sets the texture for specular color, channel RGB stores the specular color and channel A stores the glossiness.
     * @param value New value
     */
    public void setSpecularGlossinessTexture(TextureBase value) {
        throw new UnsupportedOperationException();
    }

    /**
     * Gets the glossiness(smoothness) of the material, 1 means perfectly smooth and 0 means perfectly rough, default value is 1, range is [0, 1]
     * @return the glossiness(smoothness) of the material, 1 means perfectly smooth and 0 means perfectly rough, default value is 1, range is [0, 1]
     */
    public double getGlossinessFactor() {
        throw new UnsupportedOperationException();
    }

    /**
     * Sets the glossiness(smoothness) of the material, 1 means perfectly smooth and 0 means perfectly rough, default value is 1, range is [0, 1]
     * @param value New value
     */
    public void setGlossinessFactor(double value) {
        throw new UnsupportedOperationException();
    }

    /**
     * Gets the specular color of the material, default value is (1, 1, 1).
     * @return the specular color of the material, default value is (1, 1, 1).
     */
    public Vector3 getSpecular() {
        throw new UnsupportedOperationException();
    }

    /**
     * Sets the specular color of the material, default value is (1, 1, 1).
     * @param value New value
     */
    public void setSpecular(Vector3 value) {
        throw new UnsupportedOperationException();
    }

    /**
     * Gets the texture for diffuse
     * @return the texture for diffuse
     */
    public TextureBase getDiffuseTexture() {
        throw new UnsupportedOperationException();
    }

    /**
     * Sets the texture for diffuse
     * @param value New value
     */
    public void setDiffuseTexture(TextureBase value) {
        throw new UnsupportedOperationException();
    }

    /**
     * Gets the diffuse color of the material, default value is (1, 1, 1)
     * @return the diffuse color of the material, default value is (1, 1, 1)
     */
    public Vector3 getDiffuse() {
        throw new UnsupportedOperationException();
    }

    /**
     * Sets the diffuse color of the material, default value is (1, 1, 1)
     * @param value New value
     */
    public void setDiffuse(Vector3 value) {
        throw new UnsupportedOperationException();
    }

    /**
     * Gets the texture for emissive
     * @return the texture for emissive
     */
    public TextureBase getEmissiveTexture() {
        throw new UnsupportedOperationException();
    }

    /**
     * Sets the texture for emissive
     * @param value New value
     */
    public void setEmissiveTexture(TextureBase value) {
        throw new UnsupportedOperationException();
    }

    /**
     * Gets the emissive color, default value is (0, 0, 0)
     * @return the emissive color, default value is (0, 0, 0)
     */
    public Vector3 getEmissiveColor() {
        throw new UnsupportedOperationException();
    }

    /**
     * Sets the emissive color, default value is (0, 0, 0)
     * @param value New value
     */
    public void setEmissiveColor(Vector3 value) {
        throw new UnsupportedOperationException();
    }
}
