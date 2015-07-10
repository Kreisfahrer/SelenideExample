package helpers;

import com.codeborne.selenide.testng.ScreenShooter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Attachment;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ScreenShotListener extends ScreenShooter {

    @Override
    public void onTestFailure(ITestResult result) {
        super.onTestFailure(result);
        failureScreenshot();
    }

    @Attachment
    public static byte[] failureScreenshot() {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
