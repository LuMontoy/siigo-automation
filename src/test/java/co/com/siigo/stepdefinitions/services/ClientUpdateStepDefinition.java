package co.com.siigo.stepdefinitions.services;

import co.com.siigo.models.services.ServicesClient;
import co.com.siigo.questions.services.GetResponseCode;
import co.com.siigo.utils.services.JsonTemplates;
import co.com.siigo.utils.services.ServicesFakeClient;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

import static co.com.siigo.tasks.services.DoPost.doPost;
import static co.com.siigo.tasks.services.DoPut.doPut;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class ClientUpdateStepDefinition {
    private static final String POST_RESOURCE_KEY = "post.resource";
    private static final String RESPONSE_ID_FIELD = "id";
    private static final String RESPONSE_ID_MEMORY_KEY = "createdUserId";

    private static final EnvironmentVariables environmentVariables =
            SystemEnvironmentVariables.createEnvironmentVariables();
    JsonTemplates templates = new JsonTemplates();

    @Given("el usuario creo un nuevo cliente")
    public void elUsuarioCreoUnNuevoCliente() {
        ServicesClient newClient = ServicesFakeClient.getNewFakeClient();

        theActorInTheSpotlight().attemptsTo(
                doPost().withTheResource(environmentVariables.getProperty(POST_RESOURCE_KEY))
                        .andTeBodyRequest(templates.bodyRequestReqres(newClient))
        );

        theActorInTheSpotlight().should(
                seeThat(
                        "El código de respuesta ", GetResponseCode.was(), equalTo(201))
        );

        String createdUserId = SerenityRest.lastResponse().jsonPath().getString(RESPONSE_ID_FIELD);
        theActorInTheSpotlight().remember(RESPONSE_ID_MEMORY_KEY, createdUserId);
    }

    @And("actualizo la informacion del campo job")
    public void actualizoLaInformacionDelCampoJob() {
        ServicesClient updatedClient = ServicesFakeClient.getNewFakeClient();
        String idClient = theActorInTheSpotlight().recall("createdUserId");

        theActorInTheSpotlight().attemptsTo(
                doPut().withTheResource(
                        (environmentVariables.getProperty(POST_RESOURCE_KEY)).concat("/").concat(idClient))
                        .andTeBodyRequest(templates.bodyRequestReqres(updatedClient))
        );

        theActorInTheSpotlight().should(
                seeThat(
                        "El código de respuesta ", GetResponseCode.was(), equalTo(200))
        );
    }

    @When("consume el servico para obterner los datos actuales")
    public void consumeElServicoParaObternerLosDatosActuales() {
    }

    @Then("visualizara respuesta con codigo de estado exitoso")
    public void visualizaraRespuestaConCodigoDeEstadoExitoso() {
    }

    @And("visualizara los datos actualizados del cliente")
    public void visualizaraLosDatosActualizadosDelCliente() {
    }
}
