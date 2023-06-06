package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class GetAttribute {


    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // maximizes

        driver.get("https://www.amazon.com/");

        String searchTerm = "RTX4060";
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchTerm, Keys.ENTER);

        String attribute = driver.findElement(By.id("twotabsearchtextbox")).getAttribute("value");

        System.out.println(attribute);

        Assert.assertEquals(attribute, searchTerm);

        // To grab the text of any INPUT element, use getAttribute("value"), even if the value attribute is not displayed in the html code


    }
}
