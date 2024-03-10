package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddUserPage {
     WebDriver driver;

     public AddUserPage(WebDriver driver) {
          this.driver = driver;
     }

     public By userRoleDropDown = By.xpath("(//div[@class='oxd-select-text--after'])[1]");
     public By empNameTxt = By.xpath("//input[@placeholder='Type for hints...']");
     public By statusDropDown = By.xpath("(//div[@class='oxd-select-text--after'])[2]");
     public By nameTxt = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
     public By psswdTxt = By.xpath("(//input[@type='password'])[1]");
     public By confPsswdTxt = By.xpath("(//input[@type='password'])[2]");
     public By saveBtn = By.xpath("//button[@type='submit']");

     public WebElement userRoleDropDown()
     {
          return driver.findElement(userRoleDropDown);
     }

     public WebElement empNameTxt()
     {
          return driver.findElement(empNameTxt);
     }

     public WebElement statusDropDown()
     {
          return driver.findElement(statusDropDown);
     }

     public WebElement nameTxt()
     {
          return driver.findElement(nameTxt);
     }

     public WebElement psswdTxt()
     {
          return driver.findElement(psswdTxt);
     }

     public WebElement confPsswdTxt()
     {
          return driver.findElement(confPsswdTxt);
     }

     public WebElement saveBtn()
     {
          return driver.findElement(saveBtn);
     }
}
