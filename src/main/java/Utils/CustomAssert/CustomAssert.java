package Utils.CustomAssert;

import Utils.Logs.LogClass;
import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;

public class CustomAssert extends SoftAssert {

    public static CustomAssert softAssert = new CustomAssert();

    public static void getAssert(ITestResult result) {
        try {
            softAssert.assertAll("soft assert");
        } catch (AssertionError error) {
            LogClass.error("soft assert failed " + error.getMessage());
            result.setStatus(ITestResult.FAILURE);
            result.setThrowable(error);

        }

    }


}
