package com.aspose.threed;

public class A3DObject implements INamedObject {
    private String name;
    private final PropertyCollection properties = new PropertyCollection();

    public A3DObject() {
        this.name = "";
    }

    public A3DObject(String name) {
        this.name = name != null ? name : "";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name != null ? name : "";
    }

    public PropertyCollection getProperties() {
        return properties;
    }

    public Property findProperty(String name) {
        return properties.findProperty(name);
    }

    public Object getProperty(String name) {
        return properties.get(name);
    }

    public void setProperty(String name, Object value) {
        properties.set(name, value);
    }

    public boolean removeProperty(String name) {
        Property p = findProperty(name);
        if (p != null) {
            properties.remove(p);
            return true;
        }
        return false;
    }

    public boolean removeProperty(Property property) {
        if (property == null) {
            throw new IllegalArgumentException("property");
        }
        boolean found = findProperty(property.getName()) != null;
        if (found) {
            properties.remove(property);
        }
        return found;
    }
}
