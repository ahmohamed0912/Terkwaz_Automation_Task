package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InternetHeroPage extends pagebase{

	public InternetHeroPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath="//a[@href='/upload']")
	WebElement FileUpload;

	@FindBy(xpath="//a[@href='/dynamic_loading']")
	WebElement DynamicLoading;



	public void Open_FileUpload_Page() {
		
		FileUpload.click();

	}

	public void Open_DynamicLoading_Page() {

		DynamicLoading.click();

	}



}
