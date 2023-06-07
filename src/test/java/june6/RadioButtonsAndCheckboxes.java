package june6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class RadioButtonsAndCheckboxes {

    public static void main(String[] args) {




        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // Applies global implicit wait time for every findElement() / findElements() method calls




        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);

        driver.findElement(By.linkText("Order")).click();

        List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));

        radioButtons.get(new Random().nextInt(3)).click();

        //input[@type='radio']


        driver.findElement(By.linkText("View all orders")).click();
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

//        checkboxes.forEach(s -> s.click());

        for (WebElement checkbox : checkboxes) {
            if(!checkbox.isSelected()){
                checkbox.click();
            }
        }

    }
}
