import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity17 {
    @Test
    public void activity17() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/selects");

        String title = driver.getTitle();
        System.out.println("Title of the page is :" + title);

        WebElement select = driver.findElement(By.xpath("//select[@id='single-select']"));
        Select drpdown = new Select(select);

        drpdown.selectByVisibleText("Option 2");
        System.out.println("Second option: " + drpdown.getFirstSelectedOption().getText());

        drpdown.selectByIndex(3);
        System.out.println("Third option: " + drpdown.getFirstSelectedOption().getText());

        drpdown.selectByValue("4");
        System.out.println("Fourth option: " + drpdown.getFirstSelectedOption().getText());

        List<WebElement> drpdwnEle = drpdown.getOptions();
        System.out.println("All dropdown options are:");
        for(WebElement ele: drpdwnEle){
            System.out.println(ele.getText());
        }

        driver.close();
    }
}
