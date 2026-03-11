package com.aspose.threed;

import java.util.*;

public class TestRegistry {
    public static void main(String[] args) {
        System.out.println("Importers registered:");
        for (IImporter importer : getImporters()) {
            System.out.println("  " + importer.getClass().getName());
        }
        
        System.out.println("\nExporters registered:");
        for (IExporter exporter : getExporters()) {
            System.out.println("  " + exporter.getClass().getName());
        }
    }
    
    private static List<IImporter> getImporters() {
        java.util.List<IImporter> list = new ArrayList<>();
        return list;
    }
    
    private static List<IExporter> getExporters() {
        java.util.List<IExporter> list = new ArrayList<>();
        return list;
    }
}
