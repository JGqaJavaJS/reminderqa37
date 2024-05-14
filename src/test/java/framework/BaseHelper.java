package framework;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BaseHelper {
    AppiumDriver driver;

    public BaseHelper(AppiumDriver driver) {
        this.driver = driver;
    }

    protected boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    protected void type(By locator, String text) {
        tap(locator); // the same with click on web
        WebElement el = driver.findElement(locator);
        el.clear();
        el.sendKeys(text);
        driver.hideKeyboard();
    }

    protected void tap(By locator) {
        driver.findElement(locator);
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
