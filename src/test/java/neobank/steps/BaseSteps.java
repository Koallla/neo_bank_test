package neobank.steps;

import neobank.pages.BasePage;

public class BaseSteps  {
    public static final BasePage basePage = new BasePage();

    public void openSite(String url) {
        basePage.openSite(url);
    }
    public void waitTillPreloaderDisappear() {
        basePage.waitTillPreloaderDisappear();
    }

    public void checkTitlePage(String expectedPageTitle) {
        basePage.checkTitlePage(expectedPageTitle);

    }

}
