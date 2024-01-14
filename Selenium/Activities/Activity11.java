import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Activity11 {
    @Test
    public void activity11() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/dynamic-controls");

        String title = driver.getTitle();
        System.out.println("Title of the page is :" + title);

        WebElement chkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        System.out.println("Checkbox is selected: " + chkbox.isSelected());

        chkbox.click();

        System.out.println("Checkbox is selected: " + chkbox.isSelected());

        driver.close();
    }
}
