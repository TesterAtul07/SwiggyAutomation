package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	
	@FindBy (xpath ="//div[text()='SIGN UP']")
	private WebElement signUpButton;

	private WebDriver driver;
	
	public CheckOutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void clickOnSingUpButton() throws InterruptedException
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(signUpButton).click().build().perform();
		Thread.sleep(1000);
	}
}
