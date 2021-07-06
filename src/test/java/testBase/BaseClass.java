package testBase;

import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import org.apache.log4j.Logger;

public class BaseClass 
{

	public static String uri="https://reqres.in/api";
	public Logger logger;
	@BeforeClass
	public void logs()
	{
		logger=Logger.getLogger("RESTAUTOMATION");
		PropertyConfigurator.configure("log4j.properties");
        logger.setLevel(Level.DEBUG);
	}
	
	
}
