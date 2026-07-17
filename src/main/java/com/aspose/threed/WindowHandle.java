package com.aspose.threed;

public class WindowHandle {
    public static WindowHandle fromWayland(long display, long surface) {
        return new WindowHandle();
    }

    public static WindowHandle fromXlib(long display, long window) {
        return new WindowHandle();
    }

    public static WindowHandle fromWin32(long window) {
        return new WindowHandle();
    }
}
