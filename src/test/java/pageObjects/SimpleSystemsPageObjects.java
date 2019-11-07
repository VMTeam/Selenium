package pageObjects;

import org.openqa.selenium.By;

public class SimpleSystemsPageObjects {
    public class LoginPage {
        public By EMAIL_FIELD = (By.id("username"));
        public By PASSWORD_FIELD = (By.id("password"));
        public By LOGIN_BUTTON = (By.id("login_submit"));
    }
}
