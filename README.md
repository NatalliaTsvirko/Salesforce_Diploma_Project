# Salesforce_Diploma_Project

# libraries used in the project:

-selenium version 3.141.59;

-webdrivermanager version 5.0.3;

-testNG version 6.14.3;

-java faker version 1.0.2;

# CI

-Jenkins;

# Report

-Allure-report;

# Operation commands:

In order to run tests, use the command:

-mvn clean test -DsuiteXmlFile=src/test/resources/ParallelTests.xml

command result:  Tests run: , Failures: , Errors: , Skipped: ;

-mvn clean test -DsuiteXmlFile=src/test/resources/RegressionTest.xml

command result: Tests run: , Failures: , Errors: , Skipped: ;

-mvn clean test -DsuiteXmlFile=src/test/resources/SmokeTest.xml

command result:  Tests run: , Failures: , Errors: , Skipped: ;

To run Login tests use the command:

-mvn -Dtest=LoginTest test

command result:  Tests run: 2, Failures: 0, Errors: 0, Skipped: 0;

To run CreateAccountTest tests use the command:

-mvn clean test -Dtest=CreateAccountTest test

command result: Tests run: 2, Failures: 2, Errors: 0, Skipped: 0;

To run CreateContactTest tests use the command:

-mvn clean test -Dtest=CreateContactTest test

command result: Tests run: 1, Failures: 1, Errors: 0, Skipped: 0;

To run CreateLeadsTest tests use the command:

-mvn clean test -Dtest=LeadsTest test

command result: Tests run: 4, Failures: 1, Errors: 0, Skipped: 2;