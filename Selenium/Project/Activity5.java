package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Scanner;

public class Activity5 {
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
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();


        WebElement editSaveButton=driver.findElement(By.id("btnSave"));
        editSaveButton.click();

        WebElement editFname=driver.findElement(By.id("personal_txtEmpFirstName"));
        WebElement editLname=driver.findElement(By.id("personal_txtEmpLastName"));
        WebElement genderRadio=driver.findElement(By.id("personal_optGender_1"));
        WebElement empDob=driver.findElement(By.id("personal_DOB"));
        Select nationality=new Select(driver.findElement(By.id("personal_cmbNation")));
        editFname.clear();
        editLname.clear();
        empDob.clear();
        editFname.sendKeys("Milan Singh");
        editLname.sendKeys("Baghel");
        genderRadio.click();
        nationality.selectByIndex(82);
        empDob.sendKeys("1997-12-15");
        editSaveButton.click();
        driver.quit();
    }
}
