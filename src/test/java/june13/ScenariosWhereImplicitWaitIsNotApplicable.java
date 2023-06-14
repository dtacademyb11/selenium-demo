package june13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class ScenariosWhereImplicitWaitIsNotApplicable {

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

        Thread.sleep(2000);  // Implicit wait cannot help for scenarios where wait needs to happen based on a specific condition

        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='vehicle-card   ']//div[@class='price-section price-section-vehicle-card']//span[@class='primary-price']"));


        for (WebElement element : elements) {
            System.out.println(element.getText());
        }

    }
}
