package testCases;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testBase.BaseClass;

public class TC002_GetSingleUserOfEmp  extends BaseClass
{

	@Test
	public  void getUserEmployees()
	{
		   logger.info("--------TC002_GetSingleUserOfEmp---------");

		RestAssured.baseURI=uri;
		RequestSpecification httpRequest=RestAssured.given();
		Response resp=httpRequest.request(Method.GET, "/users/5");
	    System.out.println("Status code   "+resp.getStatusCode());
	    System.out.println("Status line   "+resp.getStatusLine());
	    System.out.println("Status time   "+resp.getTime());
	    System.out.println("Status body   "+resp.getBody());
	    String respon=resp.asString();
	    JsonPath js=resp.jsonPath();
	    System.out.println(js.get("first_name"));
	    System.out.println(js.get("id"));	    
	}

}
