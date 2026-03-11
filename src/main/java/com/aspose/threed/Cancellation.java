package com.aspose.threed;

public class Cancellation {
    private boolean cancelled = false;

    public Cancellation() {
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void cancel() {
        this.cancelled = true;
    }
}
