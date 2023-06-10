package june10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class WebTables {


    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


//

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(
                "Tester", Keys.TAB, "test", Keys.ENTER);

        driver.findElement(By.linkText("View all products")).click();

        // Verify table headers

        List<String> expected = List.of("Product name", "Price", "Discount");

        List<WebElement> elements = driver.findElements(By.xpath("//table[@class='ProductsTable']//tr[1]//th"));

        List<String> actual = elements.stream()
                .map(s -> s.getText())
                .collect(Collectors.toList());

        System.out.println(actual);

        Assert.assertEquals(actual, expected);

        //Verify first column data

        List<String> expectedProductNames = List.of("MyMoney", "FamilyAlbum", "ScreenSaver");


        List<WebElement> elements1 = driver.findElements(By.xpath("//table[@class='ProductsTable']//tr//td[1]"));

        List<String> actualProducts = elements1.stream()
                .map(s -> s.getText())
                .collect(Collectors.toList());

        Assert.assertEquals(actualProducts,expectedProductNames);

    }
}
