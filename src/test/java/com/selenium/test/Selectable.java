package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Selectable {
    WebDriver driver;
    @Test
    public void selects () {
        WebElement firstItem = driver.findElement(By.xpath("//*[text()='Cras justo odio']"));
        firstItem.click();
        String cssValue = firstItem.getCssValue("background-color");
        Assert.assertEquals(cssValue, "rgba(0, 123, 255, 1)");
    }
    @BeforeMethod
    public void beforeSelect() {
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/selectable");
    }
    @AfterMethod
    public void afterSelect() {
        driver.quit();
    }
}
