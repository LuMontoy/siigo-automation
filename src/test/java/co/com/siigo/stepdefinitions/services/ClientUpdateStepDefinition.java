package co.com.siigo.stepdefinitions.services;

import co.com.siigo.models.services.ServicesClient;
import co.com.siigo.questions.services.GetResponseCode;
import co.com.siigo.utils.services.JsonTemplates;
import co.com.siigo.utils.services.ServicesFakeClient;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

import java.util.Locale;

import static co.com.siigo.tasks.services.DoDelete.doDelete;
import static co.com.siigo.tasks.services.DoGet.doGet;
import static co.com.siigo.tasks.services.DoPost.doPost;
import static co.com.siigo.tasks.services.DoPut.doPut;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

public class ClientUpdateStepDefinition {
    private static final String POST_RESOURCE_KEY = "post.resource";

    private static final EnvironmentVariables environmentVariables =
            SystemEnvironmentVariables.createEnvironmentVariables();
    JsonTemplates templates = new JsonTemplates();

    Faker faker = new Faker(new Locale("es", "CO"));

    @Given("el usuario debe registrar un cliente nuevo")
    public void elUsuarioDebeRegistrarUnClienteNuevo() {
        ServicesClient newClient = ServicesFakeClient.getNewFakeClient();
        theActorInTheSpotlight().remember("client", newClient);
    }

    @When("consume el servico para crearlo en el sistema")
    public void consumeElServicoParaCrearloEnElSistema() {
        ServicesClient newClient = theActorInTheSpotlight().recall("client");

        theActorInTheSpotlight().attemptsTo(
                doPost().withTheResource(environmentVariables.getProperty(POST_RESOURCE_KEY))
                        .andTeBodyRequest(templates.bodyRequestReqres(newClient))
        );
    }

    @Then("visualizara la respuesta con codigo de estado {int}")
    public void visualizaraLaRespuestaConCodigoDeEstado(int responseCode) {
        theActorInTheSpotlight().should(
                seeThat(
                        "El código de respuesta ", GetResponseCode.was(), equalTo(responseCode))
        );
    }

    @And("visualizara los datos del cliente")
    public void visualizaraLosDatosDelCliente() {

        theActorInTheSpotlight().should(
                seeThat("El nombre no es nulo",
                        response -> SerenityRest.lastResponse().jsonPath().getString("data"),
                        notNullValue())
        );
    }

    @Given("el usuario tiene el Id de un cliente ya registrado")
    public void elUsuarioTieneElIdDeUnClienteYaRegistrado() {
        String index = String.valueOf(faker.number().numberBetween(7, 12));
        theActorInTheSpotlight().remember("clientId", index);
    }

    @When("consume el servico para actualizar sus datos en el sistema")
    public void consumeElServicoParaActualizarSusDatosEnElSistema() {
        String idClient = theActorInTheSpotlight().recall("clientId");
        ServicesClient updatedClient = ServicesFakeClient.getNewFakeClient();
        theActorInTheSpotlight().remember("client", updatedClient);

        theActorInTheSpotlight().attemptsTo(
                doPut().withTheResource(
                                (environmentVariables.getProperty(POST_RESOURCE_KEY)).concat("/").concat(idClient))
                        .andTeBodyRequest(templates.bodyRequestReqres(updatedClient))
        );
    }

    @When("consume el servico para eliminar sus datos en el sistema")
    public void consumeElServicoParaEliminarSusDatosEnElSistema() {
        String idClient = theActorInTheSpotlight().recall("clientId");

        theActorInTheSpotlight().attemptsTo(
                doDelete().withTheResource(
                                (environmentVariables.getProperty(POST_RESOURCE_KEY)).concat("/").concat(idClient))
        );
    }

    @When("consume el servico para consultar sus datos en el sistema")
    public void consumeElServicoParaConsultarSusDatosEnElSistema() {
        String idClient = theActorInTheSpotlight().recall("clientId");

        theActorInTheSpotlight().attemptsTo(
                doGet().withTheResource(
                        (environmentVariables.getProperty(POST_RESOURCE_KEY)).concat("/").concat(idClient))
        );
    }

    @And("los datos del cliente seran los mismos que envio en la peticion")
    public void losDatosDelClienteSeranLosMismosQueEnvioEnLaPeticion() {
        ServicesClient client = theActorInTheSpotlight().recall("client");

        theActorInTheSpotlight().should(
                seeThat("El nombre es correcto",
                        response -> SerenityRest.lastResponse().jsonPath().getString("name"),
                        equalTo(client.getName()))
        );

        theActorInTheSpotlight().should(
                seeThat("El trabajo es correcto",
                        response -> SerenityRest.lastResponse().jsonPath().getString("job"),
                        equalTo(client.getJob()))
        );
    }
}
