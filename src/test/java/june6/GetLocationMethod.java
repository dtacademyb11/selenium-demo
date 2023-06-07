package june6;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class GetLocationMethod {

    public static void main(String[] args) throws InterruptedException {



        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // Applies global implicit wait time for every findElement() / findElements() method calls




        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        System.out.println( driver.findElement(By.name("ctl00$MainContent$login_button")).getLocation());
        driver.navigate().refresh();
        System.out.println( driver.findElement(By.name("ctl00$MainContent$login_button")).getLocation());
    }
}
