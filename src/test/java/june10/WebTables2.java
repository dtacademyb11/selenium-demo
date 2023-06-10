package june10;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class WebTables2 {


    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


//

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(
                "Tester", Keys.TAB, "test", Keys.ENTER);

        driver.findElement(By.linkText("Order")).click();


        // Place and order by using Faker class


        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(Keys.BACK_SPACE, "23");

        Faker faker =  new Faker();

        String full = faker.name().fullName();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(full);
        String address =faker.address().streetAddress();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(address);
        String city =faker.address().cityName();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(city);
        String state = faker.address().state();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys(state);
        String zipcode =faker.address().zipCode();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(zipcode.substring(0, 5));

        String credit = faker.business().creditCardNumber().replace("-", "");


        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(credit);
        String expiry =LocalDate.now().plusYears(2).format(DateTimeFormatter.ofPattern("MM/yy"));
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys(expiry);



        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();







    }
}
