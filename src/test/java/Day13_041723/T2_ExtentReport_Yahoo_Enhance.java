package Day13_041723;

import Day12_04112023.Test_Parent;
import Reusable_Actions.ReusableActions_Logger;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class T2_ExtentReport_Yahoo_Enhance extends Test_Parent {
    @Test
    public void tc001_verifyStaySignInOptionIsChecked() {
        //navigate to yahoo.com
        driver.navigate().to("https://www.yahoo.com");
        //next we need to click on the sign in button
        ReusableActions_Logger.clickAction(driver, "//*[text() = 'Sign in']",logger, "SignInButton");
        //verify the stay signed in option is checked
        boolean isStaySignedInChecked = driver.findElement(By.xpath("//*[@id = 'persistent']")).isSelected();
        //the actual validation of our test
        //if the checkbox is checked then we pass the test
        //or else we fail the test
        if (isStaySignedInChecked == true) {
            logger.log(LogStatus.PASS, "The checkbox is checked: " + isStaySignedInChecked);
        } else {
            logger.log(LogStatus.FAIL, "The checkbox is checked: " + isStaySignedInChecked);
        }
    }//end of test case 1

    @Test
    public void tc002_verifySignInOptionIsUnchecked() {
        //click on the checkbox to uncheck it
        ReusableActions_Logger.clickAction(driver, "//*[@class = 'stay-signed-in checkbox-container']",logger, "CheckBox");
        //check the state of the checkbox (it should be unchecked now)
        boolean isStaySignedInChecked = driver.findElement(By.xpath("//*[@id = 'persistent']")).isSelected();
        //the actual validation of our test
        //if the checkbox is checked then we pass the test
        //or else we fail the test
        if (isStaySignedInChecked == true) {
            logger.log(LogStatus.PASS, "The checkbox is checked: " + isStaySignedInChecked);
        } else {
            logger.log(LogStatus.FAIL, "The checkbox is checked: " + isStaySignedInChecked);
        }//end of conditional statement
    }//end of test case 2




}//end of class
