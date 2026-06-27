package com.aspose.threed;

/**
 * Generic enumerable interface for collection of type T
 */
public interface Enumerable<T> {
    /**
     * Returns an enumerator that iterates through the collection.
     * @return An enumerator that can be used to iterate through the collection
     */
    Enumerator<T> enumerator();
}
