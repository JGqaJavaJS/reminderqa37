package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReminderTests extends BaseTest {

    @BeforeMethod
    public void preconditions() {
        if(app.getMainScreenHelper().isBtnOkPopUpDisplays()) {
            app.getMainScreenHelper().tapBtnOkPopUp();
        }
    }

    @Test(description = "add new reminder with the name only")
    public void addNewReminderOnlyNamePositiveTest() {
        app.getReminderHelper().tapBtnAddNewReminder();
        String vacations = "vacations";
        app.getReminderHelper().fillFieldTitleReminder(vacations);
        app.getReminderHelper().tapApplyNewReminder();

        Assert.assertTrue(app.getReminderHelper().verifyReminderByNameCreated(vacations));
    }

    @Test(description = "add new reminder with the name and date")
    public void addNewReminderNameAndDateTest() {
        app.getReminderHelper().tapBtnAddNewReminder();
        String vacations = "vacations";
        app.getReminderHelper().fillFieldTitleReminder(vacations);

        app.getReminderHelper().tapOnDateField();
        app.getReminderHelper().swipeToMonth("future", 1, "June");

       // app.getReminderHelper().pause(30000);
        app.getReminderHelper().selectDate(0);
        app.getReminderHelper().tapOnYear();
        app.getReminderHelper().swipeToYear("future", "2025");
        app.getReminderHelper().tapOnOk();

        app.getReminderHelper().tapApplyNewReminder();

        Assert.assertTrue(app.getReminderHelper().verifyReminderDateCorrect("1/6/2025"));

    }

    @Test
    public void addReminderWithTimePositiveTest() {
        app.getReminderHelper().tapBtnAddNewReminder();
        String vacations = "vacations";
        app.getReminderHelper().fillFieldTitleReminder(vacations);

        app.getReminderHelper().tapOnTimeField();
        app.getReminderHelper().selectTime("am",403,1379,710,1690);
        app.getReminderHelper().tapOnOk();
        app.getReminderHelper().saveReminder();

        // 15/5/2024 23:07
        String reminderDatePresent = app.getMainScreenHelper().isReminderDatePresent();
        Assert.assertTrue(reminderDatePresent.contains("9:30")
                || reminderDatePresent.contains("21:30"));
    }


}
