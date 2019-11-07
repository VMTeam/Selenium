package pageObjects;

import org.openqa.selenium.By;

public class SimpleSystemsPageObjects {

    public static  class LoginPage {
        public static By EMAIL_FIELD = (By.id("email"));
        public static By PASSWORD_FIELD = (By.id("password"));
        public static By LOGIN_BUTTON = (By.id("login_submit"));
    }

    public static class Dashboard {
        public static By TITLE = (By.cssSelector(".greeting"));
        public static By LEFT_MENU_ACCOUNT_BUTTON = (By.cssSelector(".menu-item.menu-item-2"));
    }

    public static class Accounts {
        public static By PAGE_TITLE = (By.cssSelector(".page_title .active"));
        public static By USER_NAME_TITLE = (By.cssSelector(".username"));
        public static By COMPANY_NAME_TITLE = (By.cssSelector(".company_name"));
    }
}
