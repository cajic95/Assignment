# Htec_assignment
This is a guide how to run the automated tests for the exam scenario.

Environment and tools:  
Windows 10 home 64bit
Version 94.0.4606.71 (Official Build) (64-bit)
Eclipse Version: 2021-03 (4.19.0)  
TestNG 7.4.0
Selenium Webdriver + ChromeDriver 
Apache POI

Open the project in Eclipse and navigate to TestLoginPage to test loging in page.(Run over TestNG).
Navigate to TestTestCases to test all thing about test cases.(Run over TestNG).
Navigate to TestDashboardPages to test all form Dashboard pages. (Run over TestNG).
I am used POM in this project.
I tested things that I thought were relevant to this site.
In some parts I used the Thread.sleep method because I had problems with my internet connection and that was the only thing that helped me solve that problem.
The logging credentials are retrieved from the Excel file located in the project folder.



Testing framework TestNG:
<!-- https://mvnrepository.com/artifact/org.testng/testng -->
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.4.0</version>
    <scope>test</scope>
</dependency>

Automated testing framework for web applications Selenium:
<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-support -->
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-support</artifactId>
    <version>3.141.59</version>
</dependency>

Apache POI  (Java libraries for reading EXCEL file)
<!-- https://mvnrepository.com/artifact/org.apache.poi/poi -->
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi</artifactId>
    <version>4.1.2</version>
</dependency>
<dependency>
        <groupId>org.apache.poi</groupId>
        <artifactId>poi-ooxml</artifactId>
        <version>4.1.2</version>
</dependency>
