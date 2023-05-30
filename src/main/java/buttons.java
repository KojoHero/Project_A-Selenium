import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class buttons {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");
        //double click
        Actions action = new Actions(driver);
        WebElement locator = driver.findElement(By.id("doubleClickBtn"));
        action.doubleClick(locator).perform();
        String text = driver.findElement(By.id("doubleClickMessage")).getText();
        Assert.assertEquals("You have done a double click",text);
        //right click
        WebElement newLocator = driver.findElement(By.id("rightClickBtn"));
        action.contextClick(newLocator).perform();
        String newText = driver.findElement(By.id("rightClickMessage")).getText();
        Assert.assertEquals("You have done a right click",newText);
        driver.close();

    }
}
