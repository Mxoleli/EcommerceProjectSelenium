package testCases;

import org.testng.annotations.Test;
import pagesObjects.LoginPage;

public class TC_002_loginTest extends BaseTest{

    LoginPage loginPage = new LoginPage(driver);
    @Test
    public void LoginWithIncorrectDetailsTest() throws InterruptedException {



        loginPage.loginWithIncorrectDetails("man1max@gmail.com","1234QA");

    }
    @Test
    public void LoginWithCorrectDetailsTest() throws InterruptedException {

        Thread.sleep(2000);
        loginPage.loginWithCorrectDetils("manmax@gmail.com","123QA");
    }


}
