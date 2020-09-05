
# These are the instructions to run the UI Test Cases.

1. Clone the WhatChaMaCallIt project from Github to your machine.
2. Ensure that Java 1.8 and Maven 3.6 is installed on your machine and that JAVA_HOME & M2_HOME environment variable is set correctly.
3. Goto the "JukinMediaUIAutomation" project folder and run the batch file run-tests.bat
4. This will run the UI tests on Chrome browser
5. If you want to execute the tests on IE or Firefox browser then navigate to \src\main\resources\configuration.properties and change the value of 'browser' property to either IE or Firefox.
6. Once the execution will complete a HTML report will open up in the browser stating the execution result.
