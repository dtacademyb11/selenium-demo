package june13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitDemo2 {


    public static void main(String[] args) {


        //Explicit waits are dynamic waits provided by Selenium that are used for specific scenarios that require certain conditions
        // Explicit wait uses ExpectedConditions class that has built in conditions such as visibility or clickability


        // Implicit wait throws NoSuchElement exception when timeout is reached
        // Explicit  wait throws TimeoutException when timeout is reached




        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.cars.com/");


        new WebDriverWait(driver, Duration.ofSeconds(15)).
                until(ExpectedConditions.attributeToBe(driver.findElement(By.tagName("body")), "class", "loaded ae-lang-en ae-device-desktop")) ;


        System.out.println( driver.findElement(By.tagName("body")).getAttribute("class"));





    }




}
