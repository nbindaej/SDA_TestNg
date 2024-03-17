package SDA.homeworks.day17;

import SDA.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task01 extends TestBase {
    //Open the site: http://opencart.abstracta.us/index.php?route=account/login
    //Login with that credentials
    //Email: clarusway@gmail.com
    //Password: 123456789
    //Using the Search function do it with Data Provider for Mac, iPad and Samsung.
    By emailById = By.id("input-email");
    By passwordById = By.id("input-password");
    By buttonByXpath = By.xpath("//*[@type='submit']");
    By searchByName = By.name("search");
    @Test(dataProvider = "search")
    public void test(String keyword){
        driver.get("http://opencart.abstracta.us/index.php?route=account/login");
        // Entering the email
        WebElement email = driver.findElement(emailById);
        email.sendKeys("clarusway@gmail.com");

        // Entering the password
        WebElement password = driver.findElement(passwordById);
        password.sendKeys("123456789");

        // Clicking on login button
        driver.findElement(buttonByXpath).click();

        // Sending different keywords to the searchBox
        WebElement searchBox = driver.findElement(searchByName);
        searchBox.sendKeys(keyword, Keys.ENTER);
    }


    @DataProvider(name = "search")
    public Object[][] getData(){
        return new Object[][]{
                {"Mac"},
                {"iPad"},
                {"Samsung"},
        };
}
}

