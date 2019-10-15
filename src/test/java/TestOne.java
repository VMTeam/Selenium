import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestOne {

    WebDriver driver;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "/home/vmejinskii/Desktop/Selenium/src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @Test
    public void test_01() {
        driver.get("http://yandex.ru/");
    }

    @After
    public void after() {
        driver.close();
    }
}
