package stepdefinitions;

import com.aventstack.extentreports.Status;
import cucumber.api.java8.En;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageobjects.RegisterPage;
import pageobjects.RegistrationCompletePage;
import utils.driver.Driver;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
import static stepdefinitions.SetUp.test;

public class Register implements En{
    RegisterPage page;
    WebDriverWait wait;

    public Register() {

        Given("^I'm on the register page$", () -> {
            page = new RegisterPage(Driver.getWebDriver(), wait);
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
                fail("Something went wrong:\n" + e.getMessage());
            }
        });

        Then("^I should be taken to the registration complete page$", () -> {
            try {
                Assert.assertTrue(page.getCurrentUrl().equals(new RegistrationCompletePage().getURL()));
                test.log(Status.PASS, "Taken to Registration complete page.");
            } catch (AssertionError a){
                test.log(Status.FAIL, "Not taken to Registration complete page.");
                fail("Not taken to Registration complete page.");
            }
        });

        When("^I input an invalid email$", () -> {
            try {
                page.fillEmail("paul!!!!");
                test.log(Status.PASS, "Input an invalid email.");
            } catch (Exception e){
                test.log(Status.FAIL, e.getMessage());
                fail("Something went wring:\n" + e.getMessage());
            }

        });

        Then("^I should not be taken to the registration complete page$", () -> {
            try {
                Assert.assertFalse(page.getCurrentUrl().equals(new RegistrationCompletePage().getURL()));
                test.log(Status.PASS, "Not taken to the registration complete page");
            } catch (AssertionError a){
                test.log(Status.FAIL, a.getMessage());
                fail("Assertion failed:\n" + a.getMessage());
            }
        });

        And("^The Error should read \"Wrong email\"$", () -> {
            try {
                Assert.assertTrue(page.wrongEmail());
                test.log(Status.PASS, "The error reads: \"Wrong email\"");
            } catch (AssertionError a){
                test.log(Status.FAIL, a.getMessage());
                fail("Assertion failed:\n" + a.getMessage());
            }
        });

        And("^The Error should read \"The password should have at least 6 characters.\"$", () -> {
            try {
                Assert.assertTrue(page.invalidPassword());
                test.log(Status.PASS, "The error reads: \"The password should have at least 6 characters.\"");
            } catch (AssertionError a){
                test.log(Status.FAIL, a.getMessage());
                fail("Assertion failed:\n" + a.getMessage());
            }
        });

        And("^The Error should read \"The password and confirmation password do not match.\"$", () -> {
            try {
                Assert.assertTrue(page.mismatchedPassword());
                test.log(Status.PASS, "The error reads: \"The password and confirmation password do not match.\"");
            } catch (AssertionError a){
                test.log(Status.FAIL, "The Error doesn't read: \"The password and confirmation password do not match.\"");
                fail("The Error doesn't read: \"The password and confirmation password do not match.\"");
            }
        });

        And("^I input an invalid password in the register page$", () -> {
            try {
                page.fillPassword("1");
            } catch (Exception e){
                test.log(Status.FAIL, e.getMessage());
                fail("Something went wrong:\n" + e.getMessage());
            }
        });

        Then("^I should not be taken from the register page to the home page$", () -> {
            try {
                assertTrue(page.getCurrentUrl().equals(new RegisterPage().getURL()));
                test.log(Status.PASS, "Not taken to homepage.");
            } catch (AssertionError a){
                test.log(Status.FAIL, "Left the register page.");
                fail(a.getMessage());
            }
        });

        And("^I confirm an invalid password$", () -> {
            try {
                page.confirmPassword("123");
            } catch (Exception e){
                test.log(Status.FAIL, e.getMessage());
                fail("Something went wrong:\n" + e.getMessage());
            }
        });
    }
}
