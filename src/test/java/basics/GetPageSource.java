package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class GetPageSource {


    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();

       // 1. Navigate to homepage
        driver.get("https://www.instagram.com");

        //2. Verify that the user is on the homepage by checking if the homepage contains text "Don't have an account? Sign up"
        String expectedText = "Don't have an account?";

        // Before grabbing the html code of the page, wait 1 sec
        Thread.sleep(1000); // Thread.sleep() is not a Selenium code or wait type. It is a java code that stops the execution for certain milliseconds
        // In real world scenario, it is discouraged from using since it is not dynamic and may add extra execution time to your tests
        // But you can still use it for small amount of waits like 1-3 secs, or when Selenium's own dynamic waits do not work

       String pageSourceCode = driver.getPageSource();

       Assert.assertTrue(pageSourceCode.contains(expectedText));

       driver.quit(); //  closes all open windows/tabs
//       driver.close(); // closes only the currently active window







    }
}
