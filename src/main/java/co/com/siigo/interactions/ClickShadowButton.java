package co.com.siigo.interactions;

import co.com.siigo.utils.ShadowElement;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClickShadowButton implements Interaction {

    WebElement button;

    public ClickShadowButton inTheHost(WebDriver driver, String host, String inner){
        this.button = ShadowElement.getShadowElement(driver, host, inner);
        return this;
    }

    public ClickShadowButton inTwoHost(WebDriver driver, String host1, String host2, String inner){
        this.button = ShadowElement.getNestedShadowElement(driver, host1, host2, inner);
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        button.click();
    }

    public static ClickShadowButton clickShadowButton() {
        return new ClickShadowButton();
    }
}
