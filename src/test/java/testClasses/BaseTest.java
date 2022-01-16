package testClasses;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import util.DriverFactory;

public class BaseTest {

    @Parameters({"browser"})
    @BeforeMethod
    public void testCaseSetup(String browser) {
        //open browser
        WebDriver webDriver = DriverFactory.createWebDriver(browser);
        System.out.println("ThreadID=" + Thread.currentThread().getId() + ". Webdriver=" + webDriver.toString() + " .Current page=" + this.toString());
        webDriver.manage().window().maximize();
    }

    @AfterMethod
    public void testCaseTeardown() throws Exception{
        //close browser
        Thread.sleep(3000);
        DriverFactory.deleteWebDriver();
    }

}
