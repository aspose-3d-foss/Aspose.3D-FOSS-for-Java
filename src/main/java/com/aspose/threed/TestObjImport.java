package com.aspose.threed;

public class TestObjImport {
    public static void main(String[] args) {
        try {
            System.out.println("Testing OBJ import...");
            String cubePath = args.length > 0 ? args[0] : "../testdata/input/cube.obj";
            Scene scene = Scene.fromFile(cubePath);
            System.out.println("Scene loaded successfully!");
            System.out.println("Root node: " + scene.getRootNode().getName());
            System.out.println("Child nodes: " + scene.getRootNode().getChildNodes().size());
            
            for (Node child : scene.getRootNode().getChildNodes()) {
                Entity entity = child.getEntity();
                if (entity instanceof Mesh) {
                    Mesh mesh = (Mesh) entity;
                    System.out.println("  Mesh: " + mesh.getName());
                    System.out.println("  Vertices: " + mesh.getControlPoints().size());
                    System.out.println("  Polygons: " + mesh.getPolygonCount());
                }
            }
            
            System.out.println("\nTesting OBJ export...");
            String outputPath = args.length > 1 ? args[1] : "../testdata/output/test_export.obj";
            scene.save(outputPath);
            System.out.println("Scene exported successfully to: " + outputPath);
            
            System.out.println("\nTesting OBJ re-import...");
            Scene reimported = Scene.fromFile(outputPath);
            System.out.println("Scene re-imported successfully!");
            
            System.out.println("\nAll tests passed!");
            
        } catch (Exception e) {
            System.err.println("Test failed: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}
