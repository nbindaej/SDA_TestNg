package SDA.test.day17;

import SDA.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C01DataProvider extends TestBase {
    By searchBoxId = By.id("gh-ac");

    @Test(dataProvider = "getData")
    public void searchTest(String searchKey){
        driver.get("https://www.ebay.com");
        WebElement searchBox = driver.findElement(searchBoxId);
        searchBox.sendKeys(searchKey, Keys.ENTER);
    }

    @DataProvider
    public Object[][] getData(){
        Object[][] data = {{"Java"},{"Javascript"},{"Python"}};
        return data;
    }

    @Test(dataProvider = "Norah")
    public void searchTest2(String searchKey){
        driver.get("https://www.ebay.com");
        WebElement searchBox = driver.findElement(searchBoxId);
        searchBox.sendKeys(searchKey, Keys.ENTER);
    }

    @DataProvider(name = "Norah")
    public Object[][] getData2(){
        Object[][] data = {{"Iphone"},{"Android"},{"Laptop"}};
        return data;
    }

    @Test(dataProvider = "getData3")
    public void searchTest3(String searchKey){
        driver.get("https://www.ebay.com");
        WebElement searchBox = driver.findElement(searchBoxId);
        searchBox.sendKeys(searchKey, Keys.ENTER);
    }

    @DataProvider
    public Object[][] getData3(){
       return new Object[][]{
               {"Java"},
               {"Javascript"},
               {"Python"}
       };
    }

    @DataProvider
    public Object[][] getData4(){
        Object[][] data = new Object[3][1];
        data[0] = new Object[]{"Java"};
        data[1] = new Object[]{"JavaScript"};
        data[2] = new Object[]{"Python"};
        return data;
    }

}
