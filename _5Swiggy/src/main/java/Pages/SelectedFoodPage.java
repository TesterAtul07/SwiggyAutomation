package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectedFoodPage {
	@FindBy (xpath = "(//div[text()='ADD'])[1]")
	private WebElement topPickAddButton;
	
	@FindBy (xpath = "//span[text()='View Cart']")
	private WebElement viewCartButton;
	
	private WebDriver driver;
	private Actions actions;
	public SelectedFoodPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		
	}
	
	public void clickOnTopPickButton() throws InterruptedException
	{
		actions.moveToElement(topPickAddButton).click().build().perform();
		Thread.sleep(1000);
		
	}
	

	public void clickOnViewCartButton() throws InterruptedException
	{
		actions.moveToElement(viewCartButton).click().build().perform();
		Thread.sleep(1000);
	}
}
