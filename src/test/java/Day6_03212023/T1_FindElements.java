package Day6_03212023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T1_FindElements {
    public static void main(String[] args) throws InterruptedException {
//set up your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //declare chrome options
        ChromeOptions options = new ChromeOptions();
        //start maximized for windows
        options.addArguments("start-maximized");
        //define the webdriver and pass the options
        WebDriver driver = new ChromeDriver(options);
        //go to google home page
        driver.navigate().to("https://www.yahoo.com/");
        //wait a few seconds
        Thread.sleep(2000);
        //click on sports link from yahoo.com
        driver.findElements(By.xpath("//*[contains(@class, '_yb_pw')]")).get(3).click();
        //wait a few seconds
        Thread.sleep(2000);
        //Quit the Driver
        driver.quit();

        //define javascript executor (library that allows us to scroll)
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //declare the element you want to scroll into view as a webelement and connect with its xpath
        WebElement upcomingSchedule = driver.findElement(By.xpath("//*[@id='studioWorkshopSchedule']"));

        //scroll to the upcoming schedule and capture the entire schedule
        jse.executeScript("arguments[0].scrollIntoView(True);", upcomingSchedule);

    }//end of main
}//end of class
