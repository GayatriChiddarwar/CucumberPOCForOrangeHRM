package stepdefinations;

import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.AddEmployeePage;
import pages.HomePage;
import pages.LoginPage;
import utitlies.*;

public class HomePageSteps {
	WebDriver driver = DriverFactory.getDriver();
	private LoginPage lp = new LoginPage(driver);
	private DriverFactory df = new DriverFactory();
	private HomePage hp = new HomePage(driver);
	private AddEmployeePage aep = new AddEmployeePage(driver);
	private ElementUtils Utility = new ElementUtils(driver);
    Logger log;
    
	@Given("user Clicks on PIM and Click on Add button to add Employee")
	public void user_Clicks_on_PIM_and_Click_on_Add_button_to_add_Employee() throws InterruptedException {
		hp.addEmployee();
		//log.info("Navigated to PIM module");

	}

	@When("user lands on AddEmployee Page")
	public void user_lands_on_add_employee_page() {
		Utility.ImplicitWait();
		driver.getTitle();
	}


	@Given("User Enters (.*),Kumar and Yadav")
	public void user_enters_raj_kumar_and_yadav(String FirstName, String MiddleName, String LastName) {
	
		aep.AddEmpDetails(FirstName, MiddleName, LastName);
	}


	@Given("User Enters details to addEmployee page as {string},{string} and {string}")
	public void user_enters_details_to_add_employee_page_as_and(String FName, String MName, String LName) {
	aep.AddEmpDetails(FName, MName, LName);
	}

	@When("User Click on Create Login Details button")
	public void user_click_on_Create_Login_Details_button() {
		//driver.findElement(By.xpath("//*[@class='oxd-switch-input oxd-switch-input--active --label-right']")).click();
	   
	 aep.loginDetails();
	}

	@Given("Enters loginName and Password into respective fields")
	public void enters_login_name_and_password_into_respective_fields(DataTable dataTable) {
	  List<Map<String,String>> credList = dataTable.asMaps();
	 String LoginName= credList.get(0).get("LoginName");
	 String Password= credList.get(0).get("Password");
	 
	 aep.sendEmpCreds(LoginName, Password);
	 //
	//input[@class='oxd-input oxd-input--active
		
//		for(int i=5; i<=listOfInputFields.size();i++)
//		{
//			//indexOfusername =5 
//			String textvalue = listOfInputFields.get(i).getText();
//			String TagName =listOfInputFields.get(i).getTagName();
//		   listOfInputFields.get(5).sendKeys(LoginName);
//			
//		 System.out.println("inside for loop: the TextValue is:" + textvalue);
//		 System.out.println("inside for loop: the index  is:" + i);
//		 System.out.println("inside for loop: the tagName is:" + TagName);
//		 System.out.println("inside for loop: Login Name sent as" + LoginName);
//		}
	}
	@Then("Click on Save")
	public void click_on_save() {
	    aep.saveDetails();
	    Utility.ImplicitWait();
	    Utility.ImplicitWait();
	    Utility.ImplicitWait();
	    Utility.ImplicitWait();
	    WebDriverWait wait = new  WebDriverWait(driver, 10);
	    List<WebElement> listOfInputFields = driver.findElements(By.xpath("//input[@class='oxd-input oxd-input--active']"));
		//*[@class='oxd-input-group oxd-input-field-bottom-space']
		System.out.println("Size of input fileds are:"+listOfInputFields.size());
		listOfInputFields.get(3).sendKeys("nick");
		String CurrentURL = driver.getCurrentUrl();
		System.out.println(CurrentURL);
		//String textvalue = listOfInputFields.get(3).getText();
		//System.out.println("emp id is:"+textvalue.substring(0));
		//h6[contains(text(),"Pandurang Yadav")]
		String URL= "https://opensource-demo.orangehrmlive.com/web/index.php/pim/contactDetails";
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/contactDetails/empNumber)");
	
	    
	}

	@Given("user is on personal detail page and click on Contact Details link")
	public void user_is_on_personal_detail_page_and_click_on_contact_details_link() {
	  
	}

	@Given("Enter Address field of contact details {string},{string},{string},{string}")
	public void enter_address_field_of_contact_details (Integer int1) {
	    
	}

	@Given("Enter {string} details")
	public void enter_details(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Enter Email id and click on Save")
	public void enter_email_id_and_click_on_save() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


}
