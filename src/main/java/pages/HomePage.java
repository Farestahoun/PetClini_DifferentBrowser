package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class HomePage extends PageBase{

	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	


	
	
	//Elements
	@FindBy(xpath= "//span[contains(text(),'Find owners')]")
	WebElement findOwners;
	
	
	//Methods
	public void openFindOwnersPage()
	{
		clickButton(findOwners);
	}

}
