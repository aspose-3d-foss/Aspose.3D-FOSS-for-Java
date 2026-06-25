package com.aspose.threed;

/**
 * Extrapolation defines how to do when sampled value is out of the range which defined by the first and last key-frames.
 */
public class Extrapolation {
    private ExtrapolationType type;
    private int repeatCount;

    public Extrapolation() {
        this.type = ExtrapolationType.CONSTANT;
        this.repeatCount = 0;
    }

    /**
     * Gets and sets the sampling pattern of extrapolation
     */
    public ExtrapolationType getType() {
        return type;
    }

    /**
     * Gets and sets the sampling pattern of extrapolation
     */
    public void setType(ExtrapolationType value) {
        this.type = value;
    }

    /**
     * Gets and sets the repeat times of the extrapolation pattern.
     */
    public int getRepeatCount() {
        return repeatCount;
    }

    /**
     * Gets and sets the repeat times of the extrapolation pattern.
     */
    public void setRepeatCount(int value) {
        this.repeatCount = value;
    }
}
