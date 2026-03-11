package com.aspose.threed;

public class TestTrace {
    public static void main(String[] args) {
        try {
            String stlPath = "/home/lexchou/workspace/aspose/foss.3d.java/testdata/input/stl_binary.stl";
            
            Scene scene = Scene.fromFile(stlPath, FileFormat.STL_BINARY);
            
            System.out.println("=== SCENE FROM FILE ===");
            System.out.println("Root: " + scene.getRootNode().getName());
            
            java.util.List<Node> children = scene.getRootNode().getChildNodes();
            System.out.println("Child count: " + children.size());
            
            for (Node child : children) {
                System.out.println("  Child: " + child.getName());
                Entity e = child.getEntity();
                System.out.println("    Entity: " + e.getClass().getName());
                if (e instanceof Mesh) {
                    Mesh mesh = (Mesh) e;
                    System.out.println("    Mesh vertices: " + mesh.getControlPoints().size());
                    System.out.println("    Mesh polygons: " + mesh.getPolygonCount());
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
