package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

public class Activity2 {

    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get(" https://v1.training-support.net/selenium/target-practice");
    }

    @Test
    public void getTitle(){
        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        Assert.assertEquals("Target Practice", title);
    }
    @Test
    public void handleException() throws Exception{
        String color = driver.findElement(By.xpath("//button[text()='Black']")).getText();
        Assert.assertEquals("Red", color);
    }

    @Test(enabled = false)
    public void skipTest(){
        System.out.println("Skippping this test");
    }

    @Test
    public void skipExcepTest(){
        throw new SkipException("Skipping this test with skip exception");
    }
    @AfterClass
    public void closeBroswer(){

        driver.quit();
    }
}