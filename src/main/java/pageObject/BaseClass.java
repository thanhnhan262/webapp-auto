package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverFactory;
import util.WaitUtil;

public class BaseClass {

    private void moveToElement(WebElement element) {
        WebDriver driver = DriverFactory.getWebDriver();
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    protected WebElement findElement(By by) {
        WebDriverWait wait = WaitUtil.getWait();
        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return ele;
    }

    protected WebElement findElementIn(WebElement container, By by) {
        WebDriverWait wait = WaitUtil.getWait();
        wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(container, by));
        WebElement ele = container.findElement(by);
        return ele;
    }

    protected void click(WebElement element) {
        WebDriverWait wait = WaitUtil.getWait();
        wait.until(ExpectedConditions.elementToBeClickable(element));
        moveToElement(element);
        element.click();
    }

    protected void hover(WebElement element) {
        WebDriverWait wait = WaitUtil.getWait();
        wait.until(ExpectedConditions.visibilityOf(element));
        moveToElement(element);
    }

    protected String readText(WebElement element) {
        WebDriverWait wait = WaitUtil.getWait();
        wait.until(ExpectedConditions.visibilityOf(element));
        String text = element.getText();
        return text;
    }

    protected void setText(WebElement element, String text) {
        WebDriverWait wait = WaitUtil.getWait();
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }
}
