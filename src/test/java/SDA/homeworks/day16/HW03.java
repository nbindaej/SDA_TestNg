package SDA.homeworks.day16;

import SDA.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class HW03 extends TestBase {
    By username = By.id("username");
    By password = By.id("password");
    By submit = By.id("submit");
    By error = By.id("error");
    @Test
    @Parameters({"username","password"})
    public void negativeTest(String name,String pass){
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.findElement(username).sendKeys(name);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(submit).click();

        WebElement errorMessage = driver.findElement(error);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        Assert.assertTrue(errorMessage.isDisplayed());
    }
}
