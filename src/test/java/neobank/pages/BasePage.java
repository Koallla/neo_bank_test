package neobank.pages;

import com.codeborne.selenide.*;

import org.openqa.selenium.By;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class BasePage {
    public static final By LOADER = By.xpath("//div[@class='loader']");
    public static SelenideElement $(By bySelector) {
        return Selenide.$(bySelector);
    }
    public void openSite(String url) {
        Selenide.open(url);
    }

    public void waitTillPreloaderDisappear() {
        $(LOADER).shouldBe(Condition.disappear, Duration.ofSeconds(30));
    }

    public void checkTitlePage(String expectedPageTitle) {
        String currentPageTitle = Selenide.title();
        assertThat(currentPageTitle).isEqualTo(expectedPageTitle);
    }
}