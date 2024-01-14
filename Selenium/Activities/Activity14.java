import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Activity14 {
    @Test
    public void activity14() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/tables");

        String title = driver.getTitle();
        System.out.println("Title of the page is :" + title);

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));
        System.out.println("Row size of Static table: "+ rows.size());

        List<WebElement> cols = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr[1]/td"));
        System.out.println("Row size of Static table: "+ cols.size());

        //Find and print the cell value at the second row second column
        WebElement secondRowele = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Cell value at the second row second column: "+secondRowele.getText());

        //Click the header of the first column to sort by name
        WebElement headerName = driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th[1]"));
        headerName.click();

        //Find and print the cell value at the second row second column again
        WebElement secondRowele2 = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Cell value at the second row second column: "+secondRowele2.getText());

        //Print the cell values of the table footer
        List<WebElement> tableFooter = driver.findElements(By.xpath("//table[@id='sortableTable']/tfoot/tr/th"));
        System.out.println("Cell values of the table footer");
        for(WebElement ele:tableFooter){
            System.out.println(ele.getText());
        }

        driver.close();
    }
}
