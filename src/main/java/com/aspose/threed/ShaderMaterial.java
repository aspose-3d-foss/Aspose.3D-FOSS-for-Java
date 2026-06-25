package com.aspose.threed;

/**
 * A shader material that allows describing the material by external rendering engine or shader language.
 * ShaderMaterial uses ShaderTechnique to describe the concrete rendering details,
 * and the most suitable one will be used according to the final rendering platform.
 */
public class ShaderMaterial extends Material {
    private java.util.List<ShaderTechnique> techniques = new java.util.ArrayList<ShaderTechnique>();

    /**
     * Initializes a new instance of the ShaderMaterial class.
     */
    public ShaderMaterial() {
        super();
    }

    /**
     * Initializes a new instance of the ShaderMaterial class.
     * @param name Name of the material.
     */
    public ShaderMaterial(String name) {
        super(name);
    }

    /**
     * Gets all available techniques defined in this material.
     * @return all available techniques.
     */
    public java.util.List<ShaderTechnique> getTechniques() {
        return techniques;
    }
}
