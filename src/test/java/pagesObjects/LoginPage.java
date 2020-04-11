package pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

    WebDriver ldriver;

    HomePage homePage = new HomePage(ldriver);
    public LoginPage(WebDriver rdriver) {

        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);  // Constructor
    }

    @FindBy(how = How.CLASS_NAME, using = "header_user_info")
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

    public void submitLogin(){
        submitLoginBtn.click();
    }

    //Methods to login

    public void loginWithIncorrectDetails(String email, String password){   //Incorrect login details
        clickSignInBtn();
       // homePage.validateTittle("Login - My Store");
        getEmail(email);
        getPassWord(password);
        submitLoginBtn.click();

        if (errorMessage.isDisplayed()){
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
            System.out.println("Error not displayed");
        }

    }

    public void loginWithCorrectDetils(String email, String password){
        //clickSignInBtn();
        getEmail(email);
        getPassWord(password);
        submitLoginBtn.click();
    }

}
