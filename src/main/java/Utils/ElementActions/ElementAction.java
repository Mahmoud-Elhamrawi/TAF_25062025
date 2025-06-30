package Utils.ElementActions;

import Utils.ClassesUtils.ClassUtil;
import Utils.Waits.WaitClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementAction {


    private ElementAction() {
    }


    // click
    public static void click(WebDriver driver, By locator) {
        WaitClass.waitElementBeClickable(driver, locator);
        ClassUtil.scroll(driver, locator);
        driver.findElement(locator).click();

    }


    //type
    public static void type(WebDriver driver, By locator, String text) {

        WaitClass.waitElementBePresent(driver, locator);
        ClassUtil.scroll(driver, locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);

    }


    // get text
    public static String getText(WebDriver driver, By locator) {
        WaitClass.waitElementBePresent(driver, locator);
        return driver.findElement(locator).getText();
    }


}
