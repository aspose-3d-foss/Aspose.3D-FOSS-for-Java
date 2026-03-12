# File Format Support

## Summary

| Format | Extensions | Import | Export | Notes |
|--------|------------|--------|--------|-------|
| OBJ | .obj, .mtl | ✓ | ✓ | Full support |
| STL | .stl | ✓ | ✓ | Binary and ASCII |
| glTF | .gltf, .glb | ⚠ | ⚠ | Stub only |
| FBX | .fbx | ✗ | ✗ | Not implemented |
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
- **Import**: Stub implementation - format detection works but import not yet implemented
- **Export**: Stub implementation - not yet implemented
- **Limitations**:
  - Only binary/ASCII detection is implemented
  - JSON parsing not yet implemented
  - Buffer/accessor/view system not yet implemented
  - Full implementation requires complex buffer management

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
