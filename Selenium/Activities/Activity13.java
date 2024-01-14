import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Activity13 {
    @Test
    public void activity13() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/tables");

        String title = driver.getTitle();
        System.out.println("Title of the page is :" + title);

        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr"));
        System.out.println("Row size of Static table: "+ rows.size());

        List<WebElement> cols = driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr[1]/td"));
        System.out.println("Row size of Static table: "+ cols.size());

        //Find and print all the cell values in the third row of the table.
        List<WebElement> thirdRow = driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr[3]/td"));
        System.out.println("Cell values in the third row of the table");
        for(WebElement ele:thirdRow){
            System.out.println(ele.getText());
        }

        //Find and print the cell value at the second row second column
        WebElement secondRowele = driver.findElement(By.xpath("//table[@class='ui celled striped table']/tbody/tr[2]/td[2]"));
        System.out.println("Cell value at the second row second column: "+secondRowele.getText());

        driver.close();
    }
}
