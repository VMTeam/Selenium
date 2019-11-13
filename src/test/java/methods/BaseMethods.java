package methods;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseClass;

import java.util.List;

public class BaseMethods extends BaseClass {

    public void openPage(String path) {
        System.out.println("driver"+driver);
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

    public void elementWaitVisible(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void elementWaitInVisible(By element) {
        elementWaitVisible(element);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
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
