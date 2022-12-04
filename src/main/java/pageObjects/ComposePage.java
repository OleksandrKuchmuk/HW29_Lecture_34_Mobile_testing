package pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ComposePage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[1]//android.view.ViewGroup/android.widget.EditText")
    private MobileElement recipientIPF;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.RelativeLayout[2]")
    private MobileElement firstRecipientFromProposed;

    @AndroidFindBy(id = "subject")
    private MobileElement subjectIPF;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[2]//android.webkit.WebView/android.widget.EditText")
    private MobileElement letterIPF;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Надіслати\"]\n")
    private MobileElement sendBTN;

    public ComposePage(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public ComposePage typeRecipient(String recipient) {
        waitForElementAndSendKeys(recipientIPF, recipient, "can`t find field 'recipientIPF'", 5);
        return this;
    }

    public ComposePage chooseFirstRecipientFromProposed() {
        waitForElementAndClick(firstRecipientFromProposed, "can`t find 'firstRecipientFromProposed'", 5);
        return this;
    }

    public ComposePage typeSubject(String subject) {
        waitForElementAndSendKeys(subjectIPF, subject, "can`t find field 'subjectIPF'", 5);
        return this;
    }

    public ComposePage typeLetter(String letter) {
        waitForElementAndSendKeys(letterIPF, letter, "can`t find field 'LetterIPF'", 5);
        return this;
    }

    public ComposePage clickSend() {
        waitForElementAndClick(sendBTN, "can`t find 'sendBTN'", 5);
        return this;
    }
}
