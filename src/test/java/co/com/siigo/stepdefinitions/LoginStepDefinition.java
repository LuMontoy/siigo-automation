package co.com.siigo.stepdefinitions;

import co.com.siigo.models.Client;
import co.com.siigo.models.User;
import co.com.siigo.utils.FakeClient;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

import static co.com.siigo.questions.GetToastText.getToastText;
import static co.com.siigo.tasks.DoLogin.doLogin;
import static co.com.siigo.tasks.FillClientCreationForm.fillClientCreationForm;
import static co.com.siigo.tasks.PressCreateButton.pressCreateButton;
import static co.com.siigo.tasks.SelectClientOption.selectClientOption;
import static co.com.siigo.userinterfaces.ClientProfilePage.TITLE_PROFILE_PAGE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginStepDefinition {

    private User user;
    private static final EnvironmentVariables environmentVariables =
            SystemEnvironmentVariables.createEnvironmentVariables();
    private String SUCCESSFULL_CREATION_MESSAGE = "Tercero guardado exitosamente";

    @Given("el usuario inicio sesion en el aplicativo")
    public void elUsuarioInicioSesionEnElAplicativo() {
        user = new User();
        user.setMail(environmentVariables.getProperty("user.mail"));
        user.setPassword(environmentVariables.getProperty("user.password"));
        theActorInTheSpotlight().wasAbleTo(
                doLogin().withTheUser(user)
        );
    }

    @When("se dirige al modulo de creacion de clientes")
    public void seDirigeAlModuloDeCreacionDeClientes() {
        theActorInTheSpotlight().wasAbleTo(
                pressCreateButton(),
                selectClientOption()
        );
    }

    @And("llena los campos obligatorios para un tipo de cliente persona")
    public void llenaLosCamposObligatoriosParaUnTipoDeClientePersona() {
        Client newClient = FakeClient.getNewFakeClient();

        theActorInTheSpotlight().wasAbleTo(
                fillClientCreationForm().withTheclient(newClient)
        );
    }

    @Then("visualizara un mensaje de creacion exitosa")
    public void visualizaraUnMensajeDeCreacionExitosa() {
        theActorInTheSpotlight().should(
                seeThat(getToastText(), equalTo(SUCCESSFULL_CREATION_MESSAGE))
        );
    }

    @And("sera redirigido al perfil del cliente creado")
    public void seraRedirigidoAlPerfilDelClienteCreado() {
        theActorInTheSpotlight().should(
                seeThat("The profile client title", the(TITLE_PROFILE_PAGE), isPresent())
        );
    }
}
