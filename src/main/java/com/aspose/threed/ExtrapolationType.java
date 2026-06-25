package com.aspose.threed;

/**
 * Extrapolation type.
 */
public enum ExtrapolationType {
    /**
     * Value will keep the same value of the last value
     */
    CONSTANT,
    /**
     * Value will keep the same slope by time
     */
    GRADIENT,
    /**
     * The repetition.
     */
    CYCLE,
    /**
     * Repeat the previous pattern based on the last value
     */
    CYCLE_RELATIVE,
    /**
     * The mirror repetition.
     */
    OSCILLATE;
}
