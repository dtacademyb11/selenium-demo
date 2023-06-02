package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSSelectorsDemo {


    public static void main(String[] args) {



        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // maximizes

        driver.get("https://www.amazon.com/");


        // Absolute CSS path uses spaces, not recommended
//        driver.findElement(By.cssSelector("html body div header div div div div"));

        // Use relative CSS expression instead
        //  # -> id
        // . -> class

        // An element with id nav-logo -> #nav-logo
        // An a element with class nav-a  -> a.nav-a

        driver.findElement(By.cssSelector("#nav-logo")).click();

        // Using attribute
      //  input[aria-label='Search Amazon']
        //input[aria-label='Search Amazon'][spellcheck='false']

        driver.findElement(By.cssSelector("input[aria-label='Search Amazon']")).sendKeys("CSS", Keys.ENTER);



        // What are the differences between Xpath and CSS Selectors?








    }
}
