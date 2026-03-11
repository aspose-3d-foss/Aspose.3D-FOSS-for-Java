package com.aspose.threed;

public interface Struct<T> extends Cloneable {
    T clone();
    void copyFrom(T src);
}
