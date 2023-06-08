package june8;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WarmUp {


    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//        1. Navigate to newegg.com
//

        driver.get("https://www.newegg.com/");

//        2. Search for a rtx
//
        driver.findElement(By.xpath("//input[@title='Search Site']")).sendKeys("rtx", Keys.ENTER);

        Thread.sleep(2000);

//        3. Verify that all search results contain 'rtx'
//

//        List<WebElement> elements = driver.findElements(By.xpath("//a[@class='item-title']"));
//
//        System.out.println(elements.size());
//
//        for (WebElement element : elements) {
//            System.out.println(element.getText());
//            Assert.assertTrue(element.getText().toLowerCase().contains("rtx"));
//        }


     //   4. Find the result with the lowest price click on it


        List<WebElement> prices = driver.findElements(By.xpath("//li[@class='price-current']"));

        List<Double> pricesAsDouble =  new ArrayList<>();
        for (WebElement price : prices) {
            String priceFixed = price.getText().replaceAll("[$,]", "");
            if (priceFixed.contains(" ")) {
                priceFixed = priceFixed.substring(0, priceFixed.indexOf(" "));
            }
            pricesAsDouble.add(Double.valueOf(priceFixed));

        }
        System.out.println(pricesAsDouble);
        pricesAsDouble.sort(Comparator.naturalOrder());

        System.out.println("The lowest price is: " + pricesAsDouble.get(0));

        double d = pricesAsDouble.get(0);

        String xpath = "//li[@class='price-current']//strong[contains(text(), '" + (int)d  + "')]//ancestor::div[@class='item-action']//preceding-sibling::div";

       driver.findElement(By.xpath(xpath)).click();

//       driver.findElement(By.xpath("//label[@class='btn form-checkbox product-compare']//span")).click();
         WebElement checkbox = driver.findElement(By.xpath("//label[@class='btn form-checkbox product-compare']//input"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", checkbox);

        // ElementNotInteractableException: element not interactable
        // This exception happens when an element such as checkbox is in the html code, but is either hidden or obstructed by another element
        // The solution is to find other element nearby that lets you click on that element
        // Another solution is to use JavaScriptExecutor interface method to click









    }
}
