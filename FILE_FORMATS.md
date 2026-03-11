# File Format Support

## Summary

| Format | Extensions | Import | Export | Notes |
|--------|------------|--------|--------|-------|
| OBJ | .obj, .mtl | ✓ | ✓ | Full support |
| STL | .stl | ✗ | ✗ | Not implemented |
| glTF | .gltf, .glb | ✗ | ✗ | Not implemented |
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
- **Import**: Not implemented
- **Export**: Not implemented
- **Limitations**: None (format not yet implemented)

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
