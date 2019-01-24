package tasksToDevelop;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import utilities.BrowserInitiation;
import webPages.MMTHomePage;

public class DropdownValuesInTripHeader extends BrowserInitiation{

	@Test
	public static void tripDropdown(){
		MMTHomePage obj=PageFactory.initElements(driver, MMTHomePage.class);
		obj.TripHeaderOption("dropdownValues");
	}
}
