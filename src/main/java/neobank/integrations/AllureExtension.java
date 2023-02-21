package neobank.integrations;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.Base64;

public class AllureExtension implements AfterEachCallback {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public void afterEach(ExtensionContext context) {
        if (context.getExecutionException().isPresent()) {
            String fileName = context.getDisplayName().toLowerCase()
                    .replace(" ", "_")
                    .replaceAll("[^a-zA-Z0-9]", "");
            String screenshotAsBase64 = Selenide.screenshot(OutputType.BASE64);
            attachScreenshot(screenshotAsBase64);
            logger.info("Screenshot saved.");
        }
    }

    @Attachment(value = "Page Screenshot", type = "image/png")
    public byte[] attachScreenshot(String screenShot) {
        return Base64.getDecoder().decode(screenShot);
    }
}
