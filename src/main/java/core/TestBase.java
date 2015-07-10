package core;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;

public class TestBase {
    private static final String BASE_URL = "http://the-internet.herokuapp.com";

    @BeforeTest
    public void configure() {
        Configuration.browser = System.getProperty("browser", "firefox");
        Configuration.baseUrl = System.getProperty("baseUrl", BASE_URL);
    }
}
