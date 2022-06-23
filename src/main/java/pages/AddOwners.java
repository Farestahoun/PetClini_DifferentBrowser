package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

public class AddOwners extends PageBase{

	// This Constructor is automatic autogenerated as soon as i inhert from class that have constructor
	public AddOwners(WebDriver driver) {
		// invoke or call parent class constructor
		super(driver);

	}

	@FindBy(id="firstName")
	WebElement firstNameTxtBoX;
	@FindBy (id="lastName")
	WebElement lastNameTxtBoX;
	@FindBy (xpath="//input[@id='address']")
	WebElement adressTxtBoX;
	@FindBy (xpath="//input[@id='city']")
	WebElement cityTxtBoX;
	@FindBy(xpath="//input[@id='telephone']")
	WebElement telephoneTxtBoX;
	@FindBy(xpath="//button[@type='submit']")
	WebElement addOwnerButton;
	
	public void addOwner(String firstName, String lastName, String adresse, String city, String telephone)
	{
		setTextElementText(firstNameTxtBoX, firstName);
		setTextElementText(lastNameTxtBoX, lastName);
		setTextElementText(adressTxtBoX, adresse);
		setTextElementText(cityTxtBoX, city);
		setTextElementText(telephoneTxtBoX, telephone);
		clickButton(addOwnerButton);
	}



}