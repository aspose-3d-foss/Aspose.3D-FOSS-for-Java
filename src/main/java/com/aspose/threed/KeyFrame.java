package com.aspose.threed;

import java.io.Serializable;

public class KeyFrame implements Serializable {
    private float time;
    private Vector4 value;
    private Interpolation interpolation;
    private Vector3 tangentIn;
    private Vector3 tangentOut;
    private WeightedMode tangentWeightMode;
    private StepMode stepMode;

    public KeyFrame() {
        this.time = 0.0f;
        this.value = new Vector4(0, 0, 0, 0);
        this.interpolation = Interpolation.LINEAR;
        this.tangentIn = new Vector3(0, 0, 0);
        this.tangentOut = new Vector3(0, 0, 0);
        this.tangentWeightMode = WeightedMode.NONE;
        this.stepMode = StepMode.NONE;
    }

    public KeyFrame(float time, Vector4 value) {
        this.time = time;
        this.value = value;
        this.interpolation = Interpolation.LINEAR;
        this.tangentIn = new Vector3(0, 0, 0);
        this.tangentOut = new Vector3(0, 0, 0);
        this.tangentWeightMode = WeightedMode.NONE;
        this.stepMode = StepMode.NONE;
    }

    public float getTime() { return time; }
    public void setTime(float value) { this.time = value; }

    public Vector4 getValue() { return value; }
    public void setValue(Vector4 value) { this.value = value; }

    public Interpolation getInterpolation() { return interpolation; }
    public void setInterpolation(Interpolation value) { this.interpolation = value; }

    public Vector3 getTangentIn() { return tangentIn; }
    public void setTangentIn(Vector3 value) { this.tangentIn = value; }

    public Vector3 getTangentOut() { return tangentOut; }
    public void setTangentOut(Vector3 value) { this.tangentOut = value; }

    public WeightedMode getTangentWeightMode() { return tangentWeightMode; }
    public void setTangentWeightMode(WeightedMode value) { this.tangentWeightMode = value; }

    public StepMode getStepMode() { return stepMode; }
    public void setStepMode(StepMode value) { this.stepMode = value; }
}
