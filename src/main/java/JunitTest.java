import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JunitTest {
    WebDriver driver;
    @Test
    public void JunitTestClass(){
        String name = "Test Account";
        driver.findElement(By.id("userName")).sendKeys(name);
        driver.findElement(By.id("userEmail")).sendKeys("Test@test.com");
        driver.findElement(By.id("currentAddress")).sendKeys("This is my address");
        driver.findElement(By.id("permanentAddress")).sendKeys("This is my permanent address");
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        driver.findElement(By.xpath("//*[text()='Submit']")).click();
        String reply = driver.findElement(By.id("name")).getText();
        Assert.assertTrue(reply.contains("Test"));
        driver.quit();
    }
    @Before
    public void BeforeTest(){
        System.out.println("Beginning test");
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");
    }
    @After
    public void afterTest(){
        System.out.println("Test done");
        driver.quit();
    }
}
