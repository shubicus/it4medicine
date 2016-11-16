package test;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.UtilityForScreenshot;

public class LoginWithSkype extends BeforeAndAfter{

    @Test
    public void positiveLoginBySkype() {
        getLoginPage().setUsername("asdfgh");
        getLoginPage().submitRegister();
        Assert.assertTrue(getLoginPage().signInButtonDisplayed());
    }


    @Test
    public void negativeLoginBySkype() {
        getLoginPage().setUsername("?asdfgh*");
        getLoginPage().submitRegister();
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#usernameError")));
        UtilityForScreenshot.captureScreenshot(getWebDriver(), "ErrorInvalidSkype");  //screenshot
        Assert.assertTrue(getLoginPage().usernameErrorDisplayed());
    }

}
