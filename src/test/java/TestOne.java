import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class TestOne {

    WebDriver driver;

    @Before
    public void before() {
        WebDriverManager.chromedriver().version("77.0").setup();
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1820,900));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://google.com/");
    }

    @Test
    public void test_01_Search() {
        driver.findElement(By.cssSelector(".gLFyf.gsfi")).sendKeys("CSS vs XPATH locators");
        driver.findElement(By.cssSelector(".gNO89b")).click();


    }

    @After
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }
}
