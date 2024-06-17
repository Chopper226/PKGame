@echo off
REM Navigate to the project root directory
cd /d %~dp0

REM Create the output directory if it doesn't exist
if not exist out (
    mkdir out
)

REM Compile all Java files in the src directory
echo Compiling Java files...
for /r src %%f in (*.java) do (
    if not exist "out\%%~p" (
        mkdir "out\%%~p"
    )
    javac -d out "%%f"
)

REM Copy the resources to the output directory
echo Copying resources...
xcopy res out /s /i /y

REM Run the compiled Java program (replace com.example.Main with your main class)
set MAIN_CLASS=main.Main
echo Running Java program...
java -cp out %MAIN_CLASS%

pause
