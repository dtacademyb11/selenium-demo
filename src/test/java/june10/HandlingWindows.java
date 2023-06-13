package june10;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class HandlingWindows {


    public static void main(String[] args) {



        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


//

        driver.get("https://www.toyota.com/");

        driver.findElement(By.xpath("//a[@href='http://www.facebook.com/toyota']")).click();

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        // Switch to a new window using a window handle

        String currentWindowHandle = driver.getWindowHandle();// returns the currently active window's unique id
        Set<String> allWindowHandles = driver.getWindowHandles();// returns the all opened windows ids

        System.out.println("Toyota's window handle: " + currentWindowHandle);
        System.out.println("All  window handles: " + allWindowHandles);

        for (String handle : allWindowHandles) {
            if(!handle.equals(currentWindowHandle)){
                driver.switchTo().window(handle);
            }
        }


        driver.findElement(By.name("email")).sendKeys("emnail@gmail.com");

        // Using title to switch to a new window
        // Grab all window handles, iterate through each one by one, and while iterating grab the title with each iteration and check
        // if the title is the one that you need, and stop

        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[.='Forgot Account?']")));


        for( String handle : driver.getWindowHandles()){
            driver.switchTo().window(handle);
            if(driver.getTitle().equals("Forgot password | Can't log in | Facebook")){
                break;
            }
        }

        System.out.println("The current window's title: " + driver.getTitle());

        // Switch to 1 st window

        switchToWindow(driver, "New Cars, Trucks, SUVs & Hybrids | Toyota Official Site");

        System.out.println("The current window's title: " + driver.getTitle());

//        driver. close(); // current window only
        // closing doesn't automatically switch, you still need to switch after closing


        driver.quit();




    }

    public static void switchToWindow(WebDriver driver, String windowTitle){
        for( String handle : driver.getWindowHandles()){
            driver.switchTo().window(handle);
            if(driver.getTitle().equals(windowTitle)){
                return;
            }
        }

    }
}
