package Utilities;

import java.io.IOException;
import java.util.List;

import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import data.LoadProperties;

public class GenerateReport2 {
	
	
	
	public static void Report(List<ITestResult> Results) throws IOException
	{    
   
		
		// Create Object of ExtentHtmlReporter and provide the path where you want to generate the report 
            // I used (.) in path where represent the current working directory
	    ExtentHtmlReporter reporter=new ExtentHtmlReporter(System.getProperty("user.dir") + "\\Reports\\Automation_Report.html");
	    
	    reporter.config().setDocumentTitle("Automation Report");
	    reporter.config().setReportName(LoadProperties.TestData.getProperty("ReportName"));
	    reporter.config().setTheme(Theme.DARK);
	    
		
            // Create object of ExtentReports class- This is main class which will create report
	    ExtentReports extent = new ExtentReports();
	    
            // attach the reporter which we created in Step 1
	    extent.attachReporter(reporter);
	    extent.setSystemInfo("Host Name", LoadProperties.TestData.getProperty("BaseURL"));
	    extent.setSystemInfo("Environment", LoadProperties.TestData.getProperty("EnvironmentName"));
	        
	    for(int i = 0; i < Results.size(); i++ ) {
	    	
	    ExtentTest logger=extent.createTest(Results.get(i).getName());
		    
            // log method will add logs in report and provide the log steps which will come in report
	    
	 
	    if ((Results.get(i).getStatus() == ITestResult.SUCCESS)&&(Results.get(i).getAttribute("TC_Body") != null)) {
	    	
	    	logger.log(Status.PASS, "Test Passed"); 
	    		
	    	logger.log(Status.PASS, "API Response --> " + Results.get(i).getAttribute("TC_Body"));
	    		
	    	}else if ((Results.get(i).getStatus() == ITestResult.SUCCESS)&&(Results.get(i).getAttribute("TC_Body") == null)) {
	    	
	    		logger.log(Status.PASS, "Test Passed"); 
	    		
	    		logger.pass("Success Screenshot:", MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir") + "\\Screenshots\\" + Results.get(i).getName()+".png").build());
	    		
	    	
	    }else if (Results.get(i).getStatus() == ITestResult.FAILURE) {
	    	
	    	logger.log(Status.FAIL, "Test Failed");
	    	
	    	logger.log(Status.FAIL, "Failure Exception -->> " + Results.get(i).getThrowable() );
	    	
	    	logger.fail("Failure Screenshot:", MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir") + "\\Screenshots\\Error_" + Results.get(i).getName()+".png").build());
    	
	    } else {
	    	
	    	logger.log(Status.SKIP, "Test Skipped");
	    }
	   
            // Flush method will write the test in report- This is mandatory step  
	    extent.flush();
	
	    	
	    	
	    }
	}
	
}

