package june6;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GetLocationMethod2 {

    public static void main(String[] args) throws InterruptedException {



        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // maximizes

        driver.get("https://www.amazon.com/");


        Point location = driver.findElement(By.xpath("//span[contains(text(), 'Back to top')]")).getLocation();
        int y = location.getY();
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, "+ y +")"); // to scroll down 5000 pixels
//
//        Thread.sleep(1500);




    }
}
