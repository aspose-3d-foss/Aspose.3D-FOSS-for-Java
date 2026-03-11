package com.aspose.threed;

public class VertexElementUV extends VertexElement {
    private final TextureMapping mapping;

    public VertexElementUV(TextureMapping mapping, MappingMode mappingMode, ReferenceMode referenceMode) {
        super(VertexElementType.UV, mappingMode, referenceMode);
        this.mapping = mapping;
    }

    public TextureMapping getMapping() {
        return mapping;
    }
}
