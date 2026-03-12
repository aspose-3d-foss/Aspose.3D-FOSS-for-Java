package com.aspose.threed;

public class GltfSaveOptions extends SaveOptions {
    private boolean flipCoordinateSystem = false;
    private boolean prettyPrint = false;
    private String bufferFilePrefix = "";
    private String saveExtras = null;

    public GltfSaveOptions() {
        super();
    }

    public boolean getFlipCoordinateSystem() {
        return flipCoordinateSystem;
    }

    public void setFlipCoordinateSystem(boolean value) {
        this.flipCoordinateSystem = value;
    }

    public boolean getPrettyPrint() {
        return prettyPrint;
    }

    public void setPrettyPrint(boolean value) {
        this.prettyPrint = value;
    }

    public String getBufferFilePrefix() {
        return bufferFilePrefix;
    }

    public void setBufferFilePrefix(String value) {
        this.bufferFilePrefix = value;
    }

    public String getSaveExtras() {
        return saveExtras;
    }

    public void setSaveExtras(String value) {
        this.saveExtras = value;
    }
}
