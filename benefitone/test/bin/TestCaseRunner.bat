@echo off
rem ======================================================================
rem   $RCSfile: TestCaseRunner.bat,v $
rem  $Revision: 1.1.1.1 $
rem    $Author: gon $
rem      $Date: 2006/01/29 13:03:25 $
rem Originator: kei.omizo@sun.com
rem OriginDate: 2005/04/15
rem ======================================================================
rem Description:
rem     Run the TestCaseTool
rem     Please execute test directory.
rem ======================================================================
rem Usage:
rem     % TestCaseRuuner.bat [script options] [TestCaseTool Options]
rem
rem %ORACLE_PASSWD%, %ORACLE_USER%, %ORACLE_SID% are required.
rem ======================================================================

rem ####################
rem VARIABLES
rem ####################
set TESTCASETOOL_HOME=C:\TestCaseTool\TestCaseTool1.2.10
set JAVA_HOME=C:\Java\j2sdk1.4.2_07
set JAVA=%JAVA_HOME%\bin\java
set TEST_HOME=..
set TEST_CASE=%TEST_HOME%\testcase
set TEST_RESULT=%TEST_HOME%\testresult
set TEST_DATA=%TEST_HOME%\testdata

set JAVA_OPTS=-cp %TESTCASETOOL_HOME%\lib\webtest.jar
set RUNNER=webtest.textui.TestCaseRunner
set SHOW_HELP=0
set INIT_DATA=0
set OPTS=


rem ####################
rem MAIN
rem ####################

rem # GOTO HELP MESSAGE #
if "%1"=="--help" set SHOW_HELP=1
if "%1"=="--h" set SHOW_HELP=1
if "%1"=="--initdata" set INIT_DATA=1

if %SHOW_HELP%==1 goto usage

rem # CHECK OTHER OPTIONS
if %INIT_DATA%==1 shift
shift
:read_opts
if "%0"=="" goto check_initdata
set OPTS=%OPTS% %1
shift
goto read_opts

:check_initdata
if %INIT_DATA%==1 goto initdata

:starttest
rem # MKDIR FOR RESULT #
if not exist %TEST_RESULT% mkdir %TEST_RESULT%

rem # EXECUTE TEST #
%JAVA% %JAVA_OPTS% %RUNNER% %TEST_CASE% %TEST_RESULT% %OPTS%
goto finish

rem # INIT DATA
:initdata
sqlplus %ORACLE_USER%/%ORACLE_PASSWD%@%ORACLE_SID% < %TEST_DATA%/customerdao-delete.sql
sqlplus %ORACLE_USER%/%ORACLE_PASSWD%@%ORACLE_SID% < %TEST_DATA%/customerdao-data.sql

goto starttest

rem # SHOW HELP MESSAGE #
:usage
echo Usage:
echo     TestCaseRunner.bat [script options] [TestCaseTool options]
echo   Script Options:
echo       --help, --h    print this message
echo       --initdata     initialize sample data

:finish
echo FINISH!!
