package testCases;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import testBase.BaseClass;

public class TC007_RegisterAndLogIn extends BaseClass
{

	
	String email="Rahul@gmail.com";
	String password="Rahul1234";
	
	@Test(priority=1)
	public void register()
	{
		   logger.info("--------TC006_registerUser---------");

		RestAssured.baseURI=uri;
		RequestSpecification req=RestAssured.given();
		JSONObject jon=new JSONObject();
		jon.put("email", email);
		jon.put("password", password);
		req.body(jon.toJSONString());
		req.header("Content-Type", "application/json");
		Response resp=req.request(Method.POST,"/api/register");
		System.out.println(resp.asString());
		Assert.assertEquals(resp.getStatusCode(),201);		
	}
	@Test(priority=2)
	public void login()
	{
		   logger.info("--------TC006_loginUser---------");

		RestAssured.baseURI=uri;
		RequestSpecification req=RestAssured.given();
		JSONObject jon=new JSONObject();
		jon.put("email", email);
		jon.put("password", password);
		req.body(jon.toJSONString());
		req.header("Content-Type", "application/json");
		Response resp=req.request(Method.POST,"/api/login");
		System.out.println(resp.asString());
		Assert.assertEquals(resp.getStatusCode(),201);		
	}
	
	
}
