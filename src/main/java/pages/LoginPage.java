package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

     WebDriver driver;

     public LoginPage(WebDriver driver) {
          this.driver = driver;
     }

     By usernameTxt = By.name("username");
     By passwordTxt = By.name("password");
     By loginBtn = By.xpath("//button[@type='submit']");

     public WebElement userNameTxt()
     {
          return driver.findElement(usernameTxt);
     }

     public WebElement passwordTxt()
     {
          return driver.findElement(passwordTxt);
     }

     public WebElement loginBtn()
     {
          return driver.findElement(loginBtn);
     }
}
