# .NET FOSS to Java FOSS Directory Structure Mapping

## Summary

The Java FOSS uses a Maven source layout that matches the Java On-Premise API.
All classes use the `com.aspose.threed` package structure in a single source root.

## Mapping

| .NET FOSS Namespace | Java Source Location | Status |
|---------------------|---------------------|--------|
| Aspose.ThreeD | src/main/java/com/aspose/threed/ | ✅ Implemented |
| Aspose.ThreeD.Utilities | *NOT IMPLEMENTED* | ⚠️ Should be stubs only |
| Aspose.ThreeD.Formats | src/main/java/com/aspose/threed/ | ✅ Implemented (no subpackage) |
| Aspose.ThreeD.Formats.FBX | *NOT IMPLEMENTED* | ⚠️ Should be stubs only |
| Aspose.ThreeD.Formats.OBJ | *NOT IMPLEMENTED* | ⚠️ Should be stubs only |
| Aspose.ThreeD.Formats.STL | *NOT IMPLEMENTED* | ⚠️ Should be stubs only |
| Aspose.ThreeD.Formats.GLTF | *NOT IMPLEMENTED* | ⚠️ Should be stubs only |
| Aspose.ThreeD.Formats.Collada | *NOT IMPLEMENTED* | ⚠️ Should be stubs only |
| Aspose.ThreeD.Formats.PLY | *NOT IMPLEMENTED* | ⚠️ Should be stubs only |
| Aspose.ThreeD.Shading | src/main/java/com/aspose/threed/ | ✅ Implemented (moved to root) |
| Aspose.ThreeD.Animation | *NOT IMPLEMENTED* | ⚠️ Should be stubs only |
| Aspose.ThreeD.Entities | *NOT IMPLEMENTED* | ⚠️ Should be stubs only |
| Aspose.ThreeD.Profiles | *NOT IMPLEMENTED* | ⚠️ Should be stubs only |
| Aspose.ThreeD.Render | *NOT IMPLEMENTED* | ⚠️ Should be stubs only |

## Current Java Structure (Maven)

```
src/
  main/java/                              # Root namespace (com.aspose.threed)
    com/aspose/threed/
      *.java                              # All classes (no subpackages)
      *.java                              # Core classes (Node, Scene, Entity, etc.)
      Material.java                       # Material base class
      TextureBase.java                    # Texture base class
      TextureSlot.java                    # Texture slot
      Texture.java                        # Texture class
      AlphaSource.java                    # Alpha source enum
      TextureFilter.java                  # Texture filter enum
      WrapMode.java                       # Wrap mode enum
      LambertMaterial.java                # Lambert material
      PhongMaterial.java                  # Phong material
      PbrMaterial.java                    # PBR material
      FbxExporter.java                    # Format exporter (no subpackage)
      GltfImporter.java                   # Format importer (no subpackage)
  formats/                                # DEPRECATED - removed
  test/java/                              # All test classes
    com/aspose/threed/
      *.java                              # Test classes
```

## Notes

1. The Java FOSS uses Maven source layout with a single source root
2. All public classes use `package com.aspose.threed.*` (no subpackages)
3. Format-specific classes (FbxExporter, GltfImporter, etc.) are in root namespace
4. When porting new classes from .NET FOSS, place them in `src/main/java/com/aspose/threed/`
5. All license/trial/DRM functionality should throw `UnsupportedOperationException`
6. Rendering classes (Scene.render) are stubbed per FOSS policy
7. The `src/formats/java/` directory and build-helper configuration have been removed

## Java Package Structure

All public classes use: `package com.aspose.threed.*`

The directory structure on disk maps to .NET FOSS namespaces:
- Root namespace → `src/main/java/com/aspose/threed/`
- **Note:** All classes including formats are in the root namespace (no subpackages)
