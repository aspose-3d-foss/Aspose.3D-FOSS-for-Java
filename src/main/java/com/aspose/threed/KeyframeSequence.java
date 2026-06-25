package com.aspose.threed;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The sequence of key-frames, it describes the transformation of a sampled value over time.
 */
public class KeyframeSequence extends A3DObject implements Iterable<KeyFrame> {
    private final List<KeyFrame> keyFrames = new ArrayList<KeyFrame>();
    private Extrapolation preBehavior;
    private Extrapolation postBehavior;

    public KeyframeSequence() {
        super();
        this.preBehavior = new Extrapolation();
        this.postBehavior = new Extrapolation();
    }

    public KeyframeSequence(String name) {
        super(name);
        this.preBehavior = new Extrapolation();
        this.postBehavior = new Extrapolation();
    }

    /**
     * Gets the property bind point which owns this curve
     */
    public BindPoint getBindPoint() {
        return null;
    }

    /**
     * Gets the key frames of this curve.
     */
    public List<KeyFrame> getKeyFrames() {
        return keyFrames;
    }

    /**
     * Gets the post behavior indicates what the sampled value should be after the last key frame.
     */
    public Extrapolation getPostBehavior() {
        return postBehavior;
    }

    /**
     * Gets the pre behavior indicates what the sampled value should be before the first key.
     */
    public Extrapolation getPreBehavior() {
        return preBehavior;
    }

    /**
     * Create a new key frame with specified value
     */
    public void add(double time, float value) {
        KeyFrame frame = new KeyFrame(this, (float)time);
        frame.setValue(value);
        keyFrames.add(frame);
    }

    /**
     * Create a new key frame with specified value
     */
    public void add(double time, float value, Interpolation interpolation) {
        KeyFrame frame = new KeyFrame(this, (float)time);
        frame.setValue(value);
        frame.setInterpolation(interpolation);
        keyFrames.add(frame);
    }

    /**
     * Removes all key frames and reset the post/pre behaviors.
     */
    public void reset() {
        keyFrames.clear();
        preBehavior = new Extrapolation();
        postBehavior = new Extrapolation();
    }

    /**
     * Gets the enumerator to traverse all key frames.
     */
    public Iterator<KeyFrame> iterator() {
        return keyFrames.iterator();
    }
}
