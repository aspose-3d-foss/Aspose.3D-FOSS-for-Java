package com.aspose.threed;

import java.io.IOException;

/**
 * Google Draco format
 * 
 * Example:
 *          The following code shows how to encode and decode a Mesh to/from byte array:
 * 
 *              Mesh mesh = (new Sphere()).toMesh();
 *              //encode mesh into Draco format
 *              byte[] draco = FileFormat.DRACO.encode(mesh);
 *              //decode mesh from Draco format
 *              Mesh decodedMesh = (Mesh)FileFormat.DRACO.decode(draco);
 */
public class DracoFormat extends FileFormat {
    /**
     * Constructs a new DracoFormat instance.
     */
    public DracoFormat() {
        super(FileFormatType.DRACO, new Version(1, 0, 0), FileContentType.BINARY, 
              "drc", new String[]{"drc"}, true, true);
    }
    
    /**
     * Decode the point cloud or mesh from specified file name.
     * @param fileName The file name contains the drc file
     * @return A Mesh or PointCloud instance depends on the file content
     * @throws IOException if an I/O error occurs
     */
    public Geometry decode(String fileName) throws IOException {
        throw new UnsupportedOperationException("Draco decoding not implemented in FOSS version");
    }
    
    /**
     * Decode the point cloud or mesh from memory data.
     * @param data The raw drc bytes
     * @return A Mesh or PointCloud instance depends on the content
     * @throws ImportException if an import error occurs
     */
    public Geometry decode(byte[] data) throws ImportException {
        throw new UnsupportedOperationException("Draco decoding not implemented in FOSS version");
    }
    
    /**
     * Encode the entity to specified stream.
     * @param entity The entity to be encoded
     * @param stream The stream that encoded data will be written to
     * @param options Extra options for encoding the point cloud
     * @throws IOException if an I/O error occurs
     */
    public void encode(Entity entity, Stream stream, DracoSaveOptions options) throws IOException {
        throw new UnsupportedOperationException("Draco encoding not implemented in FOSS version");
    }
    
    /**
     * Encode the entity to specified stream.
     * @param entity The entity to be encoded
     * @param stream The stream that encoded data will be written to
     * @throws IOException if an I/O error occurs
     */
    public void encode(Entity entity, Stream stream) throws IOException {
        throw new UnsupportedOperationException("Draco encoding not implemented in FOSS version");
    }
    
    /**
     * Encode the entity to specified file.
     * @param entity The entity to be encoded
     * @param fileName The file name to be written
     * @param options Extra options for encoding the point cloud
     * @throws IOException if an I/O error occurs
     */
    public void encode(Entity entity, String fileName, DracoSaveOptions options) throws IOException {
        throw new UnsupportedOperationException("Draco encoding not implemented in FOSS version");
    }
    
    /**
     * Encode the entity to specified file.
     * @param entity The entity to be encoded
     * @param fileName The file name to be written
     * @throws IOException if an I/O error occurs
     */
    public void encode(Entity entity, String fileName) throws IOException {
        throw new UnsupportedOperationException("Draco encoding not implemented in FOSS version");
    }
    
    /**
     * Encode the entity to Draco raw data.
     * @param entity The entity to be encoded
     * @param options Extra options for encoding the point cloud
     * @return The encoded draco data represented in bytes
     */
    public byte[] encode(Entity entity, DracoSaveOptions options) throws ImportException {
        throw new UnsupportedOperationException("Draco encoding not implemented in FOSS version");
    }
    
    /**
     * Encode the entity to Draco raw data.
     * @param entity The entity to be encoded
     * @return The encoded draco data represented in bytes
     */
    public byte[] encode(Entity entity) throws ImportException {
        throw new UnsupportedOperationException("Draco encoding not implemented in FOSS version");
    }
}
