# TMS_Salesforce_TsvirkoNata

#libraries used in the project:

-selenium version 4.1.1;

-webdrivermanager version 5.0.3;

-testNG version 6.14.3;

-java faker version 0.18;

#CI
-Jenkins;

#Report

-Allure-report;

#Operation commands:
In order to run tests, use the command:

-mvn clean test -DsuiteXmlFile=src/test/java/resources/Negative.xml

command result:  Tests run: , Failures: , Errors: , Skipped: ;

-mvn clean test -DsuiteXmlFile=src/test/java/resources/ParallelTests.xml

command result: Tests run: , Failures: , Errors: , Skipped: ;

-mvn clean test -DsuiteXmlFile=src/test/java/resources/Smoke.xml

command result:  Tests run: , Failures: , Errors: , Skipped: ;

To run Login tests use the command:

-mvn -Dtest=LoginTest test

command result:  Tests run: , Failures: , Errors: , Skipped: ;

To run CreateAccountTest tests use the command:

-mvn clean test -Dtest=CreateAccountTest test

command result: Tests run: , Failures: , Errors: 0, Skipped: 0;

To run CreateContactTest tests use the command:

-mvn clean test -Dtest=CreateContactTest test

command result: Tests run: , Failures: , Errors: , Skipped: ;

To run CreateLeadsTest tests use the command:

-mvn clean test -Dtest=CreateLeadsTest test

command result: Tests run: , Failures: , Errors: , Skipped: ;