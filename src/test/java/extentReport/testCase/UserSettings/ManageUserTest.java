package extentReport.testCase.UserSettings;

import extentReport.testCase.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.AddPeoplePage;

public class ManageUserTest extends BaseTest {

    @Test(description = "Add people")
    public void testAddPeople() {
        System.out.println("test #1");

//        //Click on User & Settings icon in top right corner
//        AddPeoplePage addPeoplePage = new AddPeoplePage(webDriver);
//        addPeoplePage.clickHeaderAction("Users and Settings");
//
//        //Click on Add People
//        addPeoplePage.clickMenu("Add People");
//
//        //Add some users into list
//        String name = "Nhan Mai";
//        String email = "nhanmai" + System.currentTimeMillis() + "@gmail.com";
//        Map<String, String> userInfo = new HashMap<String, String>() {{
//            put("Name", name);
//            put("Email", email);
//        }};
//        addPeoplePage.addPersonAtRow(userInfo, 1);
//        addPeoplePage.clickAddPeople();
//
//        //Verify Congratulations page displays
//        Assert.assertTrue(addPeoplePage.isCongratPageDisplayed());
    }

    @Test(description = "Add people 2")
    public void testAddPeople2() {
        System.out.println("test #2");

//        //Click on User & Settings icon in top right corner
//        AddPeoplePage addPeoplePage = new AddPeoplePage(webDriver);
//        addPeoplePage.clickHeaderAction("Users and Settings");
//
//        //Click on Add People
//        addPeoplePage.clickMenu("Add People");
//
//        //Add some users into list
//        String name = "Nhan Mai";
//        String email = "nhanmai" + System.currentTimeMillis() + "@gmail.com";
//        Map<String, String> userInfo = new HashMap<String, String>() {{
//            put("Name", name);
//            put("Email", email);
//        }};
//        addPeoplePage.addPersonAtRow(userInfo, 1);
//        addPeoplePage.clickAddPeople();
//
//        //Verify Congratulations page displays
//        Assert.assertTrue(addPeoplePage.isCongratPageDisplayed());
    }

    @Test(description = "Add people 3")
    public void testAddPeople3() {
        System.out.println("test #3");

    }

    @Test(description = "Add people 4")
    public void testAddPeople4() {
        System.out.println("test #4");

    }

    @Test(description = "Add people 5")
    public void testAddPeople5() {
        System.out.println("test #5");

    }
}
