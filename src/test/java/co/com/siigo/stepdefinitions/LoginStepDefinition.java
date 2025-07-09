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

import static co.com.siigo.tasks.DoLogin.doLogin;
import static co.com.siigo.tasks.FillClientCreationForm.fillClientCreationForm;
import static co.com.siigo.tasks.PressCreateButton.pressCreateButton;
import static co.com.siigo.tasks.SelectClientOption.selectClientOption;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginStepDefinition {

    @Managed(driver = "chrome")
    protected WebDriver webDriver;
    LoginPage loginPage;
    private User user;
    private static final EnvironmentVariables environmentVariables =
            SystemEnvironmentVariables.createEnvironmentVariables();

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

    @And("navego hasta el modulo de creacion de clientes")
    public void navegoHastaElModuloDeCreacionDeClientes() {
        theActorInTheSpotlight().wasAbleTo(
                pressCreateButton(),
                selectClientOption()
        );
    }

    @When("llena el formulario con los campos obligatorios")
    public void llenaElFormularioConLosCamposObligatorios() throws InterruptedException {
        theActorInTheSpotlight().wasAbleTo(
                fillClientCreationForm()
        );
        Thread.sleep(10000);
    }

    @Then("visualizara el cliente creado en el modulo de terceros")
    public void visualizaraElClienteCreadoEnElModuloDeTerceros() {
    }

    @And("los datos del cliente seran los mismos con los que lo creo")
    public void losDatosDelClienteSeranLosMismosConLosQueLoCreo() {
    }
}
