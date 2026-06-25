package com.aspose.threed;

/**
 * A render target interface for rendering operations.
 */
public interface IRenderTarget extends java.io.Closeable {
    /**
     * Creates a viewport with the specified camera, position, and size.
     * @param camera The camera for the viewport.
     * @param position The position of the viewport.
     * @param size The size of the viewport.
     * @return The created viewport.
     */
    Viewport createViewport(Camera camera, Vector3 position, RelativeRectangle size);
    
    /**
     * Creates a viewport with the specified camera and size.
     * @param camera The camera for the viewport.
     * @param size The size of the viewport.
     * @return The created viewport.
     */
    Viewport createViewport(Camera camera, RelativeRectangle size);
    
    /**
     * Creates a viewport with the specified camera.
     * @param camera The camera for the viewport.
     * @return The created viewport.
     */
    Viewport createViewport(Camera camera);
    
    /**
     * Gets the size of the render target.
     * @return the size as a Vector2.
     */
    Vector2 getSize();
    
    /**
     * Sets the size of the render target.
     * @param value The new size.
     */
    void setSize(Vector2 value);
    
    /**
     * Gets all viewports in this render target.
     * @return the list of viewports.
     */
    java.util.List<Viewport> getViewports();
}
