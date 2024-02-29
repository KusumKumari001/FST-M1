package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Assert;

public class Activity1 {
        public static void main(String[] args) {
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver();
            driver.get("http://alchemy.hguy.co/orangehrm");
            String title= driver.getTitle();
            System.out.println("Title on the website:" +title);
            Assert.assertEquals(title,"OrangeHRM");
            driver.quit();
        }
}
