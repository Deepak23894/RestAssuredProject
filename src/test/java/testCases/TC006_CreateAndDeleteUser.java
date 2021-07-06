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

public class TC006_CreateAndDeleteUser extends BaseClass
{
	String id;

	@Test(priority=1)
	public void createUserEmployee()
	{
		   logger.info("--------TC006_CreateUser---------");

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
	public void deleteEmployee()
	{
		   logger.info("--------TC006_DeleteUser---------");

		RestAssured.baseURI=uri;
		RequestSpecification httpRequest=RestAssured.given();
		JSONObject jso= new JSONObject();
        jso.put("name", "Rajesh");
        jso.put("job", "Software test engineer");
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(jso.toJSONString());
		Response resp=httpRequest.delete("/api/users/"+id);
		System.out.println(resp.asString());
		Assert.assertEquals(resp.getStatusCode(),204);    
	}

	
}
