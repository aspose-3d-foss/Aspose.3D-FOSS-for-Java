package com.aspose.threed;

/**
 * Event callback interface for handling events with arguments.
 */
public interface EventCallback<EventArg> {
    /**
     * Called when the event is raised.
     * @param sender The sender of the event
     * @param arg The event argument
     */
    void call(Object sender, EventArg arg);
}
