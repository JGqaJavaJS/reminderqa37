package framework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.util.Collection;
import java.util.List;

public class ReminderHelper extends BaseHelper{
    public ReminderHelper(AppiumDriver driver) {
        super(driver);
    }

    By btnAddNewRemind = By.xpath("//*[@resource-id='com.blanyal.remindly:id/add_reminder']");

    By inputTitleAddReminder = By.xpath("//*[@resource-id='com.blanyal.remindly:id/reminder_title']");

    By btnApplyNewReminder = By.xpath("//*[@resource-id='com.blanyal.remindly:id/save_reminder']");
    By titleReminderName = By.xpath("//*[@resource-id='com.blanyal.remindly:id/recycle_title']");
    By btnReminderDate = By.id("date");
    By monthOnCalendar = By.xpath("//*[@resource-id='com.blanyal.remindly:id/animator']");

    By takeDateOnCalendar = By.className("android.view.View");
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

    public void tapOnDateField() {
        tap(btnReminderDate, 5);
    }

    public void swipeToMonth(String period, int number, String month) {
        // swipe to one month only, if we need to swipe a lot - we should use while()
        if(!getSelectedMonthAndYear().contains(month)) {
            if(period.equals("future")) {
                swipe(0.7, 0.4);
            } else if (period.equals("past")) {
                swipe(0.6, 0.8);
            }
        }
    }

    public void swipe(double start, double stop) {
        // return screen size
        Dimension size = driver.manage().window().getSize();

        int x = size.width / 2;

        int startY = (int) (size.height * start);
        int stopY = (int) (size.height * stop);

        new TouchAction<>(driver).longPress(PointOption.point(x, startY))
                .moveTo(PointOption.point(x, stopY))
                .release().perform();
    }

    protected String getSelectedMonthAndYear() {
        System.out.println(getValueByAttribute(monthOnCalendar, 15, "content-desc"));
        return getValueByAttribute(monthOnCalendar, 15, "content-desc");
    }

    public void selectDate(int index) {
        waitForElementVisibilityByLocator(takeDateOnCalendar, 10);
        List<MobileElement> list = driver.findElements(takeDateOnCalendar);
        list.get(index + 1).click();
    }
}
