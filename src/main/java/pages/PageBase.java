package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class PageBase {
	
	protected WebDriver driver; 
	
	//Create parametarized Constructor with (WebDriver driver) to avoid repeating instalizing driver in the objects
	// All pages in pages should inherit from PageBase
	public PageBase(WebDriver driver) 
	{
	   PageFactory.initElements(driver, this);
	}
	
	//Method for Click. It take WebElemnt. It will be called in the page object in case that i want to click
	// It will better to be public and static 
	protected static void clickButton(WebElement button)
	{
		button.click();
	}
	
	//Method for Sendkeys. It take WebElement and Value. It will be called in the page object in case that i want to click
	protected static void setTextElementText(WebElement textElement, String value)
	{
		textElement.sendKeys(value);
	}

}
