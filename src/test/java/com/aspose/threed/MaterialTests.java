package com.aspose.threed;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MaterialTests {
    @Test
    public void lambertMaterial_DefaultConstructor_ShouldCreateInstance() {
        LambertMaterial material = new LambertMaterial();

        assertNotNull(material);
    }

    @Test
    public void lambertMaterial_NameConstructor_ShouldSetName() {
        LambertMaterial material = new LambertMaterial("TestMaterial");

        assertEquals("TestMaterial", material.getName());
    }

    @Test
    public void lambertMaterial_Properties_ShouldBeSettable() {
        LambertMaterial material = new LambertMaterial();
        Vector3 color = new Vector3(0.5f, 0.5f, 0.5f);

        material.setEmissiveColor(color);
        material.setAmbientColor(color);
        material.setDiffuseColor(color);
        material.setTransparentColor(color);
        material.setTransparency(0.3);

        assertEquals(0.5f, material.getEmissiveColor().x, 1e-10);
        assertEquals(0.5f, material.getAmbientColor().x, 1e-10);
        assertEquals(0.5f, material.getDiffuseColor().x, 1e-10);
        assertEquals(0.5f, material.getTransparentColor().x, 1e-10);
        assertEquals(0.3, material.getTransparency(), 1e-10);
    }

    @Test
    public void phongMaterial_DefaultConstructor_ShouldCreateInstance() {
        PhongMaterial material = new PhongMaterial();

        assertNotNull(material);
    }

    @Test
    public void phongMaterial_NameConstructor_ShouldSetName() {
        PhongMaterial material = new PhongMaterial("PhongMaterial");

        assertEquals("PhongMaterial", material.getName());
    }

    @Test
    public void phongMaterial_Properties_ShouldBeSettable() {
        PhongMaterial material = new PhongMaterial();
        Vector3 specularColor = new Vector3(0.8f, 0.8f, 0.8f);

        material.setSpecularColor(specularColor);
        material.setShininess(50.0);
        material.setSpecularFactor(1.0);
        material.setReflectionColor(new Vector3(0.2f, 0.2f, 0.2f));
        material.setReflectionFactor(0.5);

        assertEquals(0.8f, material.getSpecularColor().x, 1e-10);
        assertEquals(50.0, material.getShininess(), 1e-10);
        assertEquals(1.0, material.getSpecularFactor(), 1e-10);
        assertEquals(0.2f, material.getReflectionColor().x, 1e-10);
        assertEquals(0.5, material.getReflectionFactor(), 1e-10);
    }

    @Test
    public void pbrMaterial_DefaultConstructor_ShouldCreateInstance() {
        PbrMaterial material = new PbrMaterial();

        assertNotNull(material);
    }

    @Test
    public void pbrMaterial_Properties_ShouldBeSettable() {
        PbrMaterial material = new PbrMaterial();
        Vector3 albedo = new Vector3(1.0f, 0.5f, 0.2f);

        material.setAlbedo(albedo);
        material.setMetallicFactor(0.8);
        material.setRoughnessFactor(0.2);
        material.setOcclusionFactor(0.9);
        material.setTransparency(0.5);

        assertEquals(1.0f, material.getAlbedo().x, 1e-10);
        assertEquals(0.8, material.getMetallicFactor(), 1e-10);
        assertEquals(0.2, material.getRoughnessFactor(), 1e-10);
        assertEquals(0.9, material.getOcclusionFactor(), 1e-10);
        assertEquals(0.5, material.getTransparency(), 1e-10);
    }

    @Test
    public void pbrMaterial_FromMaterial_ShouldCreateInstance() {
        LambertMaterial material = new LambertMaterial();
        PbrMaterial pbr = PbrMaterial.fromMaterial(material);

        assertNotNull(pbr);
    }
}
