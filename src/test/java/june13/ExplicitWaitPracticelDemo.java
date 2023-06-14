package june13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ExplicitWaitPracticelDemo {

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


        String originalHref = driver.findElement(By.xpath("//a[@class='vehicle-card-link js-gallery-click-link']")).getAttribute("href");

        System.out.println(originalHref);

        new Select(driver.findElement(By.id("sort-dropdown"))).selectByVisibleText("Lowest price");


        //Wait till href attribute of the first result is different

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(

                        ExpectedConditions.attributeToBe(
                                By.xpath("//a[@class='vehicle-card-link js-gallery-click-link']"), "href", "cdsghvghcds" ));

        String afterHref = driver.findElement(By.xpath("//a[@class='vehicle-card-link js-gallery-click-link']")).getAttribute("href");
        System.out.println(afterHref);





        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='vehicle-card   ']//div[@class='price-section price-section-vehicle-card']//span[@class='primary-price']"));


        for (WebElement element : elements) {
            System.out.println(element.getText());
        }

    }
}
