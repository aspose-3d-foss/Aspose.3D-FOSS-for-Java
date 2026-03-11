package com.aspose.threed;

public class TestStlImport {
    public static void main(String[] args) {
        try {
            String stlPath = args.length > 0 ? args[0] : "../testdata/input/stl_binary.stl";
            System.out.println("Testing STL binary import...");
            Scene scene = Scene.fromFile(stlPath);
            System.out.println("Scene loaded successfully!");
            System.out.println("Root node: " + scene.getRootNode().getName());
            
            for (Node child : scene.getRootNode().getChildNodes()) {
                Entity entity = child.getEntity();
                if (entity instanceof Mesh) {
                    Mesh mesh = (Mesh) entity;
                    System.out.println("  Mesh: " + mesh.getName());
                    System.out.println("  Vertices: " + mesh.getControlPoints().size());
                    System.out.println("  Polygons: " + mesh.getPolygonCount());
                }
            }
            
            System.out.println("\nTesting STL export (binary)...");
            String outputPath = args.length > 1 ? args[1] : "../testdata/output/stl_export.stl";
            scene.save(outputPath);
            System.out.println("Scene exported successfully to: " + outputPath);
            
            java.io.File f = new java.io.File(outputPath);
            System.out.println("File size: " + f.length() + " bytes");
            
            System.out.println("\nTesting STL re-import...");
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
