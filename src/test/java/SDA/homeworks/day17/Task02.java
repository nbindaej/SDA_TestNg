package SDA.homeworks.day17;

import SDA.utilities.ParametrizeBrowserTestBase;
import SDA.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Task02 extends ParametrizeBrowserTestBase {
    //Go to URL: http://crossbrowsertesting.github.io/todoapp.html
    //Checking Box todo-4 and Checking Box todo-5
    //If both clicks worked, then the following List should be have length 2.
    //Assert that this is correct
    //Assert that the todo we added is present in the list
    //Archiving old todos
    //If our archive link worked, then the following list should have length 4.
    //Assert that this is true as well
    //Doing Cross Browser Testing.

    By checkboxesByXpath= By.xpath("//*[@type='checkbox']");
    By checkboxClickedByXpath = By.xpath("//*[@class=\"done-true\"]");
    By todotextById = By.id("todotext");
    By addButtonById = By.id("addbutton");

    By archiveByLikeText = By.linkText("archive");
    @Test
    public void test() throws InterruptedException {

        driver.get("http://crossbrowsertesting.github.io/todo-app.html");
        Thread.sleep(1000);// It works correctly without waiting,but I use it to see what are happening slowly
        List<WebElement> checkboxes = driver.findElements(checkboxesByXpath);
        checkboxes.get(3).click();
        checkboxes.get(4).click();
        Thread.sleep(1000);

        List<WebElement> checkboxesClicked = driver.findElements(checkboxClickedByXpath);
        Assert.assertEquals(checkboxesClicked.size(),2);

        WebElement todoTextBox = driver.findElement(todotextById);
        todoTextBox.sendKeys("Run Selenium Test");

        WebElement addButton = driver.findElement(addButtonById);
        addButton.click();
        Thread.sleep(1000);

        checkboxes = driver.findElements(checkboxesByXpath);
        Assert.assertEquals(checkboxes.size(),6);
        Assert.assertTrue(checkboxes.get(5).isDisplayed());


        WebElement archive = driver.findElement(archiveByLikeText);
        archive.click();
        Thread.sleep(1000);

        checkboxes = driver.findElements(checkboxesByXpath);
        Assert.assertEquals(checkboxes.size(),4);
    }
}
