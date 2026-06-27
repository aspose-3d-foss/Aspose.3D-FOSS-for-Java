package com.aspose.threed;

/**
 * Factory for creating file system instances.
 * <p>
 * SaveOptions and LoadOptions will create a LocalFileSystem for default.
 * This can be a security issue in server environment.
 * Use your own FileSystemFactory to IOConfig.getFileSystemFactory() to improve server side security.
 */
public interface FileSystemFactory {
    /**
     * Creates a new file system instance.
     * @return A new file system instance
     */
    FileSystem call();
}
