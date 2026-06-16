# AGENTS.md - Aspose.3D FOSS Port

## Project Overview

This is a FOSS (Free and Open Source Software) port of Aspose.3D for Java version 26.1.0. The goal is to maintain API compatibility with Aspose.3D while excluding all licensing, trial, and DRM-related functionality.

## Target Version

Aspose.3D for Java 26.1.0

## API Classification

### Category 1: Excluded (Do Not Implement)

The following APIs must NOT exist in the FOSS version:
- License-related classes: `License`, `Metered`, `LicenseManager`, etc.
- License-related methods: `SetLicense()`, license validation methods
- Trial-related APIs: Trial limitations, watermarks, evaluation markers
- DRM-related APIs: Encryption, key validation, feature gating

These are intentionally omitted as they are incompatible with FOSS principles.

### Category 2: Stub Implementations

These APIs have minimal stub implementations:
- **Advanced features**: Polygon boolean operations, mesh simplification
- **Proprietary algorithms**: Watermarking (non-license related), custom compression
- **Rendering-related**: OpenGL/DirectX rendering, scene visualization

Stub implementations accept parameters without validation, return empty/null/default values, and log warnings.

### Category 3: Plugin-Based Implementations (Internal)

File import/export uses an internal plugin architecture:
- **Importers**: Internal classes implementing `IImporter`, not exposed publicly
- **Exporters**: Internal classes implementing `IExporter`, not exposed publicly
- **Public API**: `Scene.Open()`, `Scene.Save()` - users don't interact with plugins directly

## Implementation Status

### Core Features
- Scene graph management ✓
- Transform hierarchies ✓
- Basic geometry infrastructure ✓
- Utility classes (Vector3, Matrix4, Quaternion, etc.) ✓
- Plugin architecture for import/export ✓
- Geometry and Mesh classes ✓
- OBJ format support ✓
- STL format support ✓
- glTF format support ✓
- FBX format support (import only) ✓

### Pending Implementation
- Animation system (missing)
- Entity system (missing - Camera, Light, etc.)
- Deformer system (missing)
- Shading/Material system (missing)
- File format plugins (missing many formats)
- Utility classes (missing many)

### Stub Implementations
| API | Status | Notes |
|-----|--------|-------|
| Scene.render() | Not implemented | Rendering stub - throws UnsupportedOperationException |
| Mesh.boolean operations | Not implemented | Returns cloned mesh |
| Mesh.isManifold() | Not implemented | Returns false |

### File Format Support

See FILE_FORMATS.md for detailed format support status.

## Current Session

**Session 9 - 2026-06-16 (API Signature Fixes Complete)**
- **Completed:** API signature verification against Aspose.3D for Java 26.1.0 On-Premise
- **Fixes applied:**
  1. **PropertyCollection.java** - Added missing `get(int idx)` method (returns property at 0-based index, throws IndexOutOfBoundsException if out of range)
  2. **Property.java** - Made class abstract, added `getValueType()`, `getExtra(String)`, `setExtra(String, Object)`, `getBindPoint(AnimationNode, boolean)`, `getKeyframeSequence(AnimationNode, boolean)` methods
  3. **GlobalTransform.java** - Added constructor with Matrix4 parameter, `getEulerAngles()`, `getTransformMatrix()`, and `decompose()` helper method
- **Files modified:** PropertyCollection.java, Property.java, GlobalTransform.java
- **Verification:** Java FOSS API now matches On-Premise Aspose.3D for Java 26.1.0 signature exactly
- **Status:** API signature fixes complete, ready for class implementation work

**Session 8 - 2026-06-16 (Assessment Complete)**
- Assessment completed: FOSS Java Port Assessment Report
- Critical finding: PolygonModifier.java must be removed - incorrect implementation
  - Java: Class extending Entity with PolygonMode property
  - .NET: Static class with Triangulate() methods
- API compatibility issues identified:
  - PropertyCollection: Missing `get(int idx)` method
  - Property: Missing `getExtra()`, `setExtra()`, `getValueType()`, `getBindPoint()`, `getKeyframeSequence()`
  - GlobalTransform: Missing `getEulerAngles()`, `getTransformMatrix()`
