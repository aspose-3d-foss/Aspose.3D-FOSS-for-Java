package com.aspose.threed;

import java.util.*;

public class Mesh extends Geometry implements Iterable<int[]> {
    private final List<int[]> polygons = new ArrayList<>();
    private final List<Integer> edges = new ArrayList<>();

    public Mesh() {
        super();
    }

    public Mesh(String name) {
        super(name);
    }

    public void addControlPoint(double x, double y, double z) {
        getControlPoints().add(new Vector4(x, y, z, 1.0));
    }

    public void addControlPoint(double x, double y, double z, double w) {
        getControlPoints().add(new Vector4(x, y, z, w));
    }

    public void createPolygon(int[] indices) {
        createPolygon(indices, 0, indices.length);
    }

    public void createPolygon(int[] indices, int offset, int length) {
        int[] poly = new int[length];
        System.arraycopy(indices, offset, poly, 0, length);
        polygons.add(poly);
    }

    public void createPolygon(int v1, int v2, int v3) {
        createPolygon(new int[]{v1, v2, v3});
    }

    public void createPolygon(int v1, int v2, int v3, int v4) {
        createPolygon(new int[]{v1, v2, v3, v4});
    }

    public int getPolygonCount() {
        return polygons.size();
    }

    public int getPolygonSize(int index) {
        if (index < 0 || index >= polygons.size()) {
            return 0;
        }
        return polygons.get(index).length;
    }

    public List<int[]> getPolygons() {
        return new ArrayList<>(polygons);
    }

    public List<Integer> getEdges() {
        return new ArrayList<>(edges);
    }

    public boolean isManifold() {
        return false;
    }

    @Override
    public Iterator<int[]> iterator() {
        return new ArrayList<>(polygons).iterator();
    }

    public Mesh toMesh() {
        return clone();
    }

    @Override
    public Mesh clone() {
        Mesh mesh = new Mesh(getName());
        mesh.getControlPoints().addAll(getControlPoints());
        mesh.polygons.addAll(polygons);
        for (VertexElement element : getVertexElements()) {
            mesh.addElement(element.clone());
        }
        return mesh;
    }

    public Mesh triangulate() {
        return clone();
    }

    public Mesh optimize(boolean removeVertices) {
        return clone();
    }

    public Mesh optimize(boolean removeVertices, float tolerance) {
        return clone();
    }

    public Mesh optimize(boolean removeVertices, float tolerance, float threshold) {
        return clone();
    }

    public Mesh optimize(boolean removeVertices, float tolerance, float threshold, float angleThreshold) {
        return clone();
    }

    public Mesh optimize2(boolean removeVertices) {
        return clone();
    }

    public static Mesh union(Mesh a, Mesh b) {
        return a.clone();
    }

    public static Mesh difference(Mesh a, Mesh b) {
        return a.clone();
    }

    public static Mesh intersect(Mesh a, Mesh b) {
        return a.clone();
    }

    public static Mesh doBoolean(BooleanOperation operation, Mesh a, Matrix4 ma, Mesh b, Matrix4 mb) {
        return a.clone();
    }
}
