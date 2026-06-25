package com.aspose.threed;

/**
 * The stage of the render pipeline.
 */
public class RenderStage {
    /**
     * The default render stage.
     */
    public static final RenderStage DEFAULT = new RenderStage("Default");
    
    /**
     * The shadow map render stage.
     */
    public static final RenderStage SHADOW_MAP = new RenderStage("ShadowMap");
    
    /**
     * The pre-operations render stage.
     */
    public static final RenderStage PRE_OPERATIONS = new RenderStage("PreOperations");
    
    /**
     * The background render stage.
     */
    public static final RenderStage BACKGROUND = new RenderStage("Background");
    
    /**
     * The geometry render stage.
     */
    public static final RenderStage GEOMETRY = new RenderStage("Geometry");
    
    /**
     * The transparent render stage.
     */
    public static final RenderStage TRANSPARENT = new RenderStage("Transparent");
    
    /**
     * The overlay render stage.
     */
    public static final RenderStage OVERLAY = new RenderStage("Overlay");
    
    /**
     * The post-operations render stage.
     */
    public static final RenderStage POST_OPERATIONS = new RenderStage("PostOperations");
    
    private String name;
    
    /**
     * Constructor of RenderStage.
     * @param name The name of the stage.
     */
    public RenderStage(String name) {
        this.name = name;
    }
    
    /**
     * Gets the name of the stage.
     * @return the stage name.
     */
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
