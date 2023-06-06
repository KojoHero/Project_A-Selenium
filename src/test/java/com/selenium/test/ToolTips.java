package com.selenium.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolTips {
    WebDriver driver;

    @Test
    public void tooTip(){
        WebElement item1 = driver.findElement(By.id("toolTipButton"));
        Actions action = new Actions(driver);
        action.moveToElement(item1).perform();

//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        WebElement tip1 = driver.findElement(By.id("toolTipButton"));
        String attributeName = "aria-describedby";
        String attributeValue = tip1.getAttribute(attributeName);
        Assert.assertNotNull(attributeValue);

        WebElement tooltipElement = driver.findElement(By.id("buttonToolTip"));
        String tooltipText = tooltipElement.getText();
        System.out.println("Tooltip Text: " + tooltipText);
    }

    @Before
    public void beforeTip(){
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/tool-tips");
    }

    @After
    public void afterTip(){
        driver.quit();
    }
}
