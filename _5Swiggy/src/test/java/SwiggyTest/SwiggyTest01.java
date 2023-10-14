package SwiggyTest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Browser;
import Pages.AccountWindow;
import Pages.CheckOutPage;
import Pages.FilterWindow;
import Pages.HomePage;
import Pages.SelectedFoodPage;
import Pages.TargetLocationPage;
import Pages.WithFiltersPage;
import SwiggyUtility.Utilities;

public class SwiggyTest01 extends Browser{
	
	private WebDriver driver;
	private AccountWindow accountWindow;
	private CheckOutPage checkOutPage;
	private FilterWindow filterWindow;
	private HomePage homePage;
	private SelectedFoodPage selectedFoodPage;
	private TargetLocationPage targetLocationPage;
	private WithFiltersPage withFiltersPage;
	private String TestID;
	
 @BeforeTest
 public void launchBrowser (String browsername)
 {
	 if(browsername.equals("chrome"))
		{
		  driver = launchChrome();
		}
		
		if(browsername.equals("firefox"))
		{
			driver = launchFireFox();	
		}
		
		if(browsername.equals("microsoftEdge"))
		{
			driver = launchEdge();
		}
		
						
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

 }
 
 @BeforeClass
	public void creatingPOMObject()
	{
		accountWindow = new AccountWindow(driver);
		checkOutPage = new CheckOutPage(driver);
		filterWindow = new FilterWindow(driver);
		homePage = new HomePage(driver);
		selectedFoodPage = new SelectedFoodPage(driver);
		targetLocationPage = new TargetLocationPage(driver);
		withFiltersPage = new WithFiltersPage(driver);
	}
	
	@BeforeMethod
	public void launchBrowser() throws IOException
	{
		driver.get("");	
	}
	
	@Test
	public void selectProductFunctionality() throws InterruptedException, IOException
	{
		TestID = "SW001";
		homePage.clickOnSearchLocationTab();
		homePage.sendLocationAsInput("");
		homePage.clickOnTargetLocation();
		targetLocationPage.clickOnTargetFood();
		targetLocationPage.clickOnFilterButton();
		filterWindow.clickOnCostLowToHighRadioButton();
		filterWindow.clickOnApplyButton();
		withFiltersPage.clickOnSelectedFood();
		selectedFoodPage.clickOnTopPickButton();
		selectedFoodPage.clickOnViewCartButton();
		checkOutPage.clickOnSingUpButton();
		accountWindow.clickOnPhoneNumberFeild();
		accountWindow.sendPhoneNumber("");
		accountWindow.clickOnNameFeild();
		accountWindow.sendName("");
		accountWindow.clickOnEmailFeild();
		accountWindow.sendEmail("");
		accountWindow.clickOnContinueButton();
		
		
	}
	
	@AfterMethod
	public void printStatement(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
		  Utilities.captureScreenshot(driver, "test-output//FailedTestScreenshot", TestID);
	     }
	}
	
	@AfterClass
	public void clearObject()
	{
		accountWindow = null;
		checkOutPage = null;
		filterWindow = null;
		homePage = null;
		selectedFoodPage = null;
		targetLocationPage = null;
		withFiltersPage = null;

	}
	
	@AfterTest
	public void closeTheBrowser()
	{
		driver.quit();
		driver = null;
		System.gc();
	}


}
