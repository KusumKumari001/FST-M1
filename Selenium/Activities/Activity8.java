import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity8 {
    @Test
    public void activity8() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/dynamic-controls");

        String title = driver.getTitle();
        System.out.println("Title of the page is :" + title);

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2000));

        WebElement toggleButton = driver.findElement(By.id("toggleCheckbox"));
        WebElement checkbox = driver.findElement(By.name("toggled"));

        toggleButton.click();
        wait.until(ExpectedConditions.invisibilityOf(checkbox));

        toggleButton.click();
        wait.until(ExpectedConditions.visibilityOf(checkbox)).click();

        driver.close();
    }
}
