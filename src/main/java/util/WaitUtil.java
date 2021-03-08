package util;

import configuration.Const;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtil {
    static public WebDriverWait getWait() {
        WebDriver driver = DriverFactory.getWebDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Const.MEDIUM_TIMEOUT_IN_SECOND));
        return wait;
    }
}
