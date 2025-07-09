package co.com.siigo.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class LoginStepDefinition {

    @Managed(driver = "chrome")
    protected WebDriver webDriver;

    @Before
    public void setUp() {
    }

    @Given("el usuario inicio sesion en el aplicativo")
    public void elUsuarioInicioSesionEnElAplicativo() {
    }

    @And("navego hasta el modulo de creacion de clientes")
    public void navegoHastaElModuloDeCreacionDeClientes() {
    }

    @When("llena el formulario con los campos obligatorios")
    public void llenaElFormularioConLosCamposObligatorios() {
    }

    @Then("visualizara el cliente creado en el modulo de terceros")
    public void visualizaraElClienteCreadoEnElModuloDeTerceros() {
    }

    @And("los datos del cliente seran los mismos con los que lo creo")
    public void losDatosDelClienteSeranLosMismosConLosQueLoCreo() {
    }
}
