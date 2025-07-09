package co.com.siigo.tasks.services;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class DoDelete implements Task {

    private static final EnvironmentVariables environmentVariables =
            SystemEnvironmentVariables.createEnvironmentVariables();

    private String resource;

    public DoDelete withTheResource(String resource) {
        this.resource = resource;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(resource)
                        .with(requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .relaxedHTTPSValidation()
                                .header("x-api-key", environmentVariables.getProperty("post.apikey"))
                        )
        );
    }

    public static DoDelete doDelete() {
        return new DoDelete();
    }
}
