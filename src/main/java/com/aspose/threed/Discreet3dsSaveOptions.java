package com.aspose.threed;

/**
 * Save options for 3DS file.
 */
public class Discreet3dsSaveOptions extends SaveOptions {
    private boolean exportLight = true;
    private boolean exportCamera = true;
    private String duplicatedNameSeparator = "_";
    private int duplicatedNameCounterBase = 2;
    private String duplicatedNameCounterFormat = "";
    private double masterScale = 1.0;
    private boolean gammaCorrectedColor = false;
    private boolean flipCoordinateSystem = false;
    private boolean highPreciseColor = false;

    /**
     * Constructor of Discreet3dsSaveOptions.
     */
    public Discreet3dsSaveOptions() {
    }

    /**
     * Gets whether export all lights in the scene.
     * @return true if export lights.
     */
    public boolean getExportLight() {
        return exportLight;
    }

    /**
     * Sets whether export all lights in the scene.
     * @param value New value.
     */
    public void setExportLight(boolean value) {
        this.exportLight = value;
    }

    /**
     * Gets whether export all cameras in the scene.
     * @return true if export cameras.
     */
    public boolean getExportCamera() {
        return exportCamera;
    }

    /**
     * Sets whether export all cameras in the scene.
     * @param value New value.
     */
    public void setExportCamera(boolean value) {
        this.exportCamera = value;
    }

    /**
     * The separator between object's name and the duplicated counter, default value is "_".
     * @return The separator between object's name and the duplicated counter.
     */
    public String getDuplicatedNameSeparator() {
        return duplicatedNameSeparator;
    }

    /**
     * The separator between object's name and the duplicated counter, default value is "_".
     * @param value New value.
     */
    public void setDuplicatedNameSeparator(String value) {
        this.duplicatedNameSeparator = value;
    }

    /**
     * The counter used by generating new name for duplicated names, default value is 2.
     * @return The counter used by generating new name for duplicated names.
     */
    public int getDuplicatedNameCounterBase() {
        return duplicatedNameCounterBase;
    }

    /**
     * The counter used by generating new name for duplicated names, default value is 2.
     * @param value New value.
     */
    public void setDuplicatedNameCounterBase(int value) {
        this.duplicatedNameCounterBase = value;
    }

    /**
     * The format of the duplicated counter, default value is empty string.
     * @return The format of the duplicated counter.
     */
    public String getDuplicatedNameCounterFormat() {
        return duplicatedNameCounterFormat;
    }

    /**
     * The format of the duplicated counter, default value is empty string.
     * @param value New value.
     */
    public void setDuplicatedNameCounterFormat(String value) {
        this.duplicatedNameCounterFormat = value;
    }

    /**
     * Gets the master scale used in exporting.
     * @return The master scale used in exporting.
     */
    public double getMasterScale() {
        return masterScale;
    }

    /**
     * Sets the master scale used in exporting.
     * @param value New value.
     */
    public void setMasterScale(double value) {
        this.masterScale = value;
    }

    /**
     * A 3ds file may contains original color and gamma corrected color for same attribute,
     * Setting this to true will use the gamma corrected color if possible,
     * otherwise the Aspose.3D will try to use the original color.
     * @return true if use gamma corrected color.
     */
    public boolean getGammaCorrectedColor() {
        return gammaCorrectedColor;
    }

    /**
     * A 3ds file may contains original color and gamma corrected color for same attribute,
     * Setting this to true will use the gamma corrected color if possible,
     * otherwise the Aspose.3D will try to use the original color.
     * @param value New value.
     */
    public void setGammaCorrectedColor(boolean value) {
        this.gammaCorrectedColor = value;
    }

    /**
     * Gets flip coordinate system of control points/normal during importing/exporting.
     * @return true if flip coordinate system.
     */
    public boolean getFlipCoordinateSystem() {
        return flipCoordinateSystem;
    }

    /**
     * Sets flip coordinate system of control points/normal during importing/exporting.
     * @param value New value.
     */
    public void setFlipCoordinateSystem(boolean value) {
        this.flipCoordinateSystem = value;
    }

    /**
     * If this is true, the generated 3ds file will use high precise color, means each channel of red/green/blue are in 32bit float.
     * Otherwise the generated file will use 24bit color, each channel use 8bit byte.
     * The default value is false, because not all applications supports the high-precise color.
     * @return true if use high precise color.
     */
    public boolean getHighPreciseColor() {
        return highPreciseColor;
    }

    /**
     * If this is true, the generated 3ds file will use high precise color, means each channel of red/green/blue are in 32bit float.
     * Otherwise the generated file will use 24bit color, each channel use 8bit byte.
     * The default value is false, because not all applications supports the high-precise color.
     * @param value New value.
     */
    public void setHighPreciseColor(boolean value) {
        this.highPreciseColor = value;
    }
}
