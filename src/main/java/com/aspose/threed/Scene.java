package com.aspose.threed;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Scene extends SceneObject {
    public static final String VERSION = "26.1.0";

    private final Node rootNode;
    private AssetInfo assetInfo;
    private final List<Scene> subScenes = new ArrayList<>();
    private final List<A3DObject> library = new ArrayList<>();
    private final List<AnimationClip> animationClips = new ArrayList<>();
    private AnimationClip currentAnimationClip;
    private final Collection<Pose> poses = new ArrayList<>();

    public Scene() {
        super();
        this.rootNode = new Node("RootNode");
        this.rootNode.setScene(this);
    }

    public Scene(Entity entity) {
        this();
        if (entity != null) {
            rootNode.createChildNode("Entity", entity);
        }
    }

    public Scene(Scene scene, String name) {
        super(name);
        this.rootNode = scene.getRootNode();
        this.rootNode.setScene(this);
    }

    public Node getRootNode() {
        return rootNode;
    }

    public AssetInfo getAssetInfo() {
        return assetInfo;
    }

    public void setAssetInfo(AssetInfo value) {
        this.assetInfo = value;
    }

    public List<Scene> getSubScenes() {
        return subScenes;
    }

    public List<A3DObject> getLibrary() {
        return library;
    }

    public List<AnimationClip> getAnimationClips() {
        return animationClips;
    }

    public AnimationClip getCurrentAnimationClip() {
        return currentAnimationClip;
    }

    public void setCurrentAnimationClip(AnimationClip value) {
        this.currentAnimationClip = value;
    }

    public AnimationClip getAnimationClip(String name) {
        for (AnimationClip clip : animationClips) {
            if (name.equals(clip.getName())) {
                return clip;
            }
        }
        return null;
    }

    public AnimationClip createAnimationClip(String name) {
        AnimationClip clip = new AnimationClip(name);
        animationClips.add(clip);
        return clip;
    }

    public Collection<Pose> getPoses() {
        return poses;
    }

    public void clear() {
        rootNode.getChildNodes().clear();
        library.clear();
        animationClips.clear();
        subScenes.clear();
        poses.clear();
    }

    public void open(String filePath) throws IOException {
        open(filePath, (Cancellation) null);
    }

    public void open(String filePath, Cancellation cancellationToken) throws IOException {
        FileFormat format = FileFormat.detect(filePath);
        if (format == null) {
            throw new IOException("Unknown file format: " + filePath);
        }
        open(new Stream(new java.io.FileInputStream(filePath)), format, cancellationToken);
    }

    public void open(String filePath, FileFormat format) throws IOException {
        open(filePath, format, null);
    }

    public void open(String filePath, FileFormat format, Cancellation cancellationToken) throws IOException {
        open(new Stream(new java.io.FileInputStream(filePath)), format, cancellationToken);
    }

    public void open(String filePath, LoadOptions options) throws IOException {
        open(filePath, options, null);
    }

    public void open(String filePath, LoadOptions options, Cancellation cancellationToken) throws IOException {
        FileFormat format = options.getFileFormat();
        if (format == null) {
            format = IOService.getFormatByFileName(filePath);
        }
        open(new Stream(new FileInputStream(filePath)), format, options, cancellationToken);
    }

    public void open(InputStream stream) throws IOException {
        open(stream, (Cancellation) null);
    }

    public void open(InputStream stream, Cancellation cancellationToken) throws IOException {
        open(new Stream(stream), cancellationToken);
    }

    public void open(InputStream stream, FileFormat format) throws IOException {
        open(stream, format, null);
    }

    public void open(InputStream stream, FileFormat format, Cancellation cancellationToken) throws IOException {
        open(new Stream(stream), format, cancellationToken);
    }

    public void open(InputStream stream, LoadOptions options) throws IOException {
        open(stream, options, null);
    }

    public void open(InputStream stream, LoadOptions options, Cancellation cancellationToken) throws IOException {
        open(new Stream(stream), options, cancellationToken);
    }

    public void open(Stream stream, FileFormat format, LoadOptions options) throws IOException {
        open(stream, format, options, null);
    }

    public void open(Stream stream, FileFormat format, LoadOptions options, Cancellation cancellationToken) throws IOException {
        if (cancellationToken != null && cancellationToken.isCancelled()) {
            return;
        }
        clear();
        if (options == null) {
            try {
                options = format.createLoadOptions();
            } catch (ImportException e) {
                throw new IOException("Failed to create load options", e);
            }
        }
        
        Scene imported;
        try {
            imported = format.load(stream, options);
        } catch (ImportException e) {
            throw new IOException("Import failed: " + e.getMessage(), e);
        }
        if (imported != null) {
            rootNode.getChildNodes().clear();
            rootNode.getChildNodes().addAll(imported.getRootNode().getChildNodes());
        }
        setScene(this);
    }

    public void open(Stream stream) throws IOException {
        open(stream, (Cancellation) null);
    }

    public void open(Stream stream, Cancellation cancellationToken) throws IOException {
        open(stream, (LoadOptions) null, cancellationToken);
    }

    public void open(Stream stream, FileFormat format) throws IOException {
        try {
            LoadOptions options = format.createLoadOptions();
            open(stream, format, options, null);
        } catch (ImportException e) {
            throw new IOException("Failed to create load options", e);
        }
    }

    public void open(Stream stream, FileFormat format, Cancellation cancellationToken) throws IOException {
        if (cancellationToken != null && cancellationToken.isCancelled()) {
            return;
        }
        try {
            LoadOptions options = format.createLoadOptions();
            open(stream, format, options, cancellationToken);
        } catch (ImportException e) {
            throw new IOException("Failed to create load options", e);
        }
    }

    public void open(Stream stream, LoadOptions options) throws IOException {
        open(stream, options, null);
    }

    public void open(Stream stream, LoadOptions options, Cancellation cancellationToken) throws IOException {
        if (cancellationToken != null && cancellationToken.isCancelled()) {
            return;
        }
        FileFormat format = options.getFileFormat();
        if (format == null) {
            throw new IOException("File format not specified");
        }
        clear();
        Scene imported;
        try {
            imported = format.load(stream, options);
        } catch (ImportException e) {
            throw new IOException("Import failed: " + e.getMessage(), e);
        }
        if (imported != null) {
            rootNode.getChildNodes().clear();
            rootNode.getChildNodes().addAll(imported.getRootNode().getChildNodes());
        }
        setScene(this);
    }

    public static Scene fromFile(String filePath) throws IOException {
        return fromFile(filePath, (Cancellation) null);
    }

    public static Scene fromFile(String filePath, Cancellation cancellationToken) throws IOException {
        Scene scene = new Scene();
        scene.open(filePath, cancellationToken);
        return scene;
    }

    public static Scene fromFile(String filePath, FileFormat format) throws IOException {
        return fromFile(filePath, format, null);
    }

    public static Scene fromFile(String filePath, FileFormat format, Cancellation cancellationToken) throws IOException {
        Scene scene = new Scene();
        scene.open(filePath, format, cancellationToken);
        return scene;
    }

    public static Scene fromFile(String filePath, LoadOptions options) throws IOException {
        return fromFile(filePath, options, null);
    }

    public static Scene fromFile(String filePath, LoadOptions options, Cancellation cancellationToken) throws IOException {
        Scene scene = new Scene();
        scene.open(filePath, options, cancellationToken);
        return scene;
    }

    public static Scene fromStream(InputStream stream) throws IOException {
        return fromStream(stream, (Cancellation) null);
    }

    public static Scene fromStream(InputStream stream, Cancellation cancellationToken) throws IOException {
        Scene scene = new Scene();
        scene.open(stream, cancellationToken);
        return scene;
    }

    public static Scene fromStream(InputStream stream, FileFormat format) throws IOException {
        return fromStream(stream, format, null);
    }

    public static Scene fromStream(InputStream stream, FileFormat format, Cancellation cancellationToken) throws IOException {
        Scene scene = new Scene();
        scene.open(stream, format, cancellationToken);
        return scene;
    }

    public static Scene fromStream(InputStream stream, LoadOptions options) throws IOException {
        return fromStream(stream, options, null);
    }

    public static Scene fromStream(InputStream stream, LoadOptions options, Cancellation cancellationToken) throws IOException {
        Scene scene = new Scene();
        scene.open(stream, options, cancellationToken);
        return scene;
    }

    public static Scene fromStream(Stream stream) throws IOException {
        return fromStream(stream, (Cancellation) null);
    }

    public static Scene fromStream(Stream stream, Cancellation cancellationToken) throws IOException {
        Scene scene = new Scene();
        scene.open(stream, cancellationToken);
        return scene;
    }

    public static Scene fromStream(Stream stream, FileFormat format) throws IOException {
        return fromStream(stream, format, null);
    }

    public static Scene fromStream(Stream stream, FileFormat format, Cancellation cancellationToken) throws IOException {
        Scene scene = new Scene();
        scene.open(stream, format, cancellationToken);
        return scene;
    }

    public static Scene fromStream(Stream stream, LoadOptions options) throws IOException {
        return fromStream(stream, options, null);
    }

    public static Scene fromStream(Stream stream, LoadOptions options, Cancellation cancellationToken) throws IOException {
        Scene scene = new Scene();
        scene.open(stream, options, cancellationToken);
        return scene;
    }

    public void save(String filePath) throws IOException {
        FileFormat format = FileFormat.getFormatByExtension(filePath);
        if (format == null) {
            throw new IOException("Unknown file format for: " + filePath);
        }
        save(filePath, format);
    }

    public void save(String filePath, FileFormat format) throws IOException {
        save(filePath, format, null);
    }

    public void save(String filePath, FileFormat format, Cancellation cancellationToken) throws IOException {
        SaveOptions options = format.createSaveOptions();
        save(filePath, options, cancellationToken);
    }

    public void save(String filePath, SaveOptions options) throws IOException {
        save(filePath, options, null);
    }

    public void save(String filePath, SaveOptions options, Cancellation cancellationToken) throws IOException {
        if (cancellationToken != null && cancellationToken.isCancelled()) {
            return;
        }
        FileFormat format = FileFormat.getFormatByExtension(filePath);
        if (format == null) {
            throw new IOException("Unknown file format for: " + filePath);
        }
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            save(fos, format, options, cancellationToken);
        }
    }

    public void save(OutputStream stream, FileFormat format) throws IOException {
        SaveOptions options = format.createSaveOptions();
        save(stream, format, options, null);
    }

    public void save(OutputStream stream, FileFormat format, Cancellation cancellationToken) throws IOException {
        SaveOptions options = format.createSaveOptions();
        save(stream, format, options, cancellationToken);
    }

    public void save(OutputStream stream, SaveOptions options) throws IOException {
        save(stream, options, null);
    }

    public void save(OutputStream stream, SaveOptions options, Cancellation cancellationToken) throws IOException {
        if (cancellationToken != null && cancellationToken.isCancelled()) {
            return;
        }
        if (options.getFileFormat() == null) {
            throw new IOException("File format not specified in SaveOptions");
        }
        save(stream, options.getFileFormat(), options, cancellationToken);
    }

    public void save(OutputStream stream, FileFormat format, SaveOptions options) throws IOException {
        save(stream, format, options, null);
    }

    public void save(OutputStream stream, FileFormat format, SaveOptions options, Cancellation cancellationToken) throws IOException {
        if (cancellationToken != null && cancellationToken.isCancelled()) {
            return;
        }
        if (options == null) {
            options = format.createSaveOptions();
        }
        if (options.getFileFormat() == null) {
            throw new IOException("File format not specified in SaveOptions");
        }
        
        format.save(this, new Stream(stream), options);
    }

    public void save(Stream stream, FileFormat format) throws IOException {
        save(stream, format, null);
    }

    public void save(Stream stream, FileFormat format, Cancellation cancellationToken) throws IOException {
        SaveOptions options = format.createSaveOptions();
        save(stream, options, cancellationToken);
    }

    public void save(Stream stream, SaveOptions options) throws IOException {
        save(stream, options, null);
    }

    public void save(Stream stream, SaveOptions options, Cancellation cancellationToken) throws IOException {
        if (cancellationToken != null && cancellationToken.isCancelled()) {
            return;
        }
        if (stream.getOutputStream() == null) {
            throw new IOException("Output stream not set");
        }
        if (options.getFileFormat() == null) {
            throw new IOException("File format not specified in SaveOptions");
        }
        FileFormat format = options.getFileFormat();
        format.save(this, new Stream(stream), options);
    }

    public void render(Camera camera, String fileName) throws IOException {
        throw new UnsupportedOperationException("Rendering is not implemented in FOSS version");
    }

    public void render(Camera camera, String fileName, Vector2 size, String format) throws IOException {
        throw new UnsupportedOperationException("Rendering is not implemented in FOSS version");
    }

    public void render(Camera camera, String fileName, Vector2 size, String format, ImageRenderOptions options) throws IOException {
        throw new UnsupportedOperationException("Rendering is not implemented in FOSS version");
    }

    public void render(Camera camera, TextureData texture) throws IOException {
        throw new UnsupportedOperationException("Rendering is not implemented in FOSS version");
    }

    public void render(Camera camera, TextureData texture, ImageRenderOptions options) throws IOException {
        throw new UnsupportedOperationException("Rendering is not implemented in FOSS version");
    }
}
