package pageObjects;

import org.openqa.selenium.By;

public class TablePageObjects {
    public static By FIRST_PAGE_TEST_INSTRUCTION = (By.cssSelector(".otp-item-view-instr"));
    public static By NEXT_BUTTON = (By.cssSelector("#btnNext"));
    public static By ALERT_FAIL = (By.cssSelector(".alert-warning"));
    public static By NUMBER_OF_QUESTIONS = (By.cssSelector(".header .num"));
    public static By ANSWER_INPUT_FIELD = (By.cssSelector(".otp-textbox.digit"));
    public static By RESULT_TITLE = (By.cssSelector(".otp-item-result .title"));
}
