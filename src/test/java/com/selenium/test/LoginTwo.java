package com.selenium.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPageFactory;

public class LoginTwo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        LoginPageFactory loginPage = new LoginPageFactory(driver);
        driver.get("https://demoqa.com/login");
        loginPage.login("test","12345678!Aa");
        driver.quit();
    }
}
