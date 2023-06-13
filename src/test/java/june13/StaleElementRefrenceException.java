package june13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StaleElementRefrenceException {

    public static void main(String[] args) throws InterruptedException {



        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.cars.com/");

        WebElement usedNewDropdown = driver.findElement(By.id("make-model-search-stocktype"));

        Select select = new Select(usedNewDropdown);

        select.selectByVisibleText("Used");


        new Select(driver.findElement(By.id("makes"))).selectByVisibleText("Ford");


        new Select(driver.findElement(By.id("models"))).selectByValue("ford-f_150");
        new Select(driver.findElement(By.id("make-model-maximum-distance"))).selectByVisibleText("500 miles");





        driver.findElement(By.id("make-model-zip")).sendKeys("22031", Keys.ENTER);


        List<WebElement> allresults = driver.findElements(By.xpath("//a[@data-linkname='vehicle-listing']"));
//
//        for (WebElement allresult : allresults) {
//            allresult.click();
//            driver.navigate().back();
//        }

        for (int i = 0; i < allresults.size(); i++) {
            allresults = driver.findElements(By.xpath("//a[@data-linkname='vehicle-listing']")); // get a fresh list of webelements
            allresults.get(i).click();
            driver.navigate().back();
            Thread.sleep(1000);
        }



        //  StaleElementReferenceException: stale element reference: stale element not found

        // This exception usually happens when you navigate away from tha page and come back to it and try to use the previously stored Webelement
        // which now has become stale (old)
        // Solution: Grab the fresh reference by locating the WebElement or List<WebElement> again with findElement/s method.




    }
}
