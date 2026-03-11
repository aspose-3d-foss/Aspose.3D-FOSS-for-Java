package com.aspose.threed;

import java.nio.file.*;
import java.io.*;

public class TestStreamRead {
    public static void main(String[] args) {
        try {
            String stlPath = args.length > 0 ? args[0] : "../testdata/input/stl_binary.stl";
            
            InputStream fis = new FileInputStream(stlPath);
            Stream stream = new Stream(fis);
            
            byte[] header = new byte[80];
            int r1 = stream.read(header);
            System.out.println("Read header: " + r1 + " bytes");
            
            byte[] faceCountBytes = new byte[4];
            int r2 = stream.read(faceCountBytes);
            System.out.println("Read face count: " + r2 + " bytes");
            
            int fc = (faceCountBytes[3] & 0xFF) << 24 |
                     (faceCountBytes[2] & 0xFF) << 16 |
                     (faceCountBytes[1] & 0xFF) << 8 |
                     (faceCountBytes[0] & 0xFF);
            System.out.println("Face count: " + fc);
            
            byte[] buf = new byte[48];
            int r3 = stream.read(buf);
            System.out.println("Read first face: " + r3 + " bytes");
            
            float x = Float.intBitsToFloat(readInt(buf, 0));
            float y = Float.intBitsToFloat(readInt(buf, 4));
            float z = Float.intBitsToFloat(readInt(buf, 8));
            System.out.println("First normal: " + x + ", " + y + ", " + z);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static int readInt(byte[] b, int offset) {
        return (b[offset + 3] & 0xFF) << 24 |
               (b[offset + 2] & 0xFF) << 16 |
               (b[offset + 1] & 0xFF) << 8 |
               (b[offset] & 0xFF);
    }
}
