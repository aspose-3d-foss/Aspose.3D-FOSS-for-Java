package com.aspose.threed;

import java.io.*;

/**
 * Memory stream for reading and writing data in memory.
 */
public class MemoryStream extends Stream implements AutoCloseable {
    private byte[] buffer;
    private int position;
    private int capacity;
    private int size;
    
    /**
     * Creates a new memory stream with default capacity.
     */
    public MemoryStream() {
        this(256);
    }
    
    /**
     * Creates a new memory stream with specified capacity.
     * @param capacity The initial capacity
     */
    public MemoryStream(int capacity) {
        super((OutputStream) null);
        this.capacity = capacity;
        this.buffer = new byte[capacity];
        this.position = 0;
        this.size = 0;
    }
    
    /**
     * Creates a new memory stream from existing data.
     * @param data The data to initialize the stream with
     */
    public MemoryStream(byte[] data) {
        this(data != null ? data.length : 256);
        if (data != null) {
            System.arraycopy(data, 0, buffer, 0, data.length);
            size = data.length;
            position = 0;
        }
    }
    
    /**
     * Gets the size of the data in the stream.
     * @return The size of the data
     */
    public int getSize() {
        return size;
    }
    
    /**
     * Gets the buffer.
     * @return The buffer
     */
    public byte[] getBuffer() {
        return buffer;
    }
    
    /**
     * Sets the capacity of the stream.
     * @param cap The new capacity
     */
    public void setCapacity(int cap) {
        if (cap < size) {
            cap = size;
        }
        if (cap != capacity) {
            byte[] newBuffer = new byte[cap];
            System.arraycopy(buffer, 0, newBuffer, 0, size);
            buffer = newBuffer;
            capacity = cap;
        }
    }
    
    /**
     * Gets the length of the data in the stream.
     * @return The length
     */
    public long getLength() {
        return size;
    }
    
    /**
     * Sets the length of the stream.
     * @param len The new length
     */
    public void setLength(long len) {
        if (len > capacity) {
            setCapacity((int) len);
        }
        if (len > size) {
            // Zero out the new bytes
            for (int i = size; i < len; i++) {
                buffer[i] = 0;
            }
        }
        size = (int) len;
        if (position > size) {
            position = size;
        }
    }
    
    /**
     * Flushes the stream (no-op for memory stream).
     * @throws java.io.IOException
     */
    public void flush() throws java.io.IOException {
        // No-op
    }
    
    /**
     * Reads a byte from the stream.
     * @return The byte read, or -1 if end of stream
     * @throws java.io.IOException
     */
    public int readByte() throws java.io.IOException {
        if (position >= size) {
            return -1;
        }
        return buffer[position++] & 0xFF;
    }
    
    /**
     * Reads bytes from the stream.
     * @param buf The buffer to read into
     * @return The number of bytes read
     * @throws java.io.IOException
     */
    public int read(byte[] buf) throws java.io.IOException {
        return read(buf, 0, buf.length);
    }
    
    /**
     * Reads bytes from the stream.
     * @param buf The buffer to read into
     * @param start The start index
     * @param len The number of bytes to read
     * @return The number of bytes read
     * @throws java.io.IOException
     */
    public int read(byte[] buf, int start, int len) throws java.io.IOException {
        if (position >= size) {
            return -1;
        }
        int available = size - position;
        int toRead = Math.min(len, available);
        System.arraycopy(buffer, position, buf, start, toRead);
        position += toRead;
        return toRead;
    }
    
    /**
     * Writes bytes to the stream.
     * @param buf The buffer to write
     * @throws java.io.IOException
     */
    public void write(byte[] buf) throws java.io.IOException {
        write(buf, 0, buf.length);
    }
    
    /**
     * Writes bytes to the stream.
     * @param buf The buffer to write
     * @param start The start index
     * @param len The number of bytes to write
     * @throws java.io.IOException
     */
    public void write(byte[] buf, int start, int len) throws java.io.IOException {
        if (position + len > capacity) {
            int newCapacity = Math.max(position + len, capacity * 2);
            setCapacity(newCapacity);
        }
        System.arraycopy(buf, start, buffer, position, len);
        position += len;
        if (position > size) {
            size = position;
        }
    }
    
    /**
     * Writes a byte to the stream.
     * @param b The byte to write
     * @throws java.io.IOException
     */
    public void writeByte(int b) throws java.io.IOException {
        if (position >= capacity) {
            setCapacity(Math.max(capacity * 2, 256));
        }
        buffer[position++] = (byte) b;
        if (position > size) {
            size = position;
        }
    }
    
    /**
     * Seeks to a position in the stream.
     * @param offset The offset to seek to
     * @param seek The seek origin (0=begin, 1=current, 2=end)
     * @return The new position
     * @throws java.io.IOException
     */
    public long seek(long offset, int seek) throws java.io.IOException {
        switch (seek) {
            case 0: // SEEK_SET
                position = (int) offset;
                break;
            case 1: // SEEK_CUR
                position += (int) offset;
                break;
            case 2: // SEEK_END
                position = size + (int) offset;
                break;
            default:
                throw new IOException("Invalid seek origin");
        }
        if (position < 0) {
            position = 0;
        }
        if (position > size) {
            position = size;
        }
        return position;
    }
    
    /**
     * Converts the stream to an array.
     * @return The array of bytes
     */
    public byte[] toArray() {
        byte[] result = new byte[size];
        System.arraycopy(buffer, 0, result, 0, size);
        return result;
    }
    
    /**
     * Closes the stream.
     * @throws java.io.IOException
     */
    public void close() throws java.io.IOException {
        // No-op
    }
    
    /**
     * Copies the stream content to another stream.
     * @param stream The destination stream
     * @throws java.io.IOException
     */
    public void copyTo(Stream stream) throws java.io.IOException {
        if (size > 0) {
            stream.write(buffer);
        }
    }
    
    /**
     * Copies the stream content to an output stream.
     * @param stream The destination output stream
     * @throws java.io.IOException
     */
    public void copyTo(OutputStream stream) throws java.io.IOException {
        stream.write(buffer, 0, size);
    }
}
