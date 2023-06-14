package june13;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSExecutorDemo {


    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();



        driver.get("https://www.amazon.com/");

     //   driver.findElement(By.xpath("//a[@href='https://music.amazon.com?ref=nav_youraccount_cldplyr']")).click(); //doesn't work since it is hidden

        // click on invisible, hidden elements
//       JavascriptExecutor js=  (JavascriptExecutor)driver;
//       js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@href='https://music.amazon.com?ref=nav_youraccount_cldplyr']")));




//      sendkeys
        JavascriptExecutor js=  (JavascriptExecutor)driver;
        js.executeScript("document.getElementById('twotabsearchtextbox').value='Hello Kitty';");


        js.executeScript("window.scrollBy(0,2500);"); //scrolling down the window by 2500 pixels
        js.executeScript("alert('Hello, Kitty');");  //any JS code can be executed with this method



    }
}
