Feature: Test home page features
Background:Successful Login with valid credentials
Given user launches the browser and opens OrangeHRM page "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
When user enters UserName as "Admin" and Password as "admin123"
And clicks on login button and navigates to Home page

@Sanity2
Scenario Outline: Add New Employee to PIM module
Given user Clicks on PIM and Click on Add button to add Employee
And user lands on AddEmployee Page
And User Enters details to addEmployee page as "<UserName>","<MiddleName>" and "<LastName>"
And User Click on Create Login Details button
And Enters loginName and Password into respective fields 
|LoginName|Password|
|dsjfg|PandyJadhav@1234|
#|RaviShekshar|RaviShekhar@124|
#|RajKumar|RajKumar@1123|
Then Click on Save 

Examples:
|UserName|MiddleName|LastName|
|Pandurang|ram|Yadav|
#|Raj|Kumar|Yadav|
#|ravi|shekhar|yadav|


