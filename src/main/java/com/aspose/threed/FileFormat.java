package com.aspose.threed;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileFormat {
    public static final FileFormat FBX6100ASCII;
    public static final FileFormat FBX6100_BINARY;
    public static final FileFormat FBX7200ASCII;
    public static final FileFormat FBX7200_BINARY;
    public static final FileFormat FBX7300ASCII;
    public static final FileFormat FBX7300_BINARY;
    public static final FileFormat FBX7400ASCII;
    public static final FileFormat FBX7400_BINARY;
    public static final FileFormat FBX7500ASCII;
    public static final FileFormat FBX7500_BINARY;
    public static final FileFormat FBX7600ASCII;
    public static final FileFormat FBX7600_BINARY;
    public static final FileFormat FBX7700ASCII;
    public static final FileFormat FBX7700_BINARY;
    public static final FileFormat MAYAASCII;
    public static final FileFormat MAYA_BINARY;
    public static final FileFormat STL_BINARY;
    public static final FileFormat STLASCII;
    public static final FileFormat WAVEFRONTOBJ;
    public static final FileFormat DISCREET3DS;
    public static final FileFormat COLLADA;
    public static final FileFormat UNIVERSAL3D;
    public static final FileFormat GLTF;
    public static final FileFormat GLTF2;
    public static final FileFormat GLTF_BINARY;
    public static final FileFormat GLTF2_BINARY;
    public static final PdfFormat PDF;
    public static final FileFormat BLENDER;
    public static final FileFormat DXF;
    public static final PlyFormat PLY;
    public static final FileFormat X_BINARY;
    public static final FileFormat X_TEXT;
    public static final DracoFormat DRACO;
    public static final Microsoft3MFFormat MICROSOFT3MF;
    public static final RvmFormat RVM_TEXT;
    public static final RvmFormat RVM_BINARY;
    public static final FileFormat ASE;
    public static final FileFormat IFC;
    public static final FileFormat SIEMENSJT8;
    public static final FileFormat SIEMENSJT9;
    public static final FileFormat AMF;
    public static final FileFormat VRML;
    public static final FileFormat ASPOSE3D_WEB;
    public static final FileFormat HTML5;
    public static final FileFormat ZIP;
    public static final FileFormat USD;
    public static final FileFormat USDA;
    public static final FileFormat USDZ;
    public static final FileFormat XYZ;
    public static final FileFormat PCD;
    public static final FileFormat PCD_BINARY;

    private final FileFormatType type;
    private final Version version;
    private final FileContentType contentType;
    private final String extension;
    private final String[] extensions;
    private final boolean canImport;
    private final boolean canExport;
    private final String loadOptionsClass;
    private final String saveOptionsClass;

    private static final List<FileFormat> allFormats = new ArrayList<>();
    private static final Map<String, FileFormat> extensionIndex = new HashMap<>();

    static {
        FBX6100ASCII = new FileFormat(FileFormatType.FBX, new Version(6, 1, 0), 
            FileContentType.ASCII, ".fbx", new String[]{".fbx"}, false, false, 
            "com.aspose.threed.FbxLoadOptions", "com.aspose.threed.FbxSaveOptions");
        FBX6100_BINARY = new FileFormat(FileFormatType.FBX, new Version(6, 1, 0), 
            FileContentType.BINARY, ".fbx", new String[]{".fbx"}, false, false, 
            "com.aspose.threed.FbxLoadOptions", "com.aspose.threed.FbxSaveOptions");
        STL_BINARY = new FileFormat(FileFormatType.STL, new Version(1, 0, 0), 
            FileContentType.BINARY, ".stl", new String[]{".stl"}, true, true, 
            "com.aspose.threed.StlLoadOptions", "com.aspose.threed.StlSaveOptions");
        STLASCII = new FileFormat(FileFormatType.STL, new Version(1, 0, 0), 
            FileContentType.ASCII, ".stl", new String[]{".stl"}, true, true, 
            "com.aspose.threed.StlLoadOptions", "com.aspose.threed.StlSaveOptions");
        WAVEFRONTOBJ = new FileFormat(FileFormatType.WAVEFRONTOBJ, new Version(1, 0, 0), 
            FileContentType.ASCII, ".obj", new String[]{".obj", ".mtl"}, true, true, 
            "com.aspose.threed.ObjLoadOptions", "com.aspose.threed.ObjSaveOptions");
        GLTF2 = new FileFormat(FileFormatType.GLTF, new Version(2, 0, 0), 
            FileContentType.ASCII, ".gltf", new String[]{".gltf"}, true, true, 
            "com.aspose.threed.GltfLoadOptions", "com.aspose.threed.GltfSaveOptions");
        GLTF2_BINARY = new FileFormat(FileFormatType.GLTF, new Version(2, 0, 0), 
            FileContentType.BINARY, ".glb", new String[]{".glb"}, true, true, 
            "com.aspose.threed.GltfLoadOptions", "com.aspose.threed.GltfSaveOptions");

        FBX7200ASCII = FBX6100ASCII;
        FBX7200_BINARY = FBX6100_BINARY;
        FBX7300ASCII = FBX6100ASCII;
        FBX7300_BINARY = FBX6100_BINARY;
        FBX7400ASCII = FBX6100ASCII;
        FBX7400_BINARY = FBX6100_BINARY;
        FBX7500ASCII = FBX6100ASCII;
        FBX7500_BINARY = FBX6100_BINARY;
        FBX7600ASCII = FBX6100ASCII;
        FBX7600_BINARY = FBX6100_BINARY;
        FBX7700ASCII = FBX6100ASCII;
        FBX7700_BINARY = FBX6100_BINARY;
        MAYAASCII = new FileFormat(FileFormatType.MAYA, new Version(1, 0, 0), 
            FileContentType.ASCII, ".ma", new String[]{".ma"}, false, false, null, null);
        MAYA_BINARY = new FileFormat(FileFormatType.MAYA, new Version(1, 0, 0), 
            FileContentType.BINARY, ".mb", new String[]{".mb"}, false, false, null, null);
        DISCREET3DS = new FileFormat(FileFormatType.DISCREET3DS, new Version(1, 0, 0), 
            FileContentType.BINARY, ".3ds", new String[]{".3ds"}, false, false, null, null);
        COLLADA = new FileFormat(FileFormatType.COLLADA, new Version(1, 4, 0), 
            FileContentType.ASCII, ".dae", new String[]{".dae"}, false, false, null, null);
        UNIVERSAL3D = new FileFormat(FileFormatType.UNIVERSAL3D, new Version(1, 0, 0), 
            FileContentType.BINARY, ".u3d", new String[]{".u3d"}, false, false, null, null);
        GLTF = new FileFormat(FileFormatType.GLTF, new Version(1, 0, 0), 
            FileContentType.ASCII, ".gltf", new String[]{".gltf"}, true, true, 
            "com.aspose.threed.GltfLoadOptions", "com.aspose.threed.GltfSaveOptions");
        GLTF_BINARY = new FileFormat(FileFormatType.GLTF, new Version(1, 0, 0), 
            FileContentType.BINARY, ".glb", new String[]{".glb"}, true, true, 
            "com.aspose.threed.GltfLoadOptions", "com.aspose.threed.GltfSaveOptions");
        PDF = new PdfFormat();
        BLENDER = new FileFormat(FileFormatType.BLENDER, new Version(1, 0, 0), 
            FileContentType.BINARY, ".blend", new String[]{".blend"}, false, false, null, null);
        DXF = new FileFormat(FileFormatType.DXF, new Version(1, 0, 0), 
            FileContentType.ASCII, ".dxf", new String[]{".dxf"}, false, false, null, null);
        PLY = new PlyFormat();
        X_BINARY = new FileFormat(FileFormatType.X, new Version(1, 0, 0), 
            FileContentType.BINARY, ".x", new String[]{".x"}, false, false, null, null);
        X_TEXT = new FileFormat(FileFormatType.X, new Version(1, 0, 0), 
            FileContentType.ASCII, ".x", new String[]{".x"}, false, false, null, null);
        DRACO = new DracoFormat();
        MICROSOFT3MF = new Microsoft3MFFormat();
        RVM_TEXT = new RvmFormat(FileContentType.ASCII);
        RVM_BINARY = new RvmFormat(FileContentType.BINARY);
        ASE = new FileFormat(FileFormatType.ASE, new Version(1, 0, 0), 
            FileContentType.ASCII, ".ase", new String[]{".ase"}, false, false, null, null);
        IFC = new FileFormat(FileFormatType.IFC, new Version(1, 0, 0), 
            FileContentType.ASCII, ".ifc", new String[]{".ifc"}, false, false, null, null);
        SIEMENSJT8 = new FileFormat(FileFormatType.SIEMENSJT, new Version(8, 0, 0), 
            FileContentType.BINARY, ".jt", new String[]{".jt"}, false, false, null, null);
        SIEMENSJT9 = new FileFormat(FileFormatType.SIEMENSJT, new Version(9, 0, 0), 
            FileContentType.BINARY, ".jt", new String[]{".jt"}, false, false, null, null);
        AMF = new FileFormat(FileFormatType.AMF, new Version(1, 0, 0), 
            FileContentType.BINARY, ".amf", new String[]{".amf"}, false, false, null, null);
        VRML = new FileFormat(FileFormatType.VRML, new Version(2, 0, 0), 
            FileContentType.ASCII, ".wrl", new String[]{".wrl"}, false, false, null, null);
        ASPOSE3D_WEB = new FileFormat(FileFormatType.ASPOSE3D_WEB, new Version(1, 0, 0), 
            FileContentType.BINARY, ".a3dw", new String[]{".a3dw"}, false, false, null, null);
        HTML5 = new FileFormat(FileFormatType.HTML5, new Version(1, 0, 0), 
            FileContentType.ASCII, ".html", new String[]{".html"}, false, false, null, null);
        ZIP = new FileFormat(FileFormatType.ZIP, new Version(1, 0, 0), 
            FileContentType.BINARY, ".zip", new String[]{".zip"}, false, false, null, null);
        USD = new FileFormat(FileFormatType.USD, new Version(1, 0, 0), 
            FileContentType.BINARY, ".usdc", new String[]{".usdc"}, false, false, null, null);
        USDA = new FileFormat(FileFormatType.USD, new Version(1, 0, 0), 
            FileContentType.ASCII, ".usda", new String[]{".usda"}, false, false, null, null);
        USDZ = new FileFormat(FileFormatType.USD, new Version(1, 0, 0), 
            FileContentType.BINARY, ".usdz", new String[]{".usdz"}, false, false, null, null);
        XYZ = new FileFormat(FileFormatType.XYZ, new Version(1, 0, 0), 
            FileContentType.ASCII, ".xyz", new String[]{".xyz"}, false, false, null, null);
        PCD = new FileFormat(FileFormatType.PCD, new Version(1, 0, 0), 
            FileContentType.ASCII, ".pcd", new String[]{".pcd"}, false, false, null, null);
        PCD_BINARY = new FileFormat(FileFormatType.PCD, new Version(1, 0, 0), 
            FileContentType.BINARY, ".pcd", new String[]{".pcd"}, false, false, null, null);
    }

    private FileFormat(FileFormatType type, Version version, FileContentType contentType, 
                       String extension, String[] extensions, boolean canImport, boolean canExport,
                       String loadOptionsClass, String saveOptionsClass) {
        this.type = type;
        this.version = version;
        this.contentType = contentType;
        this.extension = extension;
        this.extensions = extensions;
        this.canImport = canImport;
        this.canExport = canExport;
        this.loadOptionsClass = loadOptionsClass;
        this.saveOptionsClass = saveOptionsClass;
        
        allFormats.add(this);
        for (String ext : extensions) {
            extensionIndex.put(ext.toLowerCase(), this);
        }
    }

    public static List<FileFormat> getFormats() {
        return new ArrayList<>(allFormats);
    }

    public Version getVersion() {
        return version;
    }

    public static FileFormat getFormatByExtension(String filePath) {
        String ext = filePath.toLowerCase();
        
        int lastSlash = Math.max(ext.lastIndexOf('/'), ext.lastIndexOf('\\'));
        if (lastSlash >= 0) {
            ext = ext.substring(lastSlash + 1);
        }
        
        int lastDot = ext.lastIndexOf('.');
        if (lastDot >= 0) {
            ext = ext.substring(lastDot);
        }
        
        if (!ext.startsWith(".")) {
            ext = "." + ext;
        }
        return extensionIndex.get(ext);
    }

    public boolean getCanImport() {
        return canImport;
    }

    public boolean getCanExport() {
        return canExport;
    }

    public String getExtension() {
        return extension;
    }

    public String[] getExtensions() {
        return extensions;
    }

    public FileContentType getContentType() {
        return contentType;
    }

    public FileFormatType getFileFormatType() {
        return type;
    }

    public static FileFormat detect(Stream stream, String fileName) throws IOException {
        return getFormatByExtension(fileName);
    }

    public static FileFormat detect(String fileName) throws IOException {
        return getFormatByExtension(fileName);
    }

    public LoadOptions createLoadOptions() throws ImportException {
        if (loadOptionsClass == null) {
            LoadOptions options = new LoadOptions();
            options.setFileFormat(this);
            return options;
        }
        try {
            LoadOptions options = (LoadOptions) Class.forName(loadOptionsClass).getDeclaredConstructor().newInstance();
            options.setFileFormat(this);
            if (options instanceof StlLoadOptions) {
                ((StlLoadOptions) options).setContentType(this.contentType);
            }
            return options;
        } catch (Exception e) {
            throw new ImportException("Failed to create LoadOptions", e);
        }
    }

    public ObjLoadOptions createObjLoadOptions() throws ImportException {
        if ("com.aspose.threed.ObjLoadOptions".equals(loadOptionsClass)) {
            return new ObjLoadOptions();
        }
        return new ObjLoadOptions();
    }

    public ObjSaveOptions createObjSaveOptions() {
        if ("com.aspose.threed.ObjSaveOptions".equals(saveOptionsClass)) {
            return new ObjSaveOptions();
        }
        return new ObjSaveOptions();
    }

    public SaveOptions createSaveOptions() {
        if (saveOptionsClass == null) {
            SaveOptions options = new SaveOptions();
            options.setFileFormat(this);
            return options;
        }
        try {
            SaveOptions options = (SaveOptions) Class.forName(saveOptionsClass).getDeclaredConstructor().newInstance();
            options.setFileFormat(this);
            return options;
        } catch (Exception e) {
            SaveOptions options = new SaveOptions();
            options.setFileFormat(this);
            return options;
        }
    }

    @Override
    public String toString() {
        return type + " " + version + " " + contentType;
    }

    protected FileFormat(FileFormatType type, Version version, FileContentType contentType, 
                         String extension, String[] extensions) {
        this(type, version, contentType, extension, extensions, false, false, null, null);
    }
}

class PdfFormat extends FileFormat {
    public PdfFormat() {
        super(FileFormatType.PDF, new Version(1, 7, 0), FileContentType.BINARY, 
              ".pdf", new String[]{".pdf"});
    }
}

class PlyFormat extends FileFormat {
    public PlyFormat() {
        super(FileFormatType.PLY, new Version(1, 0, 0), FileContentType.ASCII, 
              ".ply", new String[]{".ply"});
    }
}

class DracoFormat extends FileFormat {
    public DracoFormat() {
        super(FileFormatType.DRACO, new Version(1, 0, 0), FileContentType.BINARY, 
              ".drc", new String[]{".drc"});
    }
}

class Microsoft3MFFormat extends FileFormat {
    public Microsoft3MFFormat() {
        super(FileFormatType.MICROSOFT3MF, new Version(1, 0, 0), FileContentType.BINARY, 
              ".3mf", new String[]{".3mf"});
    }
}

class RvmFormat extends FileFormat {
    public RvmFormat(FileContentType contentType) {
        super(FileFormatType.RVM, new Version(1, 0, 0), contentType, 
              ".rvm", new String[]{".rvm"});
    }
}
