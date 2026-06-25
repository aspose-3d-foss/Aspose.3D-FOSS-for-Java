package com.aspose.threed;

import java.io.Serializable;

public interface Struct<T> extends Cloneable, Serializable {
    T clone();
    void copyFrom(T src);
    
    /**
     * Try to copy the input value if it's Struct
     * @param <T> Struct type
     * @param value The value to copy
     * @return null if input is null or cloned instance
     */
    static <T extends Struct<T>> T byVal(T value) {
        return value != null ? value.clone() : null;
    }
}
