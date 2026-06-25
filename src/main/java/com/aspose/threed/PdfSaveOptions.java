package com.aspose.threed;

/**
 * The save options in PDF exporting.
 */
public class PdfSaveOptions extends SaveOptions {
    private PdfRenderMode renderMode = PdfRenderMode.SOLID;
    private PdfLightingScheme lightingScheme = PdfLightingScheme.ARTWORK;
    private Vector3 backgroundColor = new Vector3(1, 1, 1);
    private Vector3 faceColor = new Vector3(0.75f, 0.75f, 0.75f);
    private Vector3 auxiliaryColor = new Vector3(0, 0, 0);
    private boolean flipCoordinateSystem = false;
    private boolean embedTextures = false;

    /**
     * Constructor of PdfSaveOptions.
     */
    public PdfSaveOptions() {
    }

    /**
     * Render mode specifies the style in which the 3D artwork is rendered.
     * @return The render mode.
     */
    public PdfRenderMode getRenderMode() {
        return renderMode;
    }

    /**
     * Render mode specifies the style in which the 3D artwork is rendered.
     * @param value New value.
     */
    public void setRenderMode(PdfRenderMode value) {
        this.renderMode = value;
    }

    /**
     * LightingScheme specifies the lighting to apply to 3D artwork.
     * @return The lighting scheme.
     */
    public PdfLightingScheme getLightingScheme() {
        return lightingScheme;
    }

    /**
     * LightingScheme specifies the lighting to apply to 3D artwork.
     * @param value New value.
     */
    public void setLightingScheme(PdfLightingScheme value) {
        this.lightingScheme = value;
    }

    /**
     * Background color of the 3D view in PDF file.
     * @return The background color.
     */
    public Vector3 getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * Background color of the 3D view in PDF file.
     * @param value New value.
     */
    public void setBackgroundColor(Vector3 value) {
        this.backgroundColor = value;
    }

    /**
     * Gets the face color to be used when rendering the 3D content.
     * This is only relevant only when the getRenderMode() has a value of Illustration.
     * @return The face color.
     */
    public Vector3 getFaceColor() {
        return faceColor;
    }

    /**
     * Sets the face color to be used when rendering the 3D content.
     * This is only relevant only when the getRenderMode() has a value of Illustration.
     * @param value New value.
     */
    public void setFaceColor(Vector3 value) {
        this.faceColor = value;
    }

    /**
     * Gets the auxiliary color to be used when rendering the 3D content.
     * The interpretation of this color depends on the getRenderMode().
     * @return The auxiliary color.
     */
    public Vector3 getAuxiliaryColor() {
        return auxiliaryColor;
    }

    /**
     * Sets the auxiliary color to be used when rendering the 3D content.
     * The interpretation of this color depends on the getRenderMode().
     * @param value New value.
     */
    public void setAuxiliaryColor(Vector3 value) {
        this.auxiliaryColor = value;
    }

    /**
     * Gets to flip the coordinate system of the scene during exporting.
     * @return true if flip coordinate system.
     */
    public boolean getFlipCoordinateSystem() {
        return flipCoordinateSystem;
    }

    /**
     * Sets to flip the coordinate system of the scene during exporting.
     * @param value New value.
     */
    public void setFlipCoordinateSystem(boolean value) {
        this.flipCoordinateSystem = value;
    }

    /**
     * Embed the external textures into the PDF file, default value is false.
     * @return true if embed textures.
     */
    public boolean getEmbedTextures() {
        return embedTextures;
    }

    /**
     * Embed the external textures into the PDF file, default value is false.
     * @param value New value.
     */
    public void setEmbedTextures(boolean value) {
        this.embedTextures = value;
    }
}
