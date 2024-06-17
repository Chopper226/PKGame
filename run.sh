#!/bin/bash

cd "$(dirname "$0")"
javac -d out $(find src -name "*.java")
cp -r res/* out/
java -cp out main.Main