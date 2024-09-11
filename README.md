# GermanyIsCalling_LoginTest
Automating login page of Germany is calling using selenium webdriver and java . It contains both Successful and unsuccessful login test case.
# Test Execution Step
      # prerequisites
        1. Java Development kit
        2. IDE(Eclipse)
        3. Maven
        4. WebDriverManager
        5. Browser(chrome,opera,edge etc)

# Project setup
1. Import the project as maven project.
2. Configure the config.properties file.
3. Configure the login.properties File.
4.  Run the test using testNG.xml file.
5.  View report under report folder which contains extent-report.html(open using web).

# Assumptions
  1. Browser is compatable.
  2. Login Test Scenario: The login page structure  contains specific elements like email input, password input, login button, error message, etc. These elements should match the login.properties configuration file.
  3. Web Application Stability: The base_URL provided in config.properties assumes that the web application is stable and running. The URL should be updated accordingly if testing is done on a different site.
  4. Extent Report Integration: Screenshots are captured when tests fail, and the path to the screenshot is attached to the Extent Report. Reports are saved in the /reports/ folder.

# Limitations
  1.Any changes to the UI elements such as locators, IDs, or classes will require updates in the login.properties file.
  
     
