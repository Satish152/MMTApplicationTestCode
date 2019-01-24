package tasksToDevelop;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import utilities.BrowserInitiation;
import webPages.MMTHomePage;

public class LoginFieldValidation extends BrowserInitiation{

	@Test
	public static void LoginFieldsCheck(){
		MMTHomePage obj=PageFactory.initElements(driver, MMTHomePage.class);
		obj.VerifyLoginFields();
	}
}
