package pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class LoginPage {

    WebDriver ldriver;

    HomePage homePage = new HomePage(ldriver);

    public LoginPage(WebDriver rdriver) {

        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);  // Constructor
    }

    @FindBy(how = How.XPATH, using = "//a[@class='login']")
    @CacheLookup
    WebElement signInBtn;

    @FindBy(how = How.ID, using = "email")
    @CacheLookup
    WebElement emailTxt;

    @FindBy(how = How.ID, using = "passwd")
    @CacheLookup
    WebElement passWordTxt;

    @FindBy(how = How.ID, using = "SubmitLogin")
    @CacheLookup
    WebElement submitLoginBtn;

    @FindBy(how = How.XPATH, using = "//div[@class='alert alert-danger']")
    @CacheLookup
    WebElement errorMessage;

    //My Account Elements
    @FindBy(how = How.XPATH, using = "//ul[@class='myaccount-link-list']")
    @CacheLookup
    WebElement orderHistoryDetails;


    public void clickSignInBtn() {
        signInBtn.click();
    }

    public void getEmail(String eml) {
        emailTxt.clear();
        emailTxt.sendKeys(eml);
    }

    public void getPassWord(String pwrd) {
        passWordTxt.clear();
        passWordTxt.sendKeys(pwrd);

    }

    public void submitLogin() {
        submitLoginBtn.click();
    }

    public void myAccountList() {
        if(orderHistoryDetails.isDisplayed()){

            Assert.assertTrue(true);
        }
        else{

            Assert.assertTrue(false);
        }

    }

    //Methods to login

    public void loginWithIncorrectDetails(String email, String password) {   //Incorrect login details
        clickSignInBtn();
        // homePage.validateTittle("Login - My Store");
        getEmail(email);
        getPassWord(password);
        submitLoginBtn.click();

        if (errorMessage.isDisplayed()) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
            System.out.println("Error not displayed");
        }

    }

    public void loginWithCorrectDetils(String email, String password) throws InterruptedException {
        clickSignInBtn();
        getEmail(email);
        getPassWord(password);
        submitLoginBtn.click();
        Thread.sleep(2000);
        myAccountList();
    }



}
