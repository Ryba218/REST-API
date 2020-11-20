call runcrud.bat

if "%ERRORLEVEL%" == "0" goto openchrome
echo.
echo Cannot run
goto fail

:openchrome
start chrome http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo.
echo Cannot open
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Job done