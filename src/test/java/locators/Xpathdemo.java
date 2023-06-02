package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpathdemo {


    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // maximizes

        driver.get("https://www.amazon.com/");



        // absolute xpath uses / and goes through each individial element to locate the necessary element
        // absolute xpath can easily break if a new change is added to the page by devs
//        driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[1]/div[2]/span/a/div[2]/span[2]")).click();

        //Relative Xpath uses // and locates an element regardless of its location on the page

        // most common syntax
        //elementName[@attributeName='attributeValue']

        //span[@id='glow-ingress-line2']

        //span -> matches the first span element on the page

//        driver.findElement(By.xpath("//span[@id='glow-ingress-line2']")).click();

        // You can use more than one attribute if one is not enough to make the expression unique

        //input[@type='text'][@placeholder='Search Amazon']


//        driver.findElement(
//                By.xpath("//input[@type='text'][@placeholder='Search Amazon']")).
//                sendKeys("Apple Macbook Pro", Keys.ENTER);


        //*[@id="twotabsearchtextbox"]  -> matches any element with id twotabsearchtextbox





         // Normally all elements of the page are loaded when you navigate to a page which means you can locate any element of the page even if it is not 'in view'
        // But sometimes certain elements on the page are not loaded till you scroll down, in those cases you would need to scroll down the page
        // You can use JSExecutor to scroll down as follows:

        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 5000)"); // to scroll down 5000 pixels

        Thread.sleep(1500);


        //Locate element by its exact text  ->  .=

        // If an element does not have any unique or no attributes at all but has a text, you can use its text to locate it

        //div[.='See personalized recommendations']
        //div[text()='See personalized recommendations']

//        System.out.println(driver.findElement(By.xpath("//div[text()='See personalized recommendations']")).getText());

        // Partial text match

        //div[contains( text(),  'See personalized') ]


        System.out.println(driver.findElement(By.xpath("//div[contains( text(),  'See personalized') ]")).getText());









    }
}
