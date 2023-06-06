package com.selenium.test;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePicker {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/date-picker");
        driver.findElement(By.id("datePickerMonthYearInput")).click();
        Select month = new Select(driver.findElement(By.className("react-datepicker__month-select")));
        month.selectByValue("1");
        Select year = new Select(driver.findElement(By.className("react-datepicker__year-select")));
        year.selectByValue("2022");
        driver.findElement(By.className("react-datepicker__day--001")).click();
        String date = driver.findElement(By.id("datePickerMonthYearInput")).getAttribute("value");
        Assert.assertEquals("02/01/2022",date);
        driver.quit();
    }
}
