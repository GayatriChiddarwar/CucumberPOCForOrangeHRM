package factory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class DriverFactory {
	
	public WebDriver driver;
	
	


	public WebDriver DriverFactory(WebDriver driver)
	{
		return driver =driver;
		
	}
	
	public static ThreadLocal<WebDriver> tlDriver =new ThreadLocal<>();
	
	/**
	 * Thid method is used to intialize the threadlocal driver as per given browser
	 * @param browser
	 * @return it will return tldriver
	 */
	public WebDriver init_driver(String browser)
	{
		System.out.println("browser is "+ browser);
		
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver()); //create a local  driver copy for parallel execution 
		}else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver()); //create a local  driver copy for parallel execution 
		} else if(browser.equals("safari"))
		{
		
			tlDriver.set(new SafariDriver()); //set is void method create a local  driver copy for parallel execution 
		} else
		{
			System.out.println("please give proper drier name");
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
		
	}	
		
		/**
		 * get the driver for return webdriver instance 
		 * sync for multiple thraeds in sychronized way
		 */
	
		public static synchronized WebDriver getDriver()
		{
			return tlDriver.get(); //get Returns:the current thread's value of this thread-local
			
		}
	}

