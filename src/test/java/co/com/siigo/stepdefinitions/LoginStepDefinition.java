package co.com.siigo.stepdefinitions;

import co.com.siigo.models.User;
import co.com.siigo.userinterfaces.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import org.openqa.selenium.WebDriver;

import static co.com.siigo.questions.GetToastText.getToastText;
import static co.com.siigo.tasks.DoLogin.doLogin;
import static co.com.siigo.tasks.FillClientCreationForm.fillClientCreationForm;
import static co.com.siigo.tasks.PressCreateButton.pressCreateButton;
import static co.com.siigo.tasks.SelectClientOption.selectClientOption;
import static co.com.siigo.userinterfaces.ClientProfilePage.TITLE_PROFILE_PAGE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginStepDefinition {

    @Managed(driver = "chrome")
    protected WebDriver webDriver;
    LoginPage loginPage;
    private User user;
    private static final EnvironmentVariables environmentVariables =
            SystemEnvironmentVariables.createEnvironmentVariables();
    private String SUCCESSFULL_CREATION_MESSAGE = "Tercero guardado exitosamente";

    @Before
    public void setUp() {
        user = new User();
        user.setMail(environmentVariables.getProperty("user.mail"));
        user.setPassword(environmentVariables.getProperty("user.password"));
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

    @Given("el usuario inicio sesion en el aplicativo")
    public void elUsuarioInicioSesionEnElAplicativo() {
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
        theActorInTheSpotlight().wasAbleTo(
                fillClientCreationForm()
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
