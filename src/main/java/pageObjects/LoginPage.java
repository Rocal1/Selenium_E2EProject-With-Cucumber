package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	//ATTRIBUTES
	public WebDriver driver;

	//CONSTRUCTOR
	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	//LOCATORS
	By email= By.id("user_email");
	By pass= By.id("user_password");
	By submit= By.cssSelector("input.login-button");
	
	//METHODS
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	public WebElement getPassword() {
		return driver.findElement(pass);
	}
	public WebElement getSubmit() {
		return driver.findElement(submit);
	}
}
