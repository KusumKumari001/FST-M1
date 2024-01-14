import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class Activity18 {
    @Test
    public void activity18() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/selects");

        String title = driver.getTitle();
        System.out.println("Title of the page is :" + title);

        WebElement select = driver.findElement(By.xpath("//select[@id='multi-select']"));
        Select drpdown = new Select(select);

        drpdown.selectByVisibleText("Javascript");
        drpdown.selectByIndex(3);
        drpdown.selectByIndex(5);
        drpdown.selectByIndex(6);
        drpdown.selectByValue("node");
        drpdown.deselectByIndex(5);

        List<WebElement> drpdwnSelected = drpdown.getAllSelectedOptions();
        System.out.println("All selected options are:");
        for (WebElement ele : drpdwnSelected){
            System.out.println(ele.getText());
        }


        driver.close();
    }
}
