package SDA.homeworks.day16;

import SDA.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HW01 extends TestBase {
    //Go to URL: https://www.google.com
    //Search words: Java, Selenium
    //Assert get text result est that the result text contains the searched Word.
    //Run tests from XML file.

    By search = By.id("APjFqb");
    By javaOracle = By.xpath("//*[text()='Java | Oracle']");
    By seleniumWebsite = By.xpath("(//*[text()='https://www.selenium.dev'])[1]");
    @Test
    @Parameters("keyword")
    public void searchJava(String word){
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(search);
        searchBox.sendKeys(word+ Keys.ENTER);
        WebElement searchResult = driver.findElement(javaOracle);
        Assert.assertTrue(searchResult.isDisplayed());

    }
    @Test
    @Parameters("keyword")
    public void searchSelenium(String word){
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(search);
        searchBox.sendKeys(word+ Keys.ENTER);
        WebElement searchResult = driver.findElement(seleniumWebsite);
        Assert.assertTrue(searchResult.getText().contains("selenium"));
    }
}
