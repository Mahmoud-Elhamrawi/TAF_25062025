package Pages;

import Utils.BrowserActions.BrowserAction;
import Utils.ElementActions.ElementAction;
import Utils.Logs.LogClass;
import Utils.Validation.ValidationUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {
    //Variables
    WebDriver driver;


    //Constructor
    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By username_INP = By.id("user-name");
    private final By password_INP = By.id("password");
    private final By login_BTN = By.id("login-button");


    //methods Actions
    @Step("Navigate to login page")
    public P01_LoginPage navigateToLoginPage(String url) {
        BrowserAction.openBrowser(driver, url);
        LogClass.info("Navigated to login page", url);
        return this;
    }

    @Step("Enter username")
    public P01_LoginPage enterUsername(String username) {
        ElementAction.type(driver, this.username_INP, username);
        LogClass.info("Entered username", username);
        return this;
    }

    @Step("Enter password")
    public P01_LoginPage enterPassword(String password) {
        ElementAction.type(driver, this.password_INP, password);
        LogClass.info("Entered password", password);
        return this;
    }

    @Step("Click login button")
    public P02_HomePage clickLoginButton() {
        ElementAction.click(driver, this.login_BTN);
        LogClass.info("Clicked login button");
        return new P02_HomePage(driver);
    }


    //validations
    public P01_LoginPage assertLoginUrl( String expectedUrl) {
        ValidationUtil.ValidateUrlSoft(BrowserAction.getUrl(driver), expectedUrl, "url in correct");
        return this;
    }


}
