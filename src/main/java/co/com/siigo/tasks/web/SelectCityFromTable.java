package co.com.siigo.tasks.web;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import static co.com.siigo.interactions.web.SelectAnOptionFromShadowTable.selectFromShadowTable;
import static co.com.siigo.userinterfaces.CreateClientPage.CITY_TABLE_HOST;
import static co.com.siigo.userinterfaces.CreateClientPage.CITY_TABLE_INNER;

public class SelectCityFromTable implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        actor.attemptsTo(
                selectFromShadowTable()
                        .inTheHost(driver, CITY_TABLE_HOST, CITY_TABLE_INNER)
        );
    }

    public static SelectCityFromTable selectCityFromTable() {
        return new SelectCityFromTable();
    }
}
