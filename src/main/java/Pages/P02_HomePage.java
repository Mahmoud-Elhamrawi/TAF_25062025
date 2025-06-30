package Pages;

import Utils.BrowserActions.BrowserAction;
import Utils.Validation.ValidationUtil;
import org.openqa.selenium.WebDriver;

public class P02_HomePage {
   //variable
    WebDriver driver;

    //constructor
    public P02_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //locators

    //methods


    //validations
    public P02_HomePage assertLandingUrlPage( String expectedUrl) {
        ValidationUtil.ValidateUrl(BrowserAction.getUrl(driver), expectedUrl, "url in correct");
        return this;
    }
    public P02_HomePage assertLoginTitle(String expectedTitle) {
        ValidationUtil.ValidateTitle(BrowserAction.getTitle(driver), expectedTitle, "title in correct");
        return new P02_HomePage(driver);
    }









}