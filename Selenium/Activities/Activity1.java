import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Activity1 {
    @Test
    public void activity1(){
        System.setProperty("webdriver.gecko.driver","C:\\Users\\002J5Q744\\IdeaProjects\\FST_Selenium\\Resources\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/");

        String title = driver.getTitle();
        System.out.println("Title of the page is :" + title);

        driver.findElement(By.id("about-link")).click();

        String title_aboutUs_Page = driver.getTitle();
        System.out.println("Title of the page is :" + title_aboutUs_Page);

        driver.close();
    }
}
