import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
    public static void main(String[] args){
         System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("");
        //selecting an item in dropdown
        new Select(driver.findElement(By.id(""))).selectByValue("");
    }
}
