package testCases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testBase.BaseClass;

public class TC001_GetEmployee extends BaseClass
{

	@Test(priority =1)
	public  Response getEmployees()
	{
	   logger.info("--------getEmployees---------");
		RestAssured.baseURI=uri;
		RequestSpecification httpRequest=RestAssured.given();
		Response resp=httpRequest.request(Method.GET, "/users?page=2");
	    return resp;
	}
	@Test(priority =2)
	public void getStatus()
	
	{
		   logger.info("--------getEmployees Of getStatus---------");

		Response resp= getEmployees();
		System.out.println(resp.getStatusCode());
	}
	@Test(priority =3)
	public void getReponse()
	{
		   logger.info("--------getEmployees Of message---------");

		Response resp=getEmployees();
		String mesg=resp.asString();
		System.out.println(mesg);
	}
}
