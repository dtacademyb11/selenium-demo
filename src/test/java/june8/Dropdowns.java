package june8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Dropdowns {

    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.cars.com/");

        WebElement usedNewDropdown = driver.findElement(By.id("make-model-search-stocktype"));

        Select select = new Select(usedNewDropdown);

        select.selectByVisibleText("Used");


        new Select(driver.findElement(By.id("makes"))).selectByValue("hyundai");


        new Select(driver.findElement(By.id("models"))).selectByIndex(6); // 0 based index






    }
}
