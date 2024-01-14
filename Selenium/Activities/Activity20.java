import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity20 {
    @Test
    public void activity20() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/javascript-alerts");

        String title = driver.getTitle();
        System.out.println("Title of the page is :" + title);

        driver.findElement(By.id("prompt")).click();

        Alert promtAlert = driver.switchTo().alert();

        String alertText = promtAlert.getText();
        System.out.println("Text in alert: " + alertText);

        promtAlert.sendKeys("Awesome!");
        promtAlert.accept();

        driver.close();
    }
}
