package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_001_ValidateSite extends BaseTest {

    @Test
    public void ValidateSite(){


        if(driver.getTitle().equals("My Store")){

           Assert.assertTrue(true);
           System.out.println("Passed!");
        }
        else {
            Assert.assertTrue(false);
            System.out.println("Passed!"); //ToDo: Capture screenshot
        }
    }
}
