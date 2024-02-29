package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity8 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.manage().window().maximize();

        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(3000);

        driver.findElement(By.className("quickLinkText")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_leave_applyLeave"))).click();

        Select leaveType= new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
        leaveType.selectByVisibleText("DayOff");

        WebElement leaveFrom= driver.findElement(By.id("applyleave_txtFromDate"));
        leaveFrom.clear();
        leaveFrom.sendKeys("2024-01-20");

        WebElement leaveTill= driver.findElement(By.id("applyleave_txtToDate"));
        leaveTill.clear();
        leaveTill.sendKeys("2024-02-25");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("applyBtn"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_leave_viewMyLeaveList"))).click();

        WebElement leaveStatus= driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[6]"));
        leaveStatus.getText().contains("Pending Approval");
        driver.quit();
    }
}

