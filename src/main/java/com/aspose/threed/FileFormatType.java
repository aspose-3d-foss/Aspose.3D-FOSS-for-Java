package com.aspose.threed;

public final class FileFormatType {
    private final String extension;
    private final String name;

    private FileFormatType(String extension, String name) {
        this.extension = extension;
        this.name = name;
    }

    public static final FileFormatType MAYA = new FileFormatType(".ma", "Maya");
    public static final FileFormatType BLENDER = new FileFormatType(".blend", "Blender");
    public static final FileFormatType FBX = new FileFormatType(".fbx", "FBX");
    public static final FileFormatType STL = new FileFormatType(".stl", "STL");
    public static final FileFormatType WAVEFRONTOBJ = new FileFormatType(".obj", "Wavefront OBJ");
    public static final FileFormatType DISCREET3DS = new FileFormatType(".3ds", "Discreet3DS");
    public static final FileFormatType COLLADA = new FileFormatType(".dae", "Collada");
    public static final FileFormatType UNIVERSAL3D = new FileFormatType(".u3d", "Universal3D");
    public static final FileFormatType PDF = new FileFormatType(".pdf", "PDF");
    public static final FileFormatType GLTF = new FileFormatType(".gltf", "glTF");
    public static final FileFormatType DXF = new FileFormatType(".dxf", "DXF");
    public static final FileFormatType PLY = new FileFormatType(".ply", "PLY");
    public static final FileFormatType X = new FileFormatType(".x", "X");
    public static final FileFormatType DRACO = new FileFormatType(".drc", "Draco");
    public static final FileFormatType MICROSOFT3MF = new FileFormatType(".3mf", "Microsoft3MF");
    public static final FileFormatType RVM = new FileFormatType(".rvm", "RVM");
    public static final FileFormatType ASE = new FileFormatType(".ase", "ASE");
    public static final FileFormatType ZIP = new FileFormatType(".zip", "ZIP");
    public static final FileFormatType USD = new FileFormatType(".usd", "USD");
    public static final FileFormatType PCD = new FileFormatType(".pcd", "PCD");
    public static final FileFormatType XYZ = new FileFormatType(".xyz", "XYZ");
    public static final FileFormatType IFC = new FileFormatType(".ifc", "IFC");
    public static final FileFormatType SIEMENSJT = new FileFormatType(".jt", "SiemensJT");
    public static final FileFormatType AMF = new FileFormatType(".amf", "AMF");
    public static final FileFormatType VRML = new FileFormatType(".wrl", "VRML");
    public static final FileFormatType HTML5 = new FileFormatType(".html", "HTML5");
    public static final FileFormatType ASPOSE3D_WEB = new FileFormatType(".a3dw", "Aspose3D Web");

    public final String getExtension() {
        return extension;
    }

    @Override
    public final String toString() {
        return name;
    }
}
