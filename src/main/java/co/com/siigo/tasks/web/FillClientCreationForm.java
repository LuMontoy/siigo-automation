package co.com.siigo.tasks.web;

import co.com.siigo.models.web.WebClient;
import com.github.javafaker.Faker;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

import static co.com.siigo.interactions.web.ClickShadowButton.clickShadowButton;
import static co.com.siigo.interactions.web.SelectAnOptionFromShadowList.selectOptionFromShadowList;
import static co.com.siigo.interactions.web.TypeIntoShadowInput.typeIntoShadowInput;
import static co.com.siigo.tasks.web.SelectCityFromTable.selectCityFromTable;
import static co.com.siigo.userinterfaces.CreateClientPage.*;

public class FillClientCreationForm implements Task {

    WebClient client;
    Faker faker = new Faker(new Locale("es", "CO"));

    public FillClientCreationForm withTheclient(WebClient client) {
        this.client = client;
        return this;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        actor.attemptsTo(
                clickShadowButton()
                        .inTheHost(driver, CLIENT_TYPE_DROPDOWN_HOST, DROPDOWN_INNER),
                selectOptionFromShadowList()
                        .witheThIndex(0)
                        .inTheHost(driver, CLIENT_TYPE_DROPDOWN_HOST, LIST_INNER),
                selectOptionFromShadowList()
                        .inTheHost(driver, DOCUMENT_TYPE_DROPDOWN_HOST, DROPDOWN_INNER),
                selectOptionFromShadowList()
                        .witheThIndex(faker.number().numberBetween(0, 12))
                        .inTheHost(driver, DOCUMENT_TYPE_DROPDOWN_HOST, LIST_INNER),
                typeIntoShadowInput()
                        .withValue(client.getId())
                        .intoShadowHost(driver, IDENTIFICATION_INPUT_HOST, IDENTIFICATION_INPUT_INNER),
                typeIntoShadowInput()
                        .withValue(client.getName())
                        .intoShadowHost(driver, NAME_INPUT_HOST, NAME_INPUT_INNER),
                typeIntoShadowInput()
                        .withValue(client.getLastName())
                        .intoShadowHost(driver, LAST_NAME_INPUT_HOST, LAST_NAME_INPUT_INNER),
                clickShadowButton()
                        .inTheHost(driver, CITY_INPUT_HOST, CITY_INPUT_INNER),
                typeIntoShadowInput()
                        .withValue(client.getCity())
                        .intoShadowHost(driver, CITY_INPUT_HOST, CITY_INPUT_INNER),
                selectCityFromTable(),
                Click.on(SAVE_BUTTON)
        );
    }

    public static FillClientCreationForm fillClientCreationForm() {
        return new FillClientCreationForm();
    }
}
