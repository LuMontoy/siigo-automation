package co.com.siigo.utils.web;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ShadowElement {

    public static WebElement getNestedShadowElement(WebDriver driver, String host1, String host2, String inner) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement shadowHost1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(host1)));
        SearchContext shadowRoot1 = shadowHost1.getShadowRoot();

        WebElement shadowHost2 = shadowRoot1.findElement(By.cssSelector(host2));
        SearchContext shadowRoot2 = shadowHost2.getShadowRoot();

        return shadowRoot2.findElement(By.cssSelector(inner));
    }

    public static WebElement getShadowElement(WebDriver driver, String host, String inner) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(host)));
        SearchContext shadowRoot = shadowHost.getShadowRoot();

        return wait.until(d -> {
            try {
                WebElement el = shadowRoot.findElement(By.cssSelector(inner));
                System.out.println("[DEBUG] Found inner element: " + el);
                return el.isDisplayed() ? el : null;
            } catch (NoSuchElementException e) {
                System.out.println("[DEBUG] Inner selector not yet present: " + inner);
                return null;
            }
        });
    }

    public static List<WebElement> getShadowElementsList(WebDriver driver, String host, String inner) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(host)));
        SearchContext shadowRoot = shadowHost.getShadowRoot();

        return wait.until(driver1 -> {
            try {
                return shadowRoot.findElements(By.cssSelector(inner));
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                return null;
            }
        });
    }
}
