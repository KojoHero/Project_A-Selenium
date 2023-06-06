package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossBrowser {
    public static void main (String[] args){
        String browserType = "chrome";
        WebDriver driver = null;

        if (browserType.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
            driver = new ChromeDriver();
        } else if (browserType.equals("firefox") ) {
            System.setProperty("webdriver.gecko.driver","/usr/local/bin/geckodriver");
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Invalid browser type provided");
        }

        //code here
        driver.get("");
    }
}
