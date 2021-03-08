package cucumber.support;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import util.DriverFactory;

public class Hook {
    WebDriver webDriver;

    @Before
    public void openBrowser() {
        System.out.println("open browser>>>>>>>>>>>>>>>");
        webDriver = DriverFactory.getWebDriver();
        webDriver.manage().window().maximize();
    }

    @After
    public void closeBrowser(Scenario scenario) {

        System.out.println("close browser>>>>>>>>>>>>>>>");
        DriverFactory.deleteWebDriver();
    }
}
