package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.FindOwnersPage;
import pages.HomePage;
import pages.OwnerInformationPage;

public class SearchForOwnerTest extends TestBase{
	
	
	HomePage homeObject;
	FindOwnersPage findOwnerObject;
	OwnerInformationPage ownerInformationObject;
	
	@Test
	public void userCanSearchForTheAddedOwnerSuccessfully()
	{
		homeObject= new HomePage(driver);
		homeObject.openFindOwnersPage();
		findOwnerObject= new FindOwnersPage(driver);
		findOwnerObject.searchForOwner("Amy");
		findOwnerObject.clickFindOwnerButton();
		ownerInformationObject=new OwnerInformationPage(driver);
		Assert.assertTrue(ownerInformationObject.ownerNameThatIsSerachFor.getText().contains("Reda Amy"));
		//WebElement ownerName= driver.findElement(By.xpath("//b[contains(text(),'Reda Amy')]"));
		//Assert.assertEquals("Reda Amy",ownerName.getText());
	}
	
	@Test
	public void userCannotSearchForNotPresentOwner()
	{
		homeObject= new HomePage(driver);
		homeObject.openFindOwnersPage();
		findOwnerObject= new FindOwnersPage(driver);
		findOwnerObject.searchForOwner("Am56437458y");
		findOwnerObject.clickFindOwnerButton();
		//WebElement errorMessage= driver.findElement(By.xpath("//p[contains(text(),'has not been found')]"));
		//Assert.assertEquals("has not been found", errorMessage.getText());
		Assert.assertTrue(findOwnerObject.searchErrorMessage.getText().contains("has not been found"));
	}
	
	
	

}
