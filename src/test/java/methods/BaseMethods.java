package methods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseMethods {

    static WebDriver driver;

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
        driver.get(path);
    }

    public void clickOnElement(By element) {
        driver.findElement(element).isEnabled();
        driver.findElement(element).click();
    }

    public void sendKeysToElement(By element, String text) {
        driver.findElement(element).sendKeys(text);
    }

    public void elementShouldHaveText(By element, String text) {
        String Object = driver.findElement(element).getText();
        Assert.assertEquals(Object, text);
    }

    public void elementShouldBeVisible(By element) {
        driver.findElement(element).isDisplayed();
    }

    public void listShouldHaveSize(By collection, int num) {
        int count;
        count = driver.findElements(collection).size();
        Assert.assertEquals(count, num);
    }

    public void listShouldHaveTexts(By collection, String... listTexts) {
        List<WebElement> UserList = driver.findElements(collection);
        Assert.assertEquals(UserList, listTexts);

    }
}
