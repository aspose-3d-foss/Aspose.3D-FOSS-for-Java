# .NET FOSS to Java FOSS Directory Structure Mapping

## Summary

The Java FOSS uses a Maven source layout that matches the Java On-Premise API.
All classes use the `com.aspose.threed` package structure, with only core classes
in the root package and format-specific classes in subpackages.

## Mapping

| .NET FOSS Namespace | Java Source Location | Status |
|---------------------|---------------------|--------|
| Aspose.ThreeD | src/main/java/com/aspose/threed/ | ✅ Implemented |
| Aspose.ThreeD.Utilities | *NOT IMPLEMENTED* | ⚠️ Should be stubs only |
| Aspose.ThreeD.Formats | src/formats/java/com/aspose/threed/formats/ | ✅ Implemented |
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
  formats/java/                           # Aspose.ThreeD.Formats namespace
    com/aspose/threed/formats/
      *.java                              # Format-specific classes
  test/java/                              # All test classes
    com/aspose/threed/
      *.java                              # Test classes
```

## Notes

1. The Java FOSS uses Maven source layout
2. All public classes use `package com.aspose.threed.*` regardless of disk location
3. The shading classes from .NET FOSS are now in the root namespace in Java
4. When porting new classes from .NET FOSS, place them in appropriate folders
5. All license/trial/DRM functionality should throw `UnsupportedOperationException`
6. Rendering classes (Scene.render) are stubbed per FOSS policy
7. See `pom.xml` for the build-helper configuration of source roots

## Java Package Structure

All public classes use: `package com.aspose.threed.*`

The directory structure on disk maps to .NET FOSS namespaces:
- Root namespace → `src/main/java/com/aspose/threed/`
- Formats namespace → `src/formats/java/com/aspose/threed/formats/`
