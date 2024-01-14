import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Activity3 {
    @Test
    public void login(){
        System.setProperty("webdriver.gecko.driver","C:\\Users\\002J5Q744\\IdeaProjects\\FST_Selenium\\Resources\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/login-form");

        driver.findElement(By.xpath("//input[@name='Username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();


        driver.close();
    }
}
