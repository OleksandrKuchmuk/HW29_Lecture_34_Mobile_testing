package pageObjects;

import driver.DriverConfig;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class SentLettersPage extends BasePage {
    private DriverConfig driverConfig;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[2]//android.view.ViewGroup[1]/android.widget.TextView[3]")
    private MobileElement subjectOfLastSendLetter;

    public SentLettersPage(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isSentLetterDisplayed(String subject) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return subjectOfLastSendLetter.getText().contains(subject);
    }
}
