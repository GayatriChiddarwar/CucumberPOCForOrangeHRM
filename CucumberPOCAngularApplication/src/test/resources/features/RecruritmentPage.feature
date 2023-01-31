Feature: Test home page features
Background:Successful Login with valid credentials
Given user launches the browser and opens OrangeHRM page "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
When user enters UserName as "Admin" and Password as "admin123"
And clicks on login button and navigates to Home page

Scenario Outline: User should able o search for job vacancy under Recruitment field
Given User is on home page and Clicks on Recruitment Module
When user clicks on Vacencies user lands on VewJobVacancy Page
When user selects "<Job Title>" and clicks on search button
Then User should get records for job title as "<Job Title>"

Examples:
|Job Title|
|QA Lead|
|Chief Executive Officer|