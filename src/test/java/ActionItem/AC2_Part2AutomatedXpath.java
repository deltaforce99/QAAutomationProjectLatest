package ActionItem;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class AC2_Part2AutomatedXpath {
    public static void main(String[] args) throws InterruptedException {

//create an arraylist using the variable sports and add the values for the category 'sports'
        ArrayList<String> Sports = new ArrayList<>();
        Sports.add("Swimming");
        Sports.add("Volleyball");
        Sports.add("Soccer");
        Sports.add("Baseball");

        //set your webdriver manager
        WebDriverManager.chromedriver().setup();

        //
        WebDriver driver = new ChromeDriver();

        //write for loop for searching each sport
        for (int i = 0; i < Sports.size(); i++) {

            //tell the driver to navigate to the search page
            driver.navigate().to("https://www.bing.com/");
            Thread.sleep(5000);

            //tell the driver to search different kinds of sports using the same element from the search bar
            driver.findElement(By.xpath("//*[@id='search_icon']")).click();

            //wait a few seconds
            Thread.sleep(5000);


            String results = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();
            String[] arrayResult = results.split(" ");

            //Print out the search result number
            System.out.println("The search number is " + arrayResult[1]);

            //wait few seconds
            Thread.sleep(2000);


        }//end of loop
        driver.quit();
    }//end of main
}//end of class
