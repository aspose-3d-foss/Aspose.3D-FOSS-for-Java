package com.aspose.threed.formats;

import com.aspose.threed.*;
import java.io.*;
import java.util.*;

public class FbxImporter implements IImporter {
    private static final Set<String> supportedExtensions = Set.of(".fbx");

    @Override
    public boolean canImport(FileFormat format) {
        if (format.getExtension().equals("fbx")) {
            return true;
        }
        return false;
    }

    @Override
    public Scene load(Stream stream, LoadOptions options) throws ImportException {
        if (!(options instanceof FbxLoadOptions)) {
            options = new FbxLoadOptions();
        }
        FbxLoadOptions fbxOptions = (FbxLoadOptions) options;

        Scene scene = new Scene();
        Node rootNode = scene.getRootNode();

        try {
            byte[] content = readAllBytes(stream);
            
            if (content.length < 27) {
                throw new ImportException("FBX file too short");
            }

            String magic = new String(content, 0, 18, "ASCII");
            if (!magic.startsWith("Kaydara FBX")) {
                throw new ImportException("Invalid FBX file magic");
            }

            if (isBinaryFbx(content)) {
                return loadBinaryFbx(content, fbxOptions, scene, rootNode);
            } else {
                throw new ImportException("ASCII FBX format not yet supported - only binary FBX is supported");
            }
        } catch (IOException e) {
            throw new ImportException("Failed to read FBX file", e);
        }
    }

    private boolean isBinaryFbx(byte[] content) {
        String magic = new String(content, 0, 18);
        return magic.startsWith("Kaydara FBX Binary");
    }

    private Scene loadBinaryFbx(byte[] content, FbxLoadOptions options, Scene scene, Node rootNode) throws ImportException {
        try {
            if (content.length < 27) {
                throw new ImportException("Binary FBX file too short");
            }

            int cursor = 18;
            cursor += 5;

            int version = readUint32(content, cursor);
            cursor += 4;

            boolean is64bit = version >= 7500;

            Map<Integer, Object> objectMap = new HashMap<>();
            parseScope(content, cursor, 0, objectMap, scene, rootNode);

            return scene;

        } catch (Exception e) {
            throw new ImportException("Failed to parse binary FBX", e);
        }
    }

    private int parseScope(byte[] content, int cursor, int scopeEnd, Map<Integer, Object> objectMap, Scene scene, Node rootNode) throws IOException {
        while (cursor < scopeEnd) {
            long endOffset = is64bit(content, cursor) ? readUint64(content, cursor) : readUint32(content, cursor);
            if (endOffset == 0) break;
            if (endOffset > content.length) throw new IOException("Block offset out of range");

            cursor += is64bit(content, cursor) ? 8 : 4;

            long propCount = is64bit(content, cursor) ? readUint64(content, cursor) : readUint32(content, cursor);
            cursor += is64bit(content, cursor) ? 8 : 4;

            long propLength = is64bit(content, cursor) ? readUint64(content, cursor) : readUint32(content, cursor);
            cursor += is64bit(content, cursor) ? 8 : 4;

            String name = readString(content, cursor);
            cursor += 1 + name.length();

            int beginCursor = cursor;
            List<Object> properties = new ArrayList<>();

            for (int i = 0; i < propCount; i++) {
                Object value = readData(content, cursor, beginCursor + (int)propLength);
                properties.add(value);
                cursor += getEncodedLength(value);
            }

            if (cursor - beginCursor != propLength) {
                throw new IOException("Property length not reached");
            }

            int sentinelLength = is64bit(content, cursor) ? 25 : 13;

            if (cursor < endOffset - sentinelLength) {
                List<Object> children = new ArrayList<>();
                int childEnd = (int)(endOffset - sentinelLength);
                
                while (cursor < childEnd) {
                    cursor = parseScope(content, cursor, childEnd, objectMap, scene, rootNode);
                }

                cursor = (int)endOffset;

                if (cursor < content.length) {
                    cursor += sentinelLength;
                }
            } else {
                cursor = (int)endOffset;
            }
        }

        return cursor;
    }

    private boolean is64bit(byte[] content, int cursor) {
        return true;
    }

