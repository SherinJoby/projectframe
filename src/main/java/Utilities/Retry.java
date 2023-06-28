package Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

    private static final Logger log = LoggerFactory.getLogger(Retry.class);
    private int retryCount = 0;
    private int maxRetryCount = 2;

    public String getResultStatusName(int status) {
        String resultName = null;
        if (status == 1)
            resultName = "SUCCESS";
        if (status == 2)
            resultName = "FAILURE";
        if (status == 3)
            resultName = "SKIP";
        return resultName;
    }

    /**
     * Below method returns 'true' if the test method has to be retried else
     * 'false' and it takes the 'Result' as parameter of the test method that
     * just ran
     *
     * @see org.testng.IRetryAnalyzer#retry(org.testng.ITestResult)
     */

    @Override
    public boolean retry(ITestResult result) {
        if (!result.isSuccess()) {
            if (retryCount < maxRetryCount) {
                log.info("Retrying test " + result.getName() + " with status " + "'" + getResultStatusName(result.getStatus()) + "'" + " for the " + (retryCount + 1) + " time(s).");
                result.setStatus(ITestResult.SKIP);
                retryCount++;
                return true;
            }else {
                result.setStatus(ITestResult.FAILURE);
            }
        } else {
            result.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }
   
}
