package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterWindow {
	
	@FindBy (xpath = "//label[text()='Cost: Low to High']")
	private WebElement  costLowToHighRadioButton;
	
	@FindBy (xpath = "//div[text()='Apply']")
	private WebElement applyButton;

	private WebDriver driver;
	private Actions actions;
	
	public FilterWindow(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		actions = new Actions(driver);
	}
	
	public void clickOnCostLowToHighRadioButton() throws InterruptedException
	{
		actions.moveToElement(costLowToHighRadioButton).click().build().perform();
		Thread.sleep(3000);
	}
	
	public void clickOnApplyButton() throws InterruptedException
	{
		actions.moveToElement(applyButton).click().build().perform();
		Thread.sleep(3000);
	}
}
