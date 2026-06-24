package com.aspose.threed;

/**
 * Parameterized dish.
 */
public class Dish extends Primitive {
    private double height = 5.0;
    private double radius = 10.0;
    private int widthSegments = 16;
    private int heightSegments = 8;

    /**
     * Height of the dish.
     */
    public double getHeight() {
        return height;
    }

    public void setHeight(double value) {
        this.height = value;
    }

    /**
     * Radius of the dish.
     */
    public double getRadius() {
        return radius;
    }

    public void setRadius(double value) {
        this.radius = value;
    }

    /**
     * Gets the width segments.
     */
    public int getWidthSegments() {
        return widthSegments;
    }

    public void setWidthSegments(int value) {
        this.widthSegments = value;
    }

    /**
     * Gets the height segments.
     */
    public int getHeightSegments() {
        return heightSegments;
    }

    public void setHeightSegments(int value) {
        this.heightSegments = value;
    }

    /**
     * Create a new dish instance with default radius(10) and default height(5).
     */
    public Dish() {
        this("Dish", 10.0, 5.0, 16, 8);
    }

    /**
     * Create a new dish instance with specified radius and height.
     * @param name The name of the dish
     * @param radius The radius of the dish
     * @param height The height of the dish
     * @param widthSegments The width segment of the dish
     * @param heightSegments The height segment of the dish
     */
    public Dish(String name, double radius, double height, int widthSegments, int heightSegments) {
        super(name);
        this.radius = radius;
        this.height = height;
        this.widthSegments = widthSegments;
        this.heightSegments = heightSegments;
    }

    /**
     * Convert current object to mesh.
     */
    @Override
    public Mesh toMesh() {
        Mesh mesh = new Mesh(getName());
        float radius = (float) this.radius;
        float height = (float) this.height;

        // Calculate the angle for the spherical cap
        // The dish height is the sagitta (depth) of the spherical cap
        // We need to calculate the radius of the base and the sphere angle
        // Using the formula: r_base^2 = 2 * R * h - h^2 where r_base is the base radius
        float baseRadius = (float) Math.sqrt(2 * this.radius * this.height - this.height * this.height);

        // We'll generate vertices for the dome surface
        // The dish starts from the base (z = -height/2) to the top (z = height/2)
        // Actually, for a dish, height is typically the sagitta from base to top
        // So vertices go from z=0 (base) to z=height (top)

        for (int lat = 0; lat <= heightSegments; lat++) {
            // Calculate the angle from the top of the sphere
            // lat=0 is at the top (z=height), lat=heightSegments is at the base (z=0)
            double t = (double) lat / heightSegments;

            // Calculate the z coordinate from the top
            double z = height * t;

            // Calculate the radius at this height
            // Using sphere equation: r^2 + (R - z)^2 = R^2
            // r^2 = R^2 - (R - z)^2 = 2*R*z - z^2
            double r = Math.sqrt(2 * this.radius * z - z * z);

            for (int lon = 0; lon <= widthSegments; lon++) {
                double angle = 2 * Math.PI * lon / widthSegments;
                double x = r * Math.cos(angle);
                double y = r * Math.sin(angle);

                mesh.getControlPoints().add(new Vector4(x, y, z, 1));
            }
        }

        // Create polygons connecting the vertices
        for (int lat = 0; lat < heightSegments; lat++) {
            for (int lon = 0; lon < widthSegments; lon++) {
                int first = lat * (widthSegments + 1) + lon;
                int second = first + widthSegments + 1;

                mesh.createPolygon(first, second, second + 1, first + 1);
            }
        }

        return mesh;
    }
}
