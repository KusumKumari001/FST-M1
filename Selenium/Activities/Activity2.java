import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Activity2 {
    @Test
    public void activity2(){
        System.setProperty("webdriver.gecko.driver","C:\\Users\\002J5Q744\\IdeaProjects\\FST_Selenium\\Resources\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/login-form");

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();


        driver.close();
    }
}
