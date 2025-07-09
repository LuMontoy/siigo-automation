package co.com.siigo.tasks.web;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import static co.com.siigo.interactions.web.ClickShadowButton.clickShadowButton;
import static co.com.siigo.userinterfaces.HomePage.*;

public class PressCreateButton implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        actor.attemptsTo(
                clickShadowButton()
                        .inTwoHost(
                                driver, CREATE_BUTTON_HOST_1,
                                CREATE_BUTTON_HOST_2,
                                CREATE_BUTTON_INNER)
        );
    }

    public static PressCreateButton pressCreateButton() {
        return new PressCreateButton();
    }
}
