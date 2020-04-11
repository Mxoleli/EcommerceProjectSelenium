package testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import utilities.ReadConfig;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public static Logger logger;


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

        logger = Logger.getLogger("Ecommerce Site Automation Project");
        PropertyConfigurator.configure("log4j.properties");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();

        return driver;
    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }

    public void captureScreenshot(WebDriver driver, String tname) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        TakesScreenshot ts =(TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("./Screenshots/"+tname +timeStamp+".png"));
        FileUtils.copyFile(source, target);
        System.out.println("ScreenShot taken");
    }

//    @AfterMethod
//    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
//        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//        if (testResult.getStatus() == ITestResult.FAILURE) {
//            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//          String  path = System.getProperty("./Screenshots//"+ testResult.getName()+timeStamp+".jpg");
//            File destination = new File(path);
//            FileUtils.copyFile(scrFile, destination);
//
//        }
//    }

}
