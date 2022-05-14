package Tutorial;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class ValidateNavigationBarTest extends base{
	
	@BeforeTest
	public void SetUp() throws IOException {
		driver=initializerDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void validateTitle() throws IOException {
		LandingPage lp= new LandingPage(driver);
		assertTrue(lp.getNavBar().isDisplayed());
	
	}

	@AfterTest
	public void TearDown() {
		driver.close();
		driver=null;
	}
}
