package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Frames {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/nestedframes");
//        WebElement iframe = driver.findElement(By.tagName("iframe"));
//        driver.switchTo().frame(iframe);
//
//        // Get the text within the iframe
//        WebElement textElement = driver.findElement(By.cssSelector("iframe[src='https://demoqa.com/sampleiframe']"));
//        String text = textElement.getText();
//
//        // Print the text within the iframe
//        System.out.println("Text within the iframe: " + text);
//
//        // Switch back to the main content
//        driver.switchTo().defaultContent();
        List<WebElement> iframeElements = driver.findElements(By.id("frame1Wrapper"));

        // Print the number of iframes
        System.out.println("Total number of iframes: " + iframeElements.size());
        driver.switchTo().parentFrame();

        // Print the source attribute of each iframe
        for (WebElement iframe : iframeElements) {
            String src = iframe.getAttribute("src");
            String text = iframe.getText();
            System.out.println("IFrame source: " + text + " " + src);
        }
        driver.quit();
    }
}
