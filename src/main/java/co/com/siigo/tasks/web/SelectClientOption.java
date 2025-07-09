package co.com.siigo.tasks.web;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import static co.com.siigo.interactions.web.ClickShadowButton.clickShadowButton;
import static co.com.siigo.userinterfaces.ButtonCreatePage.CLIENT_OPTION_HOST;
import static co.com.siigo.userinterfaces.ButtonCreatePage.CLIENT_OPTION_INNER;

public class SelectClientOption implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        actor.attemptsTo(
                clickShadowButton()
                        .inTheHost(driver, CLIENT_OPTION_HOST, CLIENT_OPTION_INNER)
        );
    }

    public static SelectClientOption selectClientOption() {
        return new SelectClientOption();
    }
}

