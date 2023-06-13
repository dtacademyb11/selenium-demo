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

public class WarmUpTask {

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


        new Select(driver.findElement(By.id("sort-dropdown"))).selectByVisibleText("Lowest price");

        Thread.sleep(2000);

        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='vehicle-card   ']//div[@class='price-section price-section-vehicle-card']//span[@class='primary-price']"));



        List<Double> actualPrices = new ArrayList<>();

        for (WebElement element : elements) {

            actualPrices.add(Double.parseDouble(element.getText().replace("$", "").replace(",", "")));
        }

        System.out.println(actualPrices);

        List<Double> copy = new ArrayList<>(actualPrices);
        copy.sort(Comparator.naturalOrder());

        Assert.assertEquals(actualPrices, copy);


        //Verify the prices are sorted highest to lowest

        new Select(driver.findElement(By.id("sort-dropdown"))).selectByVisibleText("Highest price");

        Thread.sleep(2000);

        elements = driver.findElements(By.xpath("//div[@class='vehicle-card   ']//div[@class='price-section price-section-vehicle-card']//span[@class='primary-price']"));



        actualPrices = new ArrayList<>();

        for (WebElement element : elements) {

            actualPrices.add(Double.parseDouble(element.getText().replace("$", "").replace(",", "")));
        }

        System.out.println(actualPrices);

        copy = new ArrayList<>(actualPrices);
        copy.sort(Comparator.reverseOrder());

        Assert.assertEquals(actualPrices, copy);


        // Verify if the results are sorted from oldest to newest year


        new Select(driver.findElement(By.id("sort-dropdown"))).selectByVisibleText("Oldest year");

        Thread.sleep(2000);


        List<Integer> actualYears =  new ArrayList<>();

        driver.findElements(By.xpath("//a[@data-linkname='vehicle-listing']//h2[@class='title']")).
                forEach(s -> actualYears.add(Integer.valueOf(s.getText().substring(0,4))));


        System.out.println(actualYears);

        List<Integer> expectedYears =  new ArrayList<>(actualYears);

        expectedYears.sort(Comparator.naturalOrder());

        Assert.assertEquals(actualYears, expectedYears);


        // Click on the last result

        List<WebElement> allresults = driver.findElements(By.xpath("//a[@data-linkname='vehicle-listing']"));

        allresults.get(allresults.size()-1).click();

        driver.navigate().back();

        // Get a fresh reference for all webelements

        allresults = driver.findElements(By.xpath("//a[@data-linkname='vehicle-listing']"));

        System.out.println( allresults.get(allresults.size()-1).getText() );


      //  StaleElementReferenceException: stale element reference: stale element not found

        // This exception usually happens when you navigate away from tha page and come back to it and try to use the previously stored Webelement
        // which now has become stale (old)
        // Solution: Grab the fresh reference by locating the WebElement or List<WebElement> again with findElement/s method.




    }
}
