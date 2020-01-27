# ID: 260923676
# Name: Ding Yi Zhang

#!/bin/bash

#setting default values for the user options
c=0
a=0
pattern=0
dir=`pwd`

# no argument provided
if [ $# -eq 0 ]
then
    echo "Error missing the pattern argument."
    exit
fi


# 1 argument provided
if [ $# -eq 1 ]
then
    if [ $1 != "-c" ] && [ $1 != "-a" ]
    then
        pattern=$1
    else
        echo "Error missing the pattern argument."
        exit
    fi
fi


# 2 arguments provided
if [ $# -eq 2 ]
then
    if [ $2 != "-a" ] && [ $2 != "-c" ]
    then

        if [ $1 = "-c" ]
        then
            c=1
            pattern=$2
        elif [ $1 = "-a" ]
        then
            a=1
            pattern=$2
        else
            pattern=$1
            dir=$2
        fi
    else
        echo "Error missing the pattern argument."
        exit
    fi
fi


# 3 arguments provided
if [ $# -eq 3 ]
then

    if [ $1 = "-c" ]
    then
        c=1
        if [ $2 = "-a" ]
        then
            a=1
            pattern=$3
        else
            pattern=$2
            dir=$3
        fi
    fi

    if [ $1 = "-a" ]
    then
        a=1
        if [ $2 = "-c" ]
        then
            c=1
            pattern=$3
        else
            pattern=$2
            dir=$3
        fi
    fi
fi


# 4 arguments, we can assume user wants -c -a and provides a dir
if [ $# -eq 4 ]
then
    c=1
    a=1
    pattern=$3
    dir=$4
fi


#testing if dir provided exists
if [ ! -d $dir ]
then
    echo Error $dir is not a valid directory
    exit
fi


#try to find the file
files=`ls $dir | grep "$pattern"`
if [ -z "$files" ]
then
    echo Unable to locate any files that has the pattern $pattern in its name in $dir
fi

for file in $files
do
# if user use switch -c
    if [ $c = 1 ]
    then
        echo "=== Contents of: $dir/$file ==="
        cat $dir/$file
        # if user did not use -c
    else
        echo "$dir/$file"
    fi

        # is user did not use switch -a, break after first file
    if [ ! $a = 1 ]
    then
        break
    fi
done