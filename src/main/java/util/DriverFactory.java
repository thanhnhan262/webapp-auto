package util;

import configuration.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static Map<Long, WebDriver> webDrivers = new HashMap();

    public static WebDriver createWebDriver(String browserName) {
        WebDriver webDriver;
        switch (browserName){
            case BrowserType.CHROME:
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
            case BrowserType.FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
            case BrowserType.EDGE:
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
                break;
            default:
                throw new WebDriverManagerException("Browser is not supported: " + browserName);
        }
        webDrivers.put(Thread.currentThread().getId(), webDriver);
        return webDriver;
    }

    static public synchronized WebDriver getWebDriver() {
        WebDriver currentDriver = webDrivers.get(Thread.currentThread().getId());
        if(currentDriver == null) {
            throw new WebDriverManagerException("Browser is not started yet!");
        }
        return currentDriver;
    }

    static public synchronized void deleteWebDriver() {
        Long currentThread = Thread.currentThread().getId();
        WebDriver webDriver = webDrivers.get(currentThread);
        webDriver.quit();
        webDrivers.remove(currentThread);
    }
}
