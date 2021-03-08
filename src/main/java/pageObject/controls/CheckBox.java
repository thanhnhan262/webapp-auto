package pageObject.controls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObject.BaseClass;

public class CheckBox extends BaseClass {
    WebElement container;

    public CheckBox(WebElement container, WebDriver driver) {
        this.container = container;
    }
}
