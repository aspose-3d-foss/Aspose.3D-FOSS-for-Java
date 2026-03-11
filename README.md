# Aspose.3D FOSS - Java Implementation

A Free and Open Source Software implementation of Aspose.3D for Java 26.1.0 API.

## Overview

This project provides a FOSS implementation that maintains API compatibility with Aspose.3D for Java while excluding all licensing, trial, and DRM-related functionality.

## Project Status

This is a work-in-progress port. See [TODO.md](TODO.md) for current progress and [FILE_FORMATS.md](FILE_FORMATS.md) for format support status.

## API Compatibility

The public API matches Aspose.3D for Java 26.1.0:
- Package structure: `com.aspose.threed.*`
- Method signatures: Identical to Aspose.3D
- Class names: Same as Aspose.3D

**Excluded APIs:**
- No licensing, trial, or DRM-related functionality
- Some advanced features have stub implementations

## Building

```bash
# Build the project
./gradlew build

# Run tests
./gradlew test
```

## Usage

```java
import com.aspose.threed.Scene;

// Load a 3D file
Scene scene = new Scene("testdata/input/cube.obj");

// Save to another format
scene.save("output.stl");
```

## License

This project is released under the MIT License. See LICENSE file for details.

## Acknowledgments

This is a clean-room FOSS implementation designed for API compatibility with Aspose.3D.
