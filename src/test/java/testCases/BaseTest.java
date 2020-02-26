package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.ReadConfig;

import java.util.concurrent.TimeUnit;

/**
 * Base class is to initialize the browser and load url
 * Get paths from ReadConfig Class
 */

public class BaseTest {

    public static WebDriver driver;

    ReadConfig readConfig = new ReadConfig();

    public String url = readConfig.getUrl() ;
    public String browser  = readConfig.getBrowser();


    @BeforeClass
    public WebDriver initialization(){

        if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver",readConfig.getChromePath()); //ToDo: read path from the config file
            driver = new ChromeDriver();
        }
        else if(browser.equals("firefox")){
            System.setProperty("webdriver.gecko.driver",readConfig.getFirefoxPath()); //ToDo: read path from the config file
            driver = new FirefoxDriver();
        }
        else if(browser.equals("ie")){
            System.setProperty("webdriver.ie.driver",readConfig.getIePath()); //ToDo: read path from the config file
            driver = new InternetExplorerDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();

        return driver;
    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }

}
