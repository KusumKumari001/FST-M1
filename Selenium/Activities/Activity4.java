import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Activity4 {
    @Test
    public void activity4() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\002J5Q744\\IdeaProjects\\FST_Selenium\\Resources\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/target-practice");

        String title = driver.getTitle();
        System.out.println("Title of the page is :" + title);

        WebElement thirdHeader = driver.findElement(By.xpath("//*[text()='Third header']"));
        System.out.println("Third Header is : " + thirdHeader.getText());

        WebElement fifthHeader = driver.findElement(By.xpath("//*[text()='Fifth header']"));
        System.out.println("Fifth Header color is : " + fifthHeader.getCssValue("color"));

        WebElement purpleButton = driver.findElement(By.xpath("//*[text()='Violet']"));
        System.out.println("Class attribute values: "+ purpleButton.getAttribute("class"));

        WebElement greyButton = driver.findElement(By.xpath("//*[text()='Grey']"));
        System.out.println("Grey button text is : " + greyButton.getText());
        driver.close();
    }
}
