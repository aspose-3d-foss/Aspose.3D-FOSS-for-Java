package com.aspose.threed;

import java.util.ArrayList;
import java.util.List;

public class Node extends SceneObject {
    private Node parentNode;
    private final List<Node> childNodes = new ArrayList<>();
    private Entity entity;
    private final List<Entity> entities = new ArrayList<>();
    private final List<Material> materials = new ArrayList<>();
    private Material material;
    private AssetInfo assetInfo;
    private boolean visible = true;
    private boolean excluded = false;
    private final Transform transform = new Transform();
    private GlobalTransform globalTransform;
    private final List<CustomObject> metaDatas = new ArrayList<>();

    public Node() {
        super();
    }

    public Node(String name) {
        super(name);
    }

    public Node(String name, Entity entity) {
        super(name);
        this.entity = entity;
        if (entity != null) {
            entity.setParentNode(this);
            entities.add(entity);
        }
    }

    public AssetInfo getAssetInfo() {
        return assetInfo;
    }

    public void setAssetInfo(AssetInfo value) {
        this.assetInfo = value;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean value) {
        this.visible = value;
    }

    public List<Node> getChildNodes() {
        return childNodes;
    }

    public Node createChildNode() {
        Node node = new Node();
        addChildNode(node);
        return node;
    }

    public Node createChildNode(String name) {
        Node node = new Node(name);
        addChildNode(node);
        return node;
    }

    public Node createChildNode(Entity entity) {
        Node node = new Node(null, entity);
        addChildNode(node);
        return node;
    }

    public Node createChildNode(String name, Entity entity) {
        Node node = new Node(name, entity);
        addChildNode(node);
        return node;
    }

    public Node createChildNode(String name, Entity entity, Material material) {
        Node node = new Node(name, entity);
        if (material != null) {
            node.setMaterial(material);
        }
        addChildNode(node);
        return node;
    }

    public void merge(Node other) {
        if (other == null) return;
        
        for (Node child : new ArrayList<>(other.getChildNodes())) {
            childNodes.add(child);
        }
        
        other.getChildNodes().clear();
        
        if (other.entity != null) {
            entities.add(other.entity);
        }
        
        for (Entity e : other.entities) {
            if (!entities.contains(e)) {
                entities.add(e);
            }
        }
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity value) {
        this.entity = value;
        entities.clear();
        if (value != null) {
            entities.add(value);
        }
    }

    public boolean getExcluded() {
        return excluded;
    }

    public void setExcluded(boolean value) {
        this.excluded = value;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public List<CustomObject> getMetaDatas() {
        return metaDatas;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material value) {
        this.material = value;
        materials.clear();
        if (value != null) {
            materials.add(value);
        }
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node value) {
        this.parentNode = value;
    }

    public Transform getTransform() {
        return transform;
    }

    public GlobalTransform getGlobalTransform() {
        if (globalTransform == null) {
            globalTransform = new GlobalTransform();
        }
        return globalTransform;
    }

    public Matrix4 evaluateGlobalTransform(boolean includeGeometricTransform) {
        Matrix4 local = transform.getTransformMatrix();
        if (parentNode != null) {
            Matrix4 parent = parentNode.evaluateGlobalTransform(includeGeometricTransform);
            return Matrix4.mul(parent, local);
        }
        return local;
    }

    public Node getChild(int index) {
        return childNodes.get(index);
    }

    public Node getChild(String name) {
        for (Node child : childNodes) {
            if (name.equals(child.getName())) {
                return child;
            }
        }
        return null;
    }

    public boolean accept(NodeVisitor visitor) {
        if (visitor == null) return true;
        return visitor.visit(this);
    }

    public BoundingBox getBoundingBox() {
        BoundingBox result = new BoundingBox();
        for (Entity e : entities) {
            BoundingBox bb = e.getBoundingBox();
        }
        return result;
    }

    public void addEntity(Entity entity) {
        if (entity != null && !entities.contains(entity)) {
            entities.add(entity);
            entity.setParentNode(this);
            if (this.entity == null) {
                this.entity = entity;
            }
        }
    }

    public void addChildNode(Node node) {
        if (node != null && !childNodes.contains(node)) {
            childNodes.add(node);
            node.setParentNode(this);
        }
    }

    public Object selectSingleObject(String query) throws ParseException {
        return null;
    }

    public ArrayList<Object> selectObjects(String query) throws ParseException {
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Node[" + getName() + "]";
    }

    public void addEntity(Entity entity, Material material) {
        addEntity(entity);
        if (material != null) {
            materials.add(material);
        }
    }
}
