package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class pagebase {

	protected WebDriver driver;
	public JavascriptExecutor jse;
	public Actions action;
	
	public pagebase(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}
	
	public void click(WebElement botton) {
		
		botton.click();
	}
	
	public void Type(WebElement TextField,String data) {
		
		TextField.clear();
		TextField.sendKeys(data);
	}
	
	public void SelectList(WebElement List,String data) {
		
		new Select(List).selectByValue(data);

	}
	
	public void ScrollToButtom() {
		
		jse.executeScript("scrollBy(0,2500)");
	}
	



}
