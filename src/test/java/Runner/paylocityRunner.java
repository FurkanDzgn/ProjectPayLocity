package Runner;

import io.cucumber.core.backend.StepDefinition;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\resources\\com.Paylocity\\AddingEmployeeNoDiscount.feature",
        glue = "StepDefinitions",
        dryRun = true
)
public class paylocityRunner {
}
