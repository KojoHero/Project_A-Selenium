package com.selenium.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class StreamFarm {
    public static void main(String[] args) throws InterruptedException {
        // Set the path to chromedriver executable
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Set the number of iterations
        int numIterations = 50;

        for (int i = 1; i <= numIterations; i++) {
            System.out.println("Iteration: " + i);

            // Open YouTube video link
            driver.get("https://www.youtube.com/watch?v=gMINOvYsblk");

            // Locate the play button and click on it
            List<WebElement> playButton = driver.findElements(By.className("ytp-play-button ytp-button"));
            playButton.get(1).click();

            // Wait for 3 minutes (180,000 milliseconds)
            Thread.sleep(180000);

            // Close the browser
            driver.close();
        }

        // Quit the driver
        driver.quit();
    }
}
