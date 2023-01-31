package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.model.Log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import factory.DriverFactory;
import utitlies.ElementUtils;

public class AddEmployeePage {

	private WebDriver driver = DriverFactory.getDriver();
	private ElementUtils Utility = new ElementUtils(driver);
	// Loactors
	private By FName = By.xpath("//input[@placeholder='First Name']");
	private By MName = By.xpath("//input[@placeholder='Middle Name']");
	private By LName = By.xpath("//input[@placeholder='Last Name']");
	private By LoginDetailsBtn = By.xpath("//input[@type='checkbox']");
	private By inputFields = By.xpath("//input[@class='oxd-input oxd-input--active");
	Logger log = LogManager.getLogger(this.getClass());

	public AddEmployeePage(WebDriver driver) {
		this.driver = driver;

	}

	public void AddEmpDetails(String Fname, String mname, String lname) {
		driver.findElement(FName).sendKeys(Fname);
		driver.findElement(MName).sendKeys(mname);
		driver.findElement(LName).sendKeys(lname);
		log.info("Employee Details added");
	}

	public void loginDetails() {
		Utility.doClick("//*[@class='oxd-switch-input oxd-switch-input--active --label-right']");
		System.out.println("Click on Login Details button");
		log.info("Login info checked");
	}

	public void sendEmpCreds(String LoginName, String Password) {
		List<WebElement> listOfInputFields = driver
				.findElements(By.xpath("//input[@class='oxd-input oxd-input--active']"));
		// *[@class='oxd-input-group oxd-input-field-bottom-space']
		System.out.println("Size of input fileds are:" + listOfInputFields.size());
		listOfInputFields.get(2).sendKeys(LoginName);
		listOfInputFields.get(3).sendKeys(Password);
		listOfInputFields.get(4).sendKeys(Password);
		log.info("Employee credentials sent succesfully");

	}

	public void saveDetails() {
		Utility.doClick("//button[normalize-space()='Save']");
		log.info("New Employee Created");

	}
}
