package com.aspose.threed;

public class ColladaSaveOptions extends SaveOptions {
    private boolean indented;
    private ColladaTransformStyle transformStyle;

    public ColladaSaveOptions() {
        super();
        this.indented = false;
        this.transformStyle = ColladaTransformStyle.Components;
    }

    public boolean getIndented() { return indented; }
    public void setIndented(boolean value) { this.indented = value; }

    public ColladaTransformStyle getTransformStyle() { return transformStyle; }
    public void setTransformStyle(ColladaTransformStyle value) { this.transformStyle = value; }
}
