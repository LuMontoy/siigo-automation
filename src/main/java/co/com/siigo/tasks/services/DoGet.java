package co.com.siigo.tasks.services;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

import java.awt.event.WindowStateListener;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DoGet implements Task {
    private static final EnvironmentVariables environmentVariables =
            SystemEnvironmentVariables.createEnvironmentVariables();

    String resource;

    public DoGet withTheResource(String resource){
        this.resource = resource;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(resource)
                        .with(requestSpecification -> requestSpecification
                                .relaxedHTTPSValidation()
                                .header("x-api-key", environmentVariables.getProperty("post.apikey"))
                                )
        );
    }

    public static DoGet doGet(){
        return instrumented(DoGet.class);
    }
}
