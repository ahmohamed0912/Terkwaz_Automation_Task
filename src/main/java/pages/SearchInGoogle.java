package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchInGoogle extends pagebase {

	public SearchInGoogle(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(name="q")
	WebElement SearchBox;
	
	@FindBy(name="btnK")
	WebElement SearchBtn;
	
	@FindBy(xpath="//div[4]/div[2]/div/div[1]/a/h3[@class='LC20lb DKV0Md']")
	WebElement ThirdResult;

	public void GoogleSearch(String SearchTxt) {
		
		SearchBox.clear();
		SearchBox.sendKeys(SearchTxt);
		
		SearchBtn.click();
		
//		assertEquals("Selenium Tutorial for Beginners: Learn WebDriver in 7 Days", ThirdResult.getText());

		ThirdResult.click();
		
		System.out.println("Search in Google is OK");
		
	}
	

}
