package framework;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ReminderHelper extends BaseHelper{
    public ReminderHelper(AppiumDriver driver) {
        super(driver);
    }

    By btnAddNewRemind = By.xpath("//*[@resource-id='com.blanyal.remindly:id/add_reminder']");

    By inputTitleAddReminder = By.xpath("//*[@resource-id='com.blanyal.remindly:id/reminder_title']");

    By btnApplyNewReminder = By.xpath("//*[@resource-id='com.blanyal.remindly:id/save_reminder']");
    By titleReminderName = By.xpath("//*[@resource-id='com.blanyal.remindly:id/recycle_title']");

    public void tapCreateNewReminder() {
        tap(btnAddNewRemind, 10);
    }

    public boolean isAddNewReminderBtnDisplays() {
        waitForElementVisibilityByLocator(btnAddNewRemind, 10);
        return isElementPresent(btnAddNewRemind);
    }

    public void tapBtnAddNewReminder() {
        tap(btnAddNewRemind, 10);
    }

    public void fillFieldTitleReminder(String str) {
        type(inputTitleAddReminder, str, 10);
    }

    public void tapApplyNewReminder() {
        tap(btnApplyNewReminder, 5);
    }

    public boolean verifyReminderByNameCreated(String actualRes) {
        String expectedResult = getText(titleReminderName, 10);
        return expectedResult.equals(actualRes);
    }
}
