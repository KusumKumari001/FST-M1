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

public class Activity1 {
    static AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException, URISyntaxException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UIAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        // Server URL
        //  URL serverURL = new URL("http://localhost:4723/wd/hub");
        var serverURL=new URI("http://localhost:4723/wd/hub"). toURL() ;
        driver = new AndroidDriver(serverURL, options);
        wait =new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void testMethod() throws IOException {
        String[] tasks = {"Complete Activity with Google Tasks",
                "Complete Activity with Google Keep",
                "Complete the second Activity Google Keep"};
        try {

            for(String task : tasks){
                wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Create new task")));
                driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
                wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("add_task_title")));
                driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys(task);
                driver.findElement(AppiumBy.id("add_task_done")).click();
            }
        }catch (NoSuchElementException ex) {
            takeScreenshot();
        }

        Boolean bool = driver.findElement(AppiumBy.androidUIAutomator("text(\"Complete Activity with Google Tasks\")")).isDisplayed();
        Assert.assertTrue(bool, "Complete Activity with Google Tasks : task is not found");

        bool = driver.findElement(AppiumBy.androidUIAutomator("text(\"Complete Activity with Google Keep\")")).isDisplayed();
        Assert.assertTrue(bool, "Complete Activity with Google Keep : task is not found");

        bool = driver.findElement(AppiumBy.androidUIAutomator("text(\"Complete the second Activity Google Keep\")")).isDisplayed();
        Assert.assertTrue(bool, "Complete the second Activity Google Keep : task is not found");


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
