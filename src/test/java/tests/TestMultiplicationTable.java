package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static pageObjects.TablePageObjects.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMultiplicationTable {

    WebDriver driver;

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

    private void checkPageNumber() {

        int i = 1;

        while (i <= 10) {
            String pageNumber = driver.findElement(NUMBER_OF_QUESTIONS).getText();
            int Page = Integer.parseInt(pageNumber);
            Assert.assertEquals(Page, i);
            i++;
        }
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
        clickButtonNext();
        checkPageNumber();
        emptyAnswerField("Ответьте, пожалуйста, на вопрос.");
    }

    @Test
    public void test_02_Answer_All_Questions() {
        String bodyText = driver.findElement(FIRST_PAGE_TEST_INSTRUCTION).getText();
        Assert.assertTrue(bodyText.contains("Внимательно прочитайте пример и напишите получившийся ответ в окошко. Удачи в прохождении!"));
        clickButtonNext();
        for (int i = 1; i < 11; i++) {
            checkPageNumber();
            fillAnswerInput("56");
            clickButtonNext();
            i++;
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
