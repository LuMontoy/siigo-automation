package co.com.siigo.stepdefinitions.services;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class ServicesSetUp {
    private static final EnvironmentVariables environmentVariables =
            SystemEnvironmentVariables.createEnvironmentVariables();
    protected static final String URL_BASE_REQRES = environmentVariables.getProperty("services.url.base");
    protected static final String RESOURCE_POST_REQRES = "/users";
    protected final Actor actor = new Actor("User");
    protected void setupRegres(){
        actor.can(CallAnApi.at(URL_BASE_REQRES));
    }

}
