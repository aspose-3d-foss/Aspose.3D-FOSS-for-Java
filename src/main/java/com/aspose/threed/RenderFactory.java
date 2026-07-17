package com.aspose.threed;

public abstract class RenderFactory {
    protected RenderFactory() {
    }

    public abstract IRenderTexture createRenderTexture(RenderParameters parameters, int targets, int width, int height);

    public abstract IRenderTexture createRenderTexture(RenderParameters parameters, int width, int height);

    public abstract IDescriptorSet createDescriptorSet(ShaderProgram shader);

    public abstract IRenderTexture createCubeRenderTexture(RenderParameters parameters, int width, int height);

    public abstract IRenderWindow createRenderWindow(RenderParameters parameters, WindowHandle handle);

    public abstract IVertexBuffer createVertexBuffer(VertexDeclaration declaration);

    public abstract IIndexBuffer createIndexBuffer();

    public abstract ITextureUnit createTextureUnit(TextureType type);

    public ITextureUnit createTextureUnit() {
        throw new UnsupportedOperationException("createTextureUnit is not supported in FOSS");
    }

    public abstract ShaderProgram createShaderProgram(ShaderSource shader);

    public abstract IPipeline createPipeline(ShaderProgram shader, RenderState state, VertexDeclaration declaration, DrawOperation drawOperation);

    public abstract IBuffer createUniformBuffer(int size);
}
