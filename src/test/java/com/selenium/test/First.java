package com.selenium.test;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class First {
    public static void main (String [] args){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/elements");
        driver.findElement(By.id("item-0")).click();
        String name = "Test Account";
        driver.findElement(By.id("userName")).sendKeys(name);
        driver.findElement(By.id("userEmail")).sendKeys("Test@test.com");
        driver.findElement(By.id("currentAddress")).sendKeys("This is my address");
        driver.findElement(By.id("permanentAddress")).sendKeys("This is my permanent address");
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        driver.findElement(By.xpath("//*[text()='Submit']")).click();
        String reply = driver.findElement(By.id("name")).getText();
        Assert.assertTrue(reply.contains("Test"));
        driver.close();
    }
}
