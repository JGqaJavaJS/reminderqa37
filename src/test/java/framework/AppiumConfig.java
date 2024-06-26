package framework;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumConfig {

    AppiumDriver driver;
    MainScreenHelper mainScreenHelper;
    ReminderHelper reminderHelper;

    public void init() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","10");
        capabilities.setCapability("deviceName","mob");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","com.blanyal.remindly");
        capabilities.setCapability("appActivity","com.blanyal.remindme.MainActivity");
        capabilities.setCapability("app", "/Users/julia/Tools/remindly.apk");

        try {
            driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        mainScreenHelper = new MainScreenHelper(driver);
        reminderHelper = new ReminderHelper(driver);
    }

    public ReminderHelper getReminderHelper() {
        return reminderHelper;
    }

    public MainScreenHelper getMainScreenHelper() {
        return mainScreenHelper;
    }

    public void tearDown() {
        driver.quit();
    }
}
