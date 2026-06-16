# .NET FOSS to Java FOSS Directory Structure Mapping

## Summary
The Java FOSS uses a simpler structure where all public classes are in `src/main/java/com/aspose/threed/` with subpackages for related functionality. This matches the .NET FOSS organization.

## Mapping

| .NET FOSS Namespace | Java Source Location | Status |
|---------------------|---------------------|--------|
| Aspose.ThreeD | src/main/java/com/aspose/threed/ | ✅ Implemented |
| Aspose.ThreeD.Utilities | src/main/java/com/aspose/threed/ | ✅ Implemented |
| Aspose.ThreeD.Formats | src/main/java/com/aspose/threed/formats/ | ✅ Implemented |
| Aspose.ThreeD.Formats.FBX | src/main/java/com/aspose/threed/formats/ | ✅ Implemented |
| Aspose.ThreeD.Formats.OBJ | src/main/java/com/aspose/threed/formats/ | ✅ Implemented |
| Aspose.ThreeD.Formats.STL | src/main/java/com/aspose/threed/formats/ | ✅ Implemented |
| Aspose.ThreeD.Formats.GLTF | src/main/java/com/aspose/threed/formats/ | ✅ Implemented |
| Aspose.ThreeD.Formats.Collada | src/main/java/com/aspose/threed/formats/ | ✅ Implemented |
| Aspose.ThreeD.Formats.PLY | src/main/java/com/aspose/threed/formats/ | ✅ Implemented |
| Aspose.ThreeD.Shading | src/main/java/com/aspose/threed/shading/ | ✅ Implemented |
| Aspose.ThreeD.Animation | src/main/java/com/aspose/threed/ | ✅ Implemented |
| Aspose.ThreeD.Entities | src/main/java/com/aspose/threed/ | ✅ Implemented |
| Aspose.ThreeD.Profiles | *NOT IMPLEMENTED* | ⚠️ Should be stubs only |
| Aspose.ThreeD.Render | *NOT IMPLEMENTED* | ⚠️ Should be stubs only |

## Current Java Structure

```
src/main/java/com/aspose/threed/
├── *.java                          # Core classes
├── formats/                        # File format I/O
├── shading/                        # Material/texture classes
└── test/java/com/aspose/threed/  # Test classes
```

## Notes

1. The Java FOSS does not use multi-root Maven source layout currently
2. All classes are in `src/main/java/com/aspose/threed/` and subdirectories
3. When porting new classes from .NET FOSS, place them in appropriate subdirectories
4. Classes that don't exist in .NET FOSS (like current `PolygonModifier`) should be removed
5. All license/trial/DRM functionality should throw `UnsupportedOperationException`
6. Rendering classes (Scene.render) are stubbed per FOSS policy

## Java Package Structure

All public classes use: `package com.aspose.threed.*`

The directory structure on disk:
```
src/
  main/
    java/
      com/
        aspose/
          threeod/
            *.java                          # Core classes (Node, Scene, Entity, etc.)
            formats/
              *.java                        # Format-specific classes
            shading/
              *.java                        # Material/texture classes
            utilities/                      # (if split out)
              *.java                        # Utility classes
  test/
    java/
      com/
        aspose/
          threeod/
            *.java                        # Test classes
```

## Notes

1. The Java FOSS does not use multi-root Maven source layout currently
2. All classes are in `src/main/java/com/aspose/threed/` and subdirectories
3. This is acceptable - the .NET FOSS uses multi-root layout but Java FOSS can use simpler structure
4. When porting new classes, place them in appropriate subdirectories under src/main/java/com/aspose/threed/
