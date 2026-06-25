package com.aspose.threed;

import java.io.Serializable;

/**
 * A class to represent the rectangle
 */
public final class Rect implements Struct<Rect>, Serializable {
    private int x;
    private int y;
    private int width;
    private int height;

    public Rect() {
    }

    public Rect(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Gets the x of the size
     * @return the x of the size
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the x of the size
     * @param value New value
     */
    public void setX(int value) {
        this.x = value;
    }

    /**
     * Gets the y of the size
     * @return the y of the size
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the y of the size
     * @param value New value
     */
    public void setY(int value) {
        this.y = value;
    }

    /**
     * Gets the width of the size
     * @return the width of the size
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets the width of the size
     * @param value New value
     */
    public void setWidth(int value) {
        this.width = value;
    }

    /**
     * Gets the height of the size
     * @return the height of the size
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets the height of the size
     * @param value New value
     */
    public void setHeight(int value) {
        this.height = value;
    }

    /**
     * Gets the left of the rectangle
     * @return the left of the rectangle
     */
    public int getLeft() {
        return x;
    }

    /**
     * Gets the right of the rectangle
     * @return the right of the rectangle
     */
    public int getRight() {
        return x + width;
    }

    /**
     * Gets the top of the rectangle
     * @return the top of the rectangle
     */
    public int getTop() {
        return y;
    }

    /**
     * Gets the bottom of the rectangle
     * @return the bottom of the rectangle
     */
    public int getBottom() {
        return y + height;
    }

    /**
     * Return true if the given point is inside the rectangle.
     * @param x X coordinate
     * @param y Y coordinate
     * @return true if point is inside the rectangle
     */
    public boolean contains(int x, int y) {
        return x >= this.x && x < this.x + this.width &&
               y >= this.y && y < this.y + this.height;
    }

    /**
     * Clone current instance
     * @return cloned instance
     */
    @Override
    public Rect clone() {
        Rect copy = new Rect();
        copy.x = this.x;
        copy.y = this.y;
        copy.width = this.width;
        copy.height = this.height;
        return copy;
    }

    /**
     * Description copied from interface: Struct
     * @param src source instance to copy
     */
    @Override
    public void copyFrom(Rect src) {
        this.x = src.x;
        this.y = src.y;
        this.width = src.width;
        this.height = src.height;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        result = prime * result + width;
        result = prime * result + height;
        return result;
    }
     @Override
     public boolean equals(Object obj) {
         if (this == obj) return true;
         if (obj == null) return false;
         if (getClass() != obj.getClass()) return false;
         Rect other = (Rect) obj;
         return x == other.x &&
                y == other.y &&
                width == other.width &&
                height == other.height;
     }
}