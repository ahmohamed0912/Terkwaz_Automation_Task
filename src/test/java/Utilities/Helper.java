package Utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	public static void TakeScreenshots(WebDriver driver, String ScreenshotName) {
		
		 Path dest = Paths.get("./Screenshots",ScreenshotName+".png");
		 try {
			Files.createDirectories(dest.getParent());
			FileOutputStream out = new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			out.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("Exception While taking screenshot " + e.getMessage());
		}
		 
		
	}

}
