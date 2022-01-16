package testClasses;

import org.testng.annotations.Test;
import pageObject.GooglePage;

public class GoogleTest extends BaseTest{

    @Test
    public void testSearchGoogle() throws Exception {
        GooglePage googlePage = new GooglePage();
        googlePage.goToPage()
                .search("hello Intellij")
                .verifySearchResult();
    }
}
