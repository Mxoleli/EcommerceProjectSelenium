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
    public void initialization(String br){

        if(br.equals("chrome")){
            System.setProperty("weddriver.chrome.driver",readConfig.getChromePath()); //ToDo: read path from the config file
            driver = new ChromeDriver();
        }
        else if(br.equals("firefox")){
            System.setProperty("weddriver.firefox.driver",readConfig.getFirefoxPath()); //ToDo: read path from the config file
            driver = new FirefoxDriver();
        }
        else if(br.equals("ie")){
            System.setProperty("weddriver.ie.driver",readConfig.getIePath()); //ToDo: read path from the config file
            driver = new InternetExplorerDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }

}
