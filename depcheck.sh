#!/bin/sh
# This is in posix not bash,
# do not use bash syntax.
#
# This file checks for java
#

# skip if already verified
if [ -e ".java" ];then
	echo "Already verified java versions"
	exit 0;
fi

# must be run with java version
if [ ! -n "$1" ]; then
	echo "$0 JAVA_VERSION"
	exit 1;
fi

JAVA_VERSION="$1"
JAVAC_VERSION=$JAVA_VERSION

# Checks if com is installed
# on this system.
isinst(){
	local com=$1;
	if ! command -v "$com" >/dev/null 2>&1;
	then return 1; fi
	return 0;
}

# Wrapper for isinst that will
# terminate the script if the
# dep is missing
reqinst(){
	local com=$1
	if ! isinst $com; then
		echo "$com is not installed."
	fi
	return 0;
}

# checks if $b exists in $a
inout(){
	local a=$1
	local b=$2

	case $a in
		*$b*)
			return 0;
		;;
	esac
	return 1;
}

# wrapper for inout with command
# checking.
chkver(){
	local com=$1
	local chk=$2

	out=$(eval "$com")
	if [ $? -ne 0 ]; then
		echo "Program $com failed..";
		exit 1;
	fi

	ret=$(inout "$out" "$chk");
	return $ret
}


# Required programs
reqinst "java"
reqinst "javac"

# Check java version
if chkver "java --version | head -n 1" $JAVA_VERSION;
then echo "java version verified; $JAVA_VERSION";
else
	echo "Please use java: $JAVA_VERSION"
	exit 1;
fi

# Check javac version
if chkver "javac --version" $JAVAC_VERSION;
then echo "javac version verified; $JAVAC_VERSION";
else
	echo "Please use javac: $JAVAC_VERSION"
	exit 1;
fi

touch .java
