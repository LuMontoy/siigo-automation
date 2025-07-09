package co.com.siigo.runners.web;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/web/clientCreation.feature",
        glue = "co.com.siigo.stepdefinitions.web",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CreacionClienteRunner {
}
