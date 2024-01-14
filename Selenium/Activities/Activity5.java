import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Activity5 {
    @Test
    public void activity5() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/input-events");

        String title = driver.getTitle();
        System.out.println("Title of the page is :" + title);

        Actions builder = new Actions(driver);

        builder.click().pause(2000).build().perform();
        String frontText = driver.findElement(By.className("active")).getText();
        System.out.println(frontText);

        builder.doubleClick().pause(1000).build().perform();
        String frontTextAfterDoubleclick = driver.findElement(By.className("active")).getText();
        System.out.println(frontTextAfterDoubleclick);

        builder.contextClick().pause(1000).build().perform();
        String frontTextAfterRightclick = driver.findElement(By.className("active")).getText();
        System.out.println(frontTextAfterRightclick);

        driver.close();
    }
}
