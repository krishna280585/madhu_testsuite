import Utils.Hooks;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Login",
                 tags={"@signin"},
                 plugin={"html:output"})
//glue={"src/test/java/stepdefinitions"})

public class SuiteRunner  {
}
