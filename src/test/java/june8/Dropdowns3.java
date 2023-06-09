package june8;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Dropdowns3 {

    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.hoteltonight.com/");


      //  ElementClickInterceptedException: element click intercepted: Element <button .</button> is not clickable at point (579, 518). Other element would receive the click: <input >

        // Use JS

//        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("(//button[@title='Search'])[2]")));



        // Dropdowns not implemented with <select> tag / Suggestion boxes should be handled like any normal webelement like clicking, typing etc,
        //
        driver.findElement(By.name("searchfield")).click();
        driver.findElement(By.name("searchfield")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

    }
}
