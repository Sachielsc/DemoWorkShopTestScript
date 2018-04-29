package stepdefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.extentreports.ExtentManager;
import utils.driver.Driver;

public class SetUp {
    public static ExtentReports extent;
    public static ExtentTest test;

    @Before
    public void setUp(Scenario scenario){
        extent = ExtentManager.GetExtent();
        test = extent.createTest(scenario.getName());
    }

    @After
    public void tearDown(){
        test.assignAuthor("Malachi");
        extent.flush();
        Driver.quitWebDriver();
    }
}
