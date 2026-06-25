package com.aspose.threed;

/**
 * A render factory for creating rendering resources.
 */
public abstract class RenderFactory {
    /**
     * Constructor of RenderFactory.
     */
    public RenderFactory() {
    }

    /**
     * Creates a render texture with the specified parameters and dimensions.
     * @param params The render parameters.
     * @param width The width of the texture.
     * @param height The height of the texture.
     * @param renderTargetCount The number of render targets.
     * @return The created render texture.
     */
    public abstract IRenderTexture createRenderTexture(RenderParameters params, int width, int height, int renderTargetCount);

    /**
     * Creates a render texture with the specified parameters and dimensions.
     * @param params The render parameters.
     * @param width The width of the texture.
     * @param height The height of the texture.
     * @return The created render texture.
     */
    public abstract IRenderTexture createRenderTexture(RenderParameters params, int width, int height);

    /**
     * Creates a cube render texture with the specified parameters and dimensions.
     * @param params The render parameters.
     * @param width The width of each face.
     * @param height The height of each face.
     * @return The created cube render texture.
     */
    public abstract IRenderTexture createCubeRenderTexture(RenderParameters params, int width, int height);

    /**
     * Creates a render window with the specified parameters and window handle.
     * @param params The render parameters.
     * @param windowHandle The window handle.
     * @return The created render window.
     */
    public abstract IRenderWindow createRenderWindow(RenderParameters params, WindowHandle windowHandle);

    /**
     * Creates a vertex buffer with the specified vertex declaration.
     * @param vertexDeclaration The vertex declaration.
     * @return The created vertex buffer.
     */
    public abstract IVertexBuffer createVertexBuffer(VertexDeclaration vertexDeclaration);

    /**
     * Creates an index buffer.
     * @return The created index buffer.
     */
    public abstract IIndexBuffer createIndexBuffer();

    /**
     * Creates a texture unit with the specified texture type.
     * @param textureType The texture type.
     * @return The created texture unit.
     */
    public abstract ITextureUnit createTextureUnit(TextureType textureType);

    /**
     * Creates a texture unit with default texture type.
     * @return The created texture unit.
     */
    public ITextureUnit createTextureUnit() {
        return createTextureUnit(TextureType.TEXTURE2D);
    }

    /**
     * Creates a shader program with the specified shader source.
     * @param source The shader source.
     * @return The created shader program.
     */
    public abstract ShaderProgram createShaderProgram(ShaderSource source);

    /**
     * Creates a uniform buffer with the specified size.
     * @param size The size in bytes.
     * @return The created uniform buffer.
     */
    public abstract IBuffer createUniformBuffer(int size);
}
