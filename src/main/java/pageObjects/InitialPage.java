package pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class InitialPage extends BasePage {

    @AndroidFindBy(id = "welcome_tour_got_it")
    private MobileElement gotItBTN;
    @AndroidFindBy(id = "action_done")
    private MobileElement takeMeToGmailBTN;

    public InitialPage(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public InitialPage clickGotItBTN() {
        waitForElementAndClick(gotItBTN, "Do not find 'GotIt' button", 5);
        return this;
    }

    public InitialPage clickTakeMeToGmailBTN() {
        waitForElementAndClick(takeMeToGmailBTN, "Do not find 'TakeMeToGmail' button", 5);
        return this;
    }
}
