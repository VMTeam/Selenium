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
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestOne {

    WebDriver driver;

    @Before
    public void before() {
        WebDriverManager.chromedriver().version("77.0").setup();
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1820, 900));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
    }

    @Test
    public void test_01_Search() {
        driver.findElement(By.cssSelector(".gLFyf.gsfi")).sendKeys("CSS vs XPATH locators");
        driver.findElement(By.cssSelector(".gNO89b")).click();
        //System.out.println(driver.findElements(By.cssSelector("h3[class='LC20lb']")).size());

        //Check rows on google search result
        int count = 0;
        List<WebElement> rows = driver.findElements(By.cssSelector("h3[class='LC20lb']"));
        for (WebElement row : rows) {
            if (row.isDisplayed())
                count++;
        }
        System.out.println("Number of rows: " + count);

        driver.findElements(By.cssSelector("h3[class='LC20lb']")).get(0).click();

        //Check text on the page
        if (driver.getPageSource().contains("Locating Element Using XPATH Selectors")) {
            System.out.println("Text is displayed on the page");
        } else {
            System.out.println("Fail");
        }
    }

    @After
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }
}
