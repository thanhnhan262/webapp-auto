package extentReport.testCase.base;

import configuration.Const;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObject.LoginPage;
import util.DriverFactory;

public class BaseTest {
//    protected WebDriver webDriver;

    @BeforeMethod
    public void testCaseSetup() {
        //open browser
        System.out.println("open browser>>>>>>>>>>>>>>>");
        WebDriver webDriver = DriverFactory.getWebDriver();
        System.out.println(Thread.currentThread().getId() + ": " + webDriver.toString() + " - current page:" + this.toString());
        webDriver.manage().window().maximize();
        webDriver.get(Const.URL);

        //login
        LoginPage loginPage = new LoginPage();
        loginPage.logIn(Const.LOGIN_USERNAME, Const.LOGIN_PASSWORD);
    }

    @AfterMethod
    public void testCaseTeardown() {
        System.out.println("close browser>>>>>>>>>>>>>>>");
//        DriverFactory.deleteWebDriver();
    }

}
