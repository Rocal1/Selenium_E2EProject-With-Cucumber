package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializerDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
		"C:\\Users\\rodri\\Documents\\E2EProject\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\rodri\\Documents\\Selenium JARs & WebDrivers\\WebDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
			"C:\\Users\\rodri\\Documents\\Selenium JARs & WebDrivers\\WebDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (prop.getProperty("browser").trim().equalsIgnoreCase("Internetexplorer")) {
			System.setProperty("webdriver.ie.driver",
			"C:\\Users\\rodri\\Documents\\Selenium JARs & WebDrivers\\WebDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public void getScrenshoot(String name) throws IOException {
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile= new File("C:\\Users\\rodri\\Documents\\E2EProject\\"+name+"-screenshoot.png");
		FileUtils.copyFile(srcFile, destFile);
	}
}
