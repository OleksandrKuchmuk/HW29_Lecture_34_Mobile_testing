package gmail;

import driver.DriverConfig;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    public static AndroidDriver driver;
    private static Logger LOGGER = LogManager.getLogger(BaseTest.class);

    @AfterMethod
    public void quitDriver() {
        LOGGER.info("AfterSuite: ");
        driver.quit();
    }

    @BeforeMethod
    protected void setUp() {
        LOGGER.info("Before Suite: ");
        LOGGER.info("*** Setting up the driver ***");
        driver = new DriverConfig().getDriver();
    }
}
