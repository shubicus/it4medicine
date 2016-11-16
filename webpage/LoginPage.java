package webpage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver webDriver;

    @FindBy(css = "#i0116")
    private WebElement username;

    @FindBy(id = "idSIButton9")
    private WebElement submit;

    @FindBy(id = "idSIButton9")
    private WebElement signInButton;

    @FindBy(id = "usernameError")
    private WebElement usernameError;


    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    public WebElement getUsername() {
        return username;
    }

    public WebElement getSubmit() {
        return submit;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public WebElement getUsernameError() {
        return usernameError;
    }

    public void setUsername(String username) {
        getUsername().clear();
        getUsername().sendKeys(username);
    }

    public void submitRegister() {
        getSubmit().submit();
    }

    public boolean signInButtonDisplayed() {
        return getSignInButton().isDisplayed();
    }

    public boolean usernameErrorDisplayed() {
        return getUsernameError().isDisplayed();
    }
}
