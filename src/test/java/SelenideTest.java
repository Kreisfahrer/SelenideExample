import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.*;

public class SelenideTest {
    private static final String BASE_URL = "http://the-internet.herokuapp.com/login";
    private static final String SUCCESSFUL_LOGIN_MESSAGE = "You logged into a secure area!";

    @BeforeTest
    public void configure() {
        Configuration.browser = "chrome";
    }

    @Test
    public void loginTest() {
        open(BASE_URL);
        LoginPage.login("tomsmith", "SuperSecretPassword");
        $("#flash").should(be(visible), have(cssClass("success")), have(text(SUCCESSFUL_LOGIN_MESSAGE)));
    }
}