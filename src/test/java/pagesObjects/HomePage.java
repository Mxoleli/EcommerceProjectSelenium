package pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

    WebDriver ldriver;

    public HomePage(WebDriver rdriver) {

        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);  // Constructor
    }

    @FindBy(how = How.ID, using = "header_logo")
    @CacheLookup
    WebElement logo;

    @FindBy(how =How.CLASS_NAME, using = "columns-container")
    @CacheLookup
    WebElement slideshow;

    public void validateTittle(String tittle) {
        if(ldriver.getTitle().equals(tittle)){

            Assert.assertTrue(true);
            System.out.println("Passed!");
        }
        else {
            Assert.assertTrue(false);
            System.out.println("Failed!"); //ToDo: Capture screenshot
        }

    }
    public void validateLogo() {
        if (logo.isDisplayed()) {
            Assert.assertTrue(true);
        } else {

            Assert.assertTrue(false);
            System.out.println("Logo is not displayed on this site.");
        }

    }

    public void validateSlideShow() {
        if (slideshow.isDisplayed()) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
            System.out.println("Slideshow is not displayed on this site.");
        }

    }

}
