package driver;

import capabilityFactory.CapabilityFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class DriverConfig {
    private static Logger LOGGER = LogManager.getLogger(DriverConfig.class);
    private AndroidDriver<?> driver;

    public AndroidDriver<?> getDriver() {
        return driver = new AndroidDriver<MobileElement>(CapabilityFactory.getAppiumServerURL(), CapabilityFactory.getCapabilities());
    }
}