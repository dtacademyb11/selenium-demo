package june17;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.time.Duration;

public class FileUploadDownload {


    public static void main(String[] args) throws AWTException {


//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");


//        WebDriver driver = new ChromeDriver(chromeOptions);

        WebDriver driver = new ChromeDriver();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        // To perform a file upload, locate the input element with type attribute file and use sendKeys to pass the path of a file being uploaded

//        driver.get("https://www.file.io/");
//
//        driver.findElement(By.id("upload-button")).sendKeys("/Users/duotech/Downloads/git workflow.pdf");

//        driver.get("https://uploadnow.io/en");
//
//        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("/Users/duotech/Downloads/git workflow.pdf");


        // Downloading is about clicking on a download link and downloading a file to a predefined location


        driver.get("https://unsplash.com/images");

        WebElement element = driver.findElement(By.xpath("//a[@href='https://unsplash.com/photos/qRJXQz1XhzI/download?force=true']"));


        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);


        //  if you need to interact with OS windows, use either Robot class or other third party tools such as AutoIT, Sikuli
//        Robot robot = new Robot();
//        robot.keyPress(3);


    }
}
