package test;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.UtilityForScreenshot;

public class LoginWithPhone extends BeforeAndAfter{

    @Test
    public void positiveLoginWithPhoneNumber() {
        getLoginPage().setUsername("+380934663425");
        getLoginPage().submitRegister();
        Assert.assertTrue(getLoginPage().signInButtonDisplayed());
    }


    @Test
    public void negativeLoginWithPhoneNumber() {
        getLoginPage().setUsername("?3809ASDF4663425");
        getLoginPage().submitRegister();
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#usernameError")));
        UtilityForScreenshot.captureScreenshot(getWebDriver(), "ErrorInvalidPhoneNumber");  //screenshot
        Assert.assertTrue(getLoginPage().usernameErrorDisplayed());
    }

}
