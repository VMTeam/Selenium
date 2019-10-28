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

    @Before
    public void before() {
        WebDriverManager.chromedriver().version("77.0").setup();
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1820, 900));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://onlinetestpad.com/ru/test/68962-tablica-umnozheniya");
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
        Assert.assertTrue(failText.contains(Fail));
    }

    private void checkPageNumber(String PageNumber) {
        String pageNumber = driver.findElement(NUMBER_OF_QUESTIONS).getText();
        Assert.assertTrue(pageNumber.contains(PageNumber));
    }

    private void ResultTitle(String Result) {
        String pageNumber = driver.findElement(RESULT_TITLE).getText();
        Assert.assertTrue(pageNumber.contains(Result));
    }

    @Test
    public void test_01_First_Page() {
        String bodyText = driver.findElement(FIRST_PAGE_TEST_INSTRUCTION).getText();
        Assert.assertTrue(bodyText.contains("Внимательно прочитайте пример и напишите получившийся ответ в окошко. Удачи в прохождении!"));
        clickButtonNext();
    }

    @Test
    public void test_02_Empty_Answer_Field(){
        clickButtonNext();
        checkPageNumber("1");
        emptyAnswerField("Ответьте, пожалуйста, на вопрос.");
    }

    /*@Test
    public void test_03_Answer_All_Questions() {
        for (int i = 1; i > 1; i--) {
            checkPageNumber("1"+i);
            fillAnswerInput("12"+i);
            clickButtonNext();
        }
    }*/

    @Test
    public void test_04_Answer_Result() {
        clickButtonNext();
        checkPageNumber("1");
        emptyAnswerField("Ответьте, пожалуйста, на вопрос.");
        fillAnswerInput("12");
        clickButtonNext();
        checkPageNumber("2");
        emptyAnswerField("Ответьте, пожалуйста, на вопрос.");
        fillAnswerInput("25");
        clickButtonNext();
        checkPageNumber("3");
        emptyAnswerField("Ответьте, пожалуйста, на вопрос.");
        fillAnswerInput("45");
        clickButtonNext();
        checkPageNumber("4");
        emptyAnswerField("Ответьте, пожалуйста, на вопрос.");
        fillAnswerInput("23");
        clickButtonNext();
        checkPageNumber("5");
        emptyAnswerField("Ответьте, пожалуйста, на вопрос.");
        fillAnswerInput("12");
        clickButtonNext();
        checkPageNumber("6");
        emptyAnswerField("Ответьте, пожалуйста, на вопрос.");
        fillAnswerInput("98");
        clickButtonNext();
        checkPageNumber("7");
        emptyAnswerField("Ответьте, пожалуйста, на вопрос.");
        fillAnswerInput("78");
        clickButtonNext();
        checkPageNumber("8");
        emptyAnswerField("Ответьте, пожалуйста, на вопрос.");
        fillAnswerInput("76");
        clickButtonNext();
        checkPageNumber("9");
        emptyAnswerField("Ответьте, пожалуйста, на вопрос.");
        fillAnswerInput("45");
        clickButtonNext();
        checkPageNumber("10");
        emptyAnswerField("Ответьте, пожалуйста, на вопрос.");
        fillAnswerInput("77");
        clickButtonNext();
        ResultTitle("Результат");
    }

    @After
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }
}
