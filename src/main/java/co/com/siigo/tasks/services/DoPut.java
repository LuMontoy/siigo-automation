package co.com.siigo.tasks.services;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class DoPut implements Task {
    private static final EnvironmentVariables environmentVariables =
            SystemEnvironmentVariables.createEnvironmentVariables();
    private String resource;
    private String bodyRequest;

    public DoPut withTheResource(String resource){
        this.resource = resource;
        return this;
    }
    public DoPut andTeBodyRequest(String bodyRequest){
        this.bodyRequest = bodyRequest;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to(resource)
                        .with(requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .relaxedHTTPSValidation()
                                .header("x-api-key", environmentVariables.getProperty("post.apikey"))
                                .body(bodyRequest))
        );
    }

    public static DoPut doPut() {
        return new DoPut();
    }
}
