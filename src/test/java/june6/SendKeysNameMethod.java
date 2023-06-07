package june6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class SendKeysNameMethod {

    public static void main(String[] args) throws InterruptedException {



        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // Applies global implicit wait time for every findElement() / findElements() method calls




        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");


         driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(Keys.chord(Keys.SHIFT, "tester"));
         Thread.sleep(1000);

         // Clear out the existing text from the input element
         driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(Keys.chord(Keys.CONTROL, "A"), Keys.BACK_SPACE);
//         driver.findElement(By.id("ctl00_MainContent_username")).clear();
//         driver.findElement(By.id("ctl00_MainContent_login_button")).submit();

        // to check if element is visible on the page (it can be in the html but not visible to the user)
        boolean isDisplayed = driver.findElement(By.id("ctl00_MainContent_username")).isDisplayed();
        // to check if an element is enabled, i.e. intractable, not disabled
        boolean isEnabled = driver.findElement(By.id("ctl00_MainContent_username")).isEnabled();
        // to check if a radio button or a checkbox is selected
        boolean isChecked = driver.findElement(By.id("ctl00_MainContent_username")).isSelected();






    }
}
