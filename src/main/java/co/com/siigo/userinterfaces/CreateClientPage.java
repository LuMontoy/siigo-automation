package co.com.siigo.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CreateClientPage extends PageObject {
    public static final String CLIENT_TYPE_DROPDOWN_HOST = "body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(5) > div:nth-child(1) > thirdparty-root:nth-child(1) > div:nth-child(1) > div:nth-child(1) > app-third-party-detail:nth-child(2) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > app-third-party-basic-data:nth-child(1) > siigo-card-web:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > siigo-dropdownlist-web:nth-child(1)";
    public static final String DOCUMENT_TYPE_DROPDOWN_HOST = "body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(5) > div:nth-child(1) > thirdparty-root:nth-child(1) > div:nth-child(1) > div:nth-child(1) > app-third-party-detail:nth-child(2) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > app-third-party-basic-data:nth-child(1) > siigo-card-web:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > siigo-dropdownlist-web:nth-child(1)";
    public static final String DROPDOWN_INNER = ".mdc-select__anchor";
    public static final String LIST_INNER = "li.mdc-list-item";
    public static final String IDENTIFICATION_INPUT_HOST = "siigo-identification-input-web.hydrated";
    public static final String IDENTIFICATION_INPUT_INNER = ".mdc-text-field__input.input-identification";
    public static final String NAME_INPUT_HOST = "body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(5) > div:nth-child(1) > thirdparty-root:nth-child(1) > div:nth-child(1) > div:nth-child(1) > app-third-party-detail:nth-child(2) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > app-third-party-basic-data:nth-child(1) > siigo-card-web:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > siigo-textfield-web:nth-child(1)";
    public static final String NAME_INPUT_INNER = ".mdc-text-field__input";
    public static final String LAST_NAME_INPUT_HOST = "body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(5) > div:nth-child(1) > thirdparty-root:nth-child(1) > div:nth-child(1) > div:nth-child(1) > app-third-party-detail:nth-child(2) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > app-third-party-basic-data:nth-child(1) > siigo-card-web:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > siigo-textfield-web:nth-child(1)";
    //"siigo-textfield-web[label='Apellido']"
    public static final String LAST_NAME_INPUT_INNER = ".mdc-text-field__input";
    public static final String CITY_INPUT_HOST = "siigo-autocomplete-web.hydrated[key-id='city']";
    public static final String CITY_INPUT_INNER = "#labelAutocompleteSelectItemcity";
    public static final String CITY_TABLE_HOST = "siigo-autocomplete-web[key-id='city']";
    public static final String CITY_TABLE_INNER = "#tableAutocompletecity";
    public static final Target SAVE_BUTTON = Target.the("SAVE_BUTTON").located(By.xpath("//button[normalize-space(.)='Guardar']"));
}
