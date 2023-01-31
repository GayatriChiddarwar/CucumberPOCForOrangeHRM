package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import factory.DriverFactory;
import utitlies.ElementUtils;

public class RecruitmentPage {

	WebDriver driver = DriverFactory.getDriver();
	Logger log = LogManager.getLogger(this.getClass());
	private ElementUtils Utility = new ElementUtils(driver);

	// locators
	private By RecruitmentLink = By.xpath("//a[@href='/web/index.php/recruitment/viewRecruitmentModule']");

	private By jobtitle = By.xpath("//*[contains(text(),'QA Lead')]");

	public RecruitmentPage(WebDriver driver) {
		this.driver = driver;

	}

	public void searchJobacancy(String JobTitle) {

		List<WebElement> selectJob = driver
				.findElements(By.xpath("//*[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']"));
		WebElement element = selectJob.get(0);
		element.click();

		List<WebElement> selectJobOptions = driver.findElements(By.xpath("//*[@class='oxd-select-text-input']"));

		By jobtitle1 = By.xpath("//*[contains(text(),'" + JobTitle + "')]");

		selectJobOptions.get(0).findElement(jobtitle1).click();
	
		log.info("Job Title send for search");
	}

	public void navigateToRecruitmentModule() {
		driver.findElement(RecruitmentLink).click();

	}
}
