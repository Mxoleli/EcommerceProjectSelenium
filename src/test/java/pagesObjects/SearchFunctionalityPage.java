package pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchFunctionalityPage {

    WebDriver ldriver;

    HomePage homePage = new HomePage(ldriver);

    public SearchFunctionalityPage(WebDriver rdriver) {

        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);  // Constructor
    }

    @FindBy(how = How.ID, using = "search_query_top")
    @CacheLookup
    WebElement searchtxt;

    @FindBy(how = How.ID_OR_NAME, using = "submit_search")
    @CacheLookup
    WebElement searchbtn;

    public void enterSearchText() {

        searchtxt.sendKeys("Printed Dresses");
    }
    public void clickSearchBtn() {

        searchbtn.click();
    }
    public void searchForProduct(){

        enterSearchText();
        clickSearchBtn();
    }
}
