package pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	// 1.By locators

	private By username = By.xpath("//input[@placeholder='Username']");
	private By password = By.name("password");
	private By signinbutton = By.xpath("//button[normalize-space()='Login']");

	// 2.Constructor

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitle(String title) {
		return driver.getTitle();

	}

	public void enteruserName(String getuseranme) {
		driver.findElement(username).sendKeys(getuseranme);

	}

	public void enterpasoword(String getpass) {
		driver.findElement(password).sendKeys(getpass);
	}

	public void login() {
		driver.findElement(signinbutton).click();

	}
}
