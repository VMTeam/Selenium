package methods;

import pageObjects.SimpleSystemsPageObjects.*;

public class SimpleSystemsMethods extends BaseMethods {

    public void LoginSystem (String Email, String Pass) {
        sendKeysToElement(LoginPage.EMAIL_FIELD, Email);
        sendKeysToElement(LoginPage.PASSWORD_FIELD, Pass);
        clickOnElement(LoginPage.LOGIN_BUTTON);
        elementShouldHaveText(Dashboard.TITLE, "Good Morning Oleg");
    }

    public void SwitchToAccountsPage () {
        clickOnElement(Dashboard.LEFT_MENU_ACCOUNT_BUTTON);
        elementShouldHaveText(Accounts.PAGE_TITLE, "Accounts");
    }
}
