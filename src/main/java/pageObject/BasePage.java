package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.DriverFactory;

public class BasePage extends BaseClass{
    String url;

    protected BasePage() {
        WebDriver driver = DriverFactory.getWebDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class, 'Tooltip__tooltip')]")
    WebElement headerAction;

    @FindBy(className = "main-menu")
    WebElement mainMenu;

    public Object navigateTo() {
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get(url);
        return this;
    }

    public void clickHeaderAction(String actionName) {
        String locator = ".//a[@aria-label='" + actionName + "']";
        WebElement ele = findElementIn(headerAction, By.xpath(locator));
        click(ele);
    }

    public void clickMenu(String menuName) {
        String locator = ".//a[.//text()='" + menuName + "']";
        WebElement ele = findElementIn(mainMenu, By.xpath(locator));
        click(ele);
    }
}
