package com.aspose.threed;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VertexDeclaration implements Serializable, Iterable<VertexField> {
    private final List<VertexField> fields = new ArrayList<>();
    private boolean sealed = false;

    public VertexDeclaration() {
    }

    public boolean isSealed() {
        return sealed;
    }

    public int size() {
        return fields.size();
    }

    public VertexField get(int index) {
        return fields.get(index);
    }

    public int getSize() {
        if (fields.isEmpty()) {
            return 0;
        }
        VertexField last = fields.get(fields.size() - 1);
        return last.getOffset() + last.getSize();
    }

    public void clear() {
        if (sealed) {
            throw new IllegalStateException("VertexDeclaration is sealed and cannot be modified");
        }
        fields.clear();
    }

    private int getFieldSize(VertexFieldDataType dataType) {
        switch (dataType) {
            case Float:
                return 4;
            case FVector2:
                return 8;
            case FVector3:
                return 12;
            case FVector4:
                return 16;
            case Double:
                return 8;
            case Vector2:
                return 16;
            case Vector3:
                return 24;
            case Vector4:
                return 32;
            case Int8:
                return 1;
            case ByteVector4:
                return 4;
            case Int16:
                return 2;
            case Int32:
                return 4;
            case Int64:
                return 8;
            default:
                throw new IllegalArgumentException("Unknown data type: " + dataType);
        }
    }

    public VertexField addField(VertexFieldDataType dataType, VertexFieldSemantic semantic, int index, String alias) {
        if (sealed) {
            throw new IllegalStateException("VertexDeclaration is sealed and cannot be modified");
        }

        int offset = getSize();
        int size = getFieldSize(dataType);
        VertexField field = new VertexField(dataType, semantic, index, alias, offset, size);
        fields.add(field);
        return field;
    }

    @Override
    public java.util.Iterator<VertexField> iterator() {
        return fields.iterator();
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (VertexField field : fields) {
            result = 31 * result + field.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        VertexDeclaration other = (VertexDeclaration) obj;
        if (fields.size() != other.fields.size()) return false;
        for (int i = 0; i < fields.size(); i++) {
            if (!fields.get(i).equals(other.fields.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fields.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(fields.get(i).toString());
        }
        return sb.toString();
    }
}
