package com.aspose.threed;

public class TestCompile {
    public static void main(String[] args) {
        Vector3 v = new Vector3(1, 2, 3);
        Vector3 v2 = new Vector3(4, 5, 6);
        Vector3 v3 = Vector3.add(v, v2);
        System.out.println("Vector3 test: " + v3);
        
        Scene scene = new Scene();
        Node node = scene.getRootNode().createChildNode("Test");
        node.getTransform().setTranslation(10, 20, 30);
        System.out.println("Scene test: " + node);
    }
}
