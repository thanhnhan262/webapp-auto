package pageObject.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Table {
    private WebElement webElement;

    public Table(WebElement webElement) {
        this.webElement = webElement;
    }

    public int getColumnIndex(String columnName) {
        String editedColumnName = columnName.trim();
        String locator = ".//thead/tr/th[normalize-space(.//text())='" + editedColumnName + "']/preceding-sibling::th";
        List<WebElement> pre = webElement.findElements(By.xpath(locator));
        int columnIndex = pre.size() + 1;
        return columnIndex;
    }

    public WebElement getCellElementByIndex(int rowIndex, int columnIndex) {
        String locator = ".//tbody/tr[" + rowIndex + "]/td[" + columnIndex + "]";
        WebElement ele = webElement.findElement(By.xpath(locator));
        return ele;
    }

    public WebElement getCellElementByColumnName(int rowIndex, String columnName) {
        int columnIndex = getColumnIndex(columnName);
        WebElement ele = getCellElementByIndex(rowIndex, columnIndex);
        return ele;
    }
}
