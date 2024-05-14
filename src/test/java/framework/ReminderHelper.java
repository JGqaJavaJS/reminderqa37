package framework;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ReminderHelper extends BaseHelper{
    public ReminderHelper(AppiumDriver driver) {
        super(driver);
    }

    By btnAddNewRemind = By.xpath("//*[@resource-id='com.blanyal.remindly:id/add_reminder']");

    public void tapCreateNewReminder() {
        tap(btnAddNewRemind);
    }

    public boolean isAddNewReminderBtnDisplays() {
        return isElementPresent(btnAddNewRemind);
    }

}
