package testCases;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import testBase.BaseClass;

public class TC005_CreateAndUpdateUser extends BaseClass
{
	String id;

	@Test(priority=1)
	public void createUserEmployee()
	{
		   logger.info("--------TC005_createUser---------");

		RestAssured.baseURI=uri;
		RequestSpecification httpRequest=RestAssured.given();
		JSONObject jso= new JSONObject();
        jso.put("name", "Rajesh");
        jso.put("job", "Traveller");
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(jso.toJSONString());
		Response resp=httpRequest.post("/api/users");
		JsonPath jp=resp.jsonPath();
		id=jp.get("id");
		System.out.println(jp.get("id"));
		Assert.assertEquals(resp.getStatusCode(),201);

	}
	@Test(priority=2)
	public void UpdateEmployee()
	{
		
		   logger.info("--------TC005_CreateAndUpdateUser---------");

		RestAssured.baseURI=uri;
		RequestSpecification httpRequest=RestAssured.given();
		JSONObject jso= new JSONObject();
        jso.put("name", "Rajesh");
        jso.put("job", "Software test engineer");
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(jso.toJSONString());
		Response resp=httpRequest.put("/api/users/"+id);
		System.out.println(resp.asString());
		Assert.assertEquals(resp.getStatusCode(),200);    
	}

	
}
