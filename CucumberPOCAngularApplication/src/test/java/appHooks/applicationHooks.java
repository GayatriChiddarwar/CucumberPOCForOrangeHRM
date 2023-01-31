package appHooks;

import java.io.File;
import java.sql.Driver;
import java.time.Duration;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import factory.DriverFactory;

import java.util.ResourceBundle;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utitlies.ConfigReader;


public class applicationHooks {

	private WebDriver driver;
	public Logger logger;
   public ResourceBundle rb;
   private DriverFactory driverfactory;
   private ConfigReader configReader;
   Properties prop;

	@Before(order=0)
	public void getProperty()
	{
		configReader =new ConfigReader();
		prop = configReader.init_prop();
	}
   
	
	
	@Before(order =1)
	public void launchBrowser()
	{
		String BrowserName =prop.getProperty("browser");
		driverfactory = new DriverFactory();
		driver =driverfactory.init_driver(BrowserName);
	};
	
   
	//@Before(order = 1)//junit hooks- execute once before scenrio
	 public WebDriver setUp()
	   {
		   //for loding config (for browser)
		  rb=rb.getBundle("config"); 
		  String br=rb.getString("browser");
		  //for logging
		//logger =LogManager.getLogger(this.getClass()); 
		return driver;
	   }
	   
	
	
	@After(order = 0)
	public void quitbrowser()
	{
		//driver.quit();
	}
	
	@After(order =1)
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			//take screen shot:
			String ScreenShotName = scenario.getName().replaceAll(" ", "_");
			//convert driver into typecast into 
			byte [] sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);//for jenkins byte will be preferred
			scenario.attach(sourcePath, "image/jpg", ScreenShotName);
			
			File destPath=new File("FailedCases");
			
			//FileUtils.copyFile(sourcePath, destPath);
		}
	}
}
