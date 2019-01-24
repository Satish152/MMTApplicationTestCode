package webPages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import javax.jws.Oneway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utilities.ReusbaleFunctions;

public class MMTHomePage {
public WebDriver driver;

public MMTHomePage(WebDriver driver){
	this.driver=driver;
}

	@FindBy(id="hp-widget__sfrom")WebElement From;
	@FindBy(id="hp-widget__sTo")WebElement To;
	@FindBy(id="hp-widget__depart")WebElement Depart;
	@FindBy(id="hp-widget__return")WebElement ReturnDate;
	@FindBy(xpath="//div[@class='dateFilter hasDatepicker']") WebElement DepartCalendar;
	@FindBy(xpath="//div[@class='dateFilterReturn hasDatepicker']") WebElement ReturnCalendar;
	@FindBy(id="hp-widget__paxCounter_pot")WebElement PassengerCount;
	@FindBy(id="searchBtn")WebElement Search;
	@FindBy(xpath="//div[@class='input__option inputTopRow clearfix']/div[4]")WebElement returnDateDiv;
	@FindBy(xpath="//div[@id='js-switch__option']/div[1]/input") WebElement Oneway;
	@FindBy(xpath="//div[@id='js-switch__option']/div[2]/input") WebElement RoundWay;
	@FindBy(xpath="//div[@id='js-switch__option']/div[3]/input") WebElement MultiCity;
	@FindBy(xpath="//div[@mt-class='trip_login_overlay']/ul/li") List<WebElement> TripDropdown;
	@FindBy(id="ch_login_icon")WebElement Login;
	@FindBy(id="ch_trip")WebElement Trip;
	@FindBy(id="ch_login_email")WebElement EmailOrmobile;
	@FindBy(id="ch_login_password")WebElement Pwd;
	@FindBy(id="ch_login_btn")WebElement  Submit;
	@FindBy(xpath="//div[@class='ch__socialMedia ch__loginSocialMedia']/a[1]")WebElement LoginWithFb;
	@FindBy(linkText="LOG-IN WITH GOOGLE")WebElement LoginWithGoogle;
	
	public void searchFlight(String src,String Dest,String DepartDate,String ReturnDate,String PassengerCount) throws InterruptedException{
		From.clear();
	    From.sendKeys(src);
	    To.clear();
	    To.sendKeys(Dest);
	    Depart.click();
	    List<WebElement> departDate=DepartCalendar.findElements(By.xpath("//div[@class='dateFilter hasDatepicker']/div[1]/div[1]/table/tbody//td"));
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    for(WebElement values:departDate){
	    	if(values.getText().contains(DepartDate)){
	    		values.click();
	    		break;
	    	}
	    }
	    Search.click();
	   synchronized (driver) {
	    driver.wait(2000);
	}
	    if(driver.getTitle().contains("Search"))
	    	assertTrue(true);
	    else
	    	assertTrue(false);
	}
	
	public void ReturnDateValidation(String ValidationType){
		switch(ValidationType){
		case "disable":
			//this is to check Return date field is disable when the option is "Oneway"
			if(Oneway.isSelected()){
				System.out.println("Entered into if statement");
				if(returnDateDiv.getAttribute("class").contains("disable"))
					assertTrue(true);
				else
					assertTrue(false);
				
			}
			break;
			
		case "RoundTrip":
			RoundWay.click();
			if(RoundWay.isSelected()){
				System.out.println("Entered into if statement");
				if(returnDateDiv.getAttribute("class").contains("disable"))
					assertTrue(false);
				else
					assertTrue(true);
				
			}
		}
	}
	
	public void TripHeaderOption(String Validation){
		Actions action=new Actions(driver);
		action.moveToElement(Trip).build().perform();
		switch(Validation){
		case "dropdownValues":
			for(WebElement values:TripDropdown){
				System.out.println(values.getText());
			}
		}
	}
	
	public void VerifyLoginFields(){
		Login.click();
		ReusbaleFunctions.VerifyExistOfElement(EmailOrmobile);
		ReusbaleFunctions.VerifyExistOfElement(Pwd);
		ReusbaleFunctions.VerifyExistOfElement(Login);
		ReusbaleFunctions.VerifyExistOfElement(LoginWithFb);
		ReusbaleFunctions.VerifyExistOfElement(LoginWithGoogle);
	}
}
