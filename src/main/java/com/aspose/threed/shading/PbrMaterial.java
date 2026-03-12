package com.aspose.threed.shading;

import com.aspose.threed.*;

public class PbrMaterial extends Material {
    private Vector4 albedo;
    private double metallicFactor = 0.0;
    private double roughnessFactor = 1.0;
    private Vector3 emissiveColor;

    public PbrMaterial() {
        super();
    }

    public PbrMaterial(String name) {
        super(name);
    }

    public PbrMaterial(String name, Vector4 albedo) {
        super(name);
        this.albedo = albedo;
    }

    public Vector4 getAlbedo() {
        return albedo;
    }

    public void setAlbedo(Vector4 value) {
        this.albedo = value;
    }

    public double getMetallicFactor() {
        return metallicFactor;
    }

    public void setMetallicFactor(double value) {
        this.metallicFactor = value;
    }

    public double getRoughnessFactor() {
        return roughnessFactor;
    }

    public void setRoughnessFactor(double value) {
        this.roughnessFactor = value;
    }

    public Vector3 getEmissiveColor() {
        return emissiveColor;
    }

    public void setEmissiveColor(Vector3 value) {
        this.emissiveColor = value;
    }

    public double getTransparency() {
        return 1.0 - (albedo != null ? albedo.w : 1.0);
    }

    public void setTransparency(double value) {
        if (albedo != null) {
            double alpha = 1.0 - value;
            albedo = new Vector4(albedo.x, albedo.y, albedo.z, Math.max(0, Math.min(1, alpha)));
        }
    }

    public static PbrMaterial fromMaterial(Material material) {
        if (material instanceof PbrMaterial) {
            return (PbrMaterial) material;
        }
        PbrMaterial pbr = new PbrMaterial(material.getName());
        return pbr;
    }
}
