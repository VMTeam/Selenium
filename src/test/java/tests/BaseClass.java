package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver;

    @BeforeClass
    public static void upChrome77() {
        WebDriverManager.chromedriver().version("77.0").setup();
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(1820, 900));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void webDriverDown() {

        if (driver != null) {
            driver.quit();
        }
    }

    @Before
    public void beforeBase() {
        driver.manage().deleteAllCookies();
    }
}
