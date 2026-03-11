package com.aspose.threed;

public class TestFileFormat {
    public static void main(String[] args) {
        System.out.println("Testing FileFormat detection...");
        
        FileFormat objFormat = FileFormat.WAVEFRONTOBJ;
        System.out.println("OBJ format: " + objFormat);
        System.out.println("Can import: " + objFormat.getCanImport());
        System.out.println("Can export: " + objFormat.getCanExport());
        
        FileFormat detected = FileFormat.getFormatByExtension(".obj");
        System.out.println("\nDetected format for .obj: " + detected);
        
        detected = FileFormat.getFormatByExtension("obj");
        System.out.println("Detected format for obj (no dot): " + detected);
        
        detected = FileFormat.getFormatByExtension("/path/to/test.obj");
        System.out.println("Detected format for /path/to/test.obj: " + detected);
        
        System.out.println("\nAll formats:");
        for (FileFormat fmt : FileFormat.getFormats()) {
            if (fmt.getCanImport()) {
                System.out.println("  " + fmt + " - importable");
            }
        }
    }
}
