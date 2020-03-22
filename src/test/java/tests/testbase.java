package tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import Utilities.GenerateReport2;
import Utilities.Helper;
import data.LoadProperties;

public class testbase {

	protected WebDriver driver;
	//	public String BaseURL = "https://www.google.com/ncr";
	public String BaseURL = LoadProperties.TestData.getProperty("BaseURL");
	public static String downloadPath = System.getProperty("user.dir")+"/DownloadedFile";
	public static List<ITestResult> Results = new ArrayList<ITestResult>();


	@BeforeSuite
	public void StartDriver() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\sources\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get(BaseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


	} 

	@AfterSuite
	public void EndDriver() throws IOException {

		GenerateReport2.Report(Results);

		driver.navigate().to("file:///" + System.getProperty("user.dir") + "/Reports/Automation_Report.html");

		//		driver.quit();
	}

	@AfterMethod
	public void TakeScreenShotWhenFailure(ITestResult Result ) throws IOException {

		Result.setAttribute("TC_Body", TC2_API_Automation.ResponseBody );

		Results.add(Result);

		if(Result.getStatus() == ITestResult.FAILURE) {

			System.out.println("Failed");
			System.out.println("Taking Screenshot....");
			Helper.TakeScreenshots(driver, "Error_" + Result.getName());
		}

	}





}
