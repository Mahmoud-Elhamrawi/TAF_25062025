package TestNGLisenter;

import Utils.Allure.AllureUtil;
import Utils.ClassesUtils.ClassUtil;
import Utils.CustomAssert.CustomAssert;
import Utils.DataUtils.ReadPropertyFile;
import Utils.FileUtils.FileUtil;
import Utils.Logs.LogClass;
import org.testng.*;

import java.io.File;

public class TestngListener implements IExecutionListener, ITestListener, IInvokedMethodListener {

    File allureFiles = new File("test-outputs/target/allure-results/");
    File logsFiles = new File("test-outputs/Logs/");
    File screenshotFiles = new File("test-outputs/screenshot/");


    @Override
    public void onExecutionStart() {
        LogClass.info("test started");

        //load properties
        ReadPropertyFile.loadPropertyFile();
        LogClass.info("properties files are  loaded");

        //delete allure report folder
        FileUtil.cleanDirectory(allureFiles);
        LogClass.info("Previous allure report folder is deleted");

        //delete logs folder
        FileUtil.cleanDirectory(logsFiles);
        LogClass.info("Previous logs folder is deleted");


        //delete screenshot folder
        FileUtil.cleanDirectory(screenshotFiles);
        LogClass.info("Previous screenshot folder is deleted");


    }

    @Override
    public void onExecutionFinish() {
        LogClass.info("test finished");
        AllureUtil.generateReport();
        AllureUtil.openReport();
    }


    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {

            CustomAssert.getAssert(testResult);

            switch (testResult.getStatus()) {
                case ITestResult.FAILURE -> ClassUtil.takeScreenshot("failed_" + testResult.getName());
                case ITestResult.SUCCESS -> ClassUtil.takeScreenshot("passed_" + testResult.getName());
                case ITestResult.SKIP -> ClassUtil.takeScreenshot("skipped_" + testResult.getName());
            }
            AllureUtil.addLogFileToReport();

        }


    }


    @Override
    public void onTestStart(ITestResult result) {
        LogClass.info("Test Case", result.getName(), "Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogClass.info("Test Case", result.getName(), "Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogClass.error("Test Case", result.getName(), "Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogClass.debug("Test Case", result.getName(), "Skipped");
    }

    @Override
    public void onStart(ITestContext context) {
        LogClass.info("Test suite", context.getName(), "started");
    }

    @Override
    public void onFinish(ITestContext context) {
        LogClass.info("Test suite", context.getName(), "finished");
    }
}
