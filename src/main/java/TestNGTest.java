import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestNGTest {
    WebDriver driver;
    @Test
    public void TestNG(){
        driver.findElement(By.id("alertButton")).click();
        String alertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals("You clicked a button",alertMessage);
    }

//    @BeforeTest
    @BeforeMethod
    public void beforeATest(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
    }
//    @AfterClass
    @AfterMethod
    public void AfterATest(){
        driver.quit();
    }
}
