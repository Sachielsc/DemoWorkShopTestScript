package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends DemoWebShopPage {

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, "http://demowebshop.tricentis.com/login", wait);
    }

    public LoginPage() {
        super("http://demowebshop.tricentis.com/login");
    }

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(id = "Password")
    WebElement password;

    @FindBy(id = "RememberMe")
    WebElement rememberMe;

    @FindBy(className = "login-button")
    WebElement loginButton;

    @FindBy(className = "register-button")
    WebElement registerButton;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[1]/div/span")
    WebElement loginErrors;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[1]/div/ul/li")
    WebElement reasonForLoginFailure;

    public void login(String email, String password, Boolean rememberMe) {
        inputEmail(email);
        inputPassword(password);
        if (rememberMe) {
            clickRememberMe();
        }
        clickLogin();
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void inputPassword(String password) {
        this.password.sendKeys(password);
    }

    public void inputEmail(String email) {
        this.email.sendKeys(email);
    }

    public void clickRememberMe() {
        rememberMe.click();
    }

    public boolean loginFailed() {
        return (loginErrors.getText().equals("Login was unsuccessful. Please correct the errors and try again."));
    }

    public boolean loginFailedDueToPassword() {
        return (reasonForLoginFailure.getText().equals("The credentials provided are incorrect"));
    }

    public boolean loginFailedDueToUsername() {
        return (reasonForLoginFailure.getText().equals("No customer account found"));
    }

}
