import core.TestBase;
import helpers.ScreenShotListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.*;

@Listeners(ScreenShotListener.class)
public class SelenideTest extends TestBase {
    private static final String SUCCESSFUL_LOGIN_MESSAGE = "You logged into a secure area!";

    @BeforeMethod
    public void setup() {
        open("/login");
        LoginPage.shouldAppear();
    }

    @Test
    @TestCaseId("")
    @Issue("")
    public void loginTest() {
        LoginPage.login("tomsmith", "SuperSecretPassword!");
        $(HomePage.LOGIN_MESSAGE).should(
                be(visible),
                have(cssClass("success1")),
                have(text(SUCCESSFUL_LOGIN_MESSAGE)));
    }
}