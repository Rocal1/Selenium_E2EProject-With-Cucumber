package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	//DECLARE THE WEBDRIVER
	public WebDriver driver;
	
	//SET THE CONSTRUCTOR (to assign/connect the driver from the page to the driver test)
	public LandingPage (WebDriver driver) {
		this.driver=driver;
	}
	
	//SET THE LOCATORS PAGE
	By signin= By.cssSelector("a[href*='sign_in']");
	By title= By.cssSelector(".text-center>h2");
	By navbar= By.cssSelector(".navbar-nav");
	By modal= By.cssSelector("div [class*=\"sumome-react-wysiwyg-image\"]>div > div:nth-child(1)");
	
	
	//SET THE METHODS PAGE
	public WebElement getLogin() {
		return driver.findElement(signin);
	}
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	public WebElement getNavBar() {
		return driver.findElement(navbar);
	}
	public WebElement getModal() {
		return driver.findElement(modal);
	}
}
