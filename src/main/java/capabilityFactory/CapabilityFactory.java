package capabilityFactory;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CapabilityFactory {
    private static final String PLATFORM_NAME_CAPABILITY = "Android";
    private static final String DEVICE_NAME_CAPABILITY = "Motorola_G60";
    private static final String UDID_CAPABILITY = "ZY22DGF7DJ";
    private static final String APP_PACKAGE_CAPABILITY = "com.google.android.gm";
    private static final String APP_ACTIVITY_CAPABILITY = "com.google.android.gm.GmailActivity";
    private static final String COMMAND_TIME_OUT_CAPABILITY = "60";

    public static DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME_CAPABILITY);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME_CAPABILITY);
        capabilities.setCapability(MobileCapabilityType.UDID, UDID_CAPABILITY);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, APP_PACKAGE_CAPABILITY);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY_CAPABILITY);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, COMMAND_TIME_OUT_CAPABILITY);
        return capabilities;
    }

    public static URL getAppiumServerURL() {
        try {
            return new URL("http:/127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
