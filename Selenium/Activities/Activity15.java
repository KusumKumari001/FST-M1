import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity15 {
    @Test
    public void activity15() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");

        String title = driver.getTitle();
        System.out.println("Title of the page is :" + title);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));

        WebElement userName = driver.findElement(By.xpath("//input[starts-with(@class,'username')]"));
        WebElement password = driver.findElement(By.xpath("//input[starts-with(@class,'password')]"));

        userName.sendKeys("admin");
        password.sendKeys("password");

        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        WebElement loginMsg = driver.findElement(By.id("action-confirmation"));

        wait.until(ExpectedConditions.visibilityOf(loginMsg));
        System.out.println("Login message: " + loginMsg.getText());


        driver.close();
    }
}
