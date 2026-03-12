# TODO - Aspose.3D FOSS Port (Java)

## Phase 1: Core Infrastructure
- [x] Initialize project structure
- [x] Create IImporter interface
- [x] Create IExporter interface
- [x] Implement PluginRegistry for format discovery
- [x] Implement Scene class with Open()/Save() methods
- [x] Implement Node class hierarchy
- [x] Implement Transform class
- [x] Implement Geometry base class
- [x] Implement utility classes (Vector3, Vector4, Matrix4, Quaternion, etc.)
- [x] Implement FileFormat and related enums

## Phase 2: File Format Plugins
- [x] OBJ: Create plugin structure
- [x] OBJ: Implement importer
- [x] OBJ: Implement exporter
- [x] OBJ: Add tests and update FILE_FORMATS.md
- [x] STL: Create plugin structure
- [x] STL: Implement importer (binary and ASCII)
- [x] STL: Implement exporter (binary and ASCII)
- [x] STL: Add tests and update FILE_FORMATS.md
- [x] glTF: Create plugin structure
- [x] glTF: Implement importer (stub)
- [x] glTF: Implement exporter (stub)
- [x] glTF: Add tests and update FILE_FORMATS.md
- [ ] FBX: Research format specification
- [ ] FBX: Create plugin structure
- [ ] FBX: Implement importer
- [ ] FBX: Implement exporter
- [ ] FBX: Add tests and update FILE_FORMATS.md

## Phase 3: Core 3D Operations
- [ ] Implement Mesh class (vertices, faces, normals)
- [ ] Implement Polygon class
- [ ] Implement VertexElement classes (UVs, colors, etc.)
- [ ] Implement Material class
- [ ] Implement Texture classes

## Phase 4: Advanced Features
- [ ] Implement animation system
- [ ] Implement camera classes
- [ ] Implement light classes
- [ ] Implement skeleton/rigging (stub)

## Session Notes

### Session 1 - 2026-03-11
- Initial project setup
- Created directory structure (src/, testdata/, plugins/)
- Created TODO.md, AGENTS.md, FILE_FORMATS.md, README.md
- Implemented core infrastructure:
  - Base classes: A3DObject, SceneObject, Entity, Node, Scene
  - Utility classes: Vector3, Vector4, Matrix4, Quaternion, Transform
  - Helper classes: BoundingBox, Material, AssetInfo, etc.
  - Plugin system: IImporter, IExporter, PluginRegistry
  - File format system: FileFormat with all format constants (FBX, OBJ, STL, glTF, etc.)
- Verified compilation and basic functionality
- Implemented OBJ importer/exporter plugin
- Tested OBJ import/export successfully

### Session 2 - 2026-03-11
- Implemented OBJ format support
  - Created ObjImporter class with basic OBJ parsing
  - Created ObjExporter class with basic OBJ writing
  - Added support for vertices, faces, materials
  - Implemented ObjLoadOptions and ObjSaveOptions
- Added geometry system (Mesh, Geometry, VertexElement)
- Added supporting enums (VertexElementType, MappingMode, ReferenceMode, TextureMapping, CoordinateSystem, Axis)
- Successfully tested OBJ import/export with cube.obj test file
- Next: Implement STL format support

### Session 3 - 2026-03-11
- Refactored plugin architecture based on foss.3d.python implementation
- Updated Scene.open() and Scene.save() to detect format by file extension
- Updated PluginRegistry to select correct importer/exporter based on FileFormat
- Added fileFormat field to LoadOptions class
- Fixed STL binary exporter (buffer offset calculation)
- Fixed STL ASCII importer (allow newline characters in header detection)
- Added comprehensive STL format tests (StlFormatTest with 6 tests)
- All 13 tests passing (3 SceneTest, 4 Vector3Test, 6 StlFormatTest)
- Next: Implement glTF format support

### Session 4 - 2026-03-11
- Implemented complete glTF format support
- Created GltfJsonParser.java with pure Java JSON parsing (no external libraries)
- Created GltfLoadOptions and GltfSaveOptions classes
- Created GltfImporter with full ASCII (.gltf) and binary (.glb) support
- Created GltfExporter (stub - export not yet implemented)
- Implemented:
  * Binary glTF chunk parsing (JSON + BIN chunks)
  * Data URI decoding for base64-encoded buffers
  * Accessor parsing (positions, normals, tangents, UVs, colors, indices)
  * Mesh building with control points and polygons
  * Node hierarchy with transforms
  * Material support
- Enabled GLTF, GLTF2, GLTF_BINARY, GLTF2_BINARY in FileFormat
- Registered glTF importer/exporter in PluginRegistry
- Added GltfFormatTest with 3 tests (options and format detection)
- All 16 tests passing (3 SceneTest, 4 Vector3Test, 6 StlFormatTest, 3 GltfFormatTest)
- glTF ASCII import tested successfully with test data
- glTF binary (.glb) import supported but not yet tested with real .glb files
- glTF export not yet implemented
- Next: Implement FBX format support or complete glTF export

## Test Data Requests
- None yet
