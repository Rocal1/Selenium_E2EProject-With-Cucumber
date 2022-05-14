package stepDefinition;

import org.junit.runner.RunWith;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;


@RunWith(Cucumber.class)
public class stepDefinition extends base{

	@Given("Inicialize the browser with chrome")
	public void inicialize_the_browser_with_chrome() throws Throwable {
		driver=initializerDriver();
	}

	@And("Navigate to {string} site")
	public void navigate_to_site(String string) {
		driver.get(string);

	}

	@And("If modal presents click on close")
	public void If_modal_presents_click_on_close() throws InterruptedException {
		LandingPage lp = new LandingPage(driver);
		//Thread.sleep(15000);
		if(lp.getModal().isDisplayed()){
			lp.getModal().click();
			//Thread.sleep(8000);
		}
		
	}
	
	@And("Click on Login link in home page to land on Secure sign in Page")
	public void click_on_Login_link_in_home_page_to_land_on_Secure_sign_in_Page() {
		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();
	}

	@When("User enters (.*) and (.*) and logs in")
	public void user_enters_and_and_logs_in(String username, String password) {
		LoginPage logp = new LoginPage(driver);
		logp.getEmail().sendKeys(username);
		logp.getPassword().sendKeys(password);
		logp.getSubmit().click();
	}

	@Then("Verify that user is succesfully logged in")
	public void verify_that_user_is_succesfully_logged_in() {
		System.out.println("Logged into the APP");
		driver.quit();
	}

}
