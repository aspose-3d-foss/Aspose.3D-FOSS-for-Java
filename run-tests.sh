#!/bin/bash

set -e

echo "Compiling main source..."
mkdir -p target/classes
find src/main/java -name "*.java" -exec javac -d target/classes -encoding UTF-8 {} + 2>&1 | grep -v "Note: Recompile with -Xlint" || true

echo "Compiling test source..."
mkdir -p target/test-classes
mkdir -p target/test-jars
if [ ! -f target/test-jars/junit-platform-console-standalone.jar ]; then
    echo "Downloading JUnit..."
    cd target/test-jars
    curl -s -L -o junit-platform-console-standalone.jar https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.0/junit-platform-console-standalone-1.10.0.jar
    cd ../..
fi

find src/test/java -name "*.java" -exec javac -d target/test-classes -encoding UTF-8 -cp "target/classes:target/test-jars/junit-platform-console-standalone.jar" {} + 2>&1

echo "Running tests..."
java -jar target/test-jars/junit-platform-console-standalone.jar --class-path "target/classes:target/test-classes" --scan-classpath
