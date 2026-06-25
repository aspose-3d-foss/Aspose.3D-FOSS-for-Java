package com.aspose.threed;

/**
 * Options for PDF loading.
 */
public class PdfLoadOptions extends LoadOptions {
    private byte[] password;

    /**
     * Constructor of PdfLoadOptions.
     */
    public PdfLoadOptions() {
    }

    /**
     * Gets the password to unlock the encrypted PDF file.
     * @return the password to unlock the encrypted PDF file.
     */
    public byte[] getPassword() {
        return password;
    }

    /**
     * Sets the password to unlock the encrypted PDF file.
     * @param value New value.
     */
    public void setPassword(byte[] value) {
        this.password = value;
    }
}
