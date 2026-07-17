package com.aspose.threed;

/**
 * IO config for serialization/deserialization.
 *   User can specify detailed configurations like dependency look-up path
 *   Or format-related configs here
 */
public class IOConfig {
    private FileFormat fileFormat;
    private java.nio.charset.Charset encoding;
    private FileSystem fileSystem;
    private java.util.ArrayList<String> lookupPaths = new java.util.ArrayList<String>();
    private String fileName;

    /**
     * Gets the factory class for FileSystem.
     *   The default factory will create LocalFileSystem which is not suitable for server environment.
     * @return the factory class for FileSystem.
     */
    public static FileSystemFactory getFileSystemFactory() {
        return null;
    }

    /**
     * Sets the factory class for FileSystem.
     *   The default factory will create LocalFileSystem which is not suitable for server environment.
     * @param value New value.
     */
    public static void setFileSystemFactory(FileSystemFactory value) {
    }

    /**
     * Gets the file format that specified in current Save/Load option.
     * @return the file format that specified in current Save/Load option.
     */
    public FileFormat getFileFormat() {
        return fileFormat;
    }

    /**
     * Gets the default encoding for text-based files.
     *   Default value is null which means the importer/exporter will decide which encoding to use.
     * @return the default encoding for text-based files.
     */
    public java.nio.charset.Charset getEncoding() {
        return encoding;
    }

    /**
     * Sets the default encoding for text-based files.
     *   Default value is null which means the importer/exporter will decide which encoding to use.
     * @param value New value.
     */
    public void setEncoding(java.nio.charset.Charset value) {
        this.encoding = value;
    }

    /**
     * Allow user to handle how to manage the external dependencies during load/save.
     * @return the file system.
     */
    public FileSystem getFileSystem() {
        return fileSystem;
    }

    /**
     * Allow user to handle how to manage the external dependencies during load/save.
     * @param value New value.
     */
    public void setFileSystem(FileSystem value) {
        this.fileSystem = value;
    }

    /**
     * Some files like OBJ depends on external file, the lookup paths will allows Aspose.3D to look for external file to load.
     * @return the lookup paths.
     */
    public java.util.ArrayList<String> getLookupPaths() {
        return lookupPaths;
    }

    /**
     * Some files like OBJ depends on external file, the lookup paths will allows Aspose.3D to look for external file to load.
     * @param value New value.
     */
    public void setLookupPaths(java.util.ArrayList<String> value) {
        this.lookupPaths = value;
    }

    /**
     * The file name of the exporting/importing scene.
     *   This is optional, but useful when serialize external assets like OBJ's material.
     * @return The file name.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * The file name of the exporting/importing scene.
     *   This is optional, but useful when serialize external assets like OBJ's material.
     * @param value New value.
     */
    public void setFileName(String value) {
        this.fileName = value;
    }
}
