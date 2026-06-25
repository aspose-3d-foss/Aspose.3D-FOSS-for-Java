package com.aspose.threed;

/**
 * Stencil state for rendering operations.
 */
public class StencilState {
    private int failOperation = 0;
    private int zFailOperation = 0;
    private int passOperation = 0;
    private int compareFunction = 0;

    /**
     * Constructor of StencilState.
     */
    public StencilState() {
    }

    /**
     * Gets the fail operation.
     * @return the fail operation.
     */
    public int getFailOperation() {
        return failOperation;
    }

    /**
     * Sets the fail operation.
     * @param value New value.
     */
    public void setFailOperation(int value) {
        this.failOperation = value;
    }

    /**
     * Gets the depth fail operation.
     * @return the depth fail operation.
     */
    public int getZFailOperation() {
        return zFailOperation;
    }

    /**
     * Sets the depth fail operation.
     * @param value New value.
     */
    public void setZFailOperation(int value) {
        this.zFailOperation = value;
    }

    /**
     * Gets the pass operation.
     * @return the pass operation.
     */
    public int getPassOperation() {
        return passOperation;
    }

    /**
     * Sets the pass operation.
     * @param value New value.
     */
    public void setPassOperation(int value) {
        this.passOperation = value;
    }

    /**
     * Gets the compare function.
     * @return the compare function.
     */
    public int getCompareFunction() {
        return compareFunction;
    }

    /**
     * Sets the compare function.
     * @param value New value.
     */
    public void setCompareFunction(int value) {
        this.compareFunction = value;
    }
}
