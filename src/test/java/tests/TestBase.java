package tests;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.time.Duration;
import java.util.ArrayList;

public class TestBase extends AbstractTestNGCucumberTests {

    public static WebDriver driver;

    @BeforeTest
    public void startDriver() {

            System.setProperty("webdriver.gecko.driver",
                    "E:\\MG\\Automation_studies\\FlairsTechCucumberTask\\orangeHRMCucumberTask_Flairstech\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.close();
        driver.switchTo().window(tabs.get(0));

    }

    @AfterTest
    public void stopDriver(){
        driver.quit();
    }


}
