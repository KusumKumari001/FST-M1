package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class Activity3 {
    static AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException, URISyntaxException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UIAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Server URL
        //  URL serverURL = new URL("http://localhost:4723/wd/hub");
        var serverURL=new URI("http://localhost:4723/wd/hub"). toURL() ;
        driver = new AndroidDriver(serverURL, options);
        driver.get("https://v1.training-support.net/selenium");
        wait =new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void testMethod() throws IOException {
        String[] tasks = {"Add tasks to list",
                "Get number of tasks",
                "Clear the list"};
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator("text(\"Get Started!\")")));
            driver.findElement(AppiumBy.androidUIAutomator("text(\"Get Started!\")")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator("text(\"JavaScript Alerts\")")));
            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"To-Do List\"))")).click();


            for(String task : tasks){
                wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.className("android.widget.EditText")));
                driver.findElement(AppiumBy.className("android.widget.EditText")).click();
                driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys(task);
                driver.findElement(AppiumBy.androidUIAutomator("text(\"Add Task\")")).click();
            }
            Boolean bool;

            for(String task : tasks){

                driver.findElement(AppiumBy.androidUIAutomator("text(\""+task+"\")")).click();
                bool = driver.findElement(AppiumBy.androidUIAutomator("text(\""+task+"\")")).isDisplayed();
                Assert.assertTrue(bool, task + "is not added");
            }

        }catch (NoSuchElementException ex) {
            takeScreenshot();
        }

      /*  Boolean bool = driver.findElement(AppiumBy.androidUIAutomator("text(\"Test Notes\")")).isDisplayed();
        Assert.assertTrue(bool, "Notes not found");
*/
    }

    public static void takeScreenshot() throws IOException {
        // Take screenshot
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // This specifies the location the screenshot will be saved
        File screenShotName = new File("src/test/resources/screenshot.jpg");

        // This will copy the screenshot to the file created
        FileUtils.copyFile(scrFile, screenShotName);

        // Set filepath for image
        String filePath = "../" + screenShotName;

        // Set image HTML in the report
        String path = "<img src='" + filePath + "'/>";

        // Show image in report
        Reporter.log(path);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}