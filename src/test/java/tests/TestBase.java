package tests;

import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.lock.qual.EnsuresLockHeldIf;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

//in TestBase we initialize the driver, opening an closing the driver and handling more than drivers  
//All clases in tests should inherit from TestBase
public class TestBase {
    
	//Object from SoftAssertion
	SoftAssert soft=new SoftAssert();
	
	public static  WebDriver driver;

	@BeforeSuite
	
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome") String browserName )
	{
	   if (browserName.equalsIgnoreCase("chrome")) 
	   {
		   WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver(); 
	   }
	   else if (browserName.equalsIgnoreCase("firefox"))
	   {
		   WebDriverManager.firefoxdriver().setup();
		   driver= new FirefoxDriver();
	   }
	   else if (browserName.equalsIgnoreCase("ie"))
	   {
		   WebDriverManager.iedriver().setup();
		   driver= new InternetExplorerDriver();
	   }
	   
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("http://localhost:9099/");
	}


	@AfterSuite
	public void stopDriver()
	{
		driver.quit();
	}





}
