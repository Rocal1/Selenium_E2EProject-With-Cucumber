package Tutorial;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePageTest extends base{
	
	@BeforeTest
	public void SetUp() throws IOException {
		driver=initializerDriver();
	}
	
	@Test (dataProvider="getData")
	public void basePageNavigation(String email,String password, String text) throws IOException{
		driver.get(prop.getProperty("url"));
		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();
		LoginPage logp = new LoginPage(driver);
		logp.getEmail().sendKeys(email);
		logp.getPassword().sendKeys(password);
		System.out.println(text);
		logp.getSubmit().click();		
	}

	@DataProvider
	public Object[][] getData() {
		//Object[total rows of data][total columns of values per row]
		Object[][] data= new Object[2][3];
		//1st ROW
		data[0][0]="restricted@a.com";
		data[0][1]="123456789";
		data[0][2]="Restricted user";
		//2nd ROW
		data[1][0]="nonrestricted@a.com";
		data[1][1]="123456789";
		data[1][2]="Non Restricted user";
		
		return data;
	}
	
	@AfterTest
	public void TearDown() {
		driver.close();
		driver=null;
	}	
}
