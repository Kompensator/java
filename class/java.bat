@echo off

set source=%1
set class=%source:.java =%

echo Compiling %source%
javac %source%

echo Executing %class%
java %class%
