package com.aspose.threed;

/**
 * The compare function used in depth/stencil testing.
 */
public enum CompareFunction {
    /**
     * Never passes
     */
    NEVER,
    /**
     * Pass if the incoming value is less than the stored value.
     */
    LESS,
    /**
     * Pass if the incoming value is equal to the stored value.
     */
    EQUAL,
    /**
     * Pass if the incoming value is less than or equal to the stored value.
     */
    L_EQUAL,
    /**
     * Pass if the incoming value is greater than the stored value.
     */
    GREATER,
    /**
     * Pass if the incoming value is not equal to the stored value.
     */
    NOT_EQUAL,
    /**
     * Pass if the incoming value is greater than or equal to the stored value.
     */
    G_EQUAL,
    /**
     * Always passes
     */
    ALWAYS;
}
