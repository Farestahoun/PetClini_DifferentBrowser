package pages;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OwnerInformationPage extends PageBase{

	public OwnerInformationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath=("//b[contains(text(),'Reda Amy')]"))
	public WebElement ownerNameThatIsSerachFor;
}
