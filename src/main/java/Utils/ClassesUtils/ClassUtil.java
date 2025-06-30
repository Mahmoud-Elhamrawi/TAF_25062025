package Utils.ClassesUtils;

import Drivers.DriverManager;
import Utils.Allure.AllureUtil;
import Utils.Logs.LogClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClassUtil {


    static String screenshotPath = "test-outputs/screenshot/";

    //take screenshot
    public static void takeScreenshot(String screenshotName) {
        try {
            File src = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            File dist = new File(screenshotPath + screenshotName + getTimestamp() + ".png");
            FileUtils.copyFile(src, dist);
            // add screenshot to report
            AllureUtil.addScreenshotToReport(screenshotName, dist.getPath());

        } catch (Exception e) {
            LogClass.error("fail to take screenshot " + e.getMessage());
        }

    }


    // get timestamp
    public static String getTimestamp() {
        return new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
    }

    //scroll
    public static void scroll(WebDriver driver, By locator) {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);"
                , driver.findElement(locator));

    }

}
