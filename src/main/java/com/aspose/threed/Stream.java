package com.aspose.threed;

import java.io.*;

public class Stream extends FilterInputStream {
    private OutputStream outputStream;

    public Stream(InputStream in) {
        super(in);
    }

    public Stream(OutputStream out) {
        super(null);
        this.outputStream = out;
    }

    public void flush() throws IOException {
        if (outputStream != null) {
            outputStream.flush();
        }
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }
    
    public java.io.InputStream getInputStream() {
        return (java.io.InputStream) in;
    }
    
    /**
     * Writes a byte to the stream.
     * @param b The byte to write
     * @throws java.io.IOException if an I/O error occurs
     */
    public void writeByte(int b) throws java.io.IOException {
        if (outputStream != null) {
            outputStream.write(b);
        }
    }
    
    /**
     * Writes bytes to the stream.
     * @param buf The buffer to write
     * @throws java.io.IOException if an I/O error occurs
     */
    public void write(byte[] buf) throws java.io.IOException {
        if (outputStream != null) {
            outputStream.write(buf);
        }
    }
    
    /**
     * Writes bytes to the stream.
     * @param buf The buffer to write
     * @param start The start index
     * @param len The number of bytes to write
     * @throws java.io.IOException if an I/O error occurs
     */
    public void write(byte[] buf, int start, int len) throws java.io.IOException {
        if (outputStream != null) {
            outputStream.write(buf, start, len);
        }
    }

    /**
     * Wrap an InputStream as Stream.
     * @param stream Input stream to wrap
     * @return Wrapped Stream instance
     * @throws java.io.IOException
     */
    public static Stream wrap(InputStream stream) throws java.io.IOException {
        return new Stream(stream);
    }

    /**
     * Wrap an OutputStream as Stream, the stream must be closed to flush data to output stream.
     * @param stream Output stream to wrap
     * @return Wrapped Stream instance
     */
    public static Stream wrap(OutputStream stream) {
        return new Stream(stream);
    }
}
