package com.aspose.threed;

import java.lang.reflect.*;

public class TestDebugRegistry {
    public static void main(String[] args) {
        try {
            Class<?> registry = Class.forName("com.aspose.threed.PluginRegistry");
           	Field importersField = registry.getDeclaredField("importers");
            importersField.setAccessible(true);
            
            java.util.List<?> importers = (java.util.List<?>) importersField.get(null);
            
            System.out.println("Importers in registry:");
            for (Object importer : importers) {
                System.out.println("  " + importer.getClass().getName());
            }
            
            System.out.println("\nExporters in registry:");
           	Field exportersField = registry.getDeclaredField("exporters");
            exportersField.setAccessible(true);
            
            java.util.List<?> exporters = (java.util.List<?>) exportersField.get(null);
            
            for (Object exporter : exporters) {
                System.out.println("  " + exporter.getClass().getName());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
