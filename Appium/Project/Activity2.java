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

public class Activity2 {
    static AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException, URISyntaxException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UIAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
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
            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("New text note")));
            driver.findElement(AppiumBy.accessibilityId("New text note")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("editable_title")));
            driver.findElement(AppiumBy.id("editable_title")).sendKeys("Test Notes");
            driver.findElement(AppiumBy.id("edit_note_text")).sendKeys("Appium is an open-source automation mobile testing tool, which is used to test the application. It is developed and supported by Sauce Labsto automate native and hybrid mobile apps. It is a cross-platform mobile automation tool, which means that it allows the same test to be run on multiple platforms.");
            driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        }catch (NoSuchElementException ex) {
            takeScreenshot();
        }

        Boolean bool = driver.findElement(AppiumBy.androidUIAutomator("text(\"Test Notes\")")).isDisplayed();
        Assert.assertTrue(bool, "Notes not found");

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
