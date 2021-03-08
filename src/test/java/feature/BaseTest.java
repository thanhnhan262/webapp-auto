package feature;

import configuration.BrowserType;
import configuration.Const;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import util.DriverFactory;

import java.time.Duration;

public class BaseTest {

    protected WebDriver webDriver;

    public WebDriver getDriver() {
        return webDriver;
    }

    @Parameters("browser")
    @BeforeClass
    protected void setup(@Optional(BrowserType.CHROME)String browserName) {
        webDriver = DriverFactory.createWebDriver(browserName);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Const.SHORT_TIMEOUT_IN_SECOND));
    }

    @AfterClass
    protected void teardown() {
//        webDriver.quit();
    }
}
