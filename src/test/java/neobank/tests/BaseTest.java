package neobank.tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import neobank.integrations.AllureExtension;
import neobank.integrations.LoggerExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.NoSuchSessionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith({LoggerExtension.class, AllureExtension.class})
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @BeforeEach
    public void setUp() {
        configureBrowser();
        startWebDriver();
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    private void configureBrowser() {
        Configuration.browser = "chrome";
        Configuration.savePageSource = false;
        Configuration.screenshots = true;
        Configuration.startMaximized = true;
        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";
        Configuration.reportsFolder = "target/selenide/reports";
        Configuration.downloadsFolder = "target/selenide/downloads";
        Configuration.timeout = 10000;
//        Configuration.proxyEnabled = true;
//        Configuration.fileDownload = PROXY;
    }

    private void startWebDriver() {
        if (!WebDriverRunner.hasWebDriverStarted()) {
            Selenide.open();
        } else {
            logger.info("WebDriver was already started");
        }
    }

    private void closeWebDriver() {
        if (WebDriverRunner.hasWebDriverStarted()) {
            try {
                WebDriverRunner.closeWindow();
            } catch (NoSuchSessionException sessionException) {
                logger.info(sessionException.getMessage());
            }
            WebDriverRunner.closeWebDriver();
        } else {
            logger.info("No WebDriver to close");
        }
    }
}
