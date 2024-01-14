import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity7 {
    @Test
    public void activity7() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/drag-drop");

        String title = driver.getTitle();
        System.out.println("Title of the page is :" + title);

        Actions builder = new Actions(driver);

        WebElement ball = driver.findElement(By.id("draggable"));
        WebElement dropzone1 = driver.findElement(By.id("droppable"));
        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));

        Action action = builder.click(ball).dragAndDrop(ball,dropzone1).pause(1000).build();
        action.perform();

        String ballDroppedZone1 = driver.findElement(By.xpath("//div[@id='droppable']/p")).getText();
        Assert.assertEquals("Dropped!",ballDroppedZone1);

        Action action1 = builder.click(ball).dragAndDrop(dropzone1,dropzone2).build();
        action1.perform();

        String ballDroppedZone2 = driver.findElement(By.xpath("//div[@id='droppable']/p")).getText();
        Assert.assertEquals("Dropped!",ballDroppedZone2);

        driver.close();
    }
}
