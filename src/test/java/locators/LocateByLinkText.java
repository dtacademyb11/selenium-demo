package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LocateByLinkText {

    public static void main(String[] args) {





        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // maximizes

        driver.get("https://www.duotech.io/");

//        driver.findElement(By.linkText("LMS")).click();
        driver.findElement(By.partialLinkText("Conta")).click();





    }
}
