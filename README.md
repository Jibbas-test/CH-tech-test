# Companies House Tech Test - Parabank website

## Pre-requisites

Please ensure that the following are installed before attempting to clone this repository:

* Java 17
* An IDE such as IntelliJ or Eclipse
* Maven
* Chromedriver

## Running the tests

* Clone this repository on your local machine using the following command(s):

If using HTTPS:
>https://github.com/Jibbas-test/CH-tech-test.git

If using SSH:
>git@github.com:Jibbas-test/CH-tech-test.git

* Change into this project's directory
* Run the following command in a terminal window:
>mvn clean install -DbrowserProfile=chrome -Dcucumber.options="--tags @Parabank"


## Reports
### Extent Test Report
Extent test reports are generated automatically after each test run, each with a specific date and timestamp.  If a test step fails then a screenshot is also captured allowing an easy view of the page under failure.
* Extent reports are generated in the ./test-output folder.
* Navigate to this directory and open the associated HTML file in a browser of your choice.
* In the case of a test failure, a screenshot will be automatically taken and attached to the test report.