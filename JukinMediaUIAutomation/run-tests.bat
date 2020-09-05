echo "Starting project Maven build"

call mvn clean install test -Dtest=JukinRunner

echo "Opening HTML Report"

call start "" "file://%cd:\=/%/target/html/ExtentReport.html"
