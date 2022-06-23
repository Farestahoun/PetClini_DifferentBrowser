package pages;


//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FindOwnersPage extends PageBase{

	public FindOwnersPage(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	
	@FindBy (xpath="//a[contains(text(),'Add Owner')]")
	WebElement addOwner;
	
	@FindBy (xpath="//input[@name='lastName']")
	WebElement searchBox;
	
	@FindBy (xpath="//button[@type='submit']")
	WebElement findOwnerButton;
	
	@FindBy(xpath="//p[contains(text(),'has not been found')]")
	public WebElement searchErrorMessage;
	

	//Methods
	public void openAddOwnerPage()
	{
		clickButton(addOwner);
	}
	
	public void searchForOwner(String ownerName)
	{
		setTextElementText(searchBox, ownerName);
	}
	
	public void clickFindOwnerButton()
         
	{
		clickButton(findOwnerButton);
	}
	
	
	
}
