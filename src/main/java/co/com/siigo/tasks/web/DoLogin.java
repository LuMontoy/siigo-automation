package co.com.siigo.tasks.web;

import co.com.siigo.models.web.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.siigo.userinterfaces.LoginPage.*;

public class DoLogin implements Task {

    User user;

    public DoLogin withTheUser(User user){
        this.user = user;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user.getMail()).into(MAIL_INPUT),
                Enter.theValue(user.getPassword()).into(PASSWORD_INPUT),
                Click.on(CONTINUE_BUTTON)
        );
    }

    public static DoLogin doLogin() {
        return new DoLogin();
    }
}
