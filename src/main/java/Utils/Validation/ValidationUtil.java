package Utils.Validation;

import org.testng.Assert;

import static Utils.CustomAssert.CustomAssert.softAssert;

public class ValidationUtil {
    /// Hard assert

    //assert on title
    public static void ValidateTitle(String actualTitle, String expectedTitle, String message) {
        Assert.assertEquals(actualTitle, expectedTitle, message);

    }

    //assert on url
    public static void ValidateUrl(String actualUrl, String expectedUrl, String message) {
        Assert.assertEquals(actualUrl, expectedUrl, message);
    }

    //assert on text
    public static void validateText(String actualText, String expectedText, String message) {
        Assert.assertEquals(actualText, expectedText, message);
    }


    /// soft assert
    public static void ValidateUrlSoft(String actualUrl, String expectedUrl, String message) {
        softAssert.assertEquals(actualUrl, expectedUrl, message);
    }

}
