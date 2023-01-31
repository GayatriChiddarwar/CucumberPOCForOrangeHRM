package stepdefinations;

import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import factory.DriverFactory;
//import appHooks.applicationHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import utitlies.ElementUtils;
import pages.AddEmployeePage;
import pages.HomePage;
import io.cucumber.java.en.Then;
public class LoginPageSteps {

	WebDriver driver = DriverFactory.getDriver();
	private LoginPage lp = new LoginPage(driver);
	private DriverFactory df = new DriverFactory();
	private HomePage hp = new HomePage(driver);
	AddEmployeePage aep =new AddEmployeePage(driver);
	private ElementUtils Utility = new ElementUtils(driver);
	//applicationHooks appHooks;
	public ResourceBundle rb;
	public Logger logger;
	
	@Given("user launches the browser and opens OrangeHRM page {string}")
	public void user_launches_the_browser_and_opens_OrangeHRM_page(String URL) {
	DriverFactory df =new DriverFactory();
	df.getDriver().get(URL);
	}
	   

	
	@Then("user should get page title as {string}")
	public void user_should_get_page_title_as(String string) {

	   String title= lp.getTitle(string);
	   Assert.assertTrue(title.contains(string));
	    
	}

	@When("user enters UserName as {string} and Password as {string}")
	public void user_enters_user_name_as_and_password_as(String uname, String pass) throws InterruptedException {
		//LoginPage lp  =new LoginPage(driver);
		Thread.sleep(5000);
        lp.enteruserName(uname);
       lp.enterpasoword(pass);
       lp.login();
	}
	
	@When("clicks on login button and navigates to Home page")
	public void clicks_on_login_button_and_navigates_to_Home_page() throws InterruptedException {
		Thread.sleep(5000);
		
		String homepagetitle = df.getDriver().getTitle();
		System.out.println("home page title is  " +homepagetitle);
	}






}
