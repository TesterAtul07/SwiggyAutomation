package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WithFiltersPage {
	
	@FindBy (xpath ="(//div[@class='sc-fBdRDi eqHUXD'])[1]")
	private WebElement selectedFood;
	
	private WebDriver driver;
	
	public WithFiltersPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		
	}

	public void clickOnSelectedFood() throws InterruptedException
	{
		Actions actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(selectedFood));
		actions.moveToElement(selectedFood).click().build().perform();
		Thread.sleep(3000);

	}
	
}
