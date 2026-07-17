package com.aspose.threed;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class for all vertex element types.
 */
public abstract class VertexElement {
    private String name;
    private MappingMode mappingMode;
    private ReferenceMode referenceMode;
    private final List<Integer> indices = new ArrayList<>();
    protected VertexElementType type;

    /**
     * Constructor.
     */
    protected VertexElement() {
    }

    /**
     * Constructor.
     * 
     * @param type The type of the vertex element.
     * @param mappingMode The mapping mode.
     * @param referenceMode The reference mode.
     */
    protected VertexElement(VertexElementType type, MappingMode mappingMode, ReferenceMode referenceMode) {
        this.type = type;
    }

    /**
     * Gets the type of the vertex element.
     * 
     * @return The vertex element type.
     */
    public VertexElementType getVertexElementType() {
        return type;
    }

    /**
     * Gets the name of the vertex element.
     * 
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the vertex element.
     * 
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the mapping mode.
     * 
     * @return The mapping mode.
     */
    public MappingMode getMappingMode() {
        return mappingMode;
    }

    /**
     * Sets the mapping mode.
     * 
     * @param mappingMode The mapping mode to set.
     */
    public void setMappingMode(MappingMode mappingMode) {
        this.mappingMode = mappingMode;
    }

    /**
     * Gets the reference mode.
     * 
     * @return The reference mode.
     */
    public ReferenceMode getReferenceMode() {
        return referenceMode;
    }

    /**
     * Sets the reference mode.
     * 
     * @param referenceMode The reference mode to set.
     */
    public void setReferenceMode(ReferenceMode referenceMode) {
        this.referenceMode = referenceMode;
    }

    /**
     * Gets the indices list.
     * 
     * @return The indices list.
     */
    public List<Integer> getIndices() {
        return indices;
    }

    /**
     * Sets the indices array.
     * 
     * @param indices The indices array to set.
     */
    public void setIndices(int[] indices) {
        this.indices.clear();
        if (indices != null) {
            for (int index : indices) {
                this.indices.add(index);
            }
        }
    }

    /**
     * Clears all the data from this vertex element.
     */
    public abstract void clear();

    /**
     * Clones the vertex element.
     * 
     * @param withData If true, data will be cloned; otherwise only the structure.
     * @param withIndices If true, indices will be cloned; otherwise only the structure.
     * @return The cloned vertex element.
     */
    public abstract VertexElement clone(boolean withData, boolean withIndices);

    /**
     * Clones the vertex element.
     * 
     * @param withData If true, data will be cloned; otherwise only the structure.
     * @return The cloned vertex element.
     */
    public VertexElement clone(boolean withData) {
        return clone(withData, false);
    }

    /**
     * Clones the vertex element with default settings.
     * 
     * @return The cloned vertex element.
     */
    public VertexElement clone() {
        return clone(false);
    }

    /**
     * Returns a string representation of the vertex element.
     * 
     * @return A string representation.
     */
    @Override
    public String toString() {
        return "VertexElement(" + getVertexElementType() + ")";
    }
}
