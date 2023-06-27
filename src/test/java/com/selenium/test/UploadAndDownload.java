package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class UploadAndDownload {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/upload-download");
        String downloadFolder = "/Users/godswaynyatuame/Documents/GitHub/Selenium/Workspace/Project_A/src/image";


        driver.findElement(By.id("downloadButton")).click();
        String filePath = "/Users/godswaynyatuame/Downloads/sampleFile.jpeg";
        Path sourcePath = Paths.get(filePath);
        Path destinationPath = Paths.get(downloadFolder, sourcePath.getFileName().toString());

        try {
            Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File moved successfully");
        } catch (Exception e) {
            System.out.println("Error occured: "+ e.getMessage());
        }


        WebElement uploadElement = driver.findElement(By.id("uploadFile"));
        uploadElement.sendKeys("/Users/godswaynyatuame/Documents/GitHub/Selenium/Workspace/Project_A/src/image");
        driver.getPageSource().contains("C:\\fakepath\\sampleFile.jpeg");
        driver.quit();
    }
}
