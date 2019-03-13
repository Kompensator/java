#/bin/bash

source=$1
extention=.java
class=${source%"$extention"}
echo Compiling $source
`javac $source`
echo Executing $class
`java $class`
