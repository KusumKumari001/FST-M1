package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity2 {
    AndroidDriver driver;
    @BeforeClass
    public void setup() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, options);

        driver.get("https://v1.training-support.net/");
    }

    @Test
    public void test_webpage(){
        // Locate heading on page and print it
        String pageTitle = driver.findElement(AppiumBy.xpath("//android.view.View[@Text()='Training Support']")).getText();
        System.out.println("Heading: " + pageTitle);

        driver.findElement(AppiumBy.id("about-link")).click();

        String pageTitle_aboutUs = driver.findElement(AppiumBy.xpath("//android.view.View[@Text()='About Us']")).getText();
        System.out.println("Heading: " + pageTitle_aboutUs);
    }
    @AfterClass
    public void teardown(){
        driver.close();
    }
}
