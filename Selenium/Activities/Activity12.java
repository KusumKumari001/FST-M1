import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Activity12 {
    @Test
    public void activity12() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/dynamic-controls");

        String title = driver.getTitle();
        System.out.println("Title of the page is :" + title);

        WebElement inpbox = driver.findElement(By.id("input-text"));
        System.out.println("Input box is enabled: " + inpbox.isEnabled());

        //Click the "Enable Input" button to enable the input field
        driver.findElement(By.id("toggleInput")).click();

        System.out.println("Input box is enabled: " + inpbox.isEnabled());

        driver.close();
    }
}
