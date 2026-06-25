package com.aspose.threed;

/**
 * Render state for building the pipeline.
 * The changes made on render state will not affect the created pipeline instances.
 */
public class RenderState implements java.io.Closeable, java.lang.Comparable<RenderState> {
    private boolean blend = false;
    private FVector4 blendColor = new FVector4(0, 0, 0, 0);
    private int sourceBlendFactor = 0;
    private int destinationBlendFactor = 0;
    private boolean cullFace = true;
    private int cullFaceMode = 0;
    private int frontFace = 0;
    private boolean depthTest = true;
    private boolean depthMask = true;
    private int depthFunction = 0;
    private boolean stencilTest = false;
    private int stencilReference = 0;
    private int stencilMask = 0xFF;
    private StencilState stencilFrontFace = new StencilState();
    private StencilState stencilBackFace = new StencilState();
    private boolean scissorTest = false;
    private int polygonMode = 0;

    /**
     * Constructor of RenderState.
     */
    public RenderState() {
    }

    /**
     * Enable or disable the fragment blending.
     * @return Enable or disable the fragment blending.
     */
    public boolean getBlend() {
        return blend;
    }

    /**
     * Enable or disable the fragment blending.
     * @param value New value
     */
    public void setBlend(boolean value) {
        this.blend = value;
    }

    /**
     * Gets the blend color where used in BlendFactor.CONSTANT_COLOR
     * @return the blend color where used in BlendFactor.CONSTANT_COLOR
     */
    public FVector4 getBlendColor() {
        return blendColor;
    }

    /**
     * Sets the blend color where used in BlendFactor.CONSTANT_COLOR
     * @param value New value
     */
    public void setBlendColor(FVector4 value) {
        this.blendColor = value;
    }

    /**
     * Gets how the color is blended.
     * @return how the color is blended.
     */
    public int getSourceBlendFactor() {
        return sourceBlendFactor;
    }

    /**
     * Sets how the color is blended.
     * @param value New value
     */
    public void setSourceBlendFactor(int value) {
        this.sourceBlendFactor = value;
    }

    /**
     * Gets how the color is blended.
     * @return how the color is blended.
     */
    public int getDestinationBlendFactor() {
        return destinationBlendFactor;
    }

    /**
     * Sets how the color is blended.
     * @param value New value
     */
    public void setDestinationBlendFactor(int value) {
        this.destinationBlendFactor = value;
    }

    /**
     * Enable or disable cull face
     * @return Enable or disable cull face
     */
    public boolean getCullFace() {
        return cullFace;
    }

    /**
     * Enable or disable cull face
     * @param value New value
     */
    public void setCullFace(boolean value) {
        this.cullFace = value;
    }

    /**
     * Gets which face will be culled.
     * @return which face will be culled.
     */
    public int getCullFaceMode() {
        return cullFaceMode;
    }

    /**
     * Sets which face will be culled.
     * @param value New value
     */
    public void setCullFaceMode(int value) {
        this.cullFaceMode = value;
    }

    /**
     * Gets which order is front face.
     * @return which order is front face.
     */
    public int getFrontFace() {
        return frontFace;
    }

    /**
     * Sets which order is front face.
     * @param value New value
     */
    public void setFrontFace(int value) {
        this.frontFace = value;
    }

    /**
     * Enable or disable the depth test.
     * @return Enable or disable the depth test.
     */
    public boolean getDepthTest() {
        return depthTest;
    }

    /**
     * Enable or disable the depth test.
     * @param value New value
     */
    public void setDepthTest(boolean value) {
        this.depthTest = value;
    }

    /**
     * Enable or disable the depth writing.
     * @return Enable or disable the depth writing.
     */
    public boolean getDepthMask() {
        return depthMask;
    }

    /**
     * Enable or disable the depth writing.
     * @param value New value
     */
    public void setDepthMask(boolean value) {
        this.depthMask = value;
    }

    /**
     * Gets the compare function used in depth test
     * @return the compare function used in depth test
     */
    public int getDepthFunction() {
        return depthFunction;
    }

    /**
     * Sets the compare function used in depth test
     * @param value New value
     */
    public void setDepthFunction(int value) {
        this.depthFunction = value;
    }

    /**
     * Enable or disable the stencil test.
     * @return Enable or disable the stencil test.
     */
    public boolean getStencilTest() {
        return stencilTest;
    }

    /**
     * Enable or disable the stencil test.
     * @param value New value
     */
    public void setStencilTest(boolean value) {
        this.stencilTest = value;
    }

    /**
     * Gets the reference value for the stencil test.
     * @return the reference value for the stencil test.
     */
    public int getStencilReference() {
        return stencilReference;
    }

    /**
     * Sets the reference value for the stencil test.
     * @param value New value
     */
    public void setStencilReference(int value) {
        this.stencilReference = value;
    }

    /**
     * Gets the mask that is ANDed with the both reference and stored stencil value when test is done.
     * @return the mask that is ANDed with the both reference and stored stencil value when test is done.
     */
    public int getStencilMask() {
        return stencilMask;
    }

    /**
     * Sets the mask that is ANDed with the both reference and stored stencil value when test is done.
     * @param value New value
     */
    public void setStencilMask(int value) {
        this.stencilMask = value;
    }

    /**
     * Gets the stencil state for front face.
     * @return the stencil state for front face.
     */
    public StencilState getStencilFrontFace() {
        return stencilFrontFace;
    }

    /**
     * Gets the stencil state for back face.
     * @return the stencil state for back face.
     */
    public StencilState getStencilBackFace() {
        return stencilBackFace;
    }

    /**
     * Enable or disable scissor test
     * @return Enable or disable scissor test
     */
    public boolean getScissorTest() {
        return scissorTest;
    }

    /**
     * Enable or disable scissor test
     * @param value New value
     */
    public void setScissorTest(boolean value) {
        this.scissorTest = value;
    }

    /**
     * Gets the polygon's render mode.
     * @return the polygon's render mode.
     */
    public int getPolygonMode() {
        return polygonMode;
    }

    /**
     * Sets the polygon's render mode.
     * @param value New value
     */
    public void setPolygonMode(int value) {
        this.polygonMode = value;
    }

    /**
     * Compare the render state with another instance
     * @param other Another render state to compare
     * @return 0 if equal, negative if less than, positive if greater than
     */
    public int compareTo(RenderState other) {
        if (this == other) return 0;
        return System.identityHashCode(this) - System.identityHashCode(other);
    }

    @Override
    public int hashCode() {
        return System.identityHashCode(this);
    }

    @Override
    public void close() {
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }
}
