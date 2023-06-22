package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    WebDriver driver;

//    @FindBy("")
    public String loginMessage(){
//        return driver.findElement(By.id("submit")).getText();
        return driver.getCurrentUrl();
    }

    public void setUsername(String userName){
        driver.findElement(By.id("userName")).sendKeys(userName);
    }

    public void setPassword(String password){
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public void clickButton(){
        driver.findElement(By.id("login")).click();
    }

    public LoginPage(WebDriver driver){
        this.driver = driver;

    }
}
