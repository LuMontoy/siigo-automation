package co.com.siigo.interactions;

import co.com.siigo.utils.ShadowElement;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectAnOptionFromShadowList implements Interaction {

    List<WebElement> list;

    public SelectAnOptionFromShadowList inTheHost(WebDriver driver, String host, String inner) {
        this.list = ShadowElement.getShadowElementsList(driver, host, inner);
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        list.get(0).click();
    }

    public static SelectAnOptionFromShadowList selectOptionFromShadowList() {
        return new SelectAnOptionFromShadowList();
    }
}
