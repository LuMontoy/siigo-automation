package co.com.siigo.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {

    public static final Target MAIL_INPUT = Target.the("MAIL_INPUT").located(By.id("siigoSignInName"));
    public static final Target PASSWORD_INPUT = Target.the("PASSWORD_INPUT").located(By.id("siigoPassword"));
    public static final Target CONTINUE_BUTTON = Target.the("CONTINUE_BUTTON").located(By.id("siigoNext"));
}
