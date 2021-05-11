package RestAssured;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class postmethod {
	
	@Test()
	public void postmethod() 
	{
		
		RestAssured.baseURI ="http://localhost:3000";
		JSONObject jsonobj = new JSONObject();
		
		jsonobj.put("firstname" ,"Lalithya");
		jsonobj.put("stream" ,"Computerscience");
		jsonobj.put("lastname" ,"Rayachoti");
		
		System.out.println(jsonobj);
		
		given()
		.contentType(ContentType.JSON)
		.body(jsonobj.toJSONString())
	 	.post("/students").
	then()
	    .statusCode(201)
	    .log().all();
		
	}

}
