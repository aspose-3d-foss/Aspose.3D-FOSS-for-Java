# API Diff: Java FOSS vs On-Premise 26.1.0

This diff shows the differences between the current Java FOSS implementation and the Aspose.3D for Java On-Premise version 26.1.0.

## Summary

- **Added types:** 82 new types
- **Removed types:** 14 types
- **Changed types:** Many types with API signature updates

---

## Added Types

### Core Types
- com.aspose.threed.A3dwSaveOptions
- com.aspose.threed.AmfSaveOptions
- com.aspose.threed.ApertureMode
- com.aspose.threed.ArbitraryProfile
- com.aspose.threed.BlendFactor
- com.aspose.threed.Bone
- com.aspose.threed.BoneLinkMode
- com.aspose.threed.BooleanOperand
- com.aspose.threed.BooleanOperator
- com.aspose.threed.CenterLineProfile
- com.aspose.threed.CircleShape
- com.aspose.threed.CompareFunction
- com.aspose.threed.ComposeOrder
- com.aspose.threed.CryptoUtils
- com.aspose.threed.CShape
- com.aspose.threed.CubeFace
- com.aspose.threed.CubeFaceData<T>
- com.aspose.threed.CullFaceMode
- com.aspose.threed.DescriptorSetUpdater
- com.aspose.threed.Discreet3dsLoadOptions
- com.aspose.threed.Discreet3dsSaveOptions
- com.aspose.threed.DracoCompressionLevel
- com.aspose.threed.DracoFormat
- com.aspose.threed.DracoSaveOptions
- com.aspose.threed.DrawOperation
- com.aspose.threed.DriverException
- com.aspose.threed.EllipseShape
- com.aspose.threed.EndPoint
- com.aspose.threed.EntityRenderer
- com.aspose.threed.Enumerable<T>
- com.aspose.threed.Enumerator<T>
- com.aspose.threed.EventCallback<EventArg>
- com.aspose.threed.FileStream
- com.aspose.threed.FileSystemFactory
- com.aspose.threed.FontFile
- com.aspose.threed.FrontFace
- com.aspose.threed.Frustum
- com.aspose.threed.GLSLSource
- com.aspose.threed.GltfEmbeddedImageFormat
- com.aspose.threed.HalfSpace
- com.aspose.threed.HollowCircleShape
- com.aspose.threed.HollowRectangleShape
- com.aspose.threed.HShape
- com.aspose.threed.Html5SaveOptions
- com.aspose.threed.IBuffer
- com.aspose.threed.ICommandList
- com.aspose.threed.IDescriptorSet
- com.aspose.threed.IIndexBuffer
- com.aspose.threed.IIndexedVertexElement
- com.aspose.threed.IndexDataType
- com.aspose.threed.InitializationException
- com.aspose.threed.Int2D
- com.aspose.threed.IOrientable
- com.aspose.threed.IPipeline
- com.aspose.threed.IRenderQueue
- com.aspose.threed.IRenderTarget
- com.aspose.threed.IRenderTexture
- com.aspose.threed.IRenderWindow
- com.aspose.threed.ITexture1D
- com.aspose.threed.ITexture2D
- com.aspose.threed.ITextureCodec
- com.aspose.threed.ITextureCubemap
- com.aspose.threed.ITextureDecoder
- com.aspose.threed.ITextureEncoder
- com.aspose.threed.ITextureUnit
- com.aspose.threed.IVertexBuffer
- com.aspose.threed.JavaXImageCodec
- com.aspose.threed.JtLoadOptions
- com.aspose.threed.LinearExtrusion
- com.aspose.threed.LShape
- com.aspose.threed.MaterialConverter
- com.aspose.threed.MathUtils
- com.aspose.threed.MemoryStream
- com.aspose.threed.Microsoft3MFFormat
- com.aspose.threed.MirroredProfile
- com.aspose.threed.MorphTargetChannel
- com.aspose.threed.MorphTargetDeformer
- com.aspose.threed.MulticastEvent<EventArg>
- com.aspose.threed.NotImplementedException
- com.aspose.threed.NurbsDirection
- com.aspose.threed.NurbsSurface
- com.aspose.threed.ParameterizedProfile
- com.aspose.threed.Patch
- com.aspose.threed.PatchDirection
- com.aspose.threed.PatchDirectionType
- com.aspose.threed.PbrSpecularMaterial
- com.aspose.threed.PdfFormat
- com.aspose.threed.PdfLightingScheme
- com.aspose.threed.PdfLoadOptions
- com.aspose.threed.PdfRenderMode
- com.aspose.threed.PdfSaveOptions
- com.aspose.threed.PixelFormat
- com.aspose.threed.PixelMapMode
- com.aspose.threed.PixelMapping
- com.aspose.threed.PlyFormat
- com.aspose.threed.PointCloud
- com.aspose.threed.PolygonBuilder
- com.aspose.threed.PostProcessing
- com.aspose.threed.PresetShaders
- com.aspose.threed.ProjectionType
- com.aspose.threed.PushConstant
- com.aspose.threed.Rect
- com.aspose.threed.RectangleShape
- com.aspose.threed.RelativeRectangle
- com.aspose.threed.Renderer
- com.aspose.threed.RendererException
- com.aspose.threed.RendererVariableManager
- com.aspose.threed.RenderFactory
- com.aspose.threed.RenderParameters
- com.aspose.threed.RenderQueueGroupId
- com.aspose.threed.RenderResource
- com.aspose.threed.RenderStage
- com.aspose.threed.RenderState
- com.aspose.threed.RotationMode
- com.aspose.threed.RotationOrder
- com.aspose.threed.RvmFormat
- com.aspose.threed.RvmLoadOptions
- com.aspose.threed.RvmSaveOptions
- com.aspose.threed.ShaderException
- com.aspose.threed.ShaderMaterial
- com.aspose.threed.ShaderProgram
- com.aspose.threed.ShaderSet
- com.aspose.threed.ShaderSource
- com.aspose.threed.ShaderStage
- com.aspose.threed.ShaderTechnique
- com.aspose.threed.ShaderVariable
- com.aspose.threed.Skeleton
- com.aspose.threed.SkeletonType
- com.aspose.threed.SkinDeformer
- com.aspose.threed.SPIRVSource
- com.aspose.threed.SplitMeshPolicy
- com.aspose.threed.StencilAction
- com.aspose.threed.StencilState
- com.aspose.threed.Structs
- com.aspose.threed.StructuralMetadata
- com.aspose.threed.SweptAreaSolid
- com.aspose.threed.Text
- com.aspose.threed.TextureCodec
- com.aspose.threed.TextureType
- com.aspose.threed.TransformBuilder
- com.aspose.threed.TransformedCurve
- com.aspose.threed.TrapeziumShape
- com.aspose.threed.TriMesh
- com.aspose.threed.TrimmedCurve
- com.aspose.threed.TShape
- com.aspose.threed.U3dLoadOptions
- com.aspose.threed.U3dSaveOptions
- com.aspose.threed.UsdSaveOptions
- com.aspose.threed.UShape
- com.aspose.threed.Vertex
- com.aspose.threed.VertexElementDoublesTemplate
- com.aspose.threed.VertexElementEdgeCrease
- com.aspose.threed.VertexElementFVector
- com.aspose.threed.VertexElementHole
- com.aspose.threed.VertexElementIntsTemplate
- com.aspose.threed.VertexElementPolygonGroup
- com.aspose.threed.VertexElementSmoothingGroup
- com.aspose.threed.VertexElementSpecular
- com.aspose.threed.VertexElementTemplate<T>
- com.aspose.threed.VertexElementUserData
- com.aspose.threed.VertexElementVector4
- com.aspose.threed.VertexElementVertexCrease
- com.aspose.threed.VertexElementVisibility
- com.aspose.threed.VertexElementWeight
- com.aspose.threed.Viewport
- com.aspose.threed.Watermark
- com.aspose.threed.WindowHandle
- com.aspose.threed.XLoadOptions
- com.aspose.threed.ZShape

