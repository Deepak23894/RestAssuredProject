package testCases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import testBase.BaseClass;

public class TC004_UnknownEmployess extends BaseClass
{
	@Test
	public  void EmployeesNotFound()
	{
		   logger.info("--------TC004_UnknownEmployess---------");
		RestAssured.baseURI=uri;
		RequestSpecification httpRequest=RestAssured.given();
		Response resp=httpRequest.request(Method.GET, "/api/unknown");
		int statusCde=resp.getStatusCode();
	    System.out.println("Status code   "+statusCde);  
	}
}
