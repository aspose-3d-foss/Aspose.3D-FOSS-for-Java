package com.aspose.threed;

public class TestOptions {
    public static void main(String[] args) {
        try {
            FileFormat format = FileFormat.STL_BINARY;
            System.out.println("Format: " + format);
            
            LoadOptions options = format.createLoadOptions();
            System.out.println("Options class: " + options.getClass().getName());
            System.out.println("Options: " + options);
            
            if (options instanceof StlLoadOptions) {
                StlLoadOptions stlOpts = (StlLoadOptions) options;
                System.out.println("Content type: " + stlOpts.getContentType());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
