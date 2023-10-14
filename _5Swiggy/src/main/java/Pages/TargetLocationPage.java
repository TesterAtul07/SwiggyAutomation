package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TargetLocationPage {
	
	@FindBy (xpath = "//div[text()='Filter']")
	private WebElement filterDropDownButton;
	
	@FindBy (xpath = "(//a[@class='sc-dGCmGc dlVOOg'])[2]")
	private WebElement targetFood;
	
	private WebDriver driver;
	private Actions actions;
	
	public TargetLocationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		actions = new Actions(driver);
	}
	
	public void clickOnFilterButton() throws InterruptedException
	{
		actions.moveToElement(filterDropDownButton).click().build().perform();
		Thread.sleep(3000);
	}
	
	public void clickOnTargetFood() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(targetFood));
        actions.moveToElement(targetFood).click().build().perform();
        Thread.sleep(3000);
		
	}
	

}
