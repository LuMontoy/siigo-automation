package co.com.siigo.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ClientProfilePage extends PageObject {

    public static final Target TOAST_CONTAINER = Target.the("TOAST_CONTAINER").located(By.id("toast-container"));
    public static final Target TOAST_MESSAGE = Target.the("toast message").located(By.cssSelector("#toast-container .toast-message"));
    public static final Target TITLE_PROFILE_PAGE = Target.the("toast message").located(By.xpath("//h2[normalize-space()='Perfil del tercero']"));

}
