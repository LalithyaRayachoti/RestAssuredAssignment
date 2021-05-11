package RestAssured;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import util.datafromexcelsheet;



public class datadrivenapproachAssignment {

	@Test(dataProvider = "PostRequestdata")
    public void testcase1(String name1, String name2, String name3) {
        JSONObject jsonobj = new JSONObject(); // main body object
        jsonobj.put("firstname", name1);
        jsonobj.put("lastname", name2);
        jsonobj.put("stream", name3);
        RestAssured.baseURI = "http://localhost:3000";
        given().contentType(ContentType.JSON)
        	.body(jsonobj.toJSONString())
        	.post("/students")
        .then()
        	.statusCode(201)
                
        	.log().all();
    }
	@DataProvider(name = "PostRequestdata")
    public Object[][] postreqdata() throws IOException {
		
		Object[][] data = datafromexcelsheet.gettestdata();
		return data;
	}
}
