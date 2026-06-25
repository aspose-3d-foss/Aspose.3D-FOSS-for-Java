package com.aspose.threed;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * A shader technique represents a concrete rendering implementation.
 */
public class ShaderTechnique {
    private String description = "";
    private String shaderLanguage = "";
    private String shaderVersion = "";
    private String shaderFile = "";
    private byte[] shaderContent = new byte[0];
    private String shaderEntry = "";
    private String renderAPI = "";
    private String renderAPIVersion = "";
    private Map<String, String> shaderParameters = new HashMap<String, String>();

    /**
     * Initializes a new instance of the ShaderTechnique class.
     */
    public ShaderTechnique() {
    }

    /**
     * Gets the description of this technique.
     * @return the description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of this technique.
     * @param value New value.
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the shader language used by this technique.
     * @return the shader language.
     */
    public String getShaderLanguage() {
        return shaderLanguage;
    }

    /**
     * Sets the shader language used by this technique.
     * @param value New value.
     */
    public void setShaderLanguage(String value) {
        this.shaderLanguage = value;
    }

    /**
     * Gets the shader version used by this technique.
     * @return the shader version.
     */
    public String getShaderVersion() {
        return shaderVersion;
    }

    /**
     * Sets the shader version used by this technique.
     * @param value New value.
     */
    public void setShaderVersion(String value) {
        this.shaderVersion = value;
    }

    /**
     * Gets the file name of the external shader file.
     * @return the shader file name.
     */
    public String getShaderFile() {
        return shaderFile;
    }

    /**
     * Sets the file name of the external shader file.
     * @param value New value.
     */
    public void setShaderFile(String value) {
        this.shaderFile = value;
    }

    /**
     * Gets the content of an embedded shader script.
     * @return the shader content.
     */
    public byte[] getShaderContent() {
        return shaderContent;
    }

    /**
     * Sets the content of an embedded shader script.
     * @param value New value.
     */
    public void setShaderContent(byte[] value) {
        this.shaderContent = value;
    }

    /**
     * Gets the entry point of the shader.
     * @return the shader entry point.
     */
    public String getShaderEntry() {
        return shaderEntry;
    }

    /**
     * Sets the entry point of the shader.
     * @param value New value.
     */
    public void setShaderEntry(String value) {
        this.shaderEntry = value;
    }

    /**
     * Gets the rendering API used by this technique.
     * @return the rendering API.
     */
    public String getRenderAPI() {
        return renderAPI;
    }

    /**
     * Sets the rendering API used by this technique.
     * @param value New value.
     */
    public void setRenderAPI(String value) {
        this.renderAPI = value;
    }

    /**
     * Gets the version of the rendering API.
     * @return the rendering API version.
     */
    public String getRenderAPIVersion() {
        return renderAPIVersion;
    }

    /**
     * Sets the version of the rendering API.
     * @param value New value.
     */
    public void setRenderAPIVersion(String value) {
        this.renderAPIVersion = value;
    }

    /**
     * Gets the shader parameter definition.
     * @return the shader parameters map.
     */
    public Map<String, String> getShaderParameters() {
        return shaderParameters;
    }

    /**
     * Binds the dynamic property to shader parameter.
     * @param property The name of the dynamic property.
     * @param shaderParameter The name of the shader parameter.
     */
    public void addBinding(String property, String shaderParameter) {
        shaderParameters.put(property, shaderParameter);
    }
}
