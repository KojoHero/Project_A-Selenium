package com.selenium.test;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");

        //alerts
        driver.findElement(By.id("alertButton")).click();
        String alertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals("You clicked a button",alertMessage);
        driver.switchTo().alert().accept();

        //confirm box
        driver.findElement(By.id("confirmButton")).click();
        String confirmText = driver.switchTo().alert().getText();
        Assert.assertEquals("Do you confirm action?",confirmText);
        driver.switchTo().alert().accept();

        //Prompts
        driver.findElement(By.id("promtButton")).click();
        String promptText = "This is a prompt";
        driver.switchTo().alert().sendKeys(promptText);
        driver.switchTo().alert().accept();
        String promptResult = driver.findElement(By.id("promptResult")).getText();
        Assert.assertTrue(promptResult.contains(promptText));
        driver.quit();
    }
}
