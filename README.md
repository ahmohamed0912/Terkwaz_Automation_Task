# Automation Selenium POM for Terkwaz Task

## Introduction: 

	- Test Framework with Java, Maven, TestNG.
	- Each page of the scenario have a class to collect the identifiers (locators) and all functional Methods for all action in page. 
	- Each test case have a class to execute this test case.

## Project Folders and Files:

### - For "Main" Folder contains tree packages: 

	1.  DataFiles: Contains all data files we need in our test
	2.  Pages: Contain classes for each page we use in our test
 
### - For "test" Folder contains tree packages: 

	1.  data: Contains all classes that used for reading and writing data from data sources
	2.  tests: Contain test cases classes
	3.  Utilities: contains helps classes that used to take screenshot and generate the report

### Other Folders:

	1.  ExtractedFiles: contains the files extracted from system
	2.  Reports: contains html file for automation report
	3.	sources: contains the browsers drivers
	4.	test-output: contains testng report files

### Important Files:

	1. pom.xml: use to add all project dependencies.
	2. TestngFile.xml: Testng suite to run more test cases. 
	3. Automation.jpg: png file using for uploaded in task


