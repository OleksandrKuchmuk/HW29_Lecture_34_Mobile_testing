package driver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverConfig {
    private static Logger LOGGER = LogManager.getLogger(DriverConfig.class);
    private AndroidDriver<?> driver;

    public AndroidDriver<?> getDriver() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability("platformName","Android");
capabilities.setCapability("deviceName","ZY22DGF7DJ");
capabilities.setCapability("appActivity","com.google.android.gm.GmailActivity");
capabilities.setCapability("appPackage","com.google.android.gm");
capabilities.setCapability("","");

            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            LOGGER.error("Filed to initiate the tests for the Android device", e);
        }
        return driver;
    }
}