---

## Removed Types

- com.aspose.threed.formats.FbxExporter
- com.aspose.threed.formats.FbxImporter
- com.aspose.threed.formats.GltfExporter
- com.aspose.threed.formats.GltfImporter
- com.aspose.threed.formats.ObjExporter
- com.aspose.threed.formats.ObjImporter
- com.aspose.threed.formats.StlExporter
- com.aspose.threed.formats.StlImporter
- com.aspose.threed.IExporter
- com.aspose.threed.IImporter
- com.aspose.threed.PropertyFlags

---

## Changed Types

### com.aspose.threed.AlphaSource
**Added:**
- `+ static final AlphaSource FIXED_VALUE`
- `+ static final AlphaSource NONE`
- `+ static final AlphaSource PIXEL_ALPHA`

**Removed:**
- `- static final AlphaSource FixedValue`
- `- static final AlphaSource None`
- `- static final AlphaSource PixelAlpha`

### com.aspose.threed.AnimationChannel
**Added:**
- `+ Class<?> getComponentType()`
- `+ KeyframeSequence getKeyframeSequence()`
- `+ Object getDefaultValue()`
- `+ void setDefaultValue(Object)`
- `+ void setKeyframeSequence(KeyframeSequence)`

**Removed:**
- `- AnimationChannel()`

