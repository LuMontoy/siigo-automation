package co.com.siigo.interactions.web;

import co.com.siigo.utils.web.ShadowElement;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TypeIntoShadowInput implements Interaction {

    WebElement identificationInput;
    String phoneNumber;

    public TypeIntoShadowInput intoShadowHost(WebDriver driver, String host, String inner){
        this.identificationInput = ShadowElement.getShadowElement(driver, host, inner);
        return this;
    }

    public TypeIntoShadowInput withValue(String phoneNumber){
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        identificationInput.sendKeys(phoneNumber);
    }

    public static TypeIntoShadowInput typeIntoShadowInput() {
        return new TypeIntoShadowInput();
    }
}
