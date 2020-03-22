package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
	
	public static Properties TestData = loadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\DataFiles\\TestData.properties");
	
	private static Properties loadProperties(String path) {
		
		Properties pro = new Properties();
		
		try {
			FileInputStream file = new FileInputStream(path);
			pro.load(file);
			
		} catch (FileNotFoundException e) {

			System.out.println("Error: "+e.getMessage());

		} catch (IOException e) {
			
			System.out.println("Error: "+e.getMessage());

		}
		
		return pro;

	}

}
