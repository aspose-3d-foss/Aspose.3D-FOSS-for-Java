package com.aspose.threed;

/**
 * Generic enumerator for collection of type T
 */
public interface Enumerator<T> {
    /**
     * Advances the enumerator to the next element of the collection.
     * @return true if the enumerator was successfully advanced to the next element; false if the enumerator has passed the end of the collection
     */
    boolean moveNext();
    
    /**
     * Gets the current element in the collection.
     * @return The current element in the collection
     */
    T getCurrent();
}
