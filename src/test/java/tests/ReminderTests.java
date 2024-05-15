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


}
