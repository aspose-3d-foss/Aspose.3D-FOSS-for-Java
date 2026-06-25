package com.aspose.threed;

/**
 * Weighted mode.
 */
public final class WeightedMode {
    /**
     * Both out and next in weights are not used.
     *   When calculation needs tangent information, default value(0.3333) will be used.
     */
    public static final int NONE = 0;
    /**
     * Out(right) tangent is weighted.
     */
    public static final int OUT_WEIGHT = 1;
    /**
     * Next in(left) tangent is weighted.
     */
    public static final int NEXT_IN_WEIGHT = 2;
    /**
     * Both out and next in tangents are weighted.
     */
    public static final int BOTH = 3;

    public WeightedMode() {
    }
}
