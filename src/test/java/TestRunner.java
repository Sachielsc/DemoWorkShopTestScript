import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        format = { "pretty", "json:target/json/output.json", "html:target/html/output.html" },
        features = "src/test/resources/cucumber",//register.feature
        glue = {"stepdefinitions"}/*, tags = {"@RegisterSuccess"}*/)
public class TestRunner extends AbstractTestNGCucumberTests {


}

