package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class WebelementMethods {


    public static void main(String[] args) {



        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // maximizes

        driver.get("https://www.nvidia.com/");


        String attribute = driver.findElement(By.xpath("//a[@aria-label='Search NVIDIA'][@class='menu-level-1']")).getAttribute("href");

        System.out.println(attribute);

        // Find all links on the page and store their URLs into a list

        List<WebElement> links = driver.findElements(By.tagName("a"));



        List<String> allURLS =  new ArrayList<>();

        for (WebElement link : links) {
              allURLS.add(link.getAttribute("href"));
        }

        allURLS.forEach(System.out::println);





    }
}
