#! /bin/bash

echo Compiling
javac Writer.java
echo Running Simulation
java Writer
echo Animating...
python animate.py