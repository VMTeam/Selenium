package methods;

import pageObjects.AccountsPageObjects.*;

import javax.sound.sampled.Line;

public class AccountsPageSteps extends BaseMethods {

    public void openLoginPage() {
        openPage("https://qasca-554.reallysimplesystems.com/login");
    }

    public void loginSystem(String Email, String Pass) {
        sendKeysToElement(LoginPage.EMAIL_FIELD, Email);
        sendKeysToElement(LoginPage.PASSWORD_FIELD, Pass);
        clickOnElement(LoginPage.LOGIN_BUTTON);
        elementShouldBeVisible(Dashboard.WIDGETS_BUTTON);
    }

    public void switchToAccountsPage() {
        clickOnElement(Dashboard.LEFT_MENU_ACCOUNT_BUTTON);
        elementShouldHaveText(Accounts.PAGE_TITLE, "Accounts");
    }

    public void assertNumberOfUsersInTable(Integer count) {
        listShouldHaveSize(Accounts.TABLE_USERS_LIST, count);
    }

    public void searchUser(String UserName) {
        sendKeysToElement(Accounts.SEARCH_FIELD, UserName);
        clickOnElement(Accounts.SEARCH_ICON);
        elementWaitInVisible(Accounts.TABLE_LOADING_GIF);
        elementWaitVisible(Accounts.TABLE_HEADER);
    }

    public void resetSearchField() {
        clickOnElement(Accounts.CLEAR_SEARCH_BUTTON);
        elementWaitInVisible(Accounts.TABLE_LOADING_GIF);
        elementWaitVisible(Accounts.TABLE_HEADER);
    }

    public void assertFirstUserNameInTable(String UserName) {
        elementShouldHaveText(Accounts.TABLE_USERS_LIST, UserName);
    }

    public void assertInfoAboutUsersInTable(String UserInfo) {
        elementShouldHaveText(Accounts.TABLE_ACCOUNTS_INFO, UserInfo);
    }

    public void assertEmptyUsersTable(String Info) {
        elementShouldHaveText(Accounts.EMPTY_USERS_TABLE, Info);
    }
}
