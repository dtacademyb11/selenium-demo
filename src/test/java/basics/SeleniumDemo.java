package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class SeleniumDemo {


    public static void main(String[] args) {


       // ChromeDriver dr = new ChromeDriver();

        WebDriver driver = null;
        try {
            driver = new ChromeDriver(); // initiates a browser session
            driver.get("https://www.duotech.io/"); // navigates to a specific url

            String expected = "Software SDET Automation Engineer program | SDET | QA School | Software Testing";

            String actualTitle = driver.getTitle();


            // Using if statement to compare actual with the expected
//        if(actualTitle.equalsIgnoreCase(expected)){
//            System.out.println("Test Passed.");
//        }else{
//            System.out.println("Test Failed.");
//            System.out.println("EXPECTED: " + expected);
//            System.out.println("ACTUAL: " + actualTitle);
//        }

            // In practice, Assertion class methods from TestNG or JUnit are used for that purpose
            Assert.assertEquals(actualTitle, expected); //  the order is -> actual, expected
        } finally {
            driver.quit();
        }










    }
}
