import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.Set;

public class Activity22 {
    @Test
    public void activity22() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        Actions builder = new Actions(driver);

        driver.get("https://v1.training-support.net/selenium/popups");

        String title = driver.getTitle();
        System.out.println("Title of the current page is :" + title);

        WebElement signBtn = driver.findElement(By.xpath("//button[@class='ui huge inverted orange button']"));
        builder.moveToElement(signBtn).build().perform();

        System.out.println("tooltip message for signin button: " + signBtn.getAttribute("data-tooltip"));

        signBtn.click();

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        System.out.println("Sign msg: " + driver.findElement(By.id("action-confirmation")).getText());
        
        driver.quit();
    }
}
