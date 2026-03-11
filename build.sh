#!/bin/bash

set -e

echo "Building Aspose.3D FOSS..."

echo "Compiling main source..."
mkdir -p target/classes
find src/main/java -name "*.java" -exec javac -d target/classes -encoding UTF-8 {} + 2>&1 | grep -v "Note: Recompile with -Xlint" || true

echo "Creating JAR..."
cd target/classes
jar cf ../aspose-3d-foss.jar com/
cd ../..

echo "Build complete! JAR created at target/aspose-3d-foss.jar"

# Also run tests
./run-tests.sh
