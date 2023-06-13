package june10;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandlingIframes {


    public static void main(String[] args) {




        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


//

        driver.get("https://www.duotech.io/enroll-sqae2");

        // One of the main reasons why element cannot be located even if the locator is correct, is that element could be inside an iframe


//        driver.switchTo().frame("someUniqueId"); // use id or name
        //driver.switchTo().frame(0); // use iframes index (zero-based)
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@id, '16864')]")));


        driver.findElement(By.xpath("//input[@placeholder='First']")).sendKeys("Johnny");

        driver.switchTo().defaultContent(); // switches the context to the main page

        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.linkText("LMS")));

        // Shadow DOM elements are similar to iframes and must be handled using JavaScriptExecutor


//        driver.switchTo().parentFrame(); // Change focus to the parent context.







    }
}
