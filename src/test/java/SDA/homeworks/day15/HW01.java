package SDA.homeworks.day15;

import SDA.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HW01 extends TestBase {
//Test Case1: Positive Login Test
//Open page https://practicetestautomation.com/practice-test-login/
//Type username student into Username field
//Type password Password123 into Password field
//Click Submit button.
//Verify new page URL contains practicetestautomation.com/logged-in-successfully/
//Verify new page contains expected text ('Congratulations' or 'successfully logged in')
//Verify button Log out is displayed on the new page.
    By username = By.id("username");
    By password = By.id("password");
    By submit = By.id("submit");
    By message = By.xpath("//*[contains(text(),'Congratulations')]");
    By logout = By.linkText("Log out");
    @Test
    public void hardAssert(){
        //Open page https://practicetestautomation.com/practice-test-login/
        driver.get("https://practicetestautomation.com/practice-test-login/");

        //Type username student into Username field
        driver.findElement(username).sendKeys("student");

        //Type password Password123 into Password field
        driver.findElement(password).sendKeys("Password123");

        //Click Submit button.
        driver.findElement(submit).click();

        //Verify new page URL contains practicetestautomation.com/logged-in-successfully/
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("practicetestautomation.com/logged-in-successfully/"));

        //Verify new page contains expected text ('Congratulations' or 'successfully logged in')
        String messageE = driver.findElement(message).getText();
        Assert.assertTrue(messageE.contains("Congratulations"));

        //Verify button Log out is displayed on the new page.
        WebElement logoutButton = driver.findElement(logout);
        Assert.assertTrue(logoutButton.isDisplayed());
    }
    @Test
    public void softAssert(){

        SoftAssert softAssert = new SoftAssert();

        //Open page https://practicetestautomation.com/practice-test-login/
        driver.get("https://practicetestautomation.com/practice-test-login/");

        //Type username student into Username field
        driver.findElement(username).sendKeys("student");

        //Type password Password123 into Password field
        driver.findElement(password).sendKeys("Password123");

        //Click Submit button.
        driver.findElement(submit).click();

        //Verify new page URL contains practicetestautomation.com/logged-in-successfully/
        String url = driver.getCurrentUrl();
        softAssert.assertTrue(url.contains("practicetestautomation.com/logged-in-successfully/"));

        //Verify new page contains expected text ('Congratulations' or 'successfully logged in')
        String messageE = driver.findElement(message).getText();
        softAssert.assertTrue(messageE.contains("Congratulations"));

        //Verify button Log out is displayed on the new page.
        WebElement logoutButton = driver.findElement(logout);
        softAssert.assertTrue(logoutButton.isDisplayed());
        softAssert.assertAll();

    }
}
