package neobank.steps;

import neobank.pages.MainPage;

import io.qameta.allure.Step;

public class MainPageSteps {
    public static final MainPage mainPage = new MainPage();

    @Step
    public void inputPhoneNumber(String phoneNumber) {
        mainPage.inputPhoneNumber(phoneNumber);
    }

    @Step
    public void clickNext() {
        mainPage.clickNext();
    }

    @Step
    public void checkAuthFormTitle(String expectedText) {
        mainPage.checkAuthFormTitle(expectedText);
    }


}
