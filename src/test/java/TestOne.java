import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertArrayEquals;

public class TestOne {

    WebDriver driver;

    @Before
    public void before() {
        WebDriverManager.chromedriver().version("77.0").setup();
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1820, 900));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/?hl=ru");
    }

    @Test
    public void test_01_Search() {
        driver.findElement(By.cssSelector(".gLFyf.gsfi")).sendKeys("CSS vs XPATH locators");
        driver.findElement(By.cssSelector(".gNO89b")).click();
        List<WebElement> rows = driver.findElements(By.xpath("//div/a/div/img[@data-atf]"));
        System.out.println("Number of rows: " + rows.size());
        assertArrayEquals(new int[]{11}, new int[]{rows.size()});
        driver.findElements(By.cssSelector("h3[class='LC20lb']")).get(0).click();
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue("Text not found!", bodyText.contains("Locating Element Using XPATH Selectors"));
    }

    @After
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }
}
