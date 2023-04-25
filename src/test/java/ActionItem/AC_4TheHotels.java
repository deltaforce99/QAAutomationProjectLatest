package ActionItem;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class AC_4TheHotels {


    public static void main(String[] args) throws InterruptedException {
        //declare an arraylist of states
        ArrayList<String> states = new ArrayList<>();

        //add some values for states
        states.add("Chicago");//index 0
        states.add("Washington");//index 1
        states.add("Arkansas");//index 2

        for (int i = 0; i < states.size(); i++) {
            //setup your chromedriver with webdriver manager
            WebDriverManager.chromedriver().setup();
            //declare chrome options
            ChromeOptions options = new ChromeOptions();
            //start maximized for windows
            options.addArguments("start-maximized");
            //define the web-driver and pass options
            WebDriver driver = new ChromeDriver(options);


            //Step 1 go to hotels.com home page
            driver.navigate().to("https://www.hotels.com/");

            Thread.sleep(3000);

            //Step 2 type your destination in the search field
            try {
                driver.findElement(By.xpath("//*[@class='uitk-fake-input uitk-form-field-trigger']")).click();

            }catch (Exception e) {
                System.out.println("Unable to click on the going to search field" + e);
            }//end of search field click try catch block

            Thread.sleep(2000);



            //enter the state in the search field
            try {
                driver.findElement(By.xpath("//*[@id='destination_form_field']")).sendKeys(states.get(i));
            }catch (Exception e) {
                System.out.println("Unable to enter destination in the search field" + e);
            }//end of entering destination in the search field catch block

            Thread.sleep(2000);

            //click on the first dropdown option
            try {
                driver.findElement(By.xpath("//*[@class='uitk-layout-flex']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click the first drop down option" + e);
            }//end of click on first drop down option try catch block

            Thread.sleep(3000);

            //click on the search button
            try {
                driver.findElement(By.xpath("//*[@id='search_button']")).click();
            }catch (Exception e) {
                System.out.println("Unable to click on the search button" + e);
            }//end of click on search button try catch block

            Thread.sleep(3000);

            //create an arraylist for the hotel links in try and catch block
            // and use else if statements for multiple conditions, after you declare the web element as arraylist with xpath
            try {
                ArrayList<WebElement> hotelLinks = new ArrayList<>(driver.findElements(By.xpath("//*[@data-stid='open-hotel-information']")));
                if ( i == 0) {
                    hotelLinks.get(2).click();
                } else if ( i == 1) {
                    hotelLinks.get(0).click();
                }else if (i == 2) {
                    hotelLinks.get(2).click();
                }
            }catch (Exception e) {
                System.out.println("Unable to click on hotel links" + e);

            }//end of click on hotel links try and catch block

            Thread.sleep(3000);






        }//end of loop


    }//end of main
}//end of class


