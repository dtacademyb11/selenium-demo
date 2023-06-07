package june6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class GetTagNameMethod {

    public static void main(String[] args) throws InterruptedException {



        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // Applies global implicit wait time for every findElement() / findElements() method calls




        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        System.out.println( driver.findElement(By.name("ctl00$MainContent$login_button")).getTagName());


        //locate all elements with an id attribute
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id]"));

        // print their tags

        elements.forEach(s -> System.out.println(s.getTagName()));



    }
}
