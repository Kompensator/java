#!/bin/bash

#check if both command line arguments are passed
if [ -z "$1" ] || [ -z "$2" ]
then
    echo "Usage ./tarzan.sh filename tarfile"
    exit
fi

if [ ! -f $2 ]
then
    echo "Error cannot find tar file $2"
    exit
fi

#use grep and tar -tf to find the query
file=`tar -tf $2 | grep $1`

#check if $file is empty (file not found in archive)
if [ -z "$file" ]
then
    echo "$1 does not exist in $2"
else
    echo "$1 exists in $2"
fi

