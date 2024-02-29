package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity7 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.manage().window().maximize();

        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(3000);

        driver.findElement(By.id("menu_pim_viewMyDetails")).click();

        driver.findElement(By.xpath("//ul[@id='sidenav']/li[9]")).click();

        driver.findElement(By.id("addWorkExperience")).click();

        driver.findElement(By.id("experience_employer")).sendKeys("IBM");

        driver.findElement(By.id("experience_jobtitle")).sendKeys("Test Analyst");

        WebElement expFromDate= driver.findElement(By.id("experience_from_date"));
        expFromDate.clear();
        expFromDate.sendKeys("2021-01-11");

        WebElement expToDate= driver.findElement(By.id("experience_to_date"));
        expToDate.clear();
        expToDate.sendKeys("2024-01-15");

       driver.findElement(By.id("experience_comments")).sendKeys("NA");

       driver.findElement(By.id("btnWorkExpSave")).click();
        driver.quit();
    }
}
