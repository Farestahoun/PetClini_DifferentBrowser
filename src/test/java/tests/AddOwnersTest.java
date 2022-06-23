package tests;

import org.testng.Assert;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.AddOwners;
import pages.FindOwnersPage;
import pages.HomePage;
//import org.testng.asserts.SoftAssert;

public class AddOwnersTest extends TestBase{
	
	
	
	
	// Object on level of class to be visible in case adding multiple TC in these class 
	HomePage homeObject;
	FindOwnersPage findOwnerObject;
	AddOwners addOwnerObject;

	
	
	
	@Test
	public void UserCanAddOwnerSuccessfully()
	{
		homeObject= new HomePage(driver);
		homeObject.openFindOwnersPage();
		findOwnerObject= new FindOwnersPage(driver);
		findOwnerObject.openAddOwnerPage();
		addOwnerObject= new AddOwners(driver);
		addOwnerObject.addOwner("Hamza", "Klein", "Nahria", "Tanta", "01272564239");
		//
		WebElement presenceOfElemnt= driver.findElement(By.xpath("//b[contains(text(),'Hamza Klein')]"));
		Assert.assertEquals(true, presenceOfElemnt.isDisplayed());
	}
    
	@Test
	public void userCannotAddOwnerInCaseTelephoneFieldContainsStrings()
	{
		homeObject= new HomePage(driver);
		homeObject.openFindOwnersPage();
		findOwnerObject= new FindOwnersPage(driver);
		findOwnerObject.openAddOwnerPage();
		addOwnerObject= new AddOwners(driver);
		addOwnerObject.addOwner("Kaln", "Maln", "swrwrwrg", "ffwfeffwe", "dfwfefwewfwef");
		WebElement errorMessage= driver.findElement(By.xpath("//span[contains(text(),'numeric value out of bounds (<10 digits>.<0 digits> expected)')]"));
		Assert.assertEquals(true, errorMessage.isDisplayed());	
	}
	
	@Test
	public void userCannotAddOwnerInCaseTelephoneFieldContainsMoreThan10Intigers()
	{
		homeObject= new HomePage(driver);
		homeObject.openFindOwnersPage();
		findOwnerObject= new FindOwnersPage(driver);
		findOwnerObject.openAddOwnerPage();
		addOwnerObject= new AddOwners(driver);
		addOwnerObject.addOwner("Kaln", "Maln", "swrwrwrg", "ffwfeffwe", "01265786543289765");
		WebElement errorMessage= driver.findElement(By.xpath("//span[contains(text(),'numeric value out of bounds (<10 digits>.<0 digits> expected)')]"));
		Assert.assertEquals(true, errorMessage.isDisplayed());	
	}
	
	@Test
	public void userCannotAddOwnerInCaseThatRequiredFieldsAreBalnk()
	{
		homeObject= new HomePage(driver);
		homeObject.openFindOwnersPage();
		findOwnerObject= new FindOwnersPage(driver);
		findOwnerObject.openAddOwnerPage();
		addOwnerObject= new AddOwners(driver);
		addOwnerObject.addOwner("", "", "", "", "");
		WebElement firstNameErrorMessage= new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(driver ->driver.findElement(By.xpath("(//span[contains(text(),'must not be empty')]) [1]")));
		
		soft.assertEquals("must not be empty", firstNameErrorMessage.getText());
		WebElement lastNameErrorMessage= new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(driver ->driver.findElement(By.xpath("(//span[contains(text(),'must not be empty')]) [2]")));
	
		soft.assertEquals("must not be empty", lastNameErrorMessage.getText());
		WebElement adressErrorMessage= new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(driver ->driver.findElement(By.xpath("(//span[contains(text(),'must not be empty')]) [3]")));
	
		soft.assertEquals("must not be empty", adressErrorMessage.getText());
		WebElement cityErrorMessage= new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(driver ->driver.findElement(By.xpath("(//span[contains(text(),'must not be empty')]) [4]")));
	
		soft.assertEquals("must not be empty", cityErrorMessage.getText());
		WebElement telephoneErrorMessage= new WebDriverWait(driver, Duration.ofSeconds(100))
				.until(driver ->driver.findElement(By.xpath("//span[contains(text(),'numeric value out of bounds (<10 digits>.<0 digits> expected)')]")));
		assertTrue(telephoneErrorMessage.getText().contains("numeric value out of bounds"));
	}
	
}
