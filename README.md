# ALMOSAFER_AutomationQA_BACKEND
This repository contains ALMOSAFER Automation Backend QA code challenge

                            ******ALMOSAFER Backend Automation Code Challenge*****

Wrote By: Wessam Lahloub
Email: wessam.lahloub1@gmail.com

*This project contains automated tests for the Almosafer Code Challenge using Java, Maven, TestNG, Rest Assured, and 
ExtentReports. The tests cover GET and POST APIs endpoints and generate comprehensive test reports.*

*Project Structure:*

almosafer-api-tests/src/main/App.java/            Contains the default Java code.

almosafer-api-tests/src/test/ALMOSAFER_TASK.java/ Contains the task Automated APIs Code.

almosafer-api-tests/target/extent-report.html/    Contains the generated reports.

*Tools and Libraries Used*:

1- Java
Version: 1.8.0_251
Description: Programming language used to write the test automation code.

2- Maven
Version: 3.9.9
Description: Build automation tool used for managing project dependencies and running tests.

3- TestNG
Version: Latest
Description: Testing framework used to run the test cases and manage test execution.

4- Rest Assured
Version: Latest
Description: Java library used for making API requests and validating responses.

5- ExtentReports
Version: Latest
Description: Reporting library used to generate HTML reports of test execution.

***********************************Getting Started******************************
*Prerequisites:*

- Java JDK : Ensure Java is installed and JAVA_HOME is set correctly in the environment variables

- Maven: Ensure Maven is installed and configured

- Ensure that you downloaded all needed dependincies


***********************************Installation******************************

- Clone the repository

- Build the project and install dependencies "mvn clean install"

- To run all the tests in the project "mvn test"

- To run a specific test class (My Task) "mvn -Dtest=com.almosafer.api.ALMOSAFER_TASK test"


***********************************Viewing Test Reports******************************

Test reports are generated in the target directory. Open the extent-report.html file located in target/ 
to view the test results.

*The browser's link should be similar to the following: file:///D:/ALMOSAFER_BEQA_TASK/almosafer-api-tests/target/extent-report.html*
