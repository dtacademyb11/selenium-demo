package june17;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TakeScrrenshots {


    public static void main(String[] args) throws IOException {



        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        try {


            driver.get("https://www.amazon.com/");

            driver.findElement(By.id("cvdsghcd")).sendKeys("csvhcvhvdsvghv");

            Assert.assertEquals(driver.getTitle(), "cdsvcgdhsg");
        }catch (Exception e){
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("target/screenshots/screenshot"+System.currentTimeMillis()+".png"));
            System.out.println("Catch block");
            throw e;
        }finally {
            driver.quit();
        }





    }
}
