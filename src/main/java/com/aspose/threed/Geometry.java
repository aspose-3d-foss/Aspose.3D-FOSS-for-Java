package com.aspose.threed;

public class Geometry extends Entity {
    private boolean visible = true;
    private boolean castShadows = true;
    private boolean receiveShadows = true;
    private final java.util.List<Vector4> controlPoints = new java.util.ArrayList<>();
    private final java.util.List<VertexElement> vertexElements = new java.util.ArrayList<>();
    private final java.util.List<Deformer> deformers = new java.util.ArrayList<>();

    public Geometry() {
        super();
    }

    public Geometry(String name) {
        super(name);
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean value) {
        this.visible = value;
    }

    public boolean getCastShadows() {
        return castShadows;
    }

    public void setCastShadows(boolean value) {
        this.castShadows = value;
    }

    public boolean getReceiveShadows() {
        return receiveShadows;
    }

    public void setReceiveShadows(boolean value) {
        this.receiveShadows = value;
    }

    public java.util.List<Vector4> getControlPoints() {
        return controlPoints;
    }

    public java.util.List<VertexElement> getVertexElements() {
        return vertexElements;
    }

    public java.util.List<Deformer> getDeformers() {
        return deformers;
    }

    public VertexElement getElement(VertexElementType type) {
        for (VertexElement element : vertexElements) {
            if (element.getType() == type) {
                return element;
            }
        }
        return null;
    }

    public VertexElement createElement(VertexElementType type) {
        VertexElement element = createElement(type, MappingMode.CONTROL_POINT, ReferenceMode.DIRECT);
        vertexElements.add(element);
        return element;
    }

    public VertexElement createElement(VertexElementType type, MappingMode mappingMode, ReferenceMode referenceMode) {
        switch (type) {
            case NORMAL:
                return new VertexElementNormal(mappingMode, referenceMode);
            case UV:
                return new VertexElementUV(TextureMapping.DIFFUSE, mappingMode, referenceMode);
            case MATERIAL:
                return new VertexElementMaterial(mappingMode, referenceMode);
            case BINORMAL:
                return new VertexElementBinormal(mappingMode, referenceMode);
            case TANGENT:
                return new VertexElementTangent(mappingMode, referenceMode);
            default:
                return new VertexElement(type, mappingMode, referenceMode);
        }
    }

    public void addElement(VertexElement element) {
        vertexElements.add(element);
    }

    /**
     * Adds a deformer to this geometry and sets the owner reference.
     * @param deformer The deformer to add.
     */
    public void addDeformer(Deformer deformer) {
        deformers.add(deformer);
        deformer.setOwner(this);
    }

    public VertexElementUV getVertexElementOfUV(TextureMapping mapping) {
        for (VertexElement element : vertexElements) {
            if (element instanceof VertexElementUV) {
                VertexElementUV uv = (VertexElementUV) element;
                if (uv.getMapping() == mapping) {
                    return uv;
                }
            }
        }
        return null;
    }

    public VertexElementUV createElementUV(TextureMapping mapping) {
        return createElementUV(mapping, MappingMode.CONTROL_POINT, ReferenceMode.DIRECT);
    }

    public VertexElementUV createElementUV(TextureMapping mapping, MappingMode mappingMode, ReferenceMode referenceMode) {
        VertexElementUV element = new VertexElementUV(mapping, mappingMode, referenceMode);
        vertexElements.add(element);
        return element;
    }

    public <T extends Deformer> java.util.Collection<T> getDeformers2() {
        return (java.util.Collection<T>) deformers;
    }
}
