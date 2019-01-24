package tasksToDevelop;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import utilities.BrowserInitiation;
import webPages.MMTHomePage;

public class MMTFlightSearch extends BrowserInitiation{

	
	@Test(dataProvider="TestDataProvider")
	public static void Test1(String Param1,String Param2,String Param3,String Param4,String Param5) throws InterruptedException{
		MMTHomePage page=PageFactory.initElements(driver, MMTHomePage.class);
		page.searchFlight(Param1, Param2,Param3,Param4,Param5);
	}
}
