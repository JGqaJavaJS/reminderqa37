package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainScreenTests extends BaseTest{

    @Test
    public void isAppOpensTest() {
        if(app.getMainScreenHelper().isBtnOkPopUpDisplays()) {
            app.getMainScreenHelper().tapBtnOkPopUp();
        }
        Assert.assertTrue(app.getReminderHelper().isAddNewReminderBtnDisplays());
    }
}
