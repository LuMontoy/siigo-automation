package co.com.siigo.tasks.services;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class DoPost implements Task {
    private static final EnvironmentVariables environmentVariables =
            SystemEnvironmentVariables.createEnvironmentVariables();
    private String resource;
    private String bodyRequest;

    public DoPost withTheResource(String resource){
        this.resource = resource;
        return this;
    }
    public DoPost andTeBodyRequest(String bodyRequest){
        this.bodyRequest = bodyRequest;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(resource)
                        .with(requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .relaxedHTTPSValidation()
                                .header("x-api-key", environmentVariables.getProperty("post.apikey"))
                                .body(bodyRequest))
        );
    }

    public static DoPost doPost() {
        return new DoPost();
    }
}
