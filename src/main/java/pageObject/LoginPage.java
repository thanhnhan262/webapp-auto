package pageObject;

import configuration.PageURL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage() {
        super();
        url = PageURL.LOGIN;
    }

    @FindBy(xpath = "//input[@data-cucumber='input-login-email']")
    WebElement txtEmail;

    @FindBy(xpath = "//input[@data-cucumber='input-login-password']")
    WebElement txtPassword;

    @FindBy(xpath = "//div[@data-cucumber='button-continue']")
    WebElement btnContinue;

    @FindBy(xpath = "//div[@data-cucumber='button-login']")
    WebElement btnSignIn;

    public void logIn(String email, String password) {
        try {
            setText(txtEmail, email);
            click(btnContinue);
            setText(txtPassword, password);
//            click(btnSignIn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
