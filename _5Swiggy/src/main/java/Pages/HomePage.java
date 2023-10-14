package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy (xpath = "//input[@id='location']")
	private WebElement searchLoactionTab;
	
	@FindBy (xpath = "//span[text()='Pune, Maharashtra, India']")
	private WebElement targetLocation;
	
	private WebDriver diver;
	private Actions actions;
	
	public HomePage(WebDriver driver)
	
	{
		PageFactory.initElements(driver, this);
		this.diver = driver;
		actions = new Actions(diver);
		
	}
	

	public void clickOnSearchLocationTab() throws InterruptedException
	{
		actions.moveToElement(searchLoactionTab).click().build().perform();
		Thread.sleep(1000);
	}
	
	public void sendLocationAsInput(String location) throws InterruptedException
	{
		actions.moveToElement(searchLoactionTab).sendKeys(location).build().perform();
		Thread.sleep(1000);
	}
	
	public void clickOnTargetLocation() throws InterruptedException
	{
		actions.moveToElement(targetLocation).click().build().perform();
		Thread.sleep(1000);
	}
	
}
