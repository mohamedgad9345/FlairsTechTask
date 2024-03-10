package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminPage {
     WebDriver driver;

     public AdminPage(WebDriver driver) {
          this.driver = driver;
     }

    public By adminBtn = By.xpath("(//ul[@class='oxd-main-menu']//li)[1]");
     public By numOfRecords = By.xpath("//span[@class='oxd-text oxd-text--span']");
     By addBtn = By.xpath("//div[@class='orangehrm-header-container']//button");
     By searchDropDownBtn = By.xpath("//div[@class='--toggle']//button//i");
     public By userNameTxtSearch = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
     By searchBtn = By.xpath("//button[@type='submit']");
     public By deleteBtn = By.xpath("(//button[@type='button']//i)[5]");
     public By confirmDltBtn = By.xpath("(//button[@type='button'])[9]");

     public WebElement adminBtn()
     {
          return driver.findElement(adminBtn);
     }
     public WebElement numOfRecords()
     {
          return driver.findElement(numOfRecords);
     }
     public WebElement addBtn()
     {
          return driver.findElement(addBtn);
     }
     public WebElement searchDropDownBtn()
     {
          return driver.findElement(searchDropDownBtn);
     }
     public WebElement userNameTxtSearch()
     {
          return driver.findElement(userNameTxtSearch);
     }
     public WebElement searchBtn()
     {
          return driver.findElement(searchBtn);
     }
     public WebElement deleteBtn()
     {
          return driver.findElement(deleteBtn);
     }
     public WebElement confirmDltBtn()
     {
          return driver.findElement(confirmDltBtn);
     }

}
