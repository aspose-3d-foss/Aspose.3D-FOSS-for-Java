package com.aspose.threed;

/**
 * Property flags.
 */
public enum PropertyFlags {
    None(0),
    ReadOnly(1),
    Hidden(2),
    Local(4),
    Animation(8),
    Keyable(16),
    Animated(32),
    Animatable(64),
    Discrete(128),
    Override(256),
    All(0xFFFF);

    private final int value;

    PropertyFlags(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
