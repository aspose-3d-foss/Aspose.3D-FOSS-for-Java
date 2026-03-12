# File Format Support

## Summary

| Format | Extensions | Import | Export | Notes |
|--------|------------|--------|--------|-------|
| OBJ | .obj, .mtl | ✓ | ✓ | Full support |
| STL | .stl | ✓ | ✓ | Binary and ASCII |
| glTF | .gltf, .glb | ✓ | ✓ | Full import/export |
| FBX | .fbx | ⚠ | ⚠ | Import only (binary) |
| USD | .usd, .usda, .usdc | ✗ | ✗ | Not implemented |

## Format Details

### OBJ
- **Import**: Full support for geometry, basic MTL materials
- **Export**: Full support for geometry
- **Limitations**:
  - MTL export not yet implemented
  - Texture coordinates not yet imported
  - Normals not yet imported
  - Multiple objects in one file need testing

### STL
- **Import**: Full support for binary and ASCII STL
- **Export**: Full support for binary and ASCII STL
- **Limitations**:
  - No material support (STL is geometry-only)
  - Vertex deduplication not implemented (uses separate vertices for each face)
  - Normal recalculation option available but not tested

### glTF/GLB
- **Import**: Full support for ASCII (.gltf) and binary (.glb) formats
- **Export**: Full support for ASCII (.gltf) and binary (.glb) formats
- **Limitations**:
  - Some advanced glTF extensions may not be supported
  - Texture references are not fully implemented (embedded buffers only)

### FBX
- **Import**: Binary FBX format supported (version 6.1+)
- **Export**: Not implemented
- **Limitations**:
  - Only binary FBX format is supported
  - ASCII FBX format not yet supported
  - Full node hierarchy and material extraction not yet tested
  - Advanced FBX features (animations, constraints) not implemented

### glTF/GLB
- **Import**: Not implemented
- **Export**: Not implemented
- **Limitations**: None (format not yet implemented)

### FBX
- **Import**: Not implemented
- **Export**: Not implemented
- **Limitations**: None (format not yet implemented)

## Adding New Formats

1. Create plugin in `src/plugins/formats/<Format>/`
2. Implement internal `IImporter`/`IExporter` interfaces
3. Register in `PluginRegistry.java`
4. Add tests and user-provided sample files
5. Update this file
