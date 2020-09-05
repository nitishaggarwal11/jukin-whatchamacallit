package driver;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
	
	private static WebDriver driver;
	
	/***
	 * Constructor
	 */
	public DriverFactory() 
	{
		System.out.println("In Driver Factory Class");
	}
	
	/***
	 * @description Function to Initialize the driver
	 * @param browser
	 * @return
	 */
	public static void initDriver(String browser, String impliciWaitString) 
	{
		
		switch(browser.toUpperCase())
		{
			case "CHROME":
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case "IE":
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				break;
			case "FIREFOX":
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "geckodriver.exe");
				driver = new FirefoxDriver();
				break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(impliciWaitString), TimeUnit.SECONDS);
		
		//return driver;
	}
	
	/***
	 * @description Function to navigate to the application
	 * @param url
	 */
	public static void navigateToApplication(String url) {
		getDriver().get(url);
	}
	
	/***
	 * @description Function to get the Driver instance 
	 * @return
	 */
	public static WebDriver getDriver() {
		return driver;
	}
}
