package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FindElement {


    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();

       // 1. Navigate to homepage
        driver.get("https://www.instagram.com");

        Thread.sleep(1000);
        //2. Enter a valid email
        WebElement usernameField = driver.findElement(By.name("username"));
//        usernameField.sendKeys("johndoe@gmail.com");

        driver.findElement(By.name("username")).sendKeys("johndoe@gmail.com");

        //3. Enter an invalid password
        driver.findElement(By.name("password")).sendKeys("bdchscdvhdchsdhvh");

        Thread.sleep(1000);
        //4. Click on log in button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // 5. Verify that log in was unsuccessful

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.instagram.com/");

        // 6. Verify that error message is "Sorry, your password was incorrect. Please double-check your password."

        String expected = "Sorry, your password was incorrect. Please double-check your password.";

        Thread.sleep(1000);
        String actualErrorMessage = driver.findElement(By.id("slfErrorAlert")).getText();

        System.out.println(actualErrorMessage);

        Assert.assertEquals(actualErrorMessage, expected);


    }
}
