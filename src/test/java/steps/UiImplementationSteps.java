package steps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.AddUserPage;
import pages.AdminPage;
import pages.LoginPage;
import tests.TestBase;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class UiImplementationSteps extends TestBase {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    String oldNumRecords;
    LoginPage loginPage = new LoginPage(driver);
    AdminPage adminPage = new AdminPage(driver);
    AddUserPage addUserPage = new AddUserPage(driver);

    @Given("navigate to orangeHRM and login with admin credentials")
    public void navigate_to_orange_hrm_and_login_with_admin_credentials(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps();
        loginPage.userNameTxt().sendKeys(data.get(0).get("username"));
        loginPage.passwordTxt().sendKeys(data.get(0).get("password"));
        loginPage.loginBtn().click();
    }
    @When("click on admin tab on the left side menu")
    public void click_on_admin_tab_on_the_left_side_menu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminPage.adminBtn));
        adminPage.adminBtn().click();
    }
    @When("get the number of records found")
    public void get_the_number_of_records_found() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminPage.numOfRecords));
        WebElement numberOfRecord = driver.findElement(adminPage.numOfRecords);
        oldNumRecords = numberOfRecord.getAttribute("innerHTML");
        oldNumRecords = oldNumRecords.split("\\(")[1];
        oldNumRecords = oldNumRecords.split("\\)")[0];
        System.out.println("Number of Records= " + oldNumRecords);
    }
    @When("click on add button and add new user")
    public void click_on_add_button_and_add_new_user(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps();
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminPage.adminBtn));
        adminPage.addBtn().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(addUserPage.userRoleDropDown));
        addUserPage.userRoleDropDown().click();
        Actions selectRole = new Actions(driver);
        selectRole.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(addUserPage.empNameTxt));
        addUserPage.empNameTxt().sendKeys(data.get(0).get("empName"));
        Thread.sleep(2000);
        Actions empSelectedName = new Actions(driver);
        empSelectedName.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(addUserPage.nameTxt));
        addUserPage.nameTxt().sendKeys(data.get(0).get("name"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addUserPage.statusDropDown));
        addUserPage.statusDropDown().click();
        Actions selectedStatus = new Actions(driver);
        selectedStatus.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(addUserPage.psswdTxt));
        addUserPage.psswdTxt().sendKeys(data.get(0).get("passwd"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addUserPage.confPsswdTxt));
        addUserPage.confPsswdTxt().sendKeys(data.get(0).get("confPasswd"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addUserPage.saveBtn));
        addUserPage.saveBtn().click();

    }
    @Then("verify that the number of records increased by 1")
    public void verify_that_the_number_of_records_increased_by_1() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminPage.numOfRecords));
        WebElement numberOfRecord = driver.findElement(adminPage.numOfRecords);
        String numRecords = numberOfRecord.getAttribute("innerHTML");
        numRecords = numRecords.split("\\(")[1];
        numRecords = numRecords.split("\\)")[0];
        System.out.println("Number of Records= " + numRecords);
        oldNumRecords = Integer.toString(Integer.parseInt(oldNumRecords) + 1);
        Assert.assertEquals(numRecords,oldNumRecords);
    }
    @When("search with the userName for the new user")
    public void search_with_the_user_name_for_the_new_user(DataTable dataTable) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(searchDropDownBtn));
//        driver.switchTo().frame(driver.findElement(searchDropDownBtn));
        List<Map<String, String>> data = dataTable.asMaps();
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminPage.userNameTxtSearch));
        adminPage.userNameTxtSearch().sendKeys(data.get(0).get("userName"));
        adminPage.searchBtn().click();


    }
    @When("delete the new user")
    public void delete_the_new_user() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminPage.deleteBtn));
        adminPage.deleteBtn().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminPage.confirmDltBtn));
        adminPage.confirmDltBtn().click();

    }
    @Then("verify that the number of records decreased by 1")
    public void verify_that_the_number_of_records_decreased_by_1() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminPage.adminBtn));
        adminPage.adminBtn().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminPage.numOfRecords));
        WebElement numRecs = driver.findElement(adminPage.numOfRecords);
        String numRecAfterDlt = numRecs.getAttribute("innerHTML");
        numRecAfterDlt = numRecAfterDlt.split("\\(")[1];
        numRecAfterDlt = numRecAfterDlt.split("\\)")[0];
        System.out.println("Number of Records= " + numRecAfterDlt);
        oldNumRecords = Integer.toString(Integer.parseInt(oldNumRecords) - 1);
        Assert.assertEquals(numRecAfterDlt,oldNumRecords);
    }

}
