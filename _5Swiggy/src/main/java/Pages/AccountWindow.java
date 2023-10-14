package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountWindow {
	
	@FindBy (xpath = "//div[text()='SIGN UP']")
	private WebElement phoneNumberFeild;
	
	@FindBy (xpath = "//input[@name='name']")
	private WebElement nameFeild;
	
	@FindBy (xpath = "//input[@name='email']")
	private WebElement emailFeild;
	
	@FindBy (xpath = "//a[@class='_2REYC']")
	private WebElement continueButton;
	
	private WebDriver driver;
	private Actions actions;
	
	public AccountWindow(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		actions = new Actions(driver);
		
	}
	
	public void clickOnPhoneNumberFeild() throws InterruptedException
	{
		actions.moveToElement(phoneNumberFeild).click().build().perform();
		Thread.sleep(1000);
	}

	public void sendPhoneNumber(String phoneNumber) throws InterruptedException
	{
		actions.moveToElement(phoneNumberFeild).sendKeys(phoneNumber).build().perform();
		Thread.sleep(1000);
	}
	
	public void clickOnNameFeild() throws InterruptedException
	{
		actions.moveToElement(nameFeild).click().build().perform();
		Thread.sleep(1000);
	}
	
	public void sendName(String name) throws InterruptedException
	{
		actions.moveToElement(nameFeild).sendKeys(name).build().perform();
		Thread.sleep(1000);
	}
	
	public void clickOnEmailFeild() throws InterruptedException
	{
		actions.moveToElement(emailFeild).click().build().perform();
		Thread.sleep(1000);
	}
	
	public void sendEmail(String email) throws InterruptedException
	{
		actions.moveToElement(emailFeild).sendKeys(email).build().perform();
		Thread.sleep(1000);
	}
	
	public void clickOnContinueButton()
	{
		actions.moveToElement(continueButton).click().build().perform();
		
	}
}
