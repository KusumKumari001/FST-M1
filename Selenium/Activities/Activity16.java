import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity16 {
    @Test
    public void activity16() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");

        String title = driver.getTitle();
        System.out.println("Title of the page is :" + title);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));

        WebElement userName = driver.findElement(By.xpath("//input[contains(@class,'-username')]"));
        WebElement password = driver.findElement(By.xpath("//input[contains(@class,'-password')]"));
        WebElement confirmPasswrd = driver.findElement(By.xpath("(//input[@type='password'])[3]"));
        WebElement email = driver.findElement(By.xpath("//input[starts-with(@class,'email')]"));

        userName.sendKeys("John");
        password.sendKeys("John123");
        confirmPasswrd.sendKeys("John123");
        email.sendKeys("John@abc");

        driver.findElement(By.xpath("//button[text()='Sign Up']")).click();

        WebElement loginMsg = driver.findElement(By.id("action-confirmation"));

        wait.until(ExpectedConditions.visibilityOf(loginMsg));
        System.out.println("Login message: " + loginMsg.getText());

        driver.close();
    }
}
