package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.controls.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddPeoplePage extends BasePage {

    @FindBy(tagName = "table")
    WebElement tblAddPeople;

    @FindBy(xpath = "//div[@role='button' and .//text()='Add People']")
    WebElement btnAddPeople;

    @FindBy(xpath = "//div[text()='Congratulations']")
    WebElement txtCongrat;

    public void addPersonAtRow(Map<String, String> personInfo, int rowIndex) {
        List<String> fields = new ArrayList<String>();
        fields.addAll(personInfo.keySet());
        for (String field: fields) {
            Table table = new Table(tblAddPeople);
            WebElement cellEle = table.getCellElementByColumnName(rowIndex, field);
            switch (field){
                case "Name":
                    String[] name = personInfo.get(field).split(" ");
                    String firstName = name[0];
                    String lastName = name[1];
                    fillName(cellEle, firstName, lastName);
                    break;
                default:
                    WebElement input = cellEle.findElement(By.xpath(".//input"));
                    String value = personInfo.get(field);
                    input.sendKeys(value);
                    break;
            }
        }

    }

    public void clickAddPeople() {
        click(btnAddPeople);
    }

    public boolean isCongratPageDisplayed() {
        return txtCongrat.isDisplayed();
    }

    private void fillName(WebElement container, String firstName, String lastName) {
        String firstNameLocator = ".//input[@field='firstName']";
        String lastNameLocator = ".//input[@field='lastName']";
        WebElement firstNameEle = container.findElement(By.xpath(firstNameLocator));
        WebElement lastNameEle = container.findElement(By.xpath(lastNameLocator));
        firstNameEle.sendKeys(firstName);
        lastNameEle.sendKeys(lastName);
    }
}
