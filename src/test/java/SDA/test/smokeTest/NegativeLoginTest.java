package SDA.test.smokeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class NegativeLoginTest {
    By usernameE = By.id("username");
    By passwordE = By.id("password");
    By submit = By.id("submit");
    By error = By.id("error");
    @Test(dataProvider = "invalidCredentials")
    public void test(String username, String password){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practicetestautomation.com/practice-test-login/");

        driver.findElement(usernameE).sendKeys(username);
        driver.findElement(passwordE).sendKeys(password);
        driver.findElement(submit).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        SoftAssert softAssert = new SoftAssert();

        WebElement errorMessage = driver.findElement(error);
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        softAssert.assertTrue(errorMessage.isDisplayed());

        String errorMessageText = errorMessage.getText();
        softAssert.assertTrue(errorMessageText.contains("invalid!"));
        softAssert.assertAll();

        driver.quit();
    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] getData(){
        return new Object[][]{
                {"student","123123"},
                {"norah","Password123"},
                {"sarah","123123"},
        };
    }
}
