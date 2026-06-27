package com.aspose.threed;

import java.io.*;

/**
 * File stream for reading and writing files.
 */
public class FileStream extends Stream {
    public static final int CREATE = 0;
    public static final int OPEN = 1;
    public static final int APPEND = 2;
    public static final int READ = 3;
    public static final int WRITE = 4;
    public static final int READ_WRITE = 5;
    
    private RandomAccessFile file;
    private int fileMode;
    private int fileAccess;
    
    /**
     * Creates a new file stream.
     * @param fileName The file name
     * @param fileMode The file mode
     * @param fileAccess The file access
     * @throws java.io.IOException if an I/O error occurs
     */
    public FileStream(String fileName, int fileMode, int fileAccess) throws java.io.IOException {
        super((InputStream) null);
        this.fileMode = fileMode;
        this.fileAccess = fileAccess;
        this.file = new RandomAccessFile(fileName, fileAccess == READ ? "r" : "rw");
    }
    
    /**
     * Creates a new file stream.
     * @param fileName The file name
     * @param fileMode The file mode
     * @throws java.io.IOException if an I/O error occurs
     */
    public FileStream(String fileName, int fileMode) throws java.io.IOException {
        this(fileName, fileMode, READ_WRITE);
    }
    
    /**
     * Gets the length of the file.
     * @return The length of the file
     * @throws java.io.IOException if an I/O error occurs
     */
    public long getLength() throws java.io.IOException {
        return file.length();
    }
    
    /**
     * Sets the length of the file.
     * @param len The new length
     * @throws java.io.IOException if an I/O error occurs
     */
    public void setLength(long len) throws java.io.IOException {
        file.setLength(len);
    }
    
    /**
     * Reads a byte from the file.
     * @return The byte read, or -1 if end of file
     * @throws java.io.IOException if an I/O error occurs
     */
    public int readByte() throws java.io.IOException {
        return file.read();
    }
    
    /**
     * Reads bytes from the file.
     * @param buf The buffer to read into
     * @return The number of bytes read
     * @throws java.io.IOException if an I/O error occurs
     */
    public int read(byte[] buf) throws java.io.IOException {
        return file.read(buf);
    }
    
    /**
     * Reads bytes from the file.
     * @param buf The buffer to read into
     * @param start The start index
     * @param len The number of bytes to read
     * @return The number of bytes read
     * @throws java.io.IOException if an I/O error occurs
     */
    public int read(byte[] buf, int start, int len) throws java.io.IOException {
        return file.read(buf, start, len);
    }
    
    /**
     * Writes bytes to the file.
     * @param buf The buffer to write
     * @throws java.io.IOException if an I/O error occurs
     */
    public void write(byte[] buf) throws java.io.IOException {
        file.write(buf);
    }
    
    /**
     * Writes bytes to the file.
     * @param buf The buffer to write
     * @param start The start index
     * @param len The number of bytes to write
     * @throws java.io.IOException if an I/O error occurs
     */
    public void write(byte[] buf, int start, int len) throws java.io.IOException {
        file.write(buf, start, len);
    }
    
    /**
     * Writes a byte to the file.
     * @param b The byte to write
     * @throws java.io.IOException if an I/O error occurs
     */
    public void writeByte(int b) throws java.io.IOException {
        file.write(b);
    }
    
    /**
     * Seeks to a position in the file.
     * @param offset The offset to seek to
     * @param seek The seek origin (0=begin, 1=current, 2=end)
     * @return The new position
     * @throws java.io.IOException if an I/O error occurs
     */
    public long seek(long offset, int seek) throws java.io.IOException {
        long pos;
        switch (seek) {
            case 0: // SEEK_SET
                pos = offset;
                break;
            case 1: // SEEK_CUR
                pos = file.getFilePointer() + offset;
                break;
            case 2: // SEEK_END
                pos = file.length() + offset;
                break;
            default:
                throw new java.io.IOException("Invalid seek origin");
        }
        file.seek(pos);
        return file.getFilePointer();
    }
    
    /**
     * Closes the file stream.
     * @throws java.io.IOException if an I/O error occurs
     */
    public void close() throws java.io.IOException {
        file.close();
    }
    
    /**
     * Flushes the file stream.
     * @throws java.io.IOException if an I/O error occurs
     */
    public void flush() throws java.io.IOException {
        file.getChannel().force(true);
    }
}
