package SDA.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.time.Duration;

public abstract class TestBase {
    protected static WebDriver driver;
    protected static Actions actions;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
       /* if(driver != null){
            driver.quit();
            driver=null;
        }*/
    }
}
