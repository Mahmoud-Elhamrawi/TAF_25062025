package Utils.Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitClass {

    //exist
    public static WebElement waitElementBeExist(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                driver1 -> driver.findElement(locator)
        );
    }


    //present
    public static WebElement waitElementBePresent(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                driver1 -> {
                    WebElement element = waitElementBeExist(driver, locator);
                    return element.isDisplayed() ? element : null;
                }
        );
    }

    //clickable
    public static WebElement waitElementBeClickable(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                driver1 -> {
                    WebElement element = waitElementBeExist(driver, locator);
                    return element.isEnabled() ? element : null;
                }
        );
    }

}
