package ActionItem;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class AC3_JavascriptExecutor {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> countries = new ArrayList<>();
        //add values for the countries so
        countries.add("ARGENTINA"); //index 0
        countries.add("MEXICO");
        countries.add("BRAZIL");
        countries.add("CHILE");

        WebDriver driver = null;
        for (int i = 0; i < countries.size(); i++) {

            //set up your chrome driver with webdriver manager
            WebDriverManager.chromedriver().setup();
            //Now that you have setup your chrome driver with webdriver manager,declare chrome options
            ChromeOptions options = new ChromeOptions();
            //Start maximized for windows and comment out other possible options
            options.addArguments("start-maximized");
            //options.addArguments("incognito");
            //options.addArguments("headless");

            //Now, define the webdriver and pass the options
            driver = new ChromeDriver(options);

            //go to yahoo home page
            driver.navigate().to("https://www.yahoo.com/");

            //wait a few seconds
            Thread.sleep(3000);

            //inspect the search bar, get the element via xpath and ctrl f it and check for 1-1 or 1-2 match, and copy that into driver.find element then also sendkeys with countries.get include (i) for iteration;
            driver.findElement(By.xpath("//*[@class='_yb_15bqx ']")).sendKeys(countries.get(i));

            //click on the search icon
            driver.findElement(By.xpath("//*[@id='ybar-search']")).submit();

            //wait 2-3 seconds
            Thread.sleep(3000);

            //capture the search results

            String results = driver.findElement(By.xpath("//*[@class='title mb-0']")).getText();

            //declare a string value for the results, = split the message

            // and then print out only the search number for those values
            String[] arrayResult = results.split(" ");
            System.out.println(" For " + countries.get(i) + " The search number is " + arrayResult[1]);

            //Set up javascript executor command for scrolling
            JavascriptExecutor jse = (JavascriptExecutor) driver;

            //Scroll all the way to the bottom by using javascriptexecutor
            jse.executeScript("scroll (0,1200)");

            //wait a few seconds
            Thread.sleep(3000);
            //click on about this page at the bottom of the page
            driver.findElement(By.xpath("//*[text()='About this page']")).click();
            //wait a few seconds
            Thread.sleep(3000);

            //once it clicks on the "About this page"
            //now capture the text that starts with 24/7 Live and print it out using getText
            String message = driver.findElement(By.xpath("//*[@class='msg success']")).getText();

            //Print the message
            System.out.println("My message is:" + message);

            //declare arraylist for web element
            ArrayList<WebElement> relatedArticles = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@data-ylk,'elm:rhdln')]")));

            //Get the result using index number
            relatedArticles.get(0).click();


            //wait a few seconds
            Thread.sleep(3000);

            WebElement narrowMessage = driver.findElement(By.xpath("//*[(@id='article_container')]"));

            //capture the text
            String text = narrowMessage.getText();

            //Print Message
            System.out.println(text);
        }//end of loop
        driver.quit();







    }//end of main
}//end of class
