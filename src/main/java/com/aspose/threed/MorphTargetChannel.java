package com.aspose.threed;

import java.util.ArrayList;
import java.util.List;

/**
 * A MorphTargetChannel is used by MorphTargetDeformer to organize the target geometries.
 * Some file formats like FBX support multiple channels in parallel.
 */
public class MorphTargetChannel extends A3DObject {
    private List<Double> weights;
    private double channelWeight;
    private List<Shape> targets;

    /**
     * Initializes a new instance of the MorphTargetChannel class.
     */
    public MorphTargetChannel() {
        this("MorphTargetChannel");
    }

    /**
     * Initializes a new instance of the MorphTargetChannel class.
     * @param name Name.
     */
    public MorphTargetChannel(String name) {
        super(name);
        weights = new ArrayList<Double>();
        targets = new ArrayList<Shape>();
    }

    /**
     * Gets the full weight values of target geometries.
     * @return the list of weights.
     */
    public List<Double> getWeights() {
        return weights;
    }

    /**
     * Gets or sets the deformer weight of this channel.
     * The weight is between 0.0 and 1.0
     * @return the channel weight.
     */
    public double getChannelWeight() {
        return channelWeight;
    }

    /**
     * Gets or sets the deformer weight of this channel.
     * @param value New value.
     */
    public void setChannelWeight(double value) {
        this.channelWeight = value;
    }

    /**
     * Gets all targets associated with the channel.
     * @return the list of targets.
     */
    public List<Shape> getTargets() {
        return targets;
    }

    /**
     * Gets the weight for the specified target, if the target is not belongs to this channel, default value 0 is returned.
     * @param target The target shape.
     * @return the weight for the target.
     */
    public double getWeight(Shape target) {
        int index = targets.indexOf(target);
        if (index < 0 || index >= weights.size()) {
            return 0.0;
        }
        return weights.get(index);
    }

    /**
     * Sets the weight for the specified target, default value is 1, range should between 0~1.
     * @param target The target shape.
     * @param weight New weight.
     */
    public void setWeight(Shape target, double weight) {
        int index = targets.indexOf(target);
        if (index < 0) {
            targets.add(target);
            weights.add(weight);
        } else {
            weights.set(index, weight);
        }
    }

    /**
     * Gets the weight for the specified target index.
     * @param index Index of the target.
     * @return the weight for the target.
     */
    public double get(int index) {
        if (index < 0 || index >= weights.size()) {
            return 0.0;
        }
        return weights.get(index);
    }

    /**
     * Sets the weight for the specified target index.
     * @param index Index of the target.
     * @param value New weight.
     */
    public void set(int index, double value) {
        while (weights.size() <= index) {
            weights.add(0.0);
        }
        weights.set(index, value);
    }

    /**
     * Default weight for morph target.
     */
    public static final double DefaultWeight = 1.0;
}
