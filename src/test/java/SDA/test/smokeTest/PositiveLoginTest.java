package SDA.test.smokeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PositiveLoginTest {
    By username = By.id("username");
    By password = By.id("password");
    By submit = By.id("submit");
    By message = By.xpath("//*[contains(text(),'Congratulations')]");
    By logout = By.linkText("Log out");
    @Test
    public void test(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practicetestautomation.com/practice-test-login/");

        driver.findElement(username).sendKeys("student");
        driver.findElement(password).sendKeys("Password123");
        driver.findElement(submit).click();

        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("practicetestautomation.com/logged-in-successfully/"));

        String messageE = driver.findElement(message).getText();
        Assert.assertTrue(messageE.contains("Congratulations"));

        WebElement logoutButton = driver.findElement(logout);
        Assert.assertTrue(logoutButton.isDisplayed());

        driver.quit();
    }
}
