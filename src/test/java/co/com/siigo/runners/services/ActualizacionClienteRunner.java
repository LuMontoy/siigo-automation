package co.com.siigo.runners.services;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/services/clientUpdate.feature",
        glue = "co.com.siigo.stepdefinitions.services",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class ActualizacionClienteRunner {
}
