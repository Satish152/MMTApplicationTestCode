package tasksToDevelop;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import utilities.BrowserInitiation;
import webPages.MMTHomePage;

public class ReturnDateFieldValidation extends BrowserInitiation{

	@Test
	public static void returnFieldValidation(){
		MMTHomePage obj=PageFactory.initElements(driver, MMTHomePage.class);
		obj.ReturnDateValidation("disable");
		obj.ReturnDateValidation("RoundTrip");
	}
}
