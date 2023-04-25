package ActionItem;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class AC5_WatchersWeight {






    public static void main(String[] args) throws InterruptedException {
        //set up your web-driver manager
        WebDriverManager.chromedriver().setup();

        //Declare chrome options to use with your newly declared web-driver
        ChromeOptions options = new ChromeOptions();


        //Start maximized and incognito
        options.addArguments("start-maximized");
        options.addArguments("incognito");


        //Now, define the web-driver and pass the options you wish to use
        ChromeDriver driver = new ChromeDriver(options);


        //declare an integer arraylist of zipcodes
        ArrayList<String> zipCodes = new ArrayList<>();


        //add some values for the zipcodes

        zipCodes.add("17563");
        zipCodes.add("28119");
        zipCodes.add("14738");

        //Declare the for loop to iterate the test steps for it
        for (int i = 0; i < zipCodes.size(); i++) {

            //Step 1 navigate to weight watchers website
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");
            //Wait a few seconds
            Thread.sleep(3000);


            //Step 2 click on find a workshop link on the top right of the page
            try {

                driver.findElement(By.xpath("//*[text()='Find a Workshop']")).click();

            } catch (Exception e) {
                System.out.println("Unable to click on find a workshop link on the top right side of the page" + e);
            }//end of click on find a workshop link try and catch block

            //Wait a few seconds
            Thread.sleep(2000);


            //Step 3 click on in person link
            try {

                driver.findElement(By.xpath("//*[@class='buttonText-3DCCO']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on in person link" + e);
            }//end of click on in person link try and catch block


            //Wait few seconds
            Thread.sleep(3000);


            //Step 4clear the search field and enter the values from the arraylist


            try {
                WebElement searchBar = driver.findElement(By.xpath("//*[@id='location-search']"));
                searchBar.clear();
                searchBar.sendKeys(zipCodes.get(i));

            } catch (Exception e) {
                System.out.println("Unable to clear the field and enter values from the arraylist" + e);
            }//end of clearing searchbar and entering zipcodes into search field try catch block

            Thread.sleep(3000);

            //Click on submit/search arrow
            try {
                driver.findElement(By.xpath("//*[@class='rightArrow-daPRP']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on submit / search arrow" + e);
            }//end of click on submit / search arrow try and catch block

            Thread.sleep(2000);
            //Declare an arraylist with web-elements and conditional statements

            try {
                ArrayList<WebElement> studioLinks = new ArrayList<>(driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")));

                if (i == 0) {
                    studioLinks.get(1).click();
                } else if (i == 1) {
                    studioLinks.get(2).click();
                } else if (i == 2) {
                    studioLinks.get(0).click();
                }// end of conditional statements
            } catch (Exception e) {
                System.out.println("Unable to create web element arraylist, and complete conditional statements");
            }//End of try catch block

            //Wait a few seconds
            Thread.sleep(3000);


            //Declare the xpath as a string and name it and get its full text at the end by adding .getText();
            try {
                String addressInfo = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
                //declare a new string with a new variable name = to string used above.split with the regex being the word you want to split the entire message by
                String[] addressMessage = addressInfo.split("In-Person");
                //Print out & include ..the thing that they didnt teach
                System.out.println("The address is " + addressMessage[0]);
            } catch (Exception e) {
                System.out.println("Unable to split the address" + e);

                Thread.sleep(2500);
            }//end of try catch block


            Thread.sleep(2000);

            try {
                //Capture the Time and Schedule Table and Print it out
                String printedSchedule = driver.findElement(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).getText();
                System.out.println(printedSchedule);
            }catch (Exception e){
                System.out.println("Unable to capture the date an time table " + e);
            }// end of try catch
            // Wait for few seconds
            Thread.sleep(2000);


        }//end of loop


        //quit the driver
        driver.quit();


    }//end of main
}//end of class

