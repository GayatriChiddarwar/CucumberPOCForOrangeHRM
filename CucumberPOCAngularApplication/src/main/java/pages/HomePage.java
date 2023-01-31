package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import factory.DriverFactory;
import utitlies.*;
public class HomePage {

	WebDriver driver = DriverFactory.getDriver();
	
	 private ElementUtils Utility = new ElementUtils(driver);
	//by Locator
	private By addbutton =By.xpath("//button[normalize-space()='Add']");
	private By PIMlink=By.xpath("//a[@href='/web/index.php/pim/viewPimModule']"); 
	Logger log =LogManager.getLogger(this.getClass());
	//Constructor
	public HomePage(WebDriver driver)
	{
		this.driver =driver;
		
	}
	
	public void addEmployee() throws InterruptedException
	{
		driver.findElement(PIMlink).click();
		Thread.sleep(3000);
		driver.findElement(addbutton).click();
		Utility.ImplicitWait();
		
		
	}
}
