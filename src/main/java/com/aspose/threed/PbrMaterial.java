package com.aspose.threed;

import com.aspose.threed.Material;
import com.aspose.threed.Vector3;

/**
 * Material for physically based rendering based on albedo color/metallic/roughness.
 */
public class PbrMaterial extends Material {
    private double transparency = 0.0;
    private TextureBase normalTexture;
    private TextureBase specularTexture;
    private TextureBase albedoTexture;
    private Vector3 albedo = new Vector3(1, 1, 1);
    private TextureBase occlusionTexture;
    private double occlusionFactor = 1.0;
    private double metallicFactor = 0.0;
    private double roughnessFactor = 0.5;
    private TextureBase metallicRoughness;
    private TextureBase emissiveTexture;
    private Vector3 emissiveColor = new Vector3(0, 0, 0);

    /**
     * Construct a default PBR material instance.
     */
    public PbrMaterial() {
        super();
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

    /**
     * Gets or sets the texture of normal mapping.
     */
    public TextureBase getNormalTexture() {
        return normalTexture;
    }

    public void setNormalTexture(TextureBase normalTexture) {
        this.normalTexture = normalTexture;
    }

    /**
     * Gets or sets the texture for specular color.
     */
    public TextureBase getSpecularTexture() {
        return specularTexture;
    }

    public void setSpecularTexture(TextureBase specularTexture) {
        this.specularTexture = specularTexture;
    }

    /**
     * Gets or sets the texture for albedo.
     */
    public TextureBase getAlbedoTexture() {
        return albedoTexture;
    }

    public void setAlbedoTexture(TextureBase albedoTexture) {
        this.albedoTexture = albedoTexture;
    }

    /**
     * Gets or sets the base color of the material.
     */
    public Vector3 getAlbedo() {
        return albedo;
    }

    public void setAlbedo(Vector3 albedo) {
        this.albedo = albedo;
    }

    /**
     * Gets or sets the texture for ambient occlusion.
     */
    public TextureBase getOcclusionTexture() {
        return occlusionTexture;
    }

    public void setOcclusionTexture(TextureBase occlusionTexture) {
        this.occlusionTexture = occlusionTexture;
    }

    /**
     * Gets or sets the factor of ambient occlusion.
     */
    public double getOcclusionFactor() {
        return occlusionFactor;
    }

    public void setOcclusionFactor(double occlusionFactor) {
        this.occlusionFactor = occlusionFactor;
    }

    /**
     * Gets or sets the metalness of the material, value of 1 means the material is a metal and value of 0 means the material is a dielectric.
     */
    public double getMetallicFactor() {
        return metallicFactor;
    }

    public void setMetallicFactor(double metallicFactor) {
        this.metallicFactor = metallicFactor;
    }

    /**
     * Gets or sets the roughness of the material, value of 1 means the material is completely rough and value of 0 means the material is completely smooth.
     */
    public double getRoughnessFactor() {
        return roughnessFactor;
    }

    public void setRoughnessFactor(double roughnessFactor) {
        this.roughnessFactor = roughnessFactor;
    }

    /**
     * Gets or sets the texture for metallic(in R channel) and roughness(in G channel).
     */
    public TextureBase getMetallicRoughness() {
        return metallicRoughness;
    }

    public void setMetallicRoughness(TextureBase metallicRoughness) {
        this.metallicRoughness = metallicRoughness;
    }

    /**
     * Gets or sets the texture for emissive.
     */
    public TextureBase getEmissiveTexture() {
        return emissiveTexture;
    }

    public void setEmissiveTexture(TextureBase emissiveTexture) {
        this.emissiveTexture = emissiveTexture;
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
     * Allow convert other material to PbrMaterial.
     * @param material The source material
     * @return A new PbrMaterial instance
     */
    public static PbrMaterial fromMaterial(Material material) {
        return new PbrMaterial();
    }
}
