package com.aspose.threed;

import java.util.ArrayList;
import java.util.List;

public class ImageRenderOptions extends SaveOptions {
    private Vector3 backgroundColor = new Vector3();
    private List<String> assetDirectories = new ArrayList<String>();
    private boolean enableShadows;
    private String name = "";

    public ImageRenderOptions() {
        super();
    }

    public Vector3 getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Vector3 value) {
        this.backgroundColor = value;
    }

    public List<String> getAssetDirectories() {
        return assetDirectories;
    }

    public boolean isEnableShadows() {
        return enableShadows;
    }

    public void setEnableShadows(boolean value) {
        this.enableShadows = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }
}
