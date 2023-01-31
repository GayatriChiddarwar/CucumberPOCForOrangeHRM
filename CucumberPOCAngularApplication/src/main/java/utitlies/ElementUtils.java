package utitlies;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;

public class ElementUtils {
	WebDriver driver = DriverFactory.getDriver();
	
	
	
	public ElementUtils(WebDriver driver)
	{
		this.driver= driver;
	}
	
	/**
	 * This method is used for implcit wait of 3seconds
	 */
	public void ImplicitWait()
	{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	
	/**
	 * Method is to click on webElement
	 * @param send xpath of webelement
	 */
	
	public void doClick(String Xpath) 
	{
		driver.findElement(By.xpath(Xpath)).click();
		ImplicitWait();
	}
	
	public void sendInputKeys(By Locator ,String InputData)
	{
		driver.findElement(Locator).sendKeys(InputData);
	}
}
