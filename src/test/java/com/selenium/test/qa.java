package com.selenium.test;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class qa {

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        type(driver,"user-name", "standard_user");
        type(driver,"password", "secret_sauce");
        clickElement(driver,"login-button");
//       driver.findElement(By.id("login-button")).click();

        //add items to cart
        clickElement(driver,"add-to-cart-sauce-labs-backpack");
        clickElement(driver,"add-to-cart-sauce-labs-bolt-t-shirt");
        clickElement(driver,"add-to-cart-sauce-labs-onesie");

        //go to cart page
        clickElement(driver,"shopping_cart_container");

        //assert if the added items are on the cart page
        String item1 = driver.findElement(By.id("item_4_title_link")).getText();
        Assert.assertEquals("Sauce Labs Backpack", item1);

        String item2 = driver.findElement(By.id("item_1_title_link")).getText();
        Assert.assertEquals("Sauce Labs Bolt T-Shirt", item2);

        String item3 = driver.findElement(By.id("item_2_title_link")).getText();
        Assert.assertEquals("Sauce Labs Onesie", item3);

        //click to check out form page
        clickElement(driver,"checkout");

        //fill checkout form
        type(driver,"first-name", "Test");
        type(driver,"last-name", "Ignore");
        type(driver,"postal-code", "001");

        //click to main checkout page
        clickElement(driver,"continue");

        //Get the price of items and others
        Float backPackPrice = ItemPrice(driver,0);
        Float tShirtPrice = ItemPrice(driver,1);
        Float onesiePrice = ItemPrice(driver,2);

        //price of charges
        Float taxAmount = otherPrice(driver,"summary_tax_label");
        //Total price
        Float totalPrice = otherPrice(driver,"summary_total_label");

        Float totalPriceOfItem = backPackPrice + tShirtPrice + onesiePrice + taxAmount;

        Assert.assertEquals(totalPriceOfItem,totalPrice);

        clickElement(driver,"finish");

        driver.getPageSource().contains("Thank you for your order!");
        driver.quit();
    }

    public static Float ItemPrice(WebDriver driver, int index){
        List<WebElement> element = driver.findElements(By.className("inventory_item_price"));
        String totalValue = element.get(index).getText();
        char delimiter = '$';
        int delimiterIndex = totalValue.indexOf(delimiter);
        String totalMoney = totalValue.substring(delimiterIndex + 1);
        float number = Float.parseFloat(totalMoney);
        return  number;
    }

    public static Float otherPrice(WebDriver driver, String selector){
        String totalValue = driver.findElement(By.className(selector)).getText();
        char delimiter = '$';
        int delimiterIndex = totalValue.indexOf(delimiter);
        String totalMoney = totalValue.substring(delimiterIndex + 1);
        float number = Float.parseFloat(totalMoney);
        return  number;
    }

    public static boolean clickElement(WebDriver driver, String selector){
        driver.findElement(By.id(selector)).click();
        return true;
    }

    public static boolean type(WebDriver driver, String selector, String inputText){
        driver.findElement(By.id(selector)).sendKeys(inputText);
        return true;
    }
}
