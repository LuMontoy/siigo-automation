package co.com.siigo.stepdefinitions.services;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class ServicesSetUp {
    private static final EnvironmentVariables environmentVariables =
            SystemEnvironmentVariables.createEnvironmentVariables();

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        setupUser();
    }

    protected void setupUser() {
        OnStage.theActorCalled("User")
                .can(CallAnApi.at(environmentVariables.getProperty("services.url.base")));
    }
}
