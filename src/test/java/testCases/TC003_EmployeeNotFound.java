package testCases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import testBase.BaseClass;

public class TC003_EmployeeNotFound extends BaseClass

{
	@Test
	public  void EmployeesNotFound()
	{
		   logger.info("--------TC003_EmployeeNotFound---------");

		RestAssured.baseURI=uri;
		RequestSpecification httpRequest=RestAssured.given();
		Response resp=httpRequest.request(Method.GET, "/users/23");
		int statusCde=resp.getStatusCode();
	    System.out.println("Status code   "+resp.getStatusCode());
	    System.out.println("Status line   "+resp.getStatusLine());	
	    Assert.assertEquals(statusCde, 404);
	    System.out.println("Status Employess Not Found  ");	

	    
	}
}