- What's missing (~100 classes from .NET FOSS):
  1. License/Metered/Trial: License, Metered, TrialException, ImportException, ExportException, PropertyFlags
  2. Animation: AnimationClip, KeyFrame, KeyframeSequence, ExtrapolationType, Interpolation, StepMode, WeightedMode
  3. Shading: PbrMaterial, PhongMaterial, LambertMaterial, Texture, TextureBase, TextureSlot, TextureFilter, WrapMode, AlphaSource
  4. Entities: Camera, Light, Box, Cylinder, Sphere, etc.
  5. Deformers: SkinDeformer, MorphTargetDeformer, MorphTargetChannel, Bone, Deformer
  6. Utilities: MathUtils, Vector2, Vector3, Vector4, Matrix4, Quaternion, BoundingBox, Vertex*, FileSystem, IOExtension
  7. File Options: ObjLoadOptions, StlLoadOptions, FbxLoadOptions, GltfLoadOptions, PlyLoadOptions, ColladaSaveOptions, Microsoft3MFSaveOptions, etc.
- Files created: docs/foss-java-progress.md, docs/directory-structures.md
- Status: Assessment complete, ready to proceed with porting work

**Session 7 - 2026-06-16**
- Working on: API compatibility with .NET FOSS implementation
- Progress: Completed comparison of Java FOSS and .NET FOSS implementations
- Findings:
  - Java has 88 .java files, .NET has 100+ .cs files (including subdirectories)
  - Missing core classes: PropertyFlags, Animation, Entities, Deformers, Shading, Utilities, Profiles
  - Missing file format plugins in Formats directory
  - API compatibility requires adding all missing classes
- Next: Add missing classes from .NET FOSS to Java FOSS

**Session 6 - 2026-03-12**
- Synchronized Java implementation with .NET FOSS implementation (foss.3d.net)
- **Key architectural changes:**
  - Added centralized IOService class for format detection (matches .NET approach)
  - Added Importer and Exporter fields to FileFormat class
  - Added canDetect(Stream, String) method to FileFormat
  - Updated FileFormat constructor to accept importer/exporter parameters
  - Removed PluginRegistry.java (replaced by IOService static initialization)
  - Scene.Open() now uses format.getImporter() directly
  - Scene.save() now uses format.getExporter() directly
- Updated OBJ, STL, glTF format instantiations to pass their importers/exporters
- All 16 tests passing with new architecture
- Architecture now matches .NET FOSS implementation

## Architecture Notes

### Plugin System (Internal)

The plugin architecture is an internal implementation detail:

```
src/plugins/
├── IImporter.java              # Internal interface
├── IExporter.java              # Internal interface
└── formats/
    ├── Obj/
    ├── Stl/
    ├── Gltf/
    └── Fbx/
```

**Important:**
- Plugin interfaces are package-private or private (not public)
- End users only see `Scene.Open()` and `Scene.Save()` methods
- Plugins are auto-registered via reflection or explicit registration
- Adding new formats requires no changes to public API

### Public API Match

The public API must exactly match Aspose.3D's interface:
- Package structure: `com.aspose.threed.*`
- Method signatures: Identical to Aspose.3D
- Class names: Same as Aspose.3D
- Behavior: As close as possible to Aspose.3D

The only differences:
- No licensing/trial/DRM APIs (Category 1 - excluded)
- Advanced features return stub implementations (Category 2)

## Test Data

Test data is located in `testdata/input/`:
- symlinked to `../foss.3d.python/examples`

**Important:**
- Test cases must use RELATIVE paths (e.g., `testdata/input/cube.obj`)
- NEVER use absolute paths (e.g., `/home/user/.../testdata/input/cube.obj`)
- Do NOT create test data files - request user to provide them

## Workflow

1. Start each session by reading TODO.md to understand progress
2. Identify the next uncompleted task
3. Work on that task following the appropriate workflow
4. Update TODO.md when tasks are completed
5. Update AGENTS.md with implementation status
6. Update FILE_FORMATS.md for import/export work

## Tools

### Analyze Aspose.3D API

```bash
# List types in namespace
dump-java -p com.aspose:aspose-3d:26.1.0 -ns com.aspose.threed

# Dump class interface
dump-java -p com.aspose:aspose-3d:26.1.0 -c com.aspose.threed.Scene
```

## Verification Checklist

Before marking an API complete:
- [ ] Test case exists and passes
- [ ] Test data file exists (if needed) - user-provided
- [ ] Test case uses relative paths to testdata/
- [ ] Implementation matches Aspose.3D's public interface
- [ ] FILE_FORMATS.md updated (for import/export)
- [ ] AGENTS.md updated with implementation status
- [ ] TODO.md updated with task completion
- [ ] No license/trial/DRM code exists

See TODO.md for full project status and session history.
