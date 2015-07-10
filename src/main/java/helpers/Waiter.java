package helpers;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import static com.codeborne.selenide.Selenide.Wait;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class Waiter {

    // Custom waiter with custom timeout
    public static void waitForJquery(long timeout) {
        long current = Configuration.timeout;
        Configuration.timeout = timeout;
        Wait().until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) executeJavaScript("return jQuery.active == 0");
            }
        });
        Configuration.timeout = current;
    }

    // custom waiter with default timeout
    public static void waitForPageToLoad() {
        Wait().until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return executeJavaScript("return document.readyState").equals("complete");
            }
        });
    }
}
