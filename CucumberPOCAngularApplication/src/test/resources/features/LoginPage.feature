Feature: Login with valid credentials

@Sanity
Scenario: Login Page title
Given user launches the browser and opens OrangeHRM page "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
Then user should get page title as "OrangeHRM"

@Sanity
Scenario: Successful Login with valid credentials
Given user launches the browser and opens OrangeHRM page "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
When user enters UserName as "Admin" and Password as "admin123"
And clicks on login button and navigates to Home page


