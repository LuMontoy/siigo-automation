package co.com.siigo.interactions;

import co.com.siigo.utils.ShadowElement;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectAnOptionFromShadowTable implements Interaction {

    WebElement table;

    public SelectAnOptionFromShadowTable inTheHost(WebDriver driver, String host, String inner) {
        this.table = ShadowElement.getShadowElement(driver, host, inner);
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElement> rows = table.findElements(By.cssSelector("tbody > tr"));
        rows.get(0).click();
    }

    public static SelectAnOptionFromShadowTable selectFromShadowTable() {
        return new SelectAnOptionFromShadowTable();
    }
}
