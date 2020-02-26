package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

public class TC_001_ValidateSite extends BaseTest {

    static Logger log = Logger.getLogger(TC_001_ValidateSite.class.getName());
    @Test
    public void ValidateSite(){
        log.debug("Hello this is a debug message");
        log.info("Hello this is an info message");

        if(driver.getTitle().equals("My Store1")){

           Assert.assertTrue(true);
           System.out.println("Passed!");
        }
        else {
            Assert.assertTrue(false);
            System.out.println("Passed!"); //ToDo: Capture screenshot
        }

        log.info("Hello test done!!");
    }
}
