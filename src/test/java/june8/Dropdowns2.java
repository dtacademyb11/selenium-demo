package june8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dropdowns2 {

    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.cars.com/");

        //Verify that the New/Used driopdown box options are


        List<String> expectedValues = List.of("New & used", "New & certified", "New", "Used", "Certified");


        List<WebElement> options = new Select(driver.findElement(By.id("make-model-search-stocktype"))).getOptions();



//        List<String> actual =
//                options.stream()
//                        .map(s -> s.getText())
//                        .collect(Collectors.toList());

        List<String> actual = new ArrayList<>();
        for (WebElement option : options) {
             actual.add(option.getText());
        }


        System.out.println(actual);
        Assert.assertEquals(actual, expectedValues);


        // Verify that default selected option for make is Volvo and for model is XC90

        String makes = new Select(driver.findElement(By.id("makes"))).getFirstSelectedOption().getText();
        String models = new Select(driver.findElement(By.id("models"))).getFirstSelectedOption().getText();

        Assert.assertEquals(makes, "Volvo");
        Assert.assertEquals(models, "XC90 Recharge Plug-In Hybrid");




    }
}
