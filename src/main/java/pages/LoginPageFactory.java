package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageFactory {
    WebDriver driver;

    @FindBy(id="userName")
    WebElement usernameField;

    @FindBy(id="password")
    WebElement passwordField;

    @FindBy(id="login")
    WebElement loginButton;

    public String loginMessage(){
//        return driver.findElement(By.id("submit")).getText();
        return driver.getCurrentUrl();
    }

    public void setUsername(String userName){
        usernameField.sendKeys(userName);
    }

    public void setPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickButton(){
        loginButton.click();
    }

    public void login(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickButton();
    }

    public LoginPageFactory(WebDriver driver){
        this.driver = driver;

    }
}
