package com.aspose.threed;

public class DrawOperation {
    public static final DrawOperation POINTS = new DrawOperation();
    public static final DrawOperation LINES = new DrawOperation();
    public static final DrawOperation LINE_STRIP = new DrawOperation();
    public static final DrawOperation TRIANGLES = new DrawOperation();
    public static final DrawOperation TRIANGLE_STRIP = new DrawOperation();
    public static final DrawOperation TRIANGLE_FAN = new DrawOperation();

    private DrawOperation() {
    }

    public static DrawOperation valueOf(String name) {
        switch (name) {
            case "POINTS":
                return POINTS;
            case "LINES":
                return LINES;
            case "LINE_STRIP":
                return LINE_STRIP;
            case "TRIANGLES":
                return TRIANGLES;
            case "TRIANGLE_STRIP":
                return TRIANGLE_STRIP;
            case "TRIANGLE_FAN":
                return TRIANGLE_FAN;
            default:
                throw new IllegalArgumentException("Invalid DrawOperation: " + name);
        }
    }

    public static DrawOperation[] values() {
        return new DrawOperation[] { POINTS, LINES, LINE_STRIP, TRIANGLES, TRIANGLE_STRIP, TRIANGLE_FAN };
    }
}
