package com.aspose.threed;

import java.io.*;

/**
 * Created by lexchou on 12/14/2016.
 */
public abstract class Stream implements java.io.Closeable {
    public static final int SEEK_SET = 0;
    public static final int SEEK_CURRENT = 1;
    public static final int SEEK_END = 2;

    public abstract int readByte() throws java.io.IOException;
    public abstract int read(byte[] buf) throws java.io.IOException;
    public abstract int read(byte[] buf, int start, int len) throws java.io.IOException;
    public abstract void write(byte[] buf) throws java.io.IOException;
    public abstract void write(byte[] buf, int start, int len) throws java.io.IOException;
    public abstract void writeByte(int b) throws java.io.IOException;
    public abstract long seek(long offset, int seek) throws java.io.IOException;
    public abstract void copyTo(Stream output) throws java.io.IOException;
    public abstract void close() throws java.io.IOException;
    public abstract void flush() throws java.io.IOException;
    public abstract long getLength() throws java.io.IOException;
    public abstract void setLength(long len) throws java.io.IOException;
    public abstract java.io.InputStream getInputStream();
    public abstract java.io.OutputStream getOutputStream();

    protected Stream() {
    }

    /**
     * Wrap an OutputStream as Stream, the stream must be closed to flush data to output stream.
     * @param stream output stream to wrap
     * @return wrapped Stream instance
     */
    public static Stream wrap(OutputStream stream) {
        return new OutputStreamWrapper(stream);
    }

    /**
     * Wrap an InputStream as Stream.
     * @param stream Input stream to wrap
     * @return Wrapped Stream instance
     * @throws java.io.IOException
     */
    public static Stream wrap(InputStream stream) throws java.io.IOException {
        return new InputStreamWrapper(stream);
    }

    private static class OutputStreamWrapper extends Stream {
        private final OutputStream outputStream;

        OutputStreamWrapper(OutputStream outputStream) {
            this.outputStream = outputStream;
        }

        @Override
        public int readByte() throws java.io.IOException {
            throw new IOException("Stream is write-only");
        }

        @Override
        public int read(byte[] buf) throws java.io.IOException {
            throw new IOException("Stream is write-only");
        }

        @Override
        public int read(byte[] buf, int start, int len) throws java.io.IOException {
            throw new IOException("Stream is write-only");
        }

        @Override
        public void write(byte[] buf) throws java.io.IOException {
            outputStream.write(buf);
        }

        @Override
        public void write(byte[] buf, int start, int len) throws java.io.IOException {
            outputStream.write(buf, start, len);
        }

        @Override
        public void writeByte(int b) throws java.io.IOException {
            outputStream.write(b);
        }

        @Override
        public long seek(long offset, int seek) throws java.io.IOException {
            throw new IOException("Stream does not support seeking");
        }

        @Override
        public void copyTo(Stream output) throws java.io.IOException {
            // This is a write-only stream, cannot copy
        }

        @Override
        public void close() throws java.io.IOException {
            outputStream.close();
        }

        @Override
        public void flush() throws java.io.IOException {
            outputStream.flush();
        }

        @Override
        public long getLength() throws java.io.IOException {
            throw new IOException("Stream does not support getLength");
        }

        @Override
        public void setLength(long len) throws java.io.IOException {
            throw new IOException("Stream does not support setLength");
        }

        @Override
        public java.io.InputStream getInputStream() {
            return null;
        }

        @Override
        public java.io.OutputStream getOutputStream() {
            return outputStream;
        }
    }

    private static class InputStreamWrapper extends Stream {
        private final InputStream inputStream;

        InputStreamWrapper(InputStream inputStream) throws java.io.IOException {
            this.inputStream = inputStream;
        }

        @Override
        public int readByte() throws java.io.IOException {
            return inputStream.read();
        }

        @Override
        public int read(byte[] buf) throws java.io.IOException {
            return inputStream.read(buf);
        }

        @Override
        public int read(byte[] buf, int start, int len) throws java.io.IOException {
            return inputStream.read(buf, start, len);
        }

        @Override
        public void write(byte[] buf) throws java.io.IOException {
            throw new IOException("Stream is read-only");
        }

        @Override
        public void write(byte[] buf, int start, int len) throws java.io.IOException {
            throw new IOException("Stream is read-only");
        }

        @Override
        public void writeByte(int b) throws java.io.IOException {
            throw new IOException("Stream is read-only");
        }

        @Override
        public long seek(long offset, int seek) throws java.io.IOException {
            throw new IOException("Stream does not support seeking");
        }

        @Override
        public void copyTo(Stream output) throws java.io.IOException {
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
        }

        @Override
        public void close() throws java.io.IOException {
            inputStream.close();
        }

        @Override
        public void flush() throws java.io.IOException {
            // No-op for read-only stream
        }

        @Override
        public long getLength() throws java.io.IOException {
            throw new IOException("Stream does not support getLength");
        }

        @Override
        public void setLength(long len) throws java.io.IOException {
            throw new IOException("Stream does not support setLength");
        }

        @Override
        public java.io.InputStream getInputStream() {
            return inputStream;
        }

        @Override
        public java.io.OutputStream getOutputStream() {
            return null;
        }
    }
}
