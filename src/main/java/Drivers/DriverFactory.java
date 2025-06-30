package Drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Map;

public class DriverFactory {
    public static WebDriver getBrowser(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--allow-remote-origin=*");
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                chromeOptions.addArguments("--disable-extensions");
                chromeOptions.addArguments("--disable-infobars");

                Map<String, Object> chromePrefs = Map.of(
                        "autofill_enabled", false,
                        "profile.password_manager_enabled", false,
                        "profile.default_content_setting_values.notifications", 2,
                        "password_manager_enabled", false


                );

                chromeOptions.setExperimentalOption("prefs", chromePrefs);

                return new ChromeDriver(chromeOptions);
            case "edge":


                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--allow-remote-origin=*");
                edgeOptions.addArguments("--disable-notifications");
                edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                edgeOptions.addArguments("--disable-extensions");
                edgeOptions.addArguments("--disable-infobars");

                Map<String, Object> edgePrefs = Map.of(
                        "autofill_enabled", false,
                        "profile.password_manager_enabled", false,
                        "profile.default_content_setting_values.notifications", 2,
                        "password_manager_enabled", false
                );

                edgeOptions.setExperimentalOption("prefs", edgePrefs);
                return new EdgeDriver(edgeOptions);
            case "firefox":
                return new FirefoxDriver();
            default:
                return null;


        }


    }


}
