import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestOne {

    WebDriver driver;

    @Before
    public void before() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @Test
    public void test_01() {
        driver.get("http://yandex.ru/");
    }

    @After
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }
}
