package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends DemoWebShopPage {

    public RegisterPage() {
        super("http://demowebshop.tricentis.com/register");
    }

    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, "http://demowebshop.tricentis.com/register", wait);
    }

    /**
     * Test the register functionality.
     *
     * @param gender          true for male false for female
     * @param firstName       First name
     * @param lastName        Last name
     * @param email           Email
     * @param password        Password
     * @param confirmPassword Confirm password
     */
    public void register(boolean gender, String firstName, String lastName, String email, String password,
                         String confirmPassword) {
        clickGender(gender);
        fillFirstName(firstName);
        fillLastName(lastName);
        fillEmail(email);
        fillPassword(password);
        confirmPassword(confirmPassword);
        clickRegisterButton();
    }

    public void clickRegisterButton() {
        this.registerButton.click();
    }

    public void confirmPassword(String confirmPassword) {
        this.confirmPassword.sendKeys(confirmPassword);
        this.confirmPassword.sendKeys(Keys.TAB);  //Press tab to initiate the password matcher
    }

    public void fillPassword(String password) {
        this.password.sendKeys(password);
    }

    public void fillEmail(String email) {
        this.email.sendKeys(email);
    }

    public void fillLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void fillFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void clickGender(boolean gender) {
        (gender ? genderMale : genderFemale).click();
    }

    public boolean mismatchedPassword(){
        return mismatchedPassword.getText().equals("The password and confirmation password do not match.");
    }

    public boolean invalidPassword(){
        return invalidPassword.getText().equals("The password should have at least 6 characters.");
    }

    public boolean wrongEmail(){
        return wrongEmail.getText().equals("Wrong email");
    }

    @FindBy(id = "gender-male")
    private WebElement genderMale;

    @FindBy(id = "gender-female")
    private WebElement genderFemale;

    @FindBy(id = "FirstName")
    private WebElement firstName;

    @FindBy(id = "LastName")
    private WebElement lastName;

    @FindBy(id = "Email")
    private WebElement email;

    @FindBy(id = "Password")
    private WebElement password;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPassword;

    @FindBy(id = "register-button")
    private WebElement registerButton;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[2]/div[2]/div[4]/span[2]")
    private WebElement wrongEmail;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[3]/div[2]/div[1]/span[2]/span")
    private WebElement invalidPassword;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[3]/div[2]/div[2]/span[2]/span")
    private WebElement mismatchedPassword;


}
