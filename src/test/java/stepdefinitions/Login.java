package stepdefinitions;

import com.aventstack.extentreports.Status;
import cucumber.api.java8.En;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import utils.driver.Driver;

import static org.testng.Assert.assertTrue;
import static stepdefinitions.SetUp.test;

public class Login implements En {
    LoginPage page;
    WebDriverWait wait;

    public Login() {

        Given("^I'm on the login page$", () -> {
            page = new LoginPage(Driver.getWebDriver(), wait);
            test.log(Status.PASS, "Login page instantiated.");
        });

        When("^I input a valid username$", () -> {
            page.inputEmail("12@1234567.com");
            test.log(Status.PASS, "Input valid username.");

        });

        And("^I input the valid password$", () -> {
            page.inputPassword("123456");
            test.log(Status.PASS, "Input valid password.");
        });

        And("^I click the login button$", () -> {
            page.clickLogin();
            test.log(Status.PASS, "Clicked the login button.");
        });

        Then("^I should be taken to the home page$", () -> {
            assertTrue(page.getCurrentUrl().equals(new HomePage().getURL()));
            test.log(Status.PASS, "Taken to the home page.");
        });


        When("^I input an invalid username$", () -> {
            page.inputEmail("!@x.v");
            test.log(Status.PASS, "Input an invalid username.");
        });

        Then("^I should not be taken to the home page$", () -> {
            assertTrue(page.getCurrentUrl().equals(new LoginPage().getURL()));
            assertTrue(page.loginFailed());
            test.log(Status.PASS, "Not taken to homepage.");
        });

        And("^I input an invalid password in the login page$", () -> {
            page.inputPassword("!");
            test.log(Status.PASS, "Input invalid password.");
        });

        And("^The Error should read \"No customer account found\"$", () -> {
            page.loginFailedDueToUsername();
            test.log(Status.PASS, "Error reads \"No customer account found\"");
        });

        And("^The Error should read \"The credentials provided are incorrect\"$", () -> {
            page.loginFailedDueToPassword();
            test.log(Status.PASS, "Error reads \"The credentials provided are incorrect\"");
        });
    }
}
