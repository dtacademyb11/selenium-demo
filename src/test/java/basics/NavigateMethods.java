package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class NavigateMethods {


    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();

       // 1. Navigation methods demo
        driver.navigate().to("https://www.instagram.com");
        Thread.sleep(500);
        driver.navigate().to("https://www.amazon.com/");
        Thread.sleep(500);
        driver.navigate().back();
        Thread.sleep(500);
        driver.navigate().forward();
        Thread.sleep(500);
        driver.navigate().refresh();










    }
}
