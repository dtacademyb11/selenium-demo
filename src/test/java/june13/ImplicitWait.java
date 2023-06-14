package june13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ImplicitWait {


    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Implicit wait is usually added once at the beginning of the script
        // And it is implicitly applicable to all findElement/s method calls

        // Implicit wait is a dynamic wait i.e. if the timeout is 10 and the element is found at 3rd second the wait is over
        // Implicit waits are considered a global wait, set for the lifetime of the WebDriver object instance till you quit the driver;



        driver.get("https://www.cars.com/");

        WebElement usedNewDropdown = driver.findElement(By.id("make-model-search-stocktype1"));
        // If the element is not found right away, WebDriver tries to locate the element within 10 seconds
        // The default polling frequency - 500 ms (half seconds)


        // If at certain point in your script, you would like to reset the implicit wait, you can simply execute the code once more

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //sets the implicit wait from 10 to 20

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));  //removes the implicit wait


        // Implicit wait might not be suitable for all scenarios, when you need to wait for certain event to happen on the page
        // rather than waiting for elements to be found







    }
}
