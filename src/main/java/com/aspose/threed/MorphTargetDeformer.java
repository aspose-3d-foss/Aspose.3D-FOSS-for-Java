package com.aspose.threed;

import java.util.ArrayList;
import java.util.List;

/**
 * MorphTargetDeformer provides per-vertex animation.
 * MorphTargetDeformer organize all targets via channels, each channel can organize multiple targets.
 * A common use of morph target deformer is to apply facial expression to a character.
 * More details can be found at https://en.wikipedia.org/wiki/Morph_target_animation
 */
public class MorphTargetDeformer extends Deformer {
    private List<MorphTargetChannel> channels;

    /**
     * Initializes a new instance of the MorphTargetDeformer class.
     */
    public MorphTargetDeformer() {
        this("MorphTargetDeformer");
    }

    /**
     * Initializes a new instance of the MorphTargetDeformer class.
     * @param name Name.
     */
    public MorphTargetDeformer(String name) {
        super(name);
        channels = new ArrayList<MorphTargetChannel>();
    }

    /**
     * Gets or sets the weight at the specified index.
     * @param index Index of the weight.
     * @return The weight.
     */
    public double get(int index) {
        if (index >= channels.size()) {
            return 0.0;
        }
        return channels.get(index).getChannelWeight();
    }

    /**
     * Sets the weight at the specified index.
     * @param index Index of the weight.
     * @param value New value.
     */
    public void set(int index, double value) {
        while (channels.size() <= index) {
            channels.add(new MorphTargetChannel());
        }
        channels.get(index).setChannelWeight(value);
    }

    /**
     * Gets all channels contained in this deformer.
     * @return the list of channels.
     */
    public List<MorphTargetChannel> getChannels() {
        return channels;
    }
}
