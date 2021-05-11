package RestAssured;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class jsonbody {
	
	@Test()
	public void Assignmenttestcase() throws IOException
	{
		  FileInputStream fis = new FileInputStream(".\\JSON\\AssignmentMultiply.xml");  
		  RestAssured.baseURI = "http://www.dneonline.com";       
		  Response resp = given()           
				  .headers("content-type","text/xml")             
				  .body(IOUtils.toString(fis,"UTF-8"))          
				  .post("/calculator.asmx")      
				  .then()            
				  .statusCode(200)            
				  .log()            
				  .all().extract().response();               
		  XmlPath obj = new XmlPath(resp.asString());        
		  System.out.println("the response of add request is " +obj.getString("AddResult"));
	        String actualresult = obj.getString("AddResult");
	        
	        Assert.assertEquals("100", actualresult);

	}


}
