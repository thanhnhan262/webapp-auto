package cucumber.stepDefinition;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pageObject.LoginPage;
import util.DriverFactory;

public class LoginPageStepDef {
    @Given("User login with name {string} and password {string}")
    public void user_login(String name, String pass) {
        WebDriver webDriver = DriverFactory.getWebDriver();
        LoginPage loginPage = new LoginPage();
        loginPage.navigateTo();
        loginPage.logIn(name, pass);
    }
}
