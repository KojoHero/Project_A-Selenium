package com.selenium.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ResizeTable {
    WebDriver driver;
    @Test
    public void tableResizer(){
        WebElement box  = driver.findElement(By.id("resizable"));
        WebElement textBox  = driver.findElement(By.id("resizable"));
        WebElement dragBox = box.findElement(By.className("react-resizable-handle-se"));
        int startX = textBox.getSize().getWidth();
        int startY = textBox.getSize().getHeight();
        System.out.println(startX + ", " + startY);

        // Define the desired width and height
        int desiredWidth = 300;
        int desiredHeight = 300;

        // Calculate the offset to drag the text box
        int offsetX = desiredWidth - startX;
        int offsetY = desiredHeight - startY;

        // Perform the drag-and-drop action to resize the text box
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(dragBox, offsetX, offsetY).perform();

        int startA = textBox.getSize().getWidth();
        int startB = textBox.getSize().getHeight();
        System.out.println(startA + ", " + startB);
    }
    @Before
    public void beforeResize(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/resizable");
    }
    @After
    public void afterResize(){
        driver.quit();
    }
}