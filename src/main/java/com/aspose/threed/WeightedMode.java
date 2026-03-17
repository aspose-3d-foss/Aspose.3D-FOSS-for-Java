package com.aspose.threed;

public class WeightedMode {
    public static final WeightedMode NONE = new WeightedMode(0);
    public static final WeightedMode LEFT = new WeightedMode(1);
    public static final WeightedMode RIGHT = new WeightedMode(2);
    public static final WeightedMode BOTH = new WeightedMode(3);

    private final int value;

    private WeightedMode(int value) {
        this.value = value;
    }

    public int getValue() { return value; }

    @Override
    public String toString() {
        switch (value) {
            case 0: return "None";
            case 1: return "Left";
            case 2: return "Right";
            case 3: return "Both";
            default: return "Unknown";
        }
    }
}