### com.aspose.threed.AnimationClip
**Added:**
- `+ AnimationNode createAnimationNode(String)`
- `+ double getStart()`
- `+ double getStop()`
- `+ List<AnimationNode> getAnimations()`
- `+ String getDescription()`
- `+ void setDescription(String)`
- `+ void setStart(double)`
- `+ void setStop(double)`

### com.aspose.threed.AnimationNode
**Added:**
- `+ AnimationNode(String)`
- `+ BindPoint createBindPoint(A3DObject, String)`
- `+ BindPoint findBindPoint(A3DObject, String)`
- `+ BindPoint getBindPoint(A3DObject, String, boolean)`
- `+ KeyframeSequence getKeyframeSequence(A3DObject, String, boolean)`
- `+ KeyframeSequence getKeyframeSequence(A3DObject, String, String, boolean)`
- `+ List<AnimationNode> getSubAnimations()`
- `+ List<BindPoint> getBindPoints()`

### com.aspose.threed.AssetInfo
**Added:**
- `+ Axis getFrontVector()`
- `+ Axis getUpVector()`
- `+ AxisSystem getAxisSystem()`
- `+ CoordinateSystem getCoordinateSystem()`
- `+ Vector4 getAmbient()`
- `+ Calendar getCreationTime()`
- `+ Calendar getModificationTime()`
- `+ String getApplicationVendor()`
- `+ String getComment()`
- `+ String getUrl()`
- `+ void setAmbient(Vector4)`
- `+ void setApplicationVendor(String)`
- `+ void setAxisSystem(AxisSystem)`
- `+ void setComment(String)`
- `+ void setCoordinateSystem(CoordinateSystem)`
- `+ void setCreationTime(Calendar)`
- `+ void setFrontVector(Axis)`
- `+ void setModificationTime(Calendar)`
- `+ void setUpVector(Axis)`
- `+ void setUrl(String)`

**Removed:**
- `- String getComments()`
- `- String getCreationDate()`
- `- void setComments(String)`
- `- void setCreationDate(String)`

### com.aspose.threed.BindPoint
**Added:**
- `+ boolean addChannel(String, Class<?>, Object)`
- `+ boolean addChannel(String, Object)`
- `+ AnimationChannel get(String)`
- `+ AnimationChannel getChannel(String)`
- `+ KeyframeSequence createKeyframeSequence(String)`
- `+ KeyframeSequence getKeyframeSequence(String)`
- `+ Property getProperty()`
- `+ int getChannelsCount()`
- `+ String toString()`
- `+ void bindKeyframeSequence(String, KeyframeSequence)`
- `+ void resetChannels()`
- `+ void setProperty(Property)`

**Removed:**
- `- static BindPoint valueOf(String)`
- `- static BindPoint[] values()`
- `- static final BindPoint Center`
- `- static final BindPoint GeometryCenter`
- `- static final BindPoint Origin`
- `- static final BindPoint Pivot`

