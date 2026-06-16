package com.aspose.threed;

import java.io.Serializable;

public class VertexField implements Serializable {
    private VertexFieldDataType dataType;
    private VertexFieldSemantic semantic;
    private String alias;
    private int index;
    private int offset;
    private int size;

    public VertexField(VertexFieldDataType dataType, VertexFieldSemantic semantic, int index, String alias, int offset, int size) {
        this.dataType = dataType;
        this.semantic = semantic;
        this.index = index;
        this.alias = alias;
        this.offset = offset;
        this.size = size;
    }

    public VertexFieldDataType getDataType() {
        return dataType;
    }

    public VertexFieldSemantic getSemantic() {
        return semantic;
    }

    public String getAlias() {
        return alias;
    }

    public int getIndex() {
        return index;
    }

    public int getOffset() {
        return offset;
    }

    public int getSize() {
        return size;
    }

    @Override
    public int hashCode() {
        int result = dataType.hashCode();
        result = 31 * result + semantic.hashCode();
        result = 31 * result + index;
        result = 31 * result + (alias != null ? alias.hashCode() : 0);
        result = 31 * result + offset;
        result = 31 * result + size;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        VertexField other = (VertexField) obj;
        return index == other.index &&
                offset == other.offset &&
                size == other.size &&
                dataType == other.dataType &&
                semantic == other.semantic &&
                (alias != null ? alias.equals(other.alias) : other.alias == null);
    }

    @Override
    public String toString() {
        return semantic + "(" + index + ") (" + dataType + ") Offset: " + offset + ", Size: " + size;
    }
}
