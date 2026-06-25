package com.aspose.threed;

/**
 * A handle for a window for rendering operations.
 */
public class WindowHandle {
    private long handle;

    /**
     * Constructor of WindowHandle.
     * @param handle The native window handle.
     */
    public WindowHandle(long handle) {
        this.handle = handle;
    }

    /**
     * Gets the native window handle.
     * @return the window handle.
     */
    public long getHandle() {
        return handle;
    }

    /**
     * Sets the native window handle.
     * @param value The window handle.
     */
    public void setHandle(long value) {
        this.handle = value;
    }
}