### com.aspose.threed.BooleanOperation
**Added:**
- `+ static final BooleanOperation ADD`
- `+ static final BooleanOperation INTERSECT`
- `+ static final BooleanOperation SUB`

**Removed:**
- `- static final BooleanOperation DIFFERENCE`
- `- static final BooleanOperation INTERSECTION`
- `- static final BooleanOperation UNION`

### com.aspose.threed.BoundingBox
**Added:**
- `+ final boolean contains(BoundingBox)`
- `+ final boolean contains(Vector3)`
- `+ final boolean equals(Object)`
- `+ final boolean overlapsWith(BoundingBox)`
- `+ final BoundingBox clone()`
- `+ final BoundingBoxExtent getExtent()`
- `+ final Vector3 getCenter()`
- `+ final Vector3 getMaximum()`
- `+ final Vector3 getMinimum()`
- `+ final Vector3 getSize()`
- `+ final double scale()`
- `+ final int hashCode()`
- `+ final Object clone()`
- `+ final String toString()`
- `+ final void copyFrom(BoundingBox)`
- `+ final void copyFrom(Object)`
- `+ final void merge(BoundingBox)`
- `+ final void merge(FVector3)`
- `+ final void merge(Vector3)`
- `+ final void merge(Vector4)`
- `+ final void merge(double, double, double)`
- `+ static BoundingBox fromGeometry(Geometry)`
- `+ static BoundingBox getInfinite()`
- `+ static BoundingBox getNull()`
- `+ static BoundingBox mul(BoundingBox, Matrix4)`

**Removed:**
- `- boolean contains(BoundingBox)`
- `- boolean contains(Vector3)`
- `- boolean equals(Object)`
- `- boolean overlapsWith(BoundingBox)`
- `- BoundingBoxExtent getExtent()`
- `- Vector3 getCenter()`
- `- Vector3 getMaximum()`
- `- Vector3 getMinimum()`
- `- Vector3 getSize()`
- `- double scale()`
- `- int hashCode()`
- `- static final BoundingBox INFINITE`
- `- static final BoundingBox NULL`
- `- String toString()`
- `- void merge(BoundingBox)`
- `- void merge(FVector3)`
- `- void merge(Vector3)`
- `- void merge(Vector4)`
- `- void merge(double, double, double)`

### com.aspose.threed.BoundingBox2D
**Added:**
- `+ final boolean equals(Object)`
- `+ final BoundingBox2D clone()`
- `+ final BoundingBoxExtent getExtent()`
- `+ final Vector2 getMaximum()`
- `+ final Vector2 getMinimum()`
- `+ final int hashCode()`
- `+ final Object clone()`
- `+ final String toString()`
- `+ final void copyFrom(BoundingBox2D)`
- `+ final void copyFrom(Object)`
- `+ final void merge(BoundingBox2D)`
- `+ final void merge(Vector2)`

**Removed:**
- `- BoundingBox2D(Vector2, Vector2)`
- `- BoundingBoxExtent getExtent()`
- `- Vector2 getMaximum()`
- `- Vector2 getMinimum()`
- `- String toString()`
- `- void merge(BoundingBox2D)`
- `- void merge(Vector2)`

### com.aspose.threed.BoundingBoxExtent
**Added:**
- `+ static final BoundingBoxExtent FINITE`
- `+ static final BoundingBoxExtent INFINITE`
- `+ static final BoundingBoxExtent NULL`

**Removed:**
- `- static final BoundingBoxExtent Finite`
- `- static final BoundingBoxExtent Infinite`
- `- static final BoundingBoxExtent Null`
### com.aspose.threed.Box
**Removed:**
- `+ Box(String, double, double, double, int, int, int)`

