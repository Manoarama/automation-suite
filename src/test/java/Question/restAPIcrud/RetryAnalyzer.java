package Question.restAPIcrud;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int count=0;
    private static final int MAX_RETRY=2;
    public RetryAnalyzer() {
    }

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(count<MAX_RETRY){
            count++;
            return true;
        }
        return false;
    }
}

