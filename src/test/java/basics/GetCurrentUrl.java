package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class GetCurrentUrl {


    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();

       // 1. Navigate to homepage
        driver.get("https://www.instagram.com");

        //2. Verify that the url of the homepage is "https://www.instagram.com/"
        String expectedUrl = "https://www.instagram.com/";

        String actualUrl = driver.getCurrentUrl();
        System.out.println("The current url is: " + actualUrl);

        Assert.assertEquals(actualUrl,expectedUrl);


    }
}
