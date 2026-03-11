package com.aspose.threed;

import java.util.ArrayList;
import java.util.List;

public class PropertyCollection implements Iterable<Property> {
    private final List<Property> properties = new ArrayList<>();

    public void add(Property property) {
        properties.add(property);
    }

    public void remove(Property property) {
        properties.remove(property);
    }

    public Property findProperty(String name) {
        for (Property p : properties) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    public Object get(String name) {
        Property p = findProperty(name);
        return p != null ? p.getValue() : null;
    }

    public void set(String name, Object value) {
        Property p = findProperty(name);
        if (p != null) {
            p.setValue(value);
        } else {
            add(new Property(name, value));
        }
    }

    @Override
    public java.util.Iterator<Property> iterator() {
        return properties.iterator();
    }

    public int size() {
        return properties.size();
    }
}
