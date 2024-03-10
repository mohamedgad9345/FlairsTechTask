package runnet;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;
@CucumberOptions(features = "src/test/java/features",
        glue = {"steps"},
        plugin = {"pretty","html:target/cucumber-html-report"},
        tags = "@dataDriven")
public class TestRunner extends TestBase {
}
