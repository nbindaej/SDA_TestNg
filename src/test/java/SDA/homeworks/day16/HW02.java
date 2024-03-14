package SDA.homeworks.day16;

import SDA.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class HW02 extends TestBase {
    By username = By.id("username");
    By password = By.id("password");
    By submit = By.id("submit");

    @Test
    @Parameters({"username","password"})
    public void test(String name,String pass){

        //Open page https://practicetestautomation.com/practice-test-login/
        driver.get("https://practicetestautomation.com/practice-test-login/");

        //Type username into Username field
        driver.findElement(username).sendKeys(name);

        //Type password into Password field
        driver.findElement(password).sendKeys(pass);

        //Click Submit button.
        driver.findElement(submit).click();

    }
}
