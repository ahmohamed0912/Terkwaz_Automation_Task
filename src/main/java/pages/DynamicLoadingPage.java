package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DynamicLoadingPage extends pagebase{

	public DynamicLoadingPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//a[@href='/dynamic_loading/2']")
	WebElement Example2;
	
	@FindBy(tagName="button")
	WebElement StartBtn;

	
	@FindBy(xpath="//div[@id='finish']")
	public WebElement Message;
	
	
	public void StartLoading() {
		
		Example2.click();
	
		StartBtn.click();
		
		
		while(!Message.isDisplayed()) {
			
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			
		}
		
		System.out.println("Dynamic loading is Ok");
		
 }
		
		

	}
	

