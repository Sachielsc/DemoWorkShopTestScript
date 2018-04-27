package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationCompletePage extends DemoWebShopPage {

    public RegistrationCompletePage() {
        super("http://demowebshop.tricentis.com/registerresult/1");
    }

    @FindBy
    public WebElement result;

    public boolean registrationComplete() {
        return result.getText().contains("Your registration completed");
    }
}