### com.aspose.threed.Camera
**Added:**
- `+ ApertureMode getApertureMode()`
- `+ ProjectionType getProjectionType()`
- `+ Vector2 getMagnification()`
- `+ double getAspectRatio()`
- `+ double getFieldOfView()`
- `+ double getFieldOfViewX()`
- `+ double getFieldOfViewY()`
- `+ double getHeight()`
- `+ double getWidth()`
- `+ void moveForward(double)`
- `+ void setApertureMode(ApertureMode)`
- `+ void setAspectRatio(double)`
- `+ void setFieldOfView(double)`
- `+ void setFieldOfViewX(double)`
- `+ void setFieldOfViewY(double)`
- `+ void setHeight(double)`
- `+ void setMagnification(Vector2)`
- `+ void setProjectionType(ProjectionType)`
- `+ void setWidth(double)`

### com.aspose.threed.Cancellation
**Removed:**
- `- boolean isCancelled()`

### com.aspose.threed.ColladaTransformStyle
**Added:**
- `+ static final ColladaTransformStyle COMPONENTS`
- `+ static final ColladaTransformStyle MATRIX`

**Removed:**
- `- static final ColladaTransformStyle Components`
- `- static final ColladaTransformStyle Matrix`

### com.aspose.threed.CompositeCurve
**Added:**
- `+ ArrayList<CompositeCurve$Segment> getSegments()`

**Removed:**
- `- CompositeCurve(String)`
- `- List<CompositeCurve$Segment> getSegments()`

### com.aspose.threed.Curve
**Added:**
- `+ EntityRendererKey getEntityRendererKey()`

### com.aspose.threed.Cylinder
**Removed:**
- `- Cylinder(double, double, double)`
- `- Cylinder(double, double)`
- `- Cylinder(String, double, double, double, int, int, boolean, double, double)`

### com.aspose.threed.Deformer
**Added:**
- `+ Geometry getOwner()`

**Removed:**
- `- Deformer()`

### com.aspose.threed.Entity
**Removed:**
- `- Entity()`

### com.aspose.threed.EntityRendererKey
**Added:**
- `+ final String toString()`

**Removed:**
- `- String toString()`

### com.aspose.threed.ExportException
**Removed:**
- `- ExportException(String, Throwable)`

### com.aspose.threed.Extrapolation
**Added:**
- `+ ExtrapolationType getType()`
- `+ int getRepeatCount()`
- `+ void setRepeatCount(int)`
- `+ void setType(ExtrapolationType)`

**Removed:**
- `- static Extrapolation valueOf(String)`
- `- static Extrapolation[] values()`
- `- static final Extrapolation CONSTANT`
- `- static final Extrapolation CYCLE`
- `- static final Extrapolation CYCLE_OFFSET`
- `- static final Extrapolation NONE`
- `- static final Extrapolation PERIODIC`

### com.aspose.threed.ExtrapolationType
**Added:**
- `+ static final ExtrapolationType CONSTANT`
- `+ static final ExtrapolationType CYCLE`
- `+ static final ExtrapolationType CYCLE_RELATIVE`
- `+ static final ExtrapolationType GRADIENT`
- `+ static final ExtrapolationType OSCILLATE`

**Removed:**
- `- static final ExtrapolationType POST_CONSTANT`
- `- static final ExtrapolationType POST_CYCLE`
- `- static final ExtrapolationType POST_CYCLE_OFFSET`
- `- static final ExtrapolationType POST_PERIODIC`
- `- static final ExtrapolationType POST_SYMMETRICAL`
- `- static final ExtrapolationType PRE_CONSTANT`
- `- static final ExtrapolationType PRE_CYCLE`
- `- static final ExtrapolationType PRE_CYCLE_OFFSET`
- `- static final ExtrapolationType PRE_PERIODIC`
- `- static final ExtrapolationType PRE_SYMMETRICAL`

### com.aspose.threed.FbxLoadOptions
**Added:**
- `+ boolean getCompatibleMode()`
- `+ boolean getKeepBuiltinGlobalSettings()`
- `+ FbxLoadOptions(FileFormat)`
- `+ void setCompatibleMode(boolean)`
- `+ void setKeepBuiltinGlobalSettings(boolean)`

**Removed:**
- `- boolean getFlipCoordinateSystem()`
- `- void setFlipCoordinateSystem(boolean)`

