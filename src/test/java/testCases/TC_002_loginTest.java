package testCases;

import org.testng.annotations.Test;
import pagesObjects.LoginPage;

public class TC_002_loginTest extends BaseTest{


    @Test
    public void LoginWithIncorrectDetailsTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);

        //loginPage.loginWithIncorrectDetails("man1max@gmail.com","1234QA");
       // Thread.sleep(2000);
        loginPage.loginWithCorrectDetils("manmax@gmail.com","123QA");
    }


}
