package june13;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitDemo {


    public static void main(String[] args) {



        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();




        driver.get("https://www.cars.com/");


        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1)) // controls polling frequency
                .ignoring(NoSuchElementException.class); // controls what exceptions are ignored while waiting

        // You can use custom condition here with lambda expression that uses webdriver
        // wait till certain element is displayed
        wait.until(webDriver -> webDriver.findElement(By.xpath("//body[@class='loaded ae-lang-en ae-device-desktop']")).isDisplayed());

        System.out.println(driver.findElement(By.tagName("body")).getAttribute("class"));
    }
}
