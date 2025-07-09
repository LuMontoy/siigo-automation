package co.com.siigo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.siigo.userinterfaces.ClientProfilePage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GetToastText implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        WaitUntil.the(TOAST_CONTAINER, isVisible()).forNoMoreThan(10).seconds();
        return Text.of(TOAST_MESSAGE).answeredBy(actor);
    }

    public static GetToastText getToastText() {
        return new GetToastText();
    }
}
