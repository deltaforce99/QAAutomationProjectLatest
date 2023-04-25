package Day12_04112023;

import Reusable_Actions.ReusableActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class T1_Forloop_TestNG {

    WebDriver driver;

    @BeforeSuite
    public void setUpChromeDriver() {
        //declare the webdriver and define it from the reusable actions
        driver = ReusableActions.setUpDriver();
    }//end of before class

    @Test(priority = 1)
    public void searchForMultipleCars() {
        ArrayList<String> carBrands = new ArrayList<>();
        carBrands.add("BMW");
        carBrands.add("CADILLAC");
        carBrands.add("MERCEDES");
        carBrands.add("PORSCHE");
        for (int i = 0; i < carBrands.size(); i++) {

            //go to google page
            driver.navigate().to("https://www.google.com");
            //enter a car in the search field
            ReusableActions.sendKeysAction(driver, "//*[@name='q']", carBrands.get(i), "SearchField");
            //hit submit on the  search button
            ReusableActions.submitAction(driver, "//*[@name='btnK']", "GoogleSubmit");
            String result = ReusableActions.getText(driver, "//*[@id='result-stats']", "SearchResult");
            String[] arrayResult = result.split(" ");
            System.out.println(carBrands.get(i) + " " + arrayResult[1]);

        }// end of loop
    }//end of test case 1


    @AfterSuite
    public void quitDriverSession() {
        driver.quit();
    }//end of after suite
}//end of class



