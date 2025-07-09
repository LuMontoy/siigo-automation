package co.com.siigo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.WebDriver;

import static co.com.siigo.interactions.ClickShadowButton.clickShadowButton;
import static co.com.siigo.interactions.SelectAnOptionFromShadowList.selectOptionFromShadowList;
import static co.com.siigo.interactions.TypeIntoShadowInput.typeIntoShadowInput;
import static co.com.siigo.tasks.SelectCityFromTable.selectCityFromTable;
import static co.com.siigo.userinterfaces.CreateClientPage.*;

public class FillClientCreationForm implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        actor.attemptsTo(
                clickShadowButton()
                        .inTheHost(driver, CLIENT_TYPE_DROPDOWN_HOST, DROPDOWN_INNER),
                selectOptionFromShadowList()
                        .inTheHost(driver, CLIENT_TYPE_DROPDOWN_HOST, LIST_INNER),
                selectOptionFromShadowList()
                        .inTheHost(driver, DOCUMENT_TYPE_DROPDOWN_HOST, DROPDOWN_INNER),
                selectOptionFromShadowList()
                        .inTheHost(driver, DOCUMENT_TYPE_DROPDOWN_HOST, LIST_INNER),
                typeIntoShadowInput()
                        .withValue("111222255")
                        .intoShadowHost(driver, IDENTIFICATION_INPUT_HOST, IDENTIFICATION_INPUT_INNER),
                typeIntoShadowInput()
                        .withValue("Lu")
                        .intoShadowHost(driver, NAME_INPUT_HOST, NAME_INPUT_INNER),
                typeIntoShadowInput()
                        .withValue("Suarez")
                        .intoShadowHost(driver, LAST_NAME_INPUT_HOST, LAST_NAME_INPUT_INNER),
                clickShadowButton()
                        .inTheHost(driver, CITY_INPUT_HOST, CITY_INPUT_INNER),
                typeIntoShadowInput()
                        .withValue("Medellin")
                        .intoShadowHost(driver, CITY_INPUT_HOST, CITY_INPUT_INNER),
                selectCityFromTable(),
                Click.on(SAVE_BUTTON)
        );
    }

    public static FillClientCreationForm fillClientCreationForm() {
        return new FillClientCreationForm();
    }
}
