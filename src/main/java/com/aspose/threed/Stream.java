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
}
