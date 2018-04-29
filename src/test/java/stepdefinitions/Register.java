package stepdefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java8.En;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageobjects.RegisterPage;
import pageobjects.RegistrationCompletePage;
import utils.ExtentReports.ExtentManager;

import static org.testng.Assert.assertTrue;

public class Register implements En{
    RegisterPage page;
    WebDriver driver;
    WebDriverWait wait;
    ExtentReports extent;
    ExtentTest test;

    @Before
    public void setup(Scenario scenario){
        extent = ExtentManager.GetExtent();
        test = extent.createTest(scenario.getName());
        driver = Driver.getWebDriver();
    }

    @After
    public void tearDown(){
        test.assignAuthor("Malachi");
        extent.flush();
        Driver.quitWebDriver();
    }

    public Register() {

        Given("^I'm on the register page$", () -> {
            page = new RegisterPage(driver, wait);
            test.log(Status.PASS, "Register page instantiated.");
        });

        When("^I select gender male$", () -> {
            page.clickGender(true);
            test.log(Status.PASS, "Clicked gender.");
        });

        And("^I input a valid first name$", () -> {
            page.fillFirstName("Paul");
            test.log(Status.PASS, "Input first name.");
        });

        And("^I input a valid last name$", () -> {
            page.fillLastName("De Paul");
            test.log(Status.PASS, "Input last name.");
        });

        And("^I input a valid email$", () -> {
            page.fillEmail("paulpauly@paulyyyyy.com");
            test.log(Status.PASS, "Input email.");
        });

        And("^I input a valid password$", () -> {
            page.fillPassword("pauly!");
            test.log(Status.PASS, "Input password.");
        });

        And("^I confirm a valid password$", () -> {
            page.confirmPassword("pauly!");
            test.log(Status.PASS, "Confirmed password.");
        });

        And("^I click the register button$", () -> {
            try {
                page.clickRegisterButton();
                test.log(Status.PASS, "Clicked register button.");
            } catch (Exception e){
                test.log(Status.FAIL, e.toString());
            }
        });

        Then("^I should be taken to the registration complete page$", () -> {
            try {
                Assert.assertTrue(page.getCurrentUrl().equals(new RegistrationCompletePage().getURL()));
                test.log(Status.PASS, "Taken to Registration complete page.");
            } catch (AssertionError a){
                test.log(Status.FAIL, "Not taken to Registration complete page.");
            }

        });

        When("^I input an invalid email$", () -> {
            page.fillEmail("paul!!!!");
            test.log(Status.PASS, "Input an invalid email.");

        });

        Then("^I should not be taken to the registration complete page$", () -> {
            Assert.assertFalse(page.getCurrentUrl().equals(new RegistrationCompletePage().getURL()));
            test.log(Status.PASS, "Not taken to the registration complete page");
        });

        And("^The Error should read \"Wrong email\"$", () -> {
            Assert.assertTrue(page.wrongEmail());
            test.log(Status.PASS, "The error reads: \"Wrong email\"");
        });

        And("^The Error should read \"The password should have at least 6 characters.\"$", () -> {
            Assert.assertTrue(page.invalidPassword());
            test.log(Status.PASS, "The error reads: \"The password should have at least 6 characters.\"");
        });

        And("^The Error should read \"The password and confirmation password do not match.\"$", () -> {
            Assert.assertTrue(page.mismatchedPassword());
            test.log(Status.PASS, "The error reads: \"The password and confirmation password do not match.\"");
        });

        And("^I input an invalid password in the register page$", () -> {
            page.fillPassword("1");
        });

        Then("^I should not be taken from the register page to the home page$", () -> {
            try {
                assertTrue(page.getCurrentUrl().equals(new RegisterPage().getURL()));
                test.log(Status.PASS, "Not taken to homepage.");
            } catch (AssertionError a){
                test.log(Status.FAIL, "Left the register page.");
            }

        });

        And("^I confirm an invalid password$", () -> {
            page.confirmPassword("123");
        });
    }
}