### com.aspose.threed.FbxSaveOptions
**Added:**
- `+ boolean getEmbedTextures()`
- `+ boolean getEnableCompression()`
- `+ boolean getExportLegacyMaterialProperties()`
- `+ Boolean getFoldRepeatedCurveData()`
- `+ boolean getGenerateVertexElementMaterial()`
- `+ boolean getReusePrimitiveMesh()`
- `+ boolean getVideoForTexture()`
- `+ FbxSaveOptions(FileFormat)`
- `+ void setEmbedTextures(boolean)`
- `+ void setEnableCompression(boolean)`
- `+ void setExportLegacyMaterialProperties(boolean)`
- `+ void setFoldRepeatedCurveData(Boolean)`
- `+ void setGenerateVertexElementMaterial(boolean)`
- `+ void setReusePrimitiveMesh(boolean)`
- `+ void setVideoForTexture(boolean)`

**Removed:**
- `- boolean getFlipCoordinateSystem()`
- `- FbxSaveOptions()`
- `- void setFlipCoordinateSystem(boolean)`

### com.aspose.threed.FileFormat
**Removed:**
- `- boolean canDetect(Stream, String)`
- `- IExporter getExporter()`
- `- IImporter getImporter()`
- `- ObjLoadOptions createObjLoadOptions()`
- `- ObjSaveOptions createObjSaveOptions()`
- `- static void registerFormat(FileFormat)`

### com.aspose.threed.FileSystem
**Added:**
- `+ abstract Stream readFile(String, IOConfig)`
- `+ abstract Stream writeFile(String, IOConfig)`
- `+ static FileSystem createDummyFileSystem()`
- `+ static FileSystem createLocalFileSystem(String)`
- `+ static FileSystem createMemoryFileSystem()`
- `+ static FileSystem createMemoryFileSystem(HashMap<String,>)`
- `+ static FileSystem createZipFileSystem(Stream, String)`
- `+ static FileSystem createZipFileSystem(Stream)`
- `+ static FileSystem createZipFileSystem(String)`### com.aspose.threed.FileSystem
**Removed:**
- `- abstract InputStream readFile(String, IOConfig)`
- `- abstract OutputStream writeFile(String, IOConfig)`
- `- static FileSystem$DummyFileSystem createDummyFileSystem()`
- `- static FileSystem$LocalFileSystem createLocalFileSystem(String)`
- `- static FileSystem$MemoryFileSystem createMemoryFileSystem(Map<String,>)`
- `- static FileSystem$ZipFileSystem createZipFileSystem(InputStream, String)`
- `- static FileSystem$ZipFileSystem createZipFileSystem(String)`

### com.aspose.threed.FMatrix4
**Added:**
- `+ final boolean equals(Object)`
- `+ final FMatrix4 clone()`
- `+ final FMatrix4 concatenate(FMatrix4)`
- `+ final FMatrix4 concatenate(Matrix4)`
- `+ final FMatrix4 inverse()`
- `+ final FMatrix4 transpose()`
- `+ final int hashCode()`
- `+ final Object clone()`
- `+ final void copyFrom(FMatrix4)`
- `+ final void copyFrom(Object)`
- `+ static FMatrix4 mul(FMatrix4, FMatrix4)`

**Removed:**
- `- boolean equals(Object)`
- `- FMatrix4 concatenate(FMatrix4)`
- `- FMatrix4 inverse()`
- `- FMatrix4 mul(FMatrix4)`
- `- FMatrix4 transpose()`
- `- int hashCode()`
- `- static boolean op_eq(FMatrix4, FMatrix4)`
- `- static boolean op_ne(FMatrix4, FMatrix4)`

### com.aspose.threed.FVector2
**Added:**
- `+ final boolean equals(FVector2)`
- `+ final boolean equals(Object)`
- `+ final FVector2 clone()`
- `+ final int compareTo(FVector2)`
- `+ final int compareTo(Object)`
- `+ final int hashCode()`
- `+ final Object clone()`
- `+ final String toString()`
- `+ final void copyFrom(FVector2)`
- `+ final void copyFrom(Object)`
- `+ static Vector2 create(FVector2)`

