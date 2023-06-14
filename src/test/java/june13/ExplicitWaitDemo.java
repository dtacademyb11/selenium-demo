package june13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitDemo {


    public static void main(String[] args) {


        //Explicit waits are dynamic waits provided by Selenium that are used for specific scenarios that require certain conditions
        // Explicit wait uses ExpectedConditions class that has built in conditions such as visibility or clickability
        //

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//button[.='Enable']")).click();

        //Use explicit wait to wait till the element is interactable

        WebElement disabledInputBox = driver.findElement(By.xpath("//input[@type='text']"));

        WebDriverWait explicitWait =  new WebDriverWait(driver, Duration.ofSeconds(10));
        explicitWait.until(ExpectedConditions.elementToBeClickable(disabledInputBox));

        disabledInputBox.sendKeys("Hello World");


        // Click on remove and wait till the checkbox is not present on the page

        driver.findElement(By.xpath("//button[.='Remove']")).click();


//        new WebDriverWait(driver, Duration.ofSeconds(5)).
//                until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//input[@type='checkbox']"))));

//        new WebDriverWait(driver, Duration.ofSeconds(5)).
//                until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));  // this method accepts By object since the element cannot be located to check it's visibility
                                                                                         // this version must be used when element is not on the page yet but you need to check for its visibility/invisibility

        waitTillElementIsVisible(driver,By.id("message"), 10);

        System.out.println( driver.findElement(By.id("message")).getText());

        // Common conditions used from ExpectedConditions class

        // elementToBeClickable -> check is element is enabled

        //attributeToBe -> check if certain element's attribute is equal to a certain value

        // presenceOfAllElements -> check if element is present (is actually in the HTML)

        //visibilityOfAllElements -> chcek if element with given locator are visible


        //

        new WebDriverWait(driver, Duration.ofSeconds(5)).
                until(ExpectedConditions.visibilityOfAllElements());





    }


    public static void waitTillElementIsVisible(WebDriver driver, By byobject, int seconds){
        new WebDriverWait(driver, Duration.ofSeconds(seconds)).
                until(ExpectedConditions.visibilityOfElementLocated(byobject));
    }

    public static void waitTillElementIsInVisible(WebDriver driver, WebElement element, int seconds){
        new WebDriverWait(driver, Duration.ofSeconds(seconds)).
                until(ExpectedConditions.invisibilityOf(element));
    }


}
