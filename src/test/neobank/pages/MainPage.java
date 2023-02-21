package neobank.pages;

import com.codeborne.selenide.Condition;

import org.openqa.selenium.By;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;


public class MainPage extends BasePage {
    public static final By PHONE_FIELD = By.id("login");
    public static final By NEXT_BUTTON = By.id("btnNext");
    public static final By AUTH_FORM_TITLE = By.xpath("//form[@id='formAuthQr']//div[@class='auth-form-title']");


    public void inputPhoneNumber(String phoneNumber) {
        $(PHONE_FIELD).shouldBe(Condition.visible).sendKeys(phoneNumber);
    }
    public void clickNext() {
        $(NEXT_BUTTON).click();
    }
    public void checkAuthFormTitle(String expectedText) {
        String currentAuthFormTitle = $(AUTH_FORM_TITLE).should(Condition.visible, Duration.ofSeconds(20)).text();
        assertThat(currentAuthFormTitle).isEqualTo(expectedText);
    }
}
