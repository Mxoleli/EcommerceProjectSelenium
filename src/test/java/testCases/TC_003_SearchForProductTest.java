package testCases;

import org.testng.annotations.Test;
import pagesObjects.LoginPage;
import pagesObjects.SearchFunctionalityPage;

public class TC_003_SearchForProductTest extends BaseTest{


    @Test
    public void LoginWithIncorrectDetailsTest() throws InterruptedException {

        SearchFunctionalityPage sfp = new SearchFunctionalityPage(driver);

        sfp.searchForProduct();

    }


}
