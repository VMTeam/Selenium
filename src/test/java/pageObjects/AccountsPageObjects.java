package pageObjects;

import org.openqa.selenium.By;

public class AccountsPageObjects {
    public static By LOGOUT_BUTTON = (By.cssSelector(".notificationblock .fa-sign-out"));
    public static By SETTINGS_BUTTON = (By.cssSelector(".notificationblock .fa-cogs"));
    public static By NOTIFICATIONS_BUTTON = (By.cssSelector(".notificationblock .fa-bell"));
    public static By HELP_BUTTON = (By.cssSelector(".helpblock .help-switch"));

    public static class LoginPage {
        public static By EMAIL_FIELD = (By.id("email"));
        public static By PASSWORD_FIELD = (By.id("password"));
        public static By LOGIN_BUTTON = (By.id("login_submit"));
    }

    public static class Dashboard {
        public static By LEFT_MENU_ACCOUNT_BUTTON = (By.cssSelector(".menu-item.menu-item-2"));
        public static By WIDGETS_BUTTON = (By.cssSelector(".widget_controls .btn-grey"));
    }

    public static class Accounts {
        public static By PAGE_TITLE = (By.cssSelector(".page_title .active"));
        public static By TABLE_HEADER = (By.className("table-heading"));
        public static By TABLE_USERS_LIST = (By.cssSelector(".table-data .view_link"));
        public static By SEARCH_FIELD = (By.id("Accounts_basic_filter"));
        public static By TABLE_ACCOUNTS_INFO = (By.id("grid-Accounts_info"));
        public static By EMPTY_USERS_TABLE = (By.className("dataTables_empty"));
        public static By TABLE_LOADING_GIF = (By.className("outer_processing_indicator"));
        public static By SEARCH_ICON = (By.className("input-group-addon"));
        public static By CLEAR_SEARCH_BUTTON = (By.cssSelector(".fa-times"));
    }
}
