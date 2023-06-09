package june8;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Dropdowns4 {
    WebDriver driver;
    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.southwest.com/");

        driver.findElement(By.id("LandingAirBookingSearchForm_destinationAirportCode")).sendKeys("MCO", Keys.ENTER);


//        ((JavascriptExecutor)driver).executeScript("argument[0].click();", driver.findElement(By.xpath("//button[@data-testid='depart-btn']")));


        chooseDepartureAndReturnDatesCurrentMonth(driver, 21, 26);

    }


    public static void chooseDepartureAndReturnDatesCurrentMonth(WebDriver driver, int departureDate, int returnDate){

        driver.findElement(By.id("LandingAirBookingSearchForm_departureDate")).click();
        driver.findElement(By.xpath("//div[@class='calendar-month']//span[.='"+departureDate+"']/parent::button")).click();

        driver.findElement(By.id("LandingAirBookingSearchForm_returnDate")).click();
        driver.findElement(By.xpath("//div[@class='calendar-month']//span[.='"+returnDate+"']/parent::button")).click();
    }
}
