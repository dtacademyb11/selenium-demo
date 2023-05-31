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
        Thread.sleep(1000);

       String pageSourceCode = driver.getPageSource();

       Assert.assertTrue(pageSourceCode.contains(expectedText));

       driver.quit(); //  closes all open windows/tabs
//       driver.close(); // closes only the currently active window







    }
}
