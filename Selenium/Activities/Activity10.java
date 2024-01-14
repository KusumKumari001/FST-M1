import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity10 {
    @Test
    public void activity10() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/dynamic-controls");

        String title = driver.getTitle();
        System.out.println("Title of the page is :" + title);

        WebElement chkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        System.out.println("Checkbox is visible: " + chkbox.isDisplayed());

        //Click the "Remove Checkbox" button
        driver.findElement(By.xpath("//button[text()='Remove checkbox']")).click();
        System.out.println("Checkbox is visible: " + chkbox.isDisplayed());

        driver.close();
    }
}
