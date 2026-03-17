package com.aspose.threed;

import java.util.ArrayList;

public class ImageRenderOptions extends A3DObject {
    private Vector3 backgroundColor;
    private ArrayList<String> assetDirectories;
    private boolean enableShadows;

    public ImageRenderOptions() {
        this.backgroundColor = new Vector3(0, 0, 0);
        this.assetDirectories = new ArrayList<>();
        this.enableShadows = false;
    }

    public Vector3 getBackgroundColor() { return backgroundColor; }
    public void setBackgroundColor(Vector3 value) { this.backgroundColor = value; }

    public ArrayList<String> getAssetDirectories() { return assetDirectories; }
    public void setAssetDirectories(ArrayList<String> value) { this.assetDirectories = value; }

    public boolean getEnableShadows() { return enableShadows; }
    public void setEnableShadows(boolean value) { this.enableShadows = value; }
}
