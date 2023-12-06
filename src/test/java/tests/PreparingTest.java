package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackMobileDriver;
import drivers.LocalMobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.className;

public class PreparingTest {

    public static String deviceHost = System.getProperty("deviceHost");

    @BeforeAll
    static void setUpDriver() throws Exception {
        switch (deviceHost) {
            case "browserstack":
                Configuration.browser = BrowserstackMobileDriver.class.getName();
                break;
            case "local":
                Configuration.browser = LocalMobileDriver.class.getName();
                break;
            default:
                throw new Exception("The device host is not selected");
        }
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
        step("Prepare app for testing", () -> {
            back();
            $$(className("android.widget.TextView"))
                    .findBy(text("Россия")).click();
            $(className("android.widget.Button")).click();
        });
    }

    @AfterEach
    void addAttachments() {
        String sessionId = sessionId().toString();
        Attach.pageSource();
        if (deviceHost.equals("browserstack")) {
            closeWebDriver();
            Attach.addVideo(sessionId);
        }
        if (deviceHost.equals("local")) {
            Attach.screenshotAs("Last screenshot");
            closeWebDriver();
        }
        closeWebDriver();
    }
}










