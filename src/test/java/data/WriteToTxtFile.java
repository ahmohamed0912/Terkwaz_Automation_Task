package data;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToTxtFile {

	
	public static void WriteinTxtFile(String Filename, String Text) {
		
		try {
			
			FileWriter writer = new FileWriter(System.getProperty("user.dir")+"\\ExtractedFiles\\" + Filename, true);
			
			writer.write(Text);
			
			writer.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}





