package SDA.test.day17;

import SDA.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C02DataProvider02 extends TestBase {
    //Go to URL: https://opensource-demo.orangehrmlive.com/
    //Login with negative credentilas by Data Provider.
    //Then assert that ‘’Invalid credentials’’ is displayed.
    By usernameE = By.name("username");
    By passwordE = By.name("password");
    By loginE = By.tagName("button");
    By messageE = By.xpath("//*[text()='Invalid credentials']");
    @Test (dataProvider="invalidCredentials")
    public void negativeLoginTest(String userName, String password) throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        WebElement usernameBox = driver.findElement(usernameE);
        usernameBox.sendKeys(userName);
        WebElement passwordBox = driver.findElement(passwordE);
        passwordBox.sendKeys(password);
        WebElement loginButton = driver.findElement(loginE);
        loginButton.click();

        Thread.sleep(1000);

        WebElement invalidMessage = driver.findElement(messageE);
        Assert.assertTrue(invalidMessage.isDisplayed());
    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] getData(){
        return new Object[][]{
                {"Adm","123123"},
                {"Norah","admin123"},
                {"Admin","123123"},
        };
    }
}
