package june10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DynamicTables {


    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


//

        driver.get("https://www.livecoinwatch.com/");


        // Find the column number -> find the header row and get the th elements count

        int columns = driver.findElements(By.xpath("//table[@class='lcw-table layout-fixed']//thead//tr//th")).size();

        // Find the row count -> find the tbody and get the trs from it

        int rows = driver.findElements(By.xpath("//table[@class='lcw-table layout-fixed']//tbody//tr[@class='table-row filter-row']")).size();


//        System.out.println(columns);
//        System.out.println(rows);


//        for (int i = 1; i <= rows; i++) {
//
//            for (int j = 1; j <= columns; j++) {
//
//               String xpath = "//table[@class='lcw-table layout-fixed']//tbody//tr[@class='table-row filter-row']["+i+"]//td["+j+"]" ;
//                //System.out.println(xpath); // to visualize the dynamic xpath that is generated with each loop
//
//                System.out.println( driver.findElement(By.xpath(xpath)).getText());
//            }
//
//        }

        //table[@class='lcw-table layout-fixed']//tbody//tr[@class='table-row filter-row'][4]//td[5]


        //In a dynamic table with a column with changing data, find the largest value
        // Find the largest 1 hr change percentage (8th column)

        //table[@class='lcw-table layout-fixed']//tbody//tr[@class='table-row filter-row']//td[8]

        List<WebElement> elements = driver.findElements(By.xpath("//table[@class='lcw-table layout-fixed']//tbody//tr[@class='table-row filter-row']//td[8]"));

        List<Double> list = new ArrayList<>();
        for (WebElement element : elements) {
           list.add (  Double.valueOf(element.getText().replace("%", "").replace(" -", "")));
        }

        System.out.println(list);
        //Find the max without sorting

        double max = list.get(0);
        int index = 0;
        for (int i = 1; i < list.size(); i++) {

            if(list.get(i) > max){
                max = list.get(i);
                index = i;
            }

        }



        // Find the name of the crypto whose 1 hr change is the largest

        String xpath = "//table[@class='lcw-table layout-fixed']//tbody//tr[@class='table-row filter-row']["+(index+1)+"]//td[2]";
        String name = driver.findElement(By.xpath(xpath)).getText();


        System.out.println("The largest 1 hr change is " + max + " at position " + (index+1) + " belongs to " + name);



    }
}
