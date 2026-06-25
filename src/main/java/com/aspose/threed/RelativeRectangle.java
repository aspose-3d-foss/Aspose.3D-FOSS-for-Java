package com.aspose.threed;

import java.io.Serializable;

/**
 * Relative rectangle
 * The formula between relative component to absolute value is:
 * Scale * (Reference Width) + offset
 * So if we want it to represent an absolute value, leave all scale fields zero, and use offset fields instead.
 */
public final class RelativeRectangle implements Struct<RelativeRectangle>, Serializable {
    private float scaleX = 0;
    private float scaleY = 0;
    private float scaleWidth = 0;
    private float scaleHeight = 0;

    private int offsetX = 0;
    private int offsetY = 0;
    private int offsetWidth = 0;
    private int offsetHeight = 0;

    public RelativeRectangle() {
    }

    public RelativeRectangle(int left, int top, int width, int height) {
        this.scaleX = 0;
        this.scaleY = 0;
        this.scaleWidth = 0;
        this.scaleHeight = 0;
        this.offsetX = left;
        this.offsetY = top;
        this.offsetWidth = width;
        this.offsetHeight = height;
    }

    /**
     * Relative coordinate X
     * @return Relative coordinate X
     */
    public float getScaleX() {
        return scaleX;
    }

    /**
     * Relative coordinate X
     * @param value New value
     */
    public void setScaleX(float value) {
        this.scaleX = value;
    }

    /**
     * Relative coordinate Y
     * @return Relative coordinate Y
     */
    public float getScaleY() {
        return scaleY;
    }

    /**
     * Relative coordinate Y
     * @param value New value
     */
    public void setScaleY(float value) {
        this.scaleY = value;
    }

    /**
     * Relative width
     * @return Relative width
     */
    public float getScaleWidth() {
        return scaleWidth;
    }

    /**
     * Relative width
     * @param value New value
     */
    public void setScaleWidth(float value) {
        this.scaleWidth = value;
    }

    /**
     * Relative height
     * @return Relative height
     */
    public float getScaleHeight() {
        return scaleHeight;
    }

    /**
     * Relative height
     * @param value New value
     */
    public void setScaleHeight(float value) {
        this.scaleHeight = value;
    }

    /**
     * Gets the offset for coordinate X
     * @return the offset for coordinate X
     */
    public int getOffsetX() {
        return offsetX;
    }

    /**
     * Sets the offset for coordinate X
     * @param value New value
     */
    public void setOffsetX(int value) {
        this.offsetX = value;
    }

    /**
     * Gets the offset for coordinate Y
     * @return the offset for coordinate Y
     */
    public int getOffsetY() {
        return offsetY;
    }

    /**
     * Sets the offset for coordinate Y
     * @param value New value
     */
    public void setOffsetY(int value) {
        this.offsetY = value;
    }

    /**
     * Gets the offset for width
     * @return the offset for width
     */
    public int getOffsetWidth() {
        return offsetWidth;
    }

    /**
     * Sets the offset for width
     * @param value New value
     */
    public void setOffsetWidth(int value) {
        this.offsetWidth = value;
    }

    /**
     * Gets the offset for height
     * @return the offset for height
     */
    public int getOffsetHeight() {
        return offsetHeight;
    }

    /**
     * Sets the offset for height
     * @param value New value
     */
    public void setOffsetHeight(int value) {
        this.offsetHeight = value;
    }

    /**
     * Convert the relative rectangle to absolute rectangle
     * @param left Left of the rectangle
     * @param top Top of the rectangle
     * @param width Width of the rectangle
     * @param height Height of the rectangle
     * @return Absolute rectangle
     */
    public Rect toAbsolute(int left, int top, int width, int height) {
        int absX = (int)(scaleX * width) + offsetX;
        int absY = (int)(scaleY * height) + offsetY;
        int absWidth = (int)(scaleWidth * width) + offsetWidth;
        int absHeight = (int)(scaleHeight * height) + offsetHeight;
        return new Rect(absX, absY, absWidth, absHeight);
    }

    /**
     * Construct a RelativeRectangle with all offset fields zero and scale fields from given parameters.
     * @param scaleX Scale X
     * @param scaleY Scale Y
     * @param scaleWidth Scale width
     * @param scaleHeight Scale height
     * @return RelativeRectangle instance
     */
    public static RelativeRectangle fromScale(float scaleX, float scaleY, float scaleWidth, float scaleHeight) {
        RelativeRectangle rect = new RelativeRectangle(0, 0, 0, 0);
        rect.setScaleX(scaleX);
        rect.setScaleY(scaleY);
        rect.setScaleWidth(scaleWidth);
        rect.setScaleHeight(scaleHeight);
        return rect;
    }

    @Override
    public String toString() {
        return String.format("Scale: (%f, %f, %f, %f), Offset: (%d, %d, %d, %d)", 
            scaleX, scaleY, scaleWidth, scaleHeight, offsetX, offsetY, offsetWidth, offsetHeight);
    }

    @Override
    public RelativeRectangle clone() {
        try {
            RelativeRectangle copy = new RelativeRectangle();
            copy.scaleX = this.scaleX;
            copy.scaleY = this.scaleY;
            copy.scaleWidth = this.scaleWidth;
            copy.scaleHeight = this.scaleHeight;
            copy.offsetX = this.offsetX;
            copy.offsetY = this.offsetY;
            copy.offsetWidth = this.offsetWidth;
            copy.offsetHeight = this.offsetHeight;
            return copy;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void copyFrom(RelativeRectangle src) {
        this.scaleX = src.scaleX;
        this.scaleY = src.scaleY;
        this.scaleWidth = src.scaleWidth;
        this.scaleHeight = src.scaleHeight;
        this.offsetX = src.offsetX;
        this.offsetY = src.offsetY;
        this.offsetWidth = src.offsetWidth;
        this.offsetHeight = src.offsetHeight;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(scaleX);
        result = prime * result + Float.floatToIntBits(scaleY);
        result = prime * result + Float.floatToIntBits(scaleWidth);
        result = prime * result + Float.floatToIntBits(scaleHeight);
        result = prime * result + offsetX;
        result = prime * result + offsetY;
        result = prime * result + offsetWidth;
        result = prime * result + offsetHeight;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        RelativeRectangle other = (RelativeRectangle) obj;
        return Float.floatToIntBits(scaleX) == Float.floatToIntBits(other.scaleX) &&                Float.floatToIntBits(scaleY) == Float.floatToIntBits(other.scaleY) &&
                Float.floatToIntBits(scaleWidth) == Float.floatToIntBits(other.scaleWidth) &&
                Float.floatToIntBits(scaleHeight) == Float.floatToIntBits(other.scaleHeight) &&
                offsetX == other.offsetX &&
                offsetY == other.offsetY &&
                offsetWidth == other.offsetWidth &&
                offsetHeight == other.offsetHeight;
    }
}