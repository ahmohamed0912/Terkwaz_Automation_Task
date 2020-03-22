package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.Helper;
import data.ExcelReader;
import pages.DynamicLoadingPage;
import pages.FileYUploadPage;
import pages.InternetHeroPage;
import pages.SearchInGoogle;

public class TC1_Search extends testbase{


	@DataProvider(name="DataFromExcel")
	public Object[][] GetData() throws IOException{

		ExcelReader data = new ExcelReader();

		return data.getExcelData();

	} 


	@Test(dataProvider="DataFromExcel")
	public void TC1_GoogleSearch(String SearchTxt, String NavigateURL) throws InterruptedException {


		SearchInGoogle Search = new SearchInGoogle(driver);
		InternetHeroPage InternetHome = new InternetHeroPage(driver);
		FileYUploadPage upload = new FileYUploadPage(driver);
		DynamicLoadingPage DL = new DynamicLoadingPage(driver);

		// Search in Google

		Search.GoogleSearch(SearchTxt);

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		// Navigate to https://the-internet.herokuapp.com/ and upload photo 

		driver.navigate().to(NavigateURL);

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		InternetHome.Open_FileUpload_Page();

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		upload.UploadPhoto();

		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

		// Navigate to https://the-internet.herokuapp.com/ and Dynamic Loading 

		driver.navigate().to(NavigateURL);

		InternetHome.Open_DynamicLoading_Page();

		DL.StartLoading();
		
		Helper.TakeScreenshots(driver, "TC1_GoogleSearch");

	}

}
