@echo off

rem ---------------------------------------------------------------------------
rem Start script for the Rest build
rem ---------------------------------------------------------------------------

setlocal

cd restapi/Autocompletion

set "EXECUTABLE=ant autocomplete"

call %EXECUTABLE% 
:end
