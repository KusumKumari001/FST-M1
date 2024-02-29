package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Activity4 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter First name");
        String firstName = scan.nextLine();
        System.out.println("Enter Last name");
        String lastName = scan.nextLine();

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.manage().window().maximize();

        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();

        String title= driver.getTitle();
        Assert.assertEquals(title,"OrangeHRM");

        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']/b")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnAdd"))).click();

        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("btnSave")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='menu_pim_viewPimModule']/b"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("empsearch_employee_name_empName"))).sendKeys(firstName+" "+lastName);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("searchBtn"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='resultTable']")));
        WebElement empFname=driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[3]"));
        Assert.assertEquals(firstName, empFname.getText());
        driver.quit();
    }
}
