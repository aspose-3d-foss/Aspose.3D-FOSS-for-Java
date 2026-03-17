package com.aspose.threed;

import java.io.Serializable;

public class KeyframeSequence implements Serializable {
    private String name;
    private float startTime;
    private float endTime;
    private boolean loop;
    private Extrapolation preExtrapolation;
    private Extrapolation postExtrapolation;

    public KeyframeSequence() {
        this.name = "";
        this.startTime = 0.0f;
        this.endTime = 0.0f;
        this.loop = false;
        this.preExtrapolation = Extrapolation.NONE;
        this.postExtrapolation = Extrapolation.NONE;
    }

    public KeyframeSequence(String name) {
        this.name = name;
        this.startTime = 0.0f;
        this.endTime = 0.0f;
        this.loop = false;
        this.preExtrapolation = Extrapolation.NONE;
        this.postExtrapolation = Extrapolation.NONE;
    }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public float getStartTime() { return startTime; }
    public void setStartTime(float value) { this.startTime = value; }

    public float getEndTime() { return endTime; }
    public void setEndTime(float value) { this.endTime = value; }

    public boolean getLoop() { return loop; }
    public void setLoop(boolean value) { this.loop = value; }

    public Extrapolation getPreExtrapolation() { return preExtrapolation; }
    public void setPreExtrapolation(Extrapolation value) { this.preExtrapolation = value; }

    public Extrapolation getPostExtrapolation() { return postExtrapolation; }
    public void setPostExtrapolation(Extrapolation value) { this.postExtrapolation = value; }
}
