package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import util.DriverFactory;

public class GooglePage{

    String url = "https://google.com";

    By searchTbx = By.name("q");

    public GooglePage goToPage() {
        DriverFactory.getWebDriver().get(url);
        return this;
    }

    public GooglePage search(String text) {
        WebElement ele = DriverFactory.getWebDriver().findElement(searchTbx);
        ele.sendKeys(text);
        ele.sendKeys(Keys.ENTER);
        return this;
    }

    public void verifySearchResult() {
        String expectedTitle = "katalon database connection - Google Search";
        String actualTitle = DriverFactory.getWebDriver().getTitle();
        System.out.println(">>>actual title: " + actualTitle);
    }
}
