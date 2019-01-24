package utilities;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReusbaleFunctions extends Configuration{

	public static void screenShot(WebDriver driver,String fileName){
		TakesScreenshot ts=((TakesScreenshot)driver);
		File file=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(Configuration.property.getProperty("ScreenShotPath")+"\\"+fileName+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void VerifyExistOfElement(WebElement ele){
		if(ele.isDisplayed()){
			assertTrue(true);
		}else{
			assertTrue(false);
		}
	}
}
