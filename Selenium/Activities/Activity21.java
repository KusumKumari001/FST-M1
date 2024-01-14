import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Activity21 {
    @Test
    public void activity21() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

        driver.get("https://v1.training-support.net/selenium/tab-opener");

        String title = driver.getTitle();
        System.out.println("Title of the current page is :" + title);

        String parentWindow = driver.getWindowHandle();

        WebElement clickButton = driver.findElement(By.id("launcher"));
        clickButton.click();

        // Wait for the second tab to open
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> openWindows = driver.getWindowHandles();
        System.out.println("All the open windows are: " + openWindows);

        for(String handle : openWindows) {
            driver.switchTo().window(handle);
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.id("actionButton")));
        String title1 = driver.getTitle();
        System.out.println("Title of the new page is :" + title1);

        String pageHeading = driver.findElement(By.className("content")).getText();
        System.out.println("Page Heading: " + pageHeading);

        //Repeat the steps by clicking the button in the new tab page
        driver.findElement(By.id("actionButton")).click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(3));

        System.out.println("All the open windows are: " + driver.getWindowHandles());

        for(String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        // Wait for the new page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("content")));

        // Print the handle of the current tab
        System.out.println("Current tab: " + driver.getWindowHandle());

        // Print the title and heading of the new page
        System.out.println("Page title: " + driver.getTitle());

        pageHeading = driver.findElement(By.className("content")).getText();
        System.out.println("Page Heading: " + pageHeading);

        driver.quit();
    }
}
