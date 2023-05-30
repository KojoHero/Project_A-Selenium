import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Second {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/elements");
        driver.findElement(By.id("item-1")).click();
        driver.findElement(By.className("rct-checkbox")).click();
        String text = driver.findElement(By.id("result")).getText();
//        Assert.assertEquals("You have selected",text);
        Assert.assertTrue(text.contains("You have selected"));
        driver.close();
    }
}