**Removed:**
- `- boolean equals(FVector2)`
- `- boolean equals(Object)`
- `- int compareTo(FVector2)`
- `- int compareTo(Object)`
- `- int hashCode()`
- `- static Vector2 op_explicit(FVector2)`
- `- String toString()`

### com.aspose.threed.FVector3
**Added:**
- `+ FVector3(FVector2, float)`
- `+ FVector3(FVector4)`
- `+ FVector3(Vector3)`
- `+ FVector3(Vector4)`
- `+ final boolean equals(Object)`
- `+ final FVector3 clone()`
- `+ final FVector3 cross(FVector3)`
- `+ final FVector3 normalize()`
- `+ final float get(int)`
- `+ final int compareTo(FVector3)`
- `+ final int compareTo(Object)`
- `+ final int hashCode()`
- `+ final Object clone()`
- `+ final String toString()`
- `+ final void copyFrom(FVector3)`
- `+ final void copyFrom(Object)`
- `+ final void set(int, float)`
- `+ static FVector3 add(FVector3, FVector3)`
- `+ static FVector3 div(FVector3, float)`
- `+ static FVector3 getOne()`
- `+ static FVector3 getUnitX()`
- `+ static FVector3 getUnitY()`
- `+ static FVector3 getUnitZ()`
- `+ static FVector3 getZero()`
- `+ static FVector3 mul(FVector3, float)`
- `+ static FVector3 mul(float, FVector3)`
- `+ static FVector3 negative(FVector3)`
- `+ static FVector3 parse(String)`
- `+ static FVector3 sub(FVector3, FVector3)`
- `+ static Vector3 create(FVector3)`

### com.aspose.threed.FVector4
**Added:**
- `+ FVector4(FVector3, float)`
- `+ FVector4(Vector3, float)`
- `+ FVector4(Vector3)`
- `+ final boolean equals(Object)`
- `+ final FVector4 clone()`
- `+ final int compareTo(FVector4)`
- `+ final int compareTo(Object)`
- `+ final int hashCode()`
- `+ final Object clone()`
- `+ final String toString()`
- `+ final void copyFrom(FVector4)`
- `+ final void copyFrom(Object)`
- `+ static FVector4 add(FVector4, FVector4)`
- `+ static FVector4 mul(FVector4, FVector4)`
- `+ static FVector4 mul(FVector4, float)`
- `+ static FVector4 mul(float, FVector4)`
- `+ static FVector4 sub(FVector4, FVector4)`
- `+ static Vector4 create(FVector4)`

### com.aspose.threed.Geometry
**Removed:**
- `- Geometry()`

### com.aspose.threed.GlobalTransform
**Removed:**
- `- GlobalTransform()`
- `- GlobalTransform(Matrix4)`

### com.aspose.threed.GltfLoadOptions
**Added:**
- `+ boolean getFlipTexCoordV()`
- `+ void setFlipTexCoordV(boolean)`

**Removed:**
- `- boolean getFlipCoordinateSystem()`
- `- boolean getPrettyPrint()`
- `- void setFlipCoordinateSystem(boolean)`
- `- void setPrettyPrint(boolean)`

### com.aspose.threed.GltfSaveOptions
**Added:**
- `+ boolean getApplyUnitScale()`
- `+ boolean getDracoCompression()`
- `+ boolean getEmbedAssets()`
- `+ boolean getFlipTexCoordV()`
- `+ boolean getSaveExtras()`
- `+ boolean getUseCommonMaterials()`
- `+ GltfEmbeddedImageFormat getImageFormat()`
- `+ GltfSaveOptions(FileContentType)`
- `+ GltfSaveOptions(FileFormat)`
- `+ MaterialConverter getMaterialConverter()`
- `+ Vector3 getFallbackNormal()`
- `+ String getBufferFile()`
- `+ String getExternalDracoEncoder()`
- `+ void setApplyUnitScale(boolean)`
- `+ void setBufferFile(String)`
- `+ void setDracoCompression(boolean)`
- `+ void setEmbedAssets(boolean)`
- `+ void setExternalDracoEncoder(String)`
- `+ void setFallbackNormal(Vector3)`
- `+ void setFlipTexCoordV(boolean)`
- `+ void setImageFormat(GltfEmbeddedImageFormat)`
- `+ void setMaterialConverter(MaterialConverter)`
- `+ void setSaveExtras(boolean)`
- `+ void setUseCommonMaterials(boolean)`

