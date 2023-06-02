package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpathdemo2 {


    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // maximizes

        driver.get("https://www.amazon.com/");


        //Using predicates -> []

        //  syntax ->  (xpathExpressionThatMatchesMultipleElements)[2]

       // example ->  (//a[@class='nav-a  '])[4]

        driver.findElement(By.xpath("(//a[@class='nav-a  '])[4]")).click();


        // The order of preferred locating strategies:
        // - name,id
        // if it is a link, use linkText or partialLinkText
        // if there are attributes that seem unique, use Xpath/CSS to locate the element by the unique attribute
        // if there is no attribute but a text, locate element by its text
        //

        // if there are multiple matches, use predicate


        // * can be used to match any element or attribute

        //*[@id] -> all elements with id attribute

        // not() method is used to match an opposite of the given condition
        //a[not(@class='a-link-normal')]
        // find all a elements whose class is not a-link-normal









    }
}
