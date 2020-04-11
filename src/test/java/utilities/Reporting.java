package utilities;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import testCases.BaseTest;

public class Reporting extends TestListenerAdapter {

    BaseTest baseTest = new BaseTest(); // for a screenshot method
    public static WebDriver driver;
    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest test;



    public void onStart(ITestContext testContext)  {


        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
        String repName = "Ecommerce Site Project-Report-" + timeStamp + ".html"; //Name of the Report

        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/" + repName);// specif location of the report
        htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");

        extent = new ExtentReports();

        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host name", "localhost");    //ToDO: Need to read these from the config file
        extent.setSystemInfo("Environemnt", "QA");
        extent.setSystemInfo("user", "Man");

        htmlReporter.config().setDocumentTitle("Ecommerce Site Project"); // Tile of report
        htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report
        //htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); // location of the chart
        htmlReporter.config().setTheme(Theme.DARK);
    }


    public void onTestSuccess(ITestResult tr) {

        test = extent.createTest(tr.getName()); // create new entry in the report
        test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); // send the passed
        // information to the report
        // with GREEN color
        // highlighted
    }

    public void onTestFailure(ITestResult tr) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        test = extent.createTest(tr.getName()); // create new entry in the report
        test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED)); // send the passed informatio to the report with GREEN color highlighted

        String screenshotPath = System.getProperty("./Screenshots//" + tr.getName() + timeStamp + ".jpg");
        File f = new File(screenshotPath);
        if(f.exists()){
            try{
                test.fail("Screenshot is below: " + test.addScreenCaptureFromPath(screenshotPath));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
//        if (tr.getStatus() == ITestResult.FAILURE) {
//            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//           String  path = System.getProperty("./Screenshots//" + tr.getName() + timeStamp + ".jpg");
//            File destination = new File(path);
//            try {
//                FileUtils.copyFile(scrFile, destination);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            path = System.getProperty("./Screenshots//" + tr.getName() + timeStamp + ".jpg");
//            File f = new File(path);
//
//            if (f.exists()) {
//                try {
//                    test.fail("Screenshot is below:" + test.addScreenCaptureFromPath(path));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }

       // }
    }


    public void onTestSkipped(ITestResult tr) {
        test = extent.createTest(tr.getName()); // create nentryew  in th report
        test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
    }


    public void onFinish(ITestContext testContext) {
        extent.flush();
    }

}

