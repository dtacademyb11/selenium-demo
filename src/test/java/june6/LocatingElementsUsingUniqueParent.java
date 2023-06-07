package june6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatingElementsUsingUniqueParent {


    public static void main(String[] args) {



        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // Applies global implicit wait time for every findElement() / findElements() method calls




        driver.get("https://www.duotech.io/");


        //Locate non-unique child by locating its unique parent first and then locating the child
        // Location is in forward direction: parent -> child

        //div[@class='section no-top-padding wf-section']//h2[@class='section-header']

        System.out.println(driver.findElement(By.xpath("//div[@class='section no-top-padding wf-section']//h2[@class='section-header']")).getText());


        // locate a non-unique parent by locating its its unique child first and then locating the parent
        // Location is in backaward direction:  child -> parent
        //h2[.='Benefits of becoming SQAE']//parent::div


        //Locate an element based on its siblings

        // find the non-unique preceding sibling based on the current element
        //div[@data-ix='fade-up-2']/preceding-sibling::div[@class='service-simple w-clearfix']

        // find the non-unique following sibling based on the current element
        //div[@data-ix='fade-up-2']/following-sibling::div[@class='service-simple w-clearfix']

    }
}
