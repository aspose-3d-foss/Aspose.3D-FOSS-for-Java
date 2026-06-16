package com.aspose.threed;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * File system encapsulation.
 * Aspose.3D will use this to read/write dependencies.
 */
public abstract class FileSystem implements AutoCloseable {
    private boolean disposed = false;

    @Override
    public void close() {
        if (!disposed) {
            dispose(true);
            disposed = true;
        }
    }

    protected void finalize() throws Throwable {
        if (!disposed) {
            dispose(false);
        }
        super.finalize();
    }

    protected void dispose(boolean disposing) {
    }

    /**
     * Create a stream for reading dependencies.
     * @param fileName The file name to read
     * @param options The IO configuration
     * @return A stream for reading the file
     */
    public abstract InputStream readFile(String fileName, IOConfig options);

    /**
     * Create a stream for writing dependencies.
     * @param fileName The file name to write
     * @param options The IO configuration
     * @return A stream for writing the file
     */
    public abstract OutputStream writeFile(String fileName, IOConfig options);

    /**
     * Initialize a new FileSystem that only access local directory.
     * All file read/write on this FileSystem instance will be mapped to specified directory.
     * @param directory The directory to access
     * @return A local file system
     */
    public static LocalFileSystem createLocalFileSystem(String directory) {
        return new LocalFileSystem(directory);
    }

    /**
     * Initialize a new FileSystem from a dictionary of memory streams.
     * @param files Dictionary of file names to memory streams
     * @return A memory file system
     */
    public static MemoryFileSystem createMemoryFileSystem(Map<String, ByteArrayOutputStream> files) {
        return new MemoryFileSystem(files);
    }

    /**
     * Create a dummy file system, read/write operations are dummy operations.
     * @return A dummy file system
     */
    public static DummyFileSystem createDummyFileSystem() {
        return new DummyFileSystem();
    }

    public static class LocalFileSystem extends FileSystem {
        private final String directory;

        public LocalFileSystem(String directory) {
            this.directory = directory;
        }

        @Override
        public InputStream readFile(String fileName, IOConfig options) {
            // For now, return empty stream
            return new ByteArrayInputStream(new byte[0]);
        }

        @Override
        public OutputStream writeFile(String fileName, IOConfig options) {
            // For now, return empty stream
            return new ByteArrayOutputStream();
        }
    }

    public static class MemoryFileSystem extends FileSystem {
        private final Map<String, ByteArrayOutputStream> files;

        public MemoryFileSystem(Map<String, ByteArrayOutputStream> files) {
            this.files = files != null ? files : new HashMap<>();
        }

        @Override
        public InputStream readFile(String fileName, IOConfig options) {
            ByteArrayOutputStream stream = files.get(fileName);
            if (stream != null) {
                return new ByteArrayInputStream(stream.toByteArray());
            }
            return new ByteArrayInputStream(new byte[0]);
        }

        @Override
        public OutputStream writeFile(String fileName, IOConfig options) {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            files.put(fileName, stream);
            return stream;
        }
    }

    public static class DummyFileSystem extends FileSystem {
        @Override
        public InputStream readFile(String fileName, IOConfig options) {
            return new ByteArrayInputStream(new byte[0]);
        }

        @Override
        public OutputStream writeFile(String fileName, IOConfig options) {
            return new ByteArrayOutputStream();
        }
    }
}
