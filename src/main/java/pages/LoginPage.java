package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static helpers.Locators.get;

public class LoginPage {
    public final static By USERNAME_FIELD = get("loginPage.loginForm.userName");
    public final static By PASSWORD_FIELD = get("loginPage.loginForm.password");
    public final static By LOGIN_BUTTON = get("loginPage.loginForm.submit");
    public final static By VALIDATION_MESSAGE = get("loginPage.loginForm.validationMessage");

    public static void login(String user, String password) {
        $(USERNAME_FIELD).val(user);
        $(PASSWORD_FIELD).val(password);
        $(LOGIN_BUTTON).click();
    }
}
