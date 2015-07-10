package core;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TestBase {
    private static final String BASE_URL = "http://the-internet.herokuapp.com";
    private Properties env;

    @BeforeTest
    public void configure() {
        Configuration.browser = System.getProperty("browser", "firefox");
        Configuration.baseUrl = System.getProperty("baseUrl", BASE_URL);
        env = new Properties();
        RemoteWebDriver remote = (RemoteWebDriver) getWebDriver();
        env.setProperty("Browser", remote.getCapabilities().getBrowserName());
        env.setProperty("Browser Version", remote.getCapabilities().getVersion());
        env.setProperty("Platform", remote.getCapabilities().getPlatform().name());
        env.setProperty("Platform version", remote.getCapabilities().getPlatform().getMajorVersion() + "." +
                remote.getCapabilities().getPlatform().getMinorVersion());
        env.setProperty("Url", Configuration.baseUrl);
    }

    @AfterTest(alwaysRun = true)
    public void saveEnvironment() {
        File file = Paths.get(System.getProperty("user.dir"), "/target/allure-results").toAbsolutePath().toFile();
        if (!file.exists()) {
            System.out.println("Created dirs: " + file.mkdirs());
        }
        try (FileWriter out = new FileWriter("./target/allure-results/environment.properties")) {
            env.store(out, "Environment variables for report");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
