package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class FileYUploadPage extends pagebase{

	public FileYUploadPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(css="input#file-upload")
	WebElement BrowseBtn;
	
	@FindBy(css="input#file-submit.button")
	WebElement UploadBtn;
	
	@FindBy(xpath="//h3")
	WebElement ConfrimationMsg;
	
	@FindBy(css="div#uploaded-files.panel.text-center")
	WebElement ConfrimationPageName;
	
	public void UploadPhoto() {
		
		BrowseBtn.sendKeys(System.getProperty("user.dir") + "\\Automation.jpg");
		
		UploadBtn.click();
		
		Assert.assertEquals("File Uploaded!", ConfrimationMsg.getText());
		
		Assert.assertEquals("Automation.jpg", ConfrimationPageName.getText());
		
		System.out.println("File Uploaded Sucessfully");

		
	}
	
}
