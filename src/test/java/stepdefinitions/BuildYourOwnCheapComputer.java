package stepdefinitions;

import cucumber.api.java8.En;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuildYourOwnCheapComputer implements En {
    BuildYourOwnCheapComputer page;
    WebDriverWait wait;

    public BuildYourOwnCheapComputer() {
        Given("^I'm on the home page$", () -> {
        });
        When("^I navigate to the cheap pc page$", () -> {
        });
        And("^Add the cheap pc to cart$", () -> {
        });
        And("^Navigate to the shopping cart$", () -> {
        });
        And("^Click agree with terms of service$", () -> {
        });
        And("^Click the checkout button$", () -> {
        });
        And("^Login to checkout$", () -> {
        });
        And("^Select a country$", () -> {
        });
        And("^Input a city$", () -> {
        });
        And("^Fill out address line (\\d+)$", (Integer arg0) -> {
        });
        And("^Fill out zip postal$", () -> {
        });
    }
}
