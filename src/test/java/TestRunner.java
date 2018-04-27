import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.CucumberOptions;


@CucumberOptions(
        format = { "pretty", "json:target/json/output.json", "html:target/html/output.html" },
        features = {"C:\\Users\\Admin\\OneDrive - Planit Software Testing\\Code\\SeleniumPageObjectDemo\\src\\test\\resources\\cucumber\\"},
        glue = {"stepdefinitions"}/*, tags = {"@PasswordsDon'tMatch"}/*,"@RegisterSuccess"}*/)
public class TestRunner  extends AbstractTestNGCucumberTests {


}

