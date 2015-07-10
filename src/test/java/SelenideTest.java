import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.CollectionElement;
import com.codeborne.selenide.testng.BrowserPerClass;
import com.codeborne.selenide.testng.BrowserPerTest;
import com.codeborne.selenide.testng.ScreenShooter;
import core.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.*;

public class SelenideTest extends TestBase {
    private static final String SUCCESSFUL_LOGIN_MESSAGE = "You logged into a secure area!";

    @BeforeMethod
    public void setup() {
        open("/login");
        LoginPage.shouldAppear();
    }

    @Test
    public void loginTest() {
        LoginPage.login("tomsmith", "SuperSecretPassword!");
        $(HomePage.LOGIN_MESSAGE).should(
                be(visible),
                have(cssClass("success1")),
                have(text(SUCCESSFUL_LOGIN_MESSAGE)));
    }
}