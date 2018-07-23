@echo off

rem ---------------------------------------------------------------------------
rem Start script for the autocomplete deployment
rem ---------------------------------------------------------------------------

setlocal

cd apache-tomcat-7.0.90/bin

set "EXECUTABLE=shutdown.bat"
call %EXECUTABLE% 

set "EXECUTABLE=startup.bat"
call %EXECUTABLE% 

:end
