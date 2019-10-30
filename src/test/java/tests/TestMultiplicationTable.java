package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMultiplicationTable {

    WebDriver driver;

    By FIRST_PAGE_TEST_INSTRUCTION = (By.cssSelector(".otp-item-view-instr"));
    By NEXT_BUTTON = (By.cssSelector("#btnNext"));
    By ALERT_FAIL = (By.cssSelector(".alert-warning"));
    By NUMBER_OF_QUESTIONS = (By.cssSelector(".header .num"));
    By ANSWER_INPUT_FIELD = (By.cssSelector(".otp-textbox.digit"));
    By RESULT_TITLE = (By.cssSelector(".otp-item-result .title"));

    private void checkFirstPage() {
        String bodyText = driver.findElement(FIRST_PAGE_TEST_INSTRUCTION).getText();
        Assert.assertTrue(bodyText.contains("Внимательно прочитайте пример и напишите получившийся ответ в окошко. Удачи в прохождении!"));
    }

    private void clickButtonNext() {
        driver.findElement(NEXT_BUTTON).click();
    }

    private void fillAnswerInput(String result) {
        driver.findElement(ANSWER_INPUT_FIELD).sendKeys(result);
    }

    private void emptyAnswerField(String Fail) {
        driver.findElement(NEXT_BUTTON).click();
        String failText = driver.findElement(ALERT_FAIL).getText();
        Assert.assertEquals(failText, Fail);
    }

    private void checkPageNumber(Integer count) {
        String expectedResult = String.valueOf(count);
        String pageNumber = driver.findElement(NUMBER_OF_QUESTIONS).getText();
        Assert.assertEquals(pageNumber, expectedResult);
    }

    private void ResultTitle(String Result) {
        String pageNumber = driver.findElement(RESULT_TITLE).getText();
        Assert.assertEquals(pageNumber, Result);
    }

    @Before
    public void before() {
        WebDriverManager.chromedriver().version("77.0").setup();
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1820, 900));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://onlinetestpad.com/ru/test/68962-tablica-umnozheniya");
    }

    @Test
    public void test_01_Empty_Answer_Field() {
        checkFirstPage();
        clickButtonNext();
        emptyAnswerField("Ответьте, пожалуйста, на вопрос.");
    }

    @Test
    public void test_02_Answer_All_Questions() {
        String bodyText = driver.findElement(FIRST_PAGE_TEST_INSTRUCTION).getText();
        Assert.assertEquals(bodyText, "Внимательно прочитайте пример и напишите получившийся ответ в окошко. Удачи в прохождении!");
        clickButtonNext();
        for (int i = 1; i < 11; i++) {
            checkPageNumber(i);
            fillAnswerInput("56");
            clickButtonNext();
        }
        ResultTitle("Результат");
    }

    @After
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }
}
