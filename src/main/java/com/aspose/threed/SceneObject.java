package com.aspose.threed;

public abstract class SceneObject extends A3DObject {
    private Scene scene;

    public SceneObject() {
        super();
    }

    public SceneObject(String name) {
        super(name);
    }

    public Scene getScene() {
        return scene;
    }

    protected void setScene(Scene scene) {
        this.scene = scene;
    }
}
