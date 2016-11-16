package test;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.UtilityForScreenshot;

public class LoginWithEmail extends BeforeAndAfter{


    @Test
    public void positiveLoginByEmail() {
        getLoginPage().setUsername("vadimshubkin@gmail.com");
        getLoginPage().submitRegister();
        Assert.assertTrue(getLoginPage().signInButtonDisplayed());
    }


    @Test
    public void negativeLoginByEmail() {
        getLoginPage().setUsername("vadimshubkin?gmail.com");
        getLoginPage().submitRegister();
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#usernameError")));
        UtilityForScreenshot.captureScreenshot(getWebDriver(), "SortedByName");  //screenshot
        Assert.assertTrue(getLoginPage().usernameErrorDisplayed());
    }


}
