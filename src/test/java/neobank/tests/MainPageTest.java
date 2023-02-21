package neobank.tests;

import org.junit.jupiter.api.Test;

public class MainPageTest extends CommonActions {

    @Test
    public void MainTest() {
        baseSteps.openSite("https://web.neobank.one/");
        baseSteps.waitTillPreloaderDisappear();
        baseSteps.checkTitlePage("NEOBANK для бізнесу");
        mainPageSteps.inputPhoneNumber("630000000");
        mainPageSteps.clickNext();
        mainPageSteps.checkAuthFormTitle("Відкриття бізнес-рахунку можливе тільки через додаток NEOBANK для бізнесу");
    }
}
