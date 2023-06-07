package june6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class GetCSSValueMethod {

    public static void main(String[] args) throws InterruptedException {



        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // Applies global implicit wait time for every findElement() / findElements() method calls




        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "bdhsvsg", Keys.ENTER);

        //Verify that the error message color is red, and font of the message is correct

        String expectedColor = "rgba(255, 0, 0, 1)";
        String expectedFont = "Verdana, Arial, Tahoma, Helvetica, sans-serif";

        Thread.sleep(1000);

        WebElement errorMessage = driver.findElement(By.id("ctl00_MainContent_status"));

        System.out.println( errorMessage.getCssValue("color"));
        System.out.println( errorMessage.getCssValue("font-size"));
        System.out.println( errorMessage.getCssValue("font-family"));
        System.out.println( errorMessage.getCssValue("text-align"));

        Assert.assertEquals(errorMessage.getCssValue("color"), expectedColor);
        Assert.assertEquals(errorMessage.getCssValue("font-family"), expectedFont);


        //Can you verify style related aspects of the application such as color font, etc with Selenium?
        // Yes, we can use getCssValue method to gran any style attributes from any element
    }
}
