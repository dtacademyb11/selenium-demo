package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LocateByClassName {

    public static void main(String[] args) {





        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // maximizes

        driver.get("https://www.duotech.io/");

        WebElement element = driver.findElement(By.className("link-4"));
//
//        // classname method can use only one class at a time, otherswise InvalidSelectorException is thrown
//
//        System.out.println(element.getText());

        List<WebElement> elements = driver.findElements(By.className("link-4"));

       if(elements.isEmpty()){
           throw new RuntimeException("The list is empty");
       }

        for (WebElement webElement : elements) {
            System.out.println(webElement.getText());
        }


        // What is the difference between findElement vs findElements

        // findElement throws NoSuchElementException if element is not found
        // findElements returns an empty list




    }
}
