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

### Stub Implementations
| API | Status | Notes |
|-----|--------|-------|
| Scene.render() | Not implemented | Rendering stub - throws UnsupportedOperationException |
| Mesh.boolean operations | Not implemented | Returns cloned mesh |
| Mesh.isManifold() | Not implemented | Returns false |

### File Format Support

See FILE_FORMATS.md for detailed format support status.

## Current Session

**Session 2 - 2026-03-11**
- Working on: OBJ format implementation
- Progress: Implemented OBJ importer and exporter, tested successfully with cube.obj
- Completed: ObjImporter, ObjExporter, ObjLoadOptions, ObjSaveOptions, geometry system
- Next: Implement STL format support

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
