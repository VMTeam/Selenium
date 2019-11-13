package methods;

import pageObjects.AccountsPageObjects.*;

public class AccountsPageSteps extends BaseMethods {

    public void openLoginPage () {
        openPage("https://qasca-554.reallysimplesystems.com/login");
    }

    public void loginSystem (String Email, String Pass) {
        sendKeysToElement(LoginPage.EMAIL_FIELD, Email);
        sendKeysToElement(LoginPage.PASSWORD_FIELD, Pass);
        clickOnElement(LoginPage.LOGIN_BUTTON);
        elementShouldBeVisible(Dashboard.WIDGETS_BUTTON);
    }

    public void switchToAccountsPage () {
        clickOnElement(Dashboard.LEFT_MENU_ACCOUNT_BUTTON);
        elementShouldHaveText(Accounts.PAGE_TITLE, "Accounts");
    }

    public void assertNumberOfUsersInTable (Integer count) {
        listShouldHaveSize(Accounts.TABLE_USERS_LIST, count);
    }
}