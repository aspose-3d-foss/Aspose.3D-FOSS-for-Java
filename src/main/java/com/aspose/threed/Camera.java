package com.aspose.threed;

public class Camera extends Frustum implements IOrientable {
    private ProjectionType projectionType = ProjectionType.PERSPECTIVE;
    private double fieldOfView = 45.0;
    private double fieldOfViewX = 45.0;
    private double fieldOfViewY = 45.0;
    private double width = 1.0;
    private double height = 1.0;
    private double aspectRatio = 1.0;
    private Vector2 magnification = new Vector2(1, 1);
    private ApertureMode apertureMode = ApertureMode.HORIZ_AND_VERT;
     public Camera() {
         super("Camera");
     }

     public Camera(String name) {
         super(name);
     }

     public ApertureMode getApertureMode() {        return apertureMode;
    }

    public void setApertureMode(ApertureMode value) {
        this.apertureMode = value;
    }

    public double getFieldOfView() {
        return fieldOfView;
    }

    public void setFieldOfView(double value) {
        this.fieldOfView = value;
    }

    public double getFieldOfViewX() {
        return fieldOfViewX;
    }

    public void setFieldOfViewX(double value) {
        this.fieldOfViewX = value;
    }

    public double getFieldOfViewY() {
        return fieldOfViewY;
    }

    public void setFieldOfViewY(double value) {
        this.fieldOfViewY = value;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double value) {
        this.width = value;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double value) {
        this.height = value;
    }

    public double getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(double value) {
        this.aspectRatio = value;
    }

    public Vector2 getMagnification() {
        return magnification;
    }

    public void setMagnification(Vector2 value) {
        this.magnification = value;
    }

    public ProjectionType getProjectionType() {
        return projectionType;
    }

    public void setProjectionType(ProjectionType value) {
        this.projectionType = value;
         }

     /**
      * Move camera forward
      * @param distance The distance to move forward
      */
     public void moveForward(double distance) {
         // TODO: Implement moveForward
         throw new UnsupportedOperationException("moveForward is not implemented in FOSS");
     }
}
