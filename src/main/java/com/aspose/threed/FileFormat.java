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

    private static final List<FileFormat> allFormats = new ArrayList<>();
    private static final Map<String, FileFormat> extensionIndex = new HashMap<>();

    static {
         FBX6100ASCII = new FileFormat(FileFormatType.FBX, new Version(6, 1, 0), 
             FileContentType.ASCII, ".fbx", new String[]{".fbx"}, true, true);
         FBX6100_BINARY = new FileFormat(FileFormatType.FBX, new Version(6, 1, 0), 
             FileContentType.BINARY, ".fbx", new String[]{".fbx"}, true, true);
         STL_BINARY = new FileFormat(FileFormatType.STL, new Version(1, 0, 0), 
             FileContentType.BINARY, ".stl", new String[]{".stl"}, true, true);
         STLASCII = new FileFormat(FileFormatType.STL, new Version(1, 0, 0), 
             FileContentType.ASCII, ".stl", new String[]{".stl"}, true, true);
         WAVEFRONTOBJ = new FileFormat(FileFormatType.WAVEFRONTOBJ, new Version(1, 0, 0), 
             FileContentType.ASCII, ".obj", new String[]{".obj", ".mtl"}, true, true);
         GLTF2 = new FileFormat(FileFormatType.GLTF, new Version(2, 0, 0), 
             FileContentType.ASCII, ".gltf", new String[]{".gltf"}, true, true);
         GLTF2_BINARY = new FileFormat(FileFormatType.GLTF, new Version(2, 0, 0), 
             FileContentType.BINARY, ".glb", new String[]{".glb"}, true, true);


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
             FileContentType.ASCII, ".ma", new String[]{".ma"}, true, true);
         MAYA_BINARY = new FileFormat(FileFormatType.MAYA, new Version(1, 0, 0), 
             FileContentType.BINARY, ".mb", new String[]{".mb"}, true, true);
         DISCREET3DS = new FileFormat(FileFormatType.DISCREET3DS, new Version(1, 0, 0), 
             FileContentType.BINARY, ".3ds", new String[]{".3ds"}, true, true);
         COLLADA = new FileFormat(FileFormatType.COLLADA, new Version(1, 4, 0), 
             FileContentType.ASCII, ".dae", new String[]{".dae"}, true, true);
         UNIVERSAL3D = new FileFormat(FileFormatType.UNIVERSAL3D, new Version(1, 0, 0), 
             FileContentType.BINARY, ".u3d", new String[]{".u3d"}, true, true);
         GLTF = new FileFormat(FileFormatType.GLTF, new Version(1, 0, 0), 
             FileContentType.ASCII, ".gltf", new String[]{".gltf"}, true, true);
         GLTF_BINARY = new FileFormat(FileFormatType.GLTF, new Version(1, 0, 0), 
             FileContentType.BINARY, ".glb", new String[]{".glb"}, true, true);
         PDF = new PdfFormat();
         BLENDER = new FileFormat(FileFormatType.BLENDER, new Version(1, 0, 0), 
             FileContentType.BINARY, ".blend", new String[]{".blend"}, true, true);
         DXF = new FileFormat(FileFormatType.DXF, new Version(1, 0, 0), 
             FileContentType.ASCII, ".dxf", new String[]{".dxf"}, true, true);
         PLY = new PlyFormat();
         X_BINARY = new FileFormat(FileFormatType.X, new Version(1, 0, 0), 
             FileContentType.BINARY, ".x", new String[]{".x"}, true, true);
         X_TEXT = new FileFormat(FileFormatType.X, new Version(1, 0, 0), 
             FileContentType.ASCII, ".x", new String[]{".x"}, true, true);
         DRACO = new DracoFormat();
         MICROSOFT3MF = new Microsoft3MFFormat();
         RVM_TEXT = new RvmFormat(FileContentType.ASCII);
         RVM_BINARY = new RvmFormat(FileContentType.BINARY);
         ASE = new FileFormat(FileFormatType.ASE, new Version(1, 0, 0), 
             FileContentType.ASCII, ".ase", new String[]{".ase"}, true, true);
         IFC = new FileFormat(FileFormatType.IFC, new Version(1, 0, 0), 
             FileContentType.ASCII, ".ifc", new String[]{".ifc"}, true, true);
         SIEMENSJT8 = new FileFormat(FileFormatType.SIEMENSJT, new Version(8, 0, 0), 
             FileContentType.BINARY, ".jt", new String[]{".jt"}, true, true);
         SIEMENSJT9 = new FileFormat(FileFormatType.SIEMENSJT, new Version(9, 0, 0), 
             FileContentType.BINARY, ".jt", new String[]{".jt"}, true, true);
         AMF = new FileFormat(FileFormatType.AMF, new Version(1, 0, 0), 
             FileContentType.BINARY, ".amf", new String[]{".amf"}, true, true);
         VRML = new FileFormat(FileFormatType.VRML, new Version(2, 0, 0), 
             FileContentType.ASCII, ".wrl", new String[]{".wrl"}, true, true);
         ASPOSE3D_WEB = new FileFormat(FileFormatType.ASPOSE3D_WEB, new Version(1, 0, 0), 
             FileContentType.BINARY, ".a3dw", new String[]{".a3dw"}, true, true);
         HTML5 = new FileFormat(FileFormatType.HTML5, new Version(1, 0, 0), 
             FileContentType.ASCII, ".html", new String[]{".html"}, true, true);
         ZIP = new FileFormat(FileFormatType.ZIP, new Version(1, 0, 0), 
             FileContentType.BINARY, ".zip", new String[]{".zip"}, true, true);
         USD = new FileFormat(FileFormatType.USD, new Version(1, 0, 0), 
             FileContentType.BINARY, ".usdc", new String[]{".usdc"}, true, true);
         USDA = new FileFormat(FileFormatType.USD, new Version(1, 0, 0), 
             FileContentType.ASCII, ".usda", new String[]{".usda"}, true, true);
         USDZ = new FileFormat(FileFormatType.USD, new Version(1, 0, 0), 
             FileContentType.BINARY, ".usdz", new String[]{".usdz"}, true, true);
         XYZ = new FileFormat(FileFormatType.XYZ, new Version(1, 0, 0), 
             FileContentType.ASCII, ".xyz", new String[]{".xyz"}, true, true);
         PCD = new FileFormat(FileFormatType.PCD, new Version(1, 0, 0), 
             FileContentType.ASCII, ".pcd", new String[]{".pcd"}, true, true);
         PCD_BINARY = new FileFormat(FileFormatType.PCD, new Version(1, 0, 0), 
             FileContentType.BINARY, ".pcd", new String[]{".pcd"}, true, true);
         
         FileFormat.registerFormat(FBX6100ASCII);
         FileFormat.registerFormat(FBX6100_BINARY);
         FileFormat.registerFormat(STL_BINARY);
         FileFormat.registerFormat(STLASCII);
         FileFormat.registerFormat(WAVEFRONTOBJ);
         FileFormat.registerFormat(GLTF2);
         FileFormat.registerFormat(GLTF2_BINARY);
         FileFormat.registerFormat(GLTF);
         FileFormat.registerFormat(GLTF_BINARY);
    }

    public FileFormat(FileFormatType type, Version version, FileContentType contentType, 
                       String extension, String[] extensions, boolean canImport, boolean canExport) {
        this.type = type;
        this.version = version;
        this.contentType = contentType;
        this.extension = extension;
        this.extensions = extensions;
        this.canImport = canImport;
        this.canExport = canExport;
        
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

    public LoadOptions createLoadOptions() throws ImportException {
        if (extension.equals(".stl")) {
            return new StlLoadOptions();
        }
        if (extension.equals(".obj")) {
            return new ObjLoadOptions();
        }
        if (extension.equals(".gltf") || extension.equals(".glb")) {
            return new GltfLoadOptions();
        }
        if (extension.equals(".fbx")) {
            return new FbxLoadOptions();
        }
        throw new ImportException("Load options not implemented for " + extension);
    }

    public SaveOptions createSaveOptions() {
        if (extension.equals(".stl")) {
            return new StlSaveOptions();
        }
        if (extension.equals(".obj")) {
            return new ObjSaveOptions();
        }
        if (extension.equals(".gltf") || extension.equals(".glb")) {
            return new GltfSaveOptions();
        }
        if (extension.equals(".fbx")) {
            return new FbxSaveOptions();
        }
        throw new UnsupportedOperationException("Save options not implemented for " + extension);
    }

    public boolean canDetect(Stream stream, String fileName) {
        return false;
    }
    
    public static FileFormat detect(Stream stream, String fileName) throws IOException {
          return com.aspose.threed.IOService.detectFormat(stream, fileName);
     }

     public static FileFormat detect(String fileName) throws IOException {
          return com.aspose.threed.IOService.getFormatByFileName(fileName);
     }
     
    public static void registerFormat(FileFormat format) {
        allFormats.add(format);
        for (String ext : format.extensions) {
            extensionIndex.put(ext.toLowerCase(), format);
        }
    }

    @Override
    public String toString() {
        return type + " " + version + " " + contentType;
    }
    
    /**
     * Internal method to load a scene from a stream.
     * This is package-private and should not be called directly.
     */
    Scene load(Stream stream, LoadOptions options) throws IOException, ImportException {
        String ext = extension.toLowerCase();
        
        if (ext.equals(".stl")) {
            StlLoader loader = new StlLoader();
            return loader.load(stream, options);
        }
        else if (ext.equals(".obj")) {
            ObjLoader loader = new ObjLoader();
            return loader.load(stream, options);
        }
        else if (ext.equals(".gltf") || ext.equals(".glb")) {
            GltfLoader loader = new GltfLoader();
            return loader.load(stream, options);
        }
        else if (ext.equals(".fbx")) {
            FbxLoader loader = new FbxLoader();
            return loader.load(stream, options);
        }
        
        throw new IOException("No importer available for format: " + extension);
    }

    /**
     * Internal method to save a scene to a stream.
     * This is package-private and should not be called directly.
     */
    void save(Scene scene, Stream stream, SaveOptions options) throws IOException {
        String ext = extension.toLowerCase();
        
        if (ext.equals(".stl")) {
            StlSaver saver = new StlSaver();
            saver.save(scene, stream, options);
        }
        else if (ext.equals(".obj")) {
            ObjSaver saver = new ObjSaver();
            saver.save(scene, stream, options);
        }
        else if (ext.equals(".gltf") || ext.equals(".glb")) {
            GltfSaver saver = new GltfSaver();
            saver.save(scene, stream, options);
        }
        else if (ext.equals(".fbx")) {
            FbxSaver saver = new FbxSaver();
            saver.save(scene, stream, options);
        }
        else {
            throw new IOException("No exporter available for format: " + extension);
        }
    }

    // Internal loader classes
    private static class StlLoader {
        public Scene load(Stream stream, LoadOptions options) throws IOException, ImportException {
            java.io.InputStream in = stream.getInputStream();
            if (in == null) {
                throw new IOException("Input stream not available");
            }
            
            Scene scene = new Scene();
            
            try {
                // Read the first 5 bytes to check if ASCII or binary
                byte[] header5 = new byte[5];
                int read = in.read(header5);
                if (read < 5) {
                    throw new IOException("File too small");
                }
                
                String header = new String(header5, "US-ASCII");
                
                if (header.toLowerCase().startsWith("solid")) {
                    // ASCII STL - read rest of file
                    readAsciiStl(in, scene);
                } else {
                    // Binary STL - read rest of file
                    readBinaryStl(in, scene);
                }
            } catch (Exception e) {
                throw new IOException("Failed to read STL file: " + e.getMessage(), e);
            }
            
            return scene;
        }
        
        private void readAsciiStl(java.io.InputStream in, Scene scene) throws IOException {
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(in, "US-ASCII"));
            Mesh mesh = null;
            String line;
            boolean inFacet = false;
            boolean inLoop = false;
            List<Vector3> tempVertices = new ArrayList<Vector3>();
            Vector3 currentNormal = new Vector3(0, 0, 0);
            
            try {
                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    if (line.isEmpty()) continue;
                    
                    // Start of solid
                    if (line.startsWith("solid")) {
                        continue;
                    }
                    
                    // Start of facet
                    if (line.startsWith("facet normal")) {
                        inFacet = true;
                        inLoop = false;
                        tempVertices.clear();
                        
                        // Parse normal
                        String[] parts = line.substring("facet normal".length()).trim().split("\\s+");
                        if (parts.length >= 3) {
                            currentNormal = new Vector3(
                                Double.parseDouble(parts[0]),
                                Double.parseDouble(parts[1]),
                                Double.parseDouble(parts[2])
                            );
                        }
                        continue;
                    }
                    
                    // Start of loop
                    if (line.startsWith("outer loop")) {
                        inLoop = true;
                        continue;
                    }
                    
                    // Vertex definition
                    if (line.startsWith("vertex")) {
                        if (inLoop && inFacet) {
                            String[] parts = line.substring("vertex".length()).trim().split("\\s+");
                            if (parts.length >= 3) {
                                tempVertices.add(new Vector3(
                                    Double.parseDouble(parts[0]),
                                    Double.parseDouble(parts[1]),
                                    Double.parseDouble(parts[2])
                                ));
                            }
                        }
                        continue;
                    }
                    
                    // End of loop
                    if (line.startsWith("endloop")) {
                        continue;
                    }
                    
                    // End of facet - create polygon
                    if (line.startsWith("endfacet")) {
                        if (tempVertices.size() >= 3) {
                            if (mesh == null) {
                                mesh = new Mesh("STLMesh");
                                scene.getRootNode().createChildNode("MeshNode", mesh);
                            }
                            
                            // Add vertices to control points and create polygon
                            int baseIndex = mesh.getControlPoints().size();
                            for (Vector3 v : tempVertices) {
                                mesh.addControlPoint(v.x, v.y, v.z);
                            }
                            
                            // Create triangle polygon
                            if (tempVertices.size() == 3) {
                                mesh.createPolygon(new int[]{baseIndex, baseIndex + 1, baseIndex + 2});
                            } else if (tempVertices.size() == 4) {
                                mesh.createPolygon(new int[]{baseIndex, baseIndex + 1, baseIndex + 2, baseIndex + 3});
                            } else {
                                // Triangulate for more than 4 vertices
                                for (int i = 0; i < tempVertices.size() - 2; i++) {
                                    mesh.createPolygon(new int[]{baseIndex, baseIndex + i + 1, baseIndex + i + 2});
                                }
                            }
                        }
                        inFacet = false;
                        continue;
                    }
                    
                    // End of solid
                    if (line.startsWith("endsolid")) {
                        break;
                    }
                }
            } finally {
                reader.close();
            }
        }
        
        private void readBinaryStl(java.io.InputStream in, Scene scene) throws IOException {
            java.io.DataInputStream dataIn = new java.io.DataInputStream(in);
            
            // Read 80-byte header
            byte[] header = new byte[80];
            dataIn.readFully(header);
            
            // Read number of triangles (4 bytes, little-endian)
            // DataInputStream.readInt() reads big-endian, so we need to reverse bytes
            int numTriangles = Integer.reverseBytes(dataIn.readInt());
            
            Mesh mesh = new Mesh("STLMesh");
            scene.getRootNode().createChildNode("MeshNode", mesh);
            
            try {
                for (int i = 0; i < numTriangles; i++) {
                    // Read normal (3 floats = 12 bytes)
                    float nx = dataIn.readFloat();
                    float ny = dataIn.readFloat();
                    float nz = dataIn.readFloat();
                    
                    // Read 3 vertices (9 floats = 36 bytes)
                    float[] vertices = new float[9];
                    for (int j = 0; j < 9; j++) {
                        vertices[j] = dataIn.readFloat();
                    }
                    
                    // Read attribute byte count (2 bytes)
                    dataIn.readUnsignedShort();
                    
                    // Add vertices to mesh
                    int baseIndex = mesh.getControlPoints().size();
                    for (int j = 0; j < 3; j++) {
                        mesh.addControlPoint(vertices[j * 3], vertices[j * 3 + 1], vertices[j * 3 + 2]);
                    }
                    
                    // Create triangle polygon
                    mesh.createPolygon(new int[]{baseIndex, baseIndex + 1, baseIndex + 2});
                }
            } catch (Exception e) {
                // Ignore errors at end of file (might be due to trailing data)
            }
        }
    }

    private static class ObjLoader {
        public Scene load(Stream stream, LoadOptions options) throws IOException, ImportException {
            // TODO: implement OBJ loading
            return new Scene();
        }
    }

    private static class GltfLoader {
        public Scene load(Stream stream, LoadOptions options) throws IOException, ImportException {
            // TODO: implement GLTF loading
            return new Scene();
        }
    }

    private static class FbxLoader {
        public Scene load(Stream stream, LoadOptions options) throws IOException, ImportException {
            // TODO: implement FBX loading
            return new Scene();
        }
    }

    // Internal saver classes
    private static class StlSaver {
        public void save(Scene scene, Stream stream, SaveOptions options) throws IOException {
            java.io.OutputStream out = stream.getOutputStream();
            if (out == null) {
                throw new IOException("Output stream not available");
            }
            
            try {
                StlSaveOptions stlOptions = (StlSaveOptions) options;
                FileContentType contentType = stlOptions.getContentType();
                
                if (contentType == FileContentType.BINARY) {
                    writeBinaryStl(scene, out);
                } else {
                    writeAsciiStl(scene, out);
                }
            } finally {
                out.close();
            }
        }
        
        private void writeAsciiStl(Scene scene, java.io.OutputStream out) throws IOException {
            java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.OutputStreamWriter(out, "US-ASCII"));
            
            writer.println("solid Exported");
            
            // Traverse the scene to find all meshes
            traverseScene(scene.getRootNode(), writer);
            
            writer.println("endsolid Exported");
            writer.flush();
        }
        
        private void writeBinaryStl(Scene scene, java.io.OutputStream out) throws IOException {
            java.io.DataOutputStream dataOut = new java.io.DataOutputStream(out);
            
            // Write 80-byte header
            byte[] header = new byte[80];
            dataOut.write(header);
            
            // Count total number of triangles
            int triangleCount = countTriangles(scene.getRootNode());
            
            // Write triangle count (little-endian)
            dataOut.writeInt(Integer.reverseBytes(triangleCount));
            dataOut.flush();
            
            // Write triangle data
            writeTrianglesToStream(scene.getRootNode(), dataOut);
        }
        
        private void traverseScene(Node node, java.io.PrintWriter writer) throws IOException {
            // Get all entities from this node and its children
            for (Entity entity : node.getEntities()) {
                if (entity instanceof Mesh) {
                    Mesh mesh = (Mesh) entity;
                    writeMeshToAscii(mesh, writer);
                }
            }
            
            // Recursively process child nodes
            for (Node child : node.getChildNodes()) {
                traverseScene(child, writer);
            }
        }
        
        private void writeMeshToAscii(Mesh mesh, java.io.PrintWriter writer) throws IOException {
            java.util.List<Vector4> controlPoints = mesh.getControlPoints();
            List<int[]> polygons = mesh.getPolygons();
            
            for (int[] polygon : polygons) {
                if (polygon.length >= 3) {
                    // Calculate normal for the triangle
                    Vector3 v0 = getPoint(controlPoints, polygon[0]);
                    Vector3 v1 = getPoint(controlPoints, polygon[1]);
                    Vector3 v2 = getPoint(controlPoints, polygon[2]);
                    
                    // Calculate normal (v1 - v0) x (v2 - v0)
                    Vector3 edge1 = Vector3.sub(v1, v0);
                    Vector3 edge2 = Vector3.sub(v2, v0);
                    Vector3 normal = edge1.cross(edge2).normalize();
                    
                    writer.println("  facet normal " + normal.x + " " + normal.y + " " + normal.z);
                    writer.println("    outer loop");
                    writer.println("      vertex " + v0.x + " " + v0.y + " " + v0.z);
                    writer.println("      vertex " + v1.x + " " + v1.y + " " + v1.z);
                    writer.println("      vertex " + v2.x + " " + v2.y + " " + v2.z);
                    writer.println("    endloop");
                    writer.println("  endfacet");
                }
            }
        }
        
        private int countTriangles(Node node) {
            int count = 0;
            
            for (Entity entity : node.getEntities()) {
                if (entity instanceof Mesh) {
                    Mesh mesh = (Mesh) entity;
                    for (int[] polygon : mesh.getPolygons()) {
                        if (polygon.length >= 3) {
                            // Count triangles (triangulate polygons with > 3 vertices)
                            count += (polygon.length - 2);
                        }
                    }
                }
            }
            
            // Recursively process child nodes
            for (Node child : node.getChildNodes()) {
                count += countTriangles(child);
            }
            
            return count;
        }
        
        private void writeTrianglesToStream(Node node, java.io.DataOutputStream out) throws IOException {
            for (Entity entity : node.getEntities()) {
                if (entity instanceof Mesh) {
                    Mesh mesh = (Mesh) entity;
                    writeMeshTrianglesToStream(mesh, out);
                }
            }
            
            // Recursively process child nodes
            for (Node child : node.getChildNodes()) {
                writeTrianglesToStream(child, out);
            }
        }
        
        private void writeMeshTrianglesToStream(Mesh mesh, java.io.DataOutputStream out) throws IOException {
            java.util.List<Vector4> controlPoints = mesh.getControlPoints();
            List<int[]> polygons = mesh.getPolygons();
            
            for (int[] polygon : polygons) {
                if (polygon.length >= 3) {
                    // Triangulate the polygon
                    for (int i = 0; i < polygon.length - 2; i++) {
                        int[] triangle = new int[]{polygon[0], polygon[i + 1], polygon[i + 2]};
                        
                        // Calculate normal
                        Vector3 v0 = getPoint(controlPoints, triangle[0]);
                        Vector3 v1 = getPoint(controlPoints, triangle[1]);
                        Vector3 v2 = getPoint(controlPoints, triangle[2]);
                        
                        Vector3 edge1 = Vector3.sub(v1, v0);
                        Vector3 edge2 = Vector3.sub(v2, v0);
                        Vector3 normal = edge1.cross(edge2).normalize();
                        
                        // Write normal (3 floats)
                        out.writeFloat((float)normal.x);
                        out.writeFloat((float)normal.y);
                        out.writeFloat((float)normal.z);
                        
                        // Write 3 vertices (9 floats)
                        out.writeFloat((float)v0.x);
                        out.writeFloat((float)v0.y);
                        out.writeFloat((float)v0.z);
                        out.writeFloat((float)v1.x);
                        out.writeFloat((float)v1.y);
                        out.writeFloat((float)v1.z);
                        out.writeFloat((float)v2.x);
                        out.writeFloat((float)v2.y);
                        out.writeFloat((float)v2.z);
                        
                        // Write attribute byte count (2 bytes, always 0 for STL)
                        out.writeShort(0);
                    }
                }
            }
        }
        
        private Vector3 getPoint(java.util.List<Vector4> controlPoints, int index) {
            if (index >= 0 && index < controlPoints.size()) {
                Vector4 p = controlPoints.get(index);
                return new Vector3(p.x, p.y, p.z);
            }
            return new Vector3(0, 0, 0);
        }
    }

    private static class ObjSaver {
        public void save(Scene scene, Stream stream, SaveOptions options) throws IOException {
            // TODO: implement OBJ saving
        }
    }

    private static class GltfSaver {
        public void save(Scene scene, Stream stream, SaveOptions options) throws IOException {
            // TODO: implement GLTF saving
        }
    }

    private static class FbxSaver {
        public void save(Scene scene, Stream stream, SaveOptions options) throws IOException {
            // TODO: implement FBX saving
        }
    }
}
class PdfFormat extends FileFormat {
    public PdfFormat() {
        super(FileFormatType.PDF, new Version(1, 7, 0), FileContentType.BINARY, 
              "pdf", new String[]{"pdf"}, true, true);
    }
}

class PlyFormat extends FileFormat {
    public PlyFormat() {
        super(FileFormatType.PLY, new Version(1, 0, 0), FileContentType.ASCII, 
              "ply", new String[]{"ply"}, true, true);
    }
}

class Microsoft3MFFormat extends FileFormat {
    public Microsoft3MFFormat() {
        super(FileFormatType.MICROSOFT3MF, new Version(1, 0, 0), FileContentType.BINARY, 
              "3mf", new String[]{"3mf"}, true, true);
    }
}

class RvmFormat extends FileFormat {
    public RvmFormat(FileContentType contentType) {
        super(FileFormatType.RVM, new Version(1, 0, 0), contentType, 
              "rvm", new String[]{"rvm"}, true, true);
    }
}