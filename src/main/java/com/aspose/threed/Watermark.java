package com.aspose.threed;

import java.io.IOException;

/**
 * Utility to encode/decode blind watermark to/from a mesh.
 * 
 * Remarks:
 *   Both Watermark and Watermark will perform license check
 *   Trial usage will throw exception, you can use TrialException.getSuppressTrialException() to suppress the exception, but it will not lift the restriction here.
 *   A valid license is required to use these features without any restrictions.
 */
public class Watermark {

    /**
     * Default constructor.
     */
    public Watermark() {
    }

    /**
     * Encode a text into mesh's blind watermark.
     * @param input Mesh to encode a blind watermark
     * @param text Text to encode to the mesh
     * @return A new mesh instance with blind watermark encoded
     */
    public static Mesh encodeWatermark(Mesh input, String text) throws IOException {
        throw new NotImplementedException();
    }

    /**
     * Encode a text into mesh's blind watermark.
     * @param input Mesh to encode a blind watermark
     * @param text Text to encode to the mesh
     * @param password Password to protect the watermark, it's optional
     * @return A new mesh instance with blind watermark encoded
     */
    public static Mesh encodeWatermark(Mesh input, String text, String password) throws IOException {
        throw new NotImplementedException();
    }

    /**
     * Encode a text into mesh's blind watermark.
     * @param input Mesh to encode a blind watermark
     * @param text Text to encode to the mesh
     * @param password Password to protect the watermark, it's optional
     * @param permanent The permanent watermark will not be overwritten or removed.
     * @return A new mesh instance with blind watermark encoded
     */
    public static Mesh encodeWatermark(Mesh input, String text, String password, boolean permanent) throws IOException {
        throw new NotImplementedException();
    }

    /**
     * Decode the watermark from a mesh.
     * @param input The mesh to extract watermark
     * @return Blind watermark or null if no watermark decoded.
     */
    public static String decodeWatermark(Mesh input) {
        throw new NotImplementedException();
    }

    /**
     * Decode the watermark from a mesh.
     * @param input The mesh to extract watermark
     * @param password The password to decrypt the watermark
     * @return Blind watermark or null if no watermark decoded.
     */
    public static String decodeWatermark(Mesh input, String password) {
        throw new NotImplementedException();
    }
}
