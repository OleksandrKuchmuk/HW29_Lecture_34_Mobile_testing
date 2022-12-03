package gmail;

import driver.DriverConfig;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    private static Logger LOGGER = LogManager.getLogger(BaseTest.class);
    public static AndroidDriver driver;

    @AfterSuite
    public void quitDriver() {
        LOGGER.info("AfterSuite: ");
        driver.quit();
    }

    @BeforeSuite
    protected void setUp(){
        LOGGER.info("Before Suite: ");
        LOGGER.info("*** Setting up the driver ***");
        driver=new DriverConfig().getDriver();
    }


//    @AfterSuite
//    public void quitDriver(){
//        AndroidDriverSingleton.quitDriver();
//    }
}
