package june10;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandlingAlerts {


    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


//

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");


        //Handle the simple alert
//        driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();

        // Try interacting with the page elements while the JS alert is active
        //UnhandledAlertException: unexpected alert open: {Alert text : I am a JS Alert} will be thrown


//        Alert alert = driver.switchTo().alert(); //switches the webdriver focus to the active alert
//        alert.accept(); //click ok
//        Thread.sleep(1000);
//
//        driver.findElement(By.xpath("//a[.='Elemental Selenium']")).click();

//        //Handle a confirm alert
//        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
//        driver.switchTo().alert().dismiss(); // click cancel
//        Thread.sleep(1000);
//
//        driver.findElement(By.xpath("//a[.='Elemental Selenium']")).click();

        //Handle a JS Prompt alert
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello World");
        alert.accept();
        //NoAlertPresentException: no such alert if the alert is already closed
//        System.out.println("The alert message is: " + alert.getText());
        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[.='Elemental Selenium']")).click();




    }
}
