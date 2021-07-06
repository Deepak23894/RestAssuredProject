package listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListners implements ITestListener

{

	public void onFinish(ITestContext result) {
		System.out.println("testcase name which is finish "+result.getName());
		
	}

	public void onStart(ITestContext result) {
		System.out.println("testcase name which is onStart "+result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("testcase name which is onTestFailedButWithinSuccessPercentage "+result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("testcase name which is onTestFailure "+result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("testcase name which is onTestSkipped "+result.getName());
		
	}

	public void onTestStart(ITestResult result) {
		System.out.println("testcase name which is onTestStart "+result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("testcase name which is onTestSuccess "+result.getName());
		
	}

}
