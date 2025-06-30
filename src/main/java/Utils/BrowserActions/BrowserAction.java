package Utils.BrowserActions;

import Drivers.DriverManager;
import org.openqa.selenium.WebDriver;

public class BrowserAction {

    private BrowserAction() {
    }


    //open browser
    public static void openBrowser(WebDriver driver, String url) {
        driver.get(url);
    }


    // get title
    public static String getTitle(WebDriver driver) {
        return driver.getTitle();
    }

    //get url
    public static String getUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    //close browser
    public static void closeBrowser(WebDriver driver) {
        driver.quit();
        DriverManager.removeDriver();
    }


}
