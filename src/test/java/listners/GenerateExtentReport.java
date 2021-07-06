package listners;

import java.io.File;

import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class GenerateExtentReport 
{

	ExtentReports extent;
	ExtentTest test;
	@BeforeTest
	public void StartResport()
	{
		
		extent=new ExtentReports(System.getProperty("user.dir")+"test-output/RestAutomation.html");
		extent.addSystemInfo("HostName","LocalHost");
		extent.addSystemInfo("Env","QA");

		extent.addSystemInfo("user","Deeapk");
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}
	
}
