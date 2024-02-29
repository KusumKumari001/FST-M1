package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity6 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.manage().window().maximize();

        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("menu_directory_viewDirectory"))).click();
        //WebElement directory= driver.findElement(By.id("menu_directory_viewDirectory")).
        //wait.until(ExpectedConditions.elementToBeClickable(directory));
        //directory.click();
        WebElement heading= driver.findElement(By.xpath("//div[@class='head']/h1"));
        Assert.assertEquals("Search Directory", heading.getText());
        driver.quit();
}
}