    private Object readData(byte[] content, int cursor, int limit) throws IOException {
        if (cursor >= content.length) throw new EOFException();

        byte type = content[cursor++];
        int startCursor = cursor - 1;

        if (type == 'Y') {
            cursor += 2;
            return readInt16(content, cursor - 2);
        } else if (type == 'C') {
            return content[cursor++] != 0;
        } else if (type == 'I') {
            int value = readInt32(content, cursor);
            cursor += 4;
            return value;
        } else if (type == 'F') {
            float value = readFloat32(content, cursor);
            cursor += 4;
            return value;
        } else if (type == 'D') {
            double value = readFloat64(content, cursor);
            cursor += 8;
            return value;
        } else if (type == 'L') {
            long value = readInt64(content, cursor);
            cursor += 8;
            return value;
        } else if (type == 'S') {
            int length = readUint32(content, cursor);
            cursor += 4;
            String value = readString(content, cursor);
            cursor += length;
            return value;
        } else if (type == 'R') {
            int length = readUint32(content, cursor);
            cursor += 4;
            byte[] value = new byte[length];
            System.arraycopy(content, cursor, value, 0, length);
            cursor += length;
            return value;
        } else if (type == 'f' || type == 'd' || type == 'i' || type == 'l' || type == 'c') {
            int length = readUint32(content, cursor);
            cursor += 4;
            int encoding = readUint32(content, cursor);
            cursor += 4;
            int compLen = readUint32(content, cursor);
            cursor += 4;

            byte[] arrayData = new byte[compLen];
            System.arraycopy(content, cursor, arrayData, 0, compLen);
            cursor += compLen;

            if (encoding == 0) {
                int stride = type == 'f' || type == 'i' ? 4 : (type == 'd' || type == 'l' ? 8 : 1);
                int expected = length * stride;

                if (type == 'f') {
                    float[] values = new float[length];
                    for (int i = 0; i < length; i++) {
                        values[i] = readFloat32(arrayData, i * 4);
                    }
                    return values;
                } else if (type == 'd') {
                    double[] values = new double[length];
                    for (int i = 0; i < length; i++) {
                        values[i] = readFloat64(arrayData, i * 8);
                    }
                    return values;
                } else if (type == 'i') {
                    int[] values = new int[length];
                    for (int i = 0; i < length; i++) {
                        values[i] = readInt32(arrayData, i * 4);
                    }
                    return values;
                } else if (type == 'l') {
                    long[] values = new long[length];
                    for (int i = 0; i < length; i++) {
                        values[i] = readInt64(arrayData, i * 8);
                    }
                    return values;
                } else if (type == 'c') {
                    return arrayData;
                }
            } else if (encoding == 1) {
                throw new IOException("Compressed FBX data not supported");
            }
        }

        return null;
    }

    private int getEncodedLength(Object value) {
        if (value instanceof Number) return 8;
        if (value instanceof Boolean) return 2;
        if (value instanceof String) {
            String s = (String) value;
            return 1 + (s.length() > 255 ? 4 : 1) + s.length();
        }
        if (value instanceof int[]) {
            int[] arr = (int[]) value;
            return 4 + 4 + 4 + arr.length * 4;
        }
        if (value instanceof float[]) {
            float[] arr = (float[]) value;
            return 4 + 4 + 4 + arr.length * 4;
        }
        return 8;
    }

    private int readUint32(byte[] data, int offset) {
        return (data[offset] & 0xFF) |
               ((data[offset + 1] & 0xFF) << 8) |
               ((data[offset + 2] & 0xFF) << 16) |
               ((data[offset + 3] & 0xFF) << 24);
    }

    private long readUint64(byte[] data, int offset) {
        long lo = readUint32(data, offset) & 0xFFFFFFFFL;
        long hi = readUint32(data, offset + 4) & 0xFFFFFFFFL;
        return lo | (hi << 32);
    }

    private int readInt16(byte[] data, int offset) {
        return (data[offset] & 0xFF) | ((data[offset + 1] & 0xFF) << 8);
    }

    private int readInt32(byte[] data, int offset) {
        return (data[offset] & 0xFF) |
               ((data[offset + 1] & 0xFF) << 8) |
               ((data[offset + 2] & 0xFF) << 16) |
               ((data[offset + 3] & 0xFF) << 24);
    }

    private long readInt64(byte[] data, int offset) {
        long lo = readInt32(data, offset) & 0xFFFFFFFFL;
        long hi = readInt32(data, offset + 4) & 0xFFFFFFFFL;
        return lo | (hi << 32);
    }

    private float readFloat32(byte[] data, int offset) {
        int bits = readInt32(data, offset);
        return Float.intBitsToFloat(bits);
    }

    private double readFloat64(byte[] data, int offset) {
        long bits = readInt64(data, offset);
        return Double.longBitsToDouble(bits);
    }

    private String readString(byte[] data, int offset) {
        int length = data[offset] & 0xFF;
        if (length == 0xFF) {
            length = readUint32(data, offset + 1);
            offset += 4;
        }
        return new String(data, offset + 1, length);
    }

    private byte[] readAllBytes(Stream stream) throws IOException {
        java.io.InputStream in = stream.getInputStream();
        if (in == null) {
            throw new IOException("Stream not readable");
        }
        
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        byte[] buffer = new byte[8192];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1) {
            baos.write(buffer, 0, bytesRead);
        }
        return baos.toByteArray();
    }
}
