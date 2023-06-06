package com.selenium.test;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Links {
    public static void main (String[] args){
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/links");
        //open new tab
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.findElement(By.id("simpleLink")).click();
        String pageTitle = driver.getTitle();
        Assert.assertEquals("DEMOQA",pageTitle);
        //line 22 switches the tab back to the original tab
        driver.switchTo().window(tabs.get(0));
        driver.quit();
    }
}
