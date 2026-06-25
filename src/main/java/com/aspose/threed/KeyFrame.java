package com.aspose.threed;

import java.io.Serializable;

public class KeyFrame implements Serializable {
    private float time;
    private float value;
    private Interpolation interpolation;
    private int tangentWeightMode;
    private StepMode stepMode;
    private Vector2 nextInTangent;
    private Vector2 outTangent;
    private float outWeight;
    private float nextInWeight;
    private float tension;
    private float continuity;
    private float bias;
    private boolean independentTangent;
    private boolean flat;
    private boolean timeIndependentTangent;

    public KeyFrame(KeyframeSequence curve, float time) {
        this.time = time;
        this.value = 0.0f;
        this.interpolation = Interpolation.LINEAR;
        this.tangentWeightMode = WeightedMode.NONE;
        this.stepMode = StepMode.PREVIOUS_VALUE;
        this.nextInTangent = new Vector2(0, 0);
        this.outTangent = new Vector2(0, 0);
        this.outWeight = 0.0f;
        this.nextInWeight = 0.0f;
        this.tension = 0.0f;
        this.continuity = 0.0f;
        this.bias = 0.0f;
        this.independentTangent = false;
        this.flat = false;
        this.timeIndependentTangent = false;
    }

    public KeyFrame() {
        this.time = 0.0f;
        this.value = 0.0f;
        this.interpolation = Interpolation.LINEAR;
        this.tangentWeightMode = WeightedMode.NONE;
        this.stepMode = StepMode.PREVIOUS_VALUE;
        this.nextInTangent = new Vector2(0, 0);
        this.outTangent = new Vector2(0, 0);
        this.outWeight = 0.0f;
        this.nextInWeight = 0.0f;
        this.tension = 0.0f;
        this.continuity = 0.0f;
        this.bias = 0.0f;
        this.independentTangent = false;
        this.flat = false;
        this.timeIndependentTangent = false;
    }

    public float getTime() { return time; }
    public void setTime(float value) { this.time = value; }

    public float getValue() { return value; }
    public void setValue(float value) { this.value = value; }

    public Interpolation getInterpolation() { return interpolation; }
    public void setInterpolation(Interpolation value) { this.interpolation = value; }

    public int getTangentWeightMode() { return tangentWeightMode; }
    public void setTangentWeightMode(int value) { this.tangentWeightMode = value; }

    public StepMode getStepMode() { return stepMode; }
    public void setStepMode(StepMode value) { this.stepMode = value; }

    public Vector2 getNextInTangent() { return nextInTangent; }
    public void setNextInTangent(Vector2 value) { this.nextInTangent = value; }

    public Vector2 getOutTangent() { return outTangent; }
    public void setOutTangent(Vector2 value) { this.outTangent = value; }

    public float getOutWeight() { return outWeight; }
    public void setOutWeight(float value) { this.outWeight = value; }

    public float getNextInWeight() { return nextInWeight; }
    public void setNextInWeight(float value) { this.nextInWeight = value; }

    public float getTension() { return tension; }
    public void setTension(float value) { this.tension = value; }

    public float getContinuity() { return continuity; }
    public void setContinuity(float value) { this.continuity = value; }

    public float getBias() { return bias; }
    public void setBias(float value) { this.bias = value; }

    public boolean getIndependentTangent() { return independentTangent; }
    public void setIndependentTangent(boolean value) { this.independentTangent = value; }

    public boolean getFlat() { return flat; }
    public void setFlat(boolean value) { this.flat = value; }

    public boolean getTimeIndependentTangent() { return timeIndependentTangent; }
    public void setTimeIndependentTangent(boolean value) { this.timeIndependentTangent = value; }
}
