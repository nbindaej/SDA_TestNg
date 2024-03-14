package SDA.homeworks.day15;

import SDA.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class HW02 extends TestBase {
//    Test Case2: Negative Username Test
//    Open page https://practicetestautomation.com/practice-test-login/
//    Type username incorrectUser into Username field.
//    Type password Password123 into Password field.
//    Click Submit button.
//    Verify error message is displayed.
//    Verify error message text is Your username is invalid!
    By username = By.id("username");
    By password = By.id("password");
    By submit = By.id("submit");
    By error = By.id("error");

    @Test
    public void softAssert(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        SoftAssert softAssert = new SoftAssert();

        // Open page https://practicetestautomation.com/practice-test-login/
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Type username incorrectUser into Username field.
        driver.findElement(username).sendKeys("norah");

        // Type password Password123 into Password field.
        driver.findElement(password).sendKeys("Password123");

        // Click Submit button.
        driver.findElement(submit).click();

        // Verify error message is displayed.
        WebElement errorMessage = driver.findElement(error);
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        softAssert.assertTrue(errorMessage.isDisplayed());

        // Verify error message text is Your username is invalid!
        String errorMessageText = errorMessage.getText();
        softAssert.assertTrue(errorMessageText.contains("Your username is invalid!"));
        softAssert.assertAll();
    }
}
