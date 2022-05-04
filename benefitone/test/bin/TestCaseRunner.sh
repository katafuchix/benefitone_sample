#!/bin/sh
# ======================================================================
#   $RCSfile: TestCaseRunner.sh,v $
#  $Revision: 1.1.1.1 $
#    $Author: gon $
#      $Date: 2006/01/29 13:03:25 $
# Originator: kei.omizo@sun.com
# OriginDate: 2005/04/14
# ======================================================================
# Description:
#     Run the TestCaseTool
#     Please ensure variables for Oracle.
# ======================================================================
# Usage:
#     % TestCaseRuuner.sh [script options] [TestCaseTool Options]
# ======================================================================

# ####################
# SUB ROUTINE
# ####################

# - - - - - - - - - - 
# Show usage
# - - - - - - - - - -
usage() {
    echo ""
    echo "Usage:"
    echo "  $MYNAME [script options] [TestCaseTool Options]"
    echo ""
    echo "  Script Options:"
    echo "    --help, --h    print this message"
    echo "    --initdata     initialize sample data"
    echo ""
}

# - - - - - - - - - - 
# create directory
#   param1 : directory name
#   return : if directory is created, return 0.
# - - - - - - - - - -
create_dir() {
    if [ ! -d $1 ] ; then
        mkdir $1;
        return $?;
    fi;
    return 0;
}

# - - - - - - - - - -
# error exit
#   param1: reason
# - - - - - - - - - -
error_exit() {
    echo "$MYNAME is not completed.";
    echo "Reason:"
    echo "$1";
    exit;
}

# - - - - - - - - - -
# init_data
#    return: 10 - ORACLE_HOME is not set.
#    return: 11 - ORACLE_SID is not set.
#    return: 12 - ORA_NSL10 is not set.
#    return: 13 - ORACLE_USER is not set.
#    return: 14 - ORACLE_PASSWD is not set.
# - - - - - - - - - -
init_data() {
    retval=0;
    # check environment
    check_variable $ORACLE_HOME
    if [ $? -ne 0 ] ; then
        echo "ORACLE_HOME is null.";
        retval=10;
    fi;
    check_variable $ORACLE_SID
    if [ $? -ne 0 ] ; then
        echo "ORACLE_SID is null.";
        retval=11;
    fi;
    check_variable $ORA_NLS10
    if [ $? -ne 0 ] ; then
        echo "ORA_NLS10 is null.";
        retval=12;
    fi;
    check_variable $ORACLE_USER
    if [ $? -ne 0 ] ; then
        echo "ORACLE_USER is null.";
        retval=13;
    fi;
    check_variable $ORACLE_PASSWD
    if [ $? -ne 0 ] ; then
        echo "ORACLE_PASSWD is null.";
        retval=14;
    fi;

    if [ $retval -ne 0 ] ; then
        return $retval;
    fi;

    cat $TEST_DATA/customerdao-delete.sql | $ORACLE_HOME/bin/sqlplus $ORACLE_USER/$ORACLE_PASSWD@$ORACLE_SID;
    cat $TEST_DATA/customerdao-data.sql | $ORACLE_HOME/bin/sqlplus $ORACLE_USER/$ORACLE_PASSWD@$ORACLE_SID;
}

check_variable() {
    if [ $# -lt 1 ] ; then
        return 1;
    fi;
    if [ ! $1 ] ; then
        return 1;
    fi;
    return 0;
}

# ####################
# VARIABLES
# ####################
LANG=ja_JP.PCK;
export LANG

MYNAME=`basename $0`

# tool
TESTCASETOOL_HOME=${TESTCASETOOL_HOME:=/usr/local/misc/TestCaseTool};
export TESTCASETOOL_HOME

JAVA_HOME=${JAVA_HOME:=/usr/local/java/J2SE1.4.2};
export JAVA_HOME

JAVA=$JAVA_HOME/bin/java;
export JAVA

# test
TEST_HOME=${TEST_HOME:=..};
export TEST_HOME

TEST_CASE=$TEST_HOME/${TEST_CASE:=testcase};
export TEST_CASE

TEST_RESULT=$TEST_HOME/${TEST_RESULT:=testresult};
export TEST_RESULT

TEST_DATA=$TEST_HOME/${TEST_DATA:=testdata};
export TEST_DATA

# variables for TestRunner
OPTS=""
JAVA_OPTS="-cp $TESTCASETOOL_HOME/lib/webtest.jar"
RUNNER="webtest.textui.TestCaseRunner"

# show help or not. default is not.
SHOW_HELP="0";
INIT_DATA="0";

# ####################
# MAIN
# ####################
# check script options.
for i in $*; do
    case $i in
    --h | --help) SHOW_HELP="1";   shift 1;;
      --initdata) INIT_DATA="1";   shift 1;;
               *) OPTS="$OPTS $1"; shift 1;;
    esac;
done;

# check show help or not.
if [ $SHOW_HELP -eq 1 ] ; then
    usage;
    exit;
fi;

# check init data
if [ $INIT_DATA -eq 1 ] ; then
    init_data;
    if [ $? -ne 0 ] ; then
        error_exit "Couldn't initialize sample data.";
    fi;
fi;

# check testcase directory existence.
if [ ! -d $TEST_CASE ] ; then
   error_exit "$TEST_CASE directory does not found.";
fi;

# create result directory
create_dir $TEST_RESULT
if [ $? -ne 0 ] ; then
    error_exit "cannot create $TEST_RESULT diretory";
fi;

# execute TestRunner
$JAVA $JAVA_OPTS $RUNNER $TEST_CASE $TEST_RESULT $OPTS
