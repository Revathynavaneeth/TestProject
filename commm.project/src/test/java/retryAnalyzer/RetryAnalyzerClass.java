package retryAnalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerClass implements IRetryAnalyzer
{
	private int retryCount=0;
	private static final int maximumRetryCount=3;
	
	@Override
	public boolean retry(ITestResult result) 
	{
		if(retryCount<maximumRetryCount)
		{
			retryCount++;
			
			return true;
		}
		return false;
	}

}
