package TestCases;

import Drivers.DriverManager;
import Pages.P01_LoginPage;
import Utils.BrowserActions.BrowserAction;
import Utils.DataUtils.ReadJsonData;
import Utils.Logs.LogClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static Utils.DataUtils.ReadJsonData.getJsonKey;
import static Utils.DataUtils.ReadPropertyFile.getPropertyKey;

@Listeners(TestNGLisenter.TestngListener.class)
public class TC01_LoginTC {
    //variable
    protected WebDriver driver;
    ReadJsonData readJsonData;

    @Test
    public void loginTC() {

        new P01_LoginPage(driver)
                .assertLoginUrl(getPropertyKey("loginURL"))
                .enterUsername(getJsonKey("valid-Credential-Data.username"))
                .enterPassword(getJsonKey("valid-Credential-Data.password"))
                .clickLoginButton()
                .assertLandingUrlPage(getPropertyKey("landingURL"))
                .assertLoginTitle(getPropertyKey("pageTitle"));

    }


    //Configuration
    @BeforeClass
    public void setUpClass() {
        readJsonData = new ReadJsonData("testData");
        LogClass.info("test data json file loaded");
    }

    @BeforeMethod
    public void setUpMethod() {
        String Browser = System.getProperty("Browser") != null ? System.getProperty("Browser")
                : getPropertyKey("BrowserName");

        driver = DriverManager.createInstance(Browser);
        LogClass.info("driver created on " + Browser);

        new P01_LoginPage(driver).navigateToLoginPage(getPropertyKey("loginURL"));
        LogClass.info("Navigated to login page", getPropertyKey("loginURL"));

    }


    @AfterMethod
    public void downMethod() {
        BrowserAction.closeBrowser(driver);
    }


}
