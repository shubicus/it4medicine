package test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import webpage.LoginPage;

public abstract class BeforeAndAfter {

    private WebDriver webDriver;
    private WebDriverWait wait;
    private LoginPage loginPage;
    private String url = "https://login.live.com/";


    public WebDriver getWebDriver() {
        return webDriver;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    @BeforeClass
    public void setUp() {

        webDriver = new FirefoxDriver();

        wait = new WebDriverWait(webDriver, 10, 500);
        loginPage = new LoginPage(webDriver);

        webDriver.get(url);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("phholder")));
    }


    @AfterClass
    public void tearDown() {
        if (webDriver != null)
            webDriver.close();
    }

}
