package june17;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WindowSize {


    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();






        driver.get("https://www.duotech.io/");

        System.out.println(driver.manage().window().getSize());

        // Set the window size to a specific size
        driver.manage().window().setSize(new Dimension(800, 898));


        WebElement contacts = driver.findElement(By.linkText("Contacts"));

        Assert.assertTrue(!contacts.isDisplayed());


    }
}
