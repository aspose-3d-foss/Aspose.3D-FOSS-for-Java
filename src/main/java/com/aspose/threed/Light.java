package com.aspose.threed;

public class Light extends Entity {
    private Vector3 color;
    private float intensity;
    private float falloffStart;
    private float falloffEnd;
    private float innerAngle;
    private float outerAngle;
    private LightType type;
    private boolean enabled;

    public Light() {
        this(null);
    }

    public Light(String name) {
        super(name != null ? name : "Light");
        this.color = new Vector3(1, 1, 1);
        this.intensity = 1.0f;
        this.falloffStart = 0.0f;
        this.falloffEnd = 0.0f;
        this.innerAngle = 45.0f;
        this.outerAngle = 90.0f;
        this.type = LightType.DIRECTIONAL;
        this.enabled = true;
    }

    public Vector3 getColor() { return color; }
    public void setColor(Vector3 value) { this.color = value; }

    public float getIntensity() { return intensity; }
    public void setIntensity(float value) { this.intensity = value; }

    public float getFalloffStart() { return falloffStart; }
    public void setFalloffStart(float value) { this.falloffStart = value; }

    public float getFalloffEnd() { return falloffEnd; }
    public void setFalloffEnd(float value) { this.falloffEnd = value; }

    public float getInnerAngle() { return innerAngle; }
    public void setInnerAngle(float value) { this.innerAngle = value; }

    public float getOuterAngle() { return outerAngle; }
    public void setOuterAngle(float value) { this.outerAngle = value; }

    public LightType getType() { return type; }
    public void setType(LightType value) { this.type = value; }

    public boolean getEnabled() { return enabled; }
    public void setEnabled(boolean value) { this.enabled = value; }

    @Override
    public BoundingBox getBoundingBox() {
        return new BoundingBox();
    }

    @Override
    public EntityRendererKey getEntityRendererKey() {
        return new EntityRendererKey("Light");
    }
}
