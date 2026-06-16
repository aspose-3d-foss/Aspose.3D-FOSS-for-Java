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
            // Create a concrete property type based on value type
            add(new ObjectProperty(name, value));
        }
    }

    @Override
    public java.util.Iterator<Property> iterator() {
        return properties.iterator();
    }

    public int size() {
        return properties.size();
    }

    public Property get(int idx) {
        if (idx < 0 || idx >= properties.size()) {
            throw new IndexOutOfBoundsException("Index: " + idx + ", Size: " + properties.size());
        }
        return properties.get(idx);
    }

    /**
     * Concrete property implementation for Object values.
     */
    public static class ObjectProperty extends Property {
        public ObjectProperty(String name) {
            super(name);
        }

        public ObjectProperty(String name, Object value) {
            super(name, value);
        }

        @Override
        public Object getValue() {
            return value;
        }

        @Override
        public void setValue(Object value) {
            this.value = value;
        }
    }
}
