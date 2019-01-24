package utilities;

import java.util.Properties;
import java.util.UUID;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserInitiation extends Configuration{
	
public static WebDriver driver;
public static Configuration config=new Configuration();

	@BeforeClass
	@Parameters({"browserName"})
	public static void loadBrowser(String browserName){
	  config.LoadConfiguration();
		if(browserName.equals("chrome")){
			//Using WebdriverManager to setup the Chrome instead of setProperty
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}else if(browserName.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(browserName.equals("Ie")){
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.get(config.property.getProperty("URL"));
	}
	
	@AfterMethod()
	public static void resultOfTest(ITestResult result){
		if(ITestResult.FAILURE==result.getStatus()){
			ReusbaleFunctions.screenShot(driver, result.getInstanceName()+UUID.randomUUID());
		}
	  }
	
	@AfterClass
	public static void tearDown(){
		driver.quit();
	}
	}


