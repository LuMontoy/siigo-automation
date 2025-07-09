package co.com.siigo.stepdefinitions.web;

import co.com.siigo.userinterfaces.LoginPage;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class WebSetUp {

    @Managed(driver = "chrome")
    protected WebDriver webDriver;
    LoginPage loginPage;
    private static final EnvironmentVariables environmentVariables =
            SystemEnvironmentVariables.createEnvironmentVariables();

    @Before
    public void setUp() {
        setupUser("User", webDriver);
        OnStage.theActorCalled("User").
                wasAbleTo(Open.browserOn().the(LoginPage.class));
    }

    protected void setupUser(String name, WebDriver webDriver ) {
        WebDriverManager.chromedriver().setup();
        OnStage.setTheStage(new OnlineCast());
        theActorCalled(name).can(BrowseTheWeb.with(webDriver));
        theActorCalled(name).wasAbleTo(Open.browserOn(loginPage));
    }
}
