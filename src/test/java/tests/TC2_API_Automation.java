package tests;

import static org.junit.Assert.assertTrue;

import org.testng.annotations.Test;

import data.WriteToTxtFile;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC2_API_Automation extends testbase{
	
	static public String ResponseBody = null ;
	
	
	@Test
	public void TC2_API_facts_random() {
		
		
		RestAssured.baseURI = "https://cat-fact.herokuapp.com/";
		
		RequestSpecification Request = RestAssured.given();
		
		Response response = Request.request(Method.GET, "/facts/random?animal_type=cat&amount=2");
		
		ResponseBody = response.getBody().asString();
		
		System.out.println("Body: " + ResponseBody);
		
		assertTrue(!ResponseBody.isEmpty());
		
		WriteToTxtFile.WriteinTxtFile("API_ResponseBody_facts_random.txt", ResponseBody);
		
		System.out.println("API Run Successfully");
		
	}
	
	
}
