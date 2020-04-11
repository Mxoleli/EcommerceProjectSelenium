package testCases;

import org.testng.annotations.Test;
import pagesObjects.HomePage;

import java.io.IOException;

public class TC_001_ValidateHomePageTest extends BaseTest {

    @Test
    public void ValidateHomePageTest() {

        HomePage homePage = new HomePage(driver);

        logger.info("Hello this is an info message");

        logger.info("Verify title");
        homePage.validateTittle("My Store");

        logger.info("Verify logo");
        homePage.validateLogo();

        logger.info("Verify Slide Show");
        homePage.validateSlideShow();

        logger.info("Hello test done!!");
    }
}
