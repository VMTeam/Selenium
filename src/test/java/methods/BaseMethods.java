package methods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static javax.swing.UIManager.get;

public class BaseMethods {

    WebDriver driver;

    public void upChrome77() {
        WebDriverManager.chromedriver().version("77.0").setup();
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1820, 900));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void webDriverDown() {

        if (driver != null) {
            driver.quit();
        }
    }

    public void openPage(String path) {
        get(path);
    }
}
