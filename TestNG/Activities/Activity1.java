package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net");
    }

    @Test
    public void test(){
        System.out.println("The title of the page is : " + driver.getTitle());
        Assert.assertEquals("Training Support", driver.getTitle());
        driver.findElement(By.id("about-link")).click();
        System.out.println("The new title of the page is : " + driver.getTitle());
        Assert.assertEquals("About Training Support", driver.getTitle());
    }


    @AfterMethod
    public void closeBroswer(){
        driver.quit();
    }

}
