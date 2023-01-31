package stepdefinations;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;

import pages.RecruitmentPage;
import utitlies.ElementUtils;
//import utitlies.Logger;
public class RecruitmentPageSteps {
	WebDriver driver = DriverFactory.getDriver();
	private ElementUtils Utility = new ElementUtils(driver);
	private RecruitmentPage rp = new RecruitmentPage(driver);
	Logger log =LogManager.getLogger(this.getClass());

	@Given("User is on home page and Clicks on Recruitment Module")
	public void user_is_on_home_page_and_clicks_on_recruitment_module() {
		Utility.ImplicitWait();
	   rp.navigateToRecruitmentModule();
       log.info("Navigated to job vacancy page");
	}

	@When("user clicks on Vacencies user lands on VewJobVacancy Page")
	public void user_clicks_on_vacencies_user_lands_on_vew_job_vacancy_page() {
		Utility.ImplicitWait();
		Utility.doClick("//a[contains(text(),'Vacancies')]");
		
	    }

	@When("user selects {string} and clicks on search button")
	public void user_selects_and_clicks_on_search_button(String jobtitle) {
		rp.searchJobacancy(jobtitle);
		
	}

	@Then("User should get records for job title as {string}")
	public void user_should_get_records_for_job_title_as(String string) {
		 Utility.doClick("//button[@type='submit']");
	  }
}
