package pages;

import core.PageBase;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static helpers.Locators.get;

public class HomePage extends PageBase {
    public final static By LOGIN_MESSAGE = get("homePage.loginSuccessfulMessage");
    public final static By LOGOUT_BUTTON = get("homePage.logout");
    public final static String TITLE = "The Internet";

    public static void logout() {
        $(LOGOUT_BUTTON).click();
    }

    public static void shouldAppear() {
        shouldAppear(TITLE);
    }
}
