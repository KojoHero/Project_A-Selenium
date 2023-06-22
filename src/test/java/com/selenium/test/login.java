package com.selenium.test;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class login {

    public static void main(String[] args) {
        String username = "test";
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://demoqa.com/login");
        loginPage.setUsername(username);
        loginPage.setPassword("12345678!Aa");
        loginPage.clickButton();
        String text = loginPage.loginMessage();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        Assert.assertEquals(loginPage.loginMessage(),"Log out");
//        String textValue = driver.findElement(By.cssSelector("button[id='submit']")).getText();
//        System.out.println(textValue);
        Assert.assertTrue(loginPage.loginMessage().contains("profile"));
        driver.quit();
    }
}