**Removed:**
- `- boolean getFlipCoordinateSystem()`
- `- FileContentType getContentType()`
- `- GltfSaveOptions()`
- `- String getBufferFilePrefix()`
- `- String getSaveExtras()`
- `- void setBufferFilePrefix(String)`
- `- void setContentType(FileContentType)`
- `- void setFlipCoordinateSystem(boolean)`
- `- void setSaveExtras(String)`

### com.aspose.threed.Group
**Added:**
- `+ Group getParent()`
- `+ List<Group> getGroups()`
- `+ List<Node> getNodes()`
- `+ String toString()`

**Removed:**
- `- BoundingBox getBoundingBox()`
- `- EntityRendererKey getEntityRendererKey()`

### com.aspose.threed.ImportException
**Removed:**
- `- ImportException(String, Throwable)`

### com.aspose.threed.INamedObject
**Removed:**
- `- abstract void setName(String)`

### com.aspose.threed.IOConfig
**Added:**
- `+ FileFormat getFileFormat()`
- `+ FileSystem getFileSystem()`
- `+ Charset getEncoding()`
- `+ ArrayList<String> getLookupPaths()`
- `+ static FileSystemFactory getFileSystemFactory()`
- `+ static void setFileSystemFactory(FileSystemFactory)`
### com.aspose.threed.Camera
**Added:**
- `+ ApertureMode getApertureMode()`
- `+ ProjectionType getProjectionType()`
- `+ Vector2 getMagnification()`
- `+ double getAspectRatio()`
- `+ double getFieldOfView()`
- `+ double getFieldOfViewX()`
- `+ double getFieldOfViewY()`
- `+ double getHeight()`
- `+ double getWidth()`
- `+ void moveForward(double)`
- `+ void setApertureMode(ApertureMode)`
- `+ void setAspectRatio(double)`
- `+ void setFieldOfView(double)`
- `+ void setFieldOfViewX(double)`
- `+ void setFieldOfViewY(double)`
- `+ void setHeight(double)`
- `+ void setMagnification(Vector2)`
- `+ void setProjectionType(ProjectionType)`
- `+ void setWidth(double)`

### com.aspose.threed.Cancellation
**Removed:**
- `- boolean isCancelled()`

### com.aspose.threed.ColladaTransformStyle
**Added:**
- `+ static final ColladaTransformStyle COMPONENTS`
- `+ static final ColladaTransformStyle MATRIX`

**Removed:**
- `- static final ColladaTransformStyle Components`
- `- static final ColladaTransformStyle Matrix`

### com.aspose.threed.CompositeCurve
**Added:**
- `+ ArrayList<CompositeCurve$Segment> getSegments()`

**Removed:**
- `- CompositeCurve(String)`
- `- List<CompositeCurve$Segment> getSegments()`

### com.aspose.threed.Curve
**Added:**
- `+ EntityRendererKey getEntityRendererKey()`

### com.aspose.threed.Cylinder
**Removed:**
- `- Cylinder(double, double, double)`
- `- Cylinder(double, double)`
- `- Cylinder(String, double, double, double, int, int, boolean, double, double)`

### com.aspose.threed.Deformer
**Added:**
- `+ Geometry getOwner()`

**Removed:**
- `- Deformer()`

### com.aspose.threed.Entity
**Removed:**
- `- Entity()`

### com.aspose.threed.EntityRendererKey
**Added:**
- `+ final String toString()`

**Removed:**
- `- String toString()`

### com.aspose.threed.ExportException
**Removed:**
- `- ExportException(String, Throwable)`

### com.aspose.threed.Extrapolation
**Added:**
- `+ ExtrapolationType getType()`
-