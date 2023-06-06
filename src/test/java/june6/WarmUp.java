package june6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class WarmUp {


    public static void main(String[] args) {



        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // Applies global implicit wait time for every findElement() / findElements() method calls


//        1. Navigate to webstaurant.com

          driver.get("https://www.webstaurantstore.com/");
//        2. Search for a table
           String searchTerm = "table";
           driver.findElement(By.name("searchval")).sendKeys(searchTerm, Keys.ENTER);

//        3. Verify that all search results contain 'table' and there are 60 search results
        List<WebElement> searchResults = driver.findElements(By.xpath("//span[@class='block font-semibold text-sm-1/2 leading-none mt-4 mb-0 max-h-10 hover:max-h-full min-h-10 overflow-hidden hover:overflow-visible text-center']"));

        Assert.assertEquals(searchResults.size(), 60);


        for (WebElement searchResult : searchResults) {
            Assert.assertTrue(searchResult.getText().toLowerCase().contains(searchTerm));
        }

//        4. Click on the last search result

        searchResults.get(searchResults.size()-1).click();

//        5. Verify the deafult quantity of a product is 1

        String actualQty = driver.findElement(By.id("qty")).getAttribute("value");

        Assert.assertEquals(Integer.parseInt(actualQty), 1);

//         5a.  Verify the price is 194.99
        double expPrice = 194.99;

        double actualPrice = Double.parseDouble(driver.findElement(By.xpath("//div[@id='priceBox']//p[@class='price ']")).getText().replace("$", "").replace("/Each", ""));

        Assert.assertEquals(actualPrice, expPrice);
//        6. Click add to cart

        driver.findElement(By.id("buyButton")).click();



//        7. Verify 1 item added to your cart is on the page
        Assert.assertTrue(driver.findElement(By.cssSelector("div[data-testid='amount-in-cart']")).isDisplayed());
//        8. Empty the cart and verify the cart is empty

          driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();

          driver.findElement(By.xpath("//button[.='Empty Cart']")).click();

          driver.findElement(By.xpath("//footer//button[.='Empty Cart']")).click();

          Assert.assertTrue(driver.findElement(By.xpath("//p[.='Your cart is empty.']")).isDisplayed());


          driver.quit();



    }
}
