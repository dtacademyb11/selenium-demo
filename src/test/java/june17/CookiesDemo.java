package june17;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class CookiesDemo {


    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));



        driver.get("https://www.amazon.com/");

        System.out.println(driver.manage().window().getSize());

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Macbook", Keys.ENTER);


        driver.findElements(By.xpath("//span[@class='a-color-secondary'][contains(text(),'Sponsored')]/ancestor::div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']")).get(0).click();


        driver.findElement(By.id("add-to-cart-button")).click();
        driver.findElement(By.xpath("//input[@aria-labelledby='attachSiNoCoverage-announce']")).click();






//        Assert.assertTrue(!contacts.isDisplayed());


    }
}
