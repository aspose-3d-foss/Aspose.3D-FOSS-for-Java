package com.aspose.threed;

/**
 * Utility class with mathematical functions.
 */
public class MathUtils {
    /**
     * Calculates the normal vector from three points.
     * @param points Array of at least 3 points.
     * @return The normalized normal vector.
     * @throws IllegalArgumentException if less than 3 points are provided.
     */
    public static Vector3 calcNormal(Vector3[] points) {
        if (points.length < 3) {
            throw new IllegalArgumentException("At least 3 points are required to calculate a normal");
        }

        Vector3 v1 = Vector3.sub(points[1], points[0]);
        Vector3 v2 = Vector3.sub(points[2], points[0]);
        Vector3 normal = v1.cross(v2).normalize();
        return normal;
    }

    /**
     * Finds the intersection of two lines in 2D space.
     * @param p0 First point on line 1.
     * @param d0 Direction vector of line 1.
     * @param p1 First point on line 2.
     * @param d1 Direction vector of line 2.
     * @param results Output array to store intersection point.
     * @return Number of intersection points found (0 or 1).
     */
    public static int findIntersection(Vector2 p0, Vector2 d0, Vector2 p1, Vector2 d1, Vector2[] results) {
        double det = d0.x * d1.y - d0.y * d1.x;
        if (det == 0) {
            return 0;
        }

        Vector2 dp = Vector2.sub(p1, p0);
        double t = (dp.x * d1.y - dp.y * d1.x) / det;
        double u = (dp.x * d0.y - dp.y * d0.x) / det;

        if (results != null && results.length > 0) {
            Vector2 intersection = Vector2.add(p0, Vector2.mul(d0, t));
            results[0] = intersection;
        }

        return 1;
    }

    /**
     * Checks if a point is inside a triangle.
     * @param p Point to check.
     * @param p0 Triangle vertex 0.
     * @param p1 Triangle vertex 1.
     * @param p2 Triangle vertex 2.
     * @return true if the point is inside the triangle.
     */
    public static boolean pointInsideTriangle(Vector2 p, Vector2 p0, Vector2 p1, Vector2 p2) {
        double d1 = sign(p, p0, p1);
        double d2 = sign(p, p1, p2);
        double d3 = sign(p, p2, p0);

        boolean hasNeg = (d1 < 0) || (d2 < 0) || (d3 < 0);
        boolean hasPos = (d1 > 0) || (d2 > 0) || (d3 > 0);

        return !(hasNeg && hasPos);
    }

    private static double sign(Vector2 p1, Vector2 p2, Vector2 p3) {
        return (p1.x - p3.x) * (p2.y - p3.y) - (p2.x - p3.x) * (p1.y - p3.y);
    }

    /**
     * Finds the intersection of a ray and a line segment in 2D space.
     * @param origin Ray origin.
     * @param dir Ray direction.
     * @param a Line segment point A.
     * @param b Line segment point B.
     * @return Intersection point if exists, null otherwise.
     */
    public static Vector2 rayIntersect(Vector2 origin, Vector2 dir, Vector2 a, Vector2 b) {
        Vector2 v1 = Vector2.sub(origin, a);
        Vector2 v2 = Vector2.sub(b, a);
        Vector2 v3 = new Vector2(-dir.y, dir.x);

        double dot = v2.x * v3.x + v2.y * v3.y;
        if (Math.abs(dot) < 0.00001) {
            return null;
        }

        double t1 = (v2.x * v1.y - v2.y * v1.x) / dot;
        double t2 = (v1.x * v3.x + v1.y * v3.y) / dot;

        if (t1 >= 0 && (t2 >= 0 && t2 <= 1)) {
            return Vector2.add(origin, Vector2.mul(dir, t1));
        }

        return null;
    }

    /**
     * Clamps a value between min and max.
     * @param val Value to clamp.
     * @param min Minimum value.
     * @param max Maximum value.
     * @return Clamped value.
     */
    public static double clamp(double val, double min, double max) {
        if (val < min) return min;
        if (val > max) return max;
        return val;
    }

    /**
     * Converts radians to degrees.
     * @param radian Value in radians.
     * @return Value in degrees.
     */
    public static Vector3 toDegree(Vector3 radian) {
        return new Vector3(
            radian.x * 180.0 / Math.PI,
            radian.y * 180.0 / Math.PI,
            radian.z * 180.0 / Math.PI
        );
    }

    /**
     * Converts degrees to radians.
     * @param degree Value in degrees.
     * @return Value in radians.
     */
    public static Vector3 toRadian(Vector3 degree) {
        return new Vector3(
            degree.x * Math.PI / 180.0,
            degree.y * Math.PI / 180.0,
            degree.z * Math.PI / 180.0
        );
    }

    /**
     * Converts radians to degrees.
     * @param radian Value in radians.
     * @return Value in degrees.
     */
    public static double toDegree(double radian) {
        return radian * 180.0 / Math.PI;
    }

    /**
     * Converts degrees to radians.
     * @param degree Value in degrees.
     * @return Value in radians.
     */
    public static double toRadian(double degree) {
        return degree * Math.PI / 180.0;
    }

    /**
     * Converts radians to degrees.
     * @param x X component in radians.
     * @param y Y component in radians.
     * @param z Z component in radians.
     * @return Vector3 in degrees.
     */
    public static Vector3 toDegree(double x, double y, double z) {
        return new Vector3(
            x * 180.0 / Math.PI,
            y * 180.0 / Math.PI,
            z * 180.0 / Math.PI
        );
    }

    /**
     * Converts degrees to radians.
     * @param x X component in degrees.
     * @param y Y component in degrees.
     * @param z Z component in degrees.
     * @return Vector3 in radians.
     */
    public static Vector3 toRadian(double x, double y, double z) {
        return new Vector3(
            x * Math.PI / 180.0,
            y * Math.PI / 180.0,
            z * Math.PI / 180.0
        );
    }
}
